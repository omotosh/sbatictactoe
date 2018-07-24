
var stompClient = null;
var gameId = null;
var playerId = null;
var isPlayersTurn = false;
var idOfPlayerWithNextMove = null;
var idOfWinner = null;
var isGameOver = false;

var NO_WINNER_ID = "NO_WINNER";

function connect() {
	var socket = new SockJS('/sbatictactoe');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {	
		console.log('Connected: ' + frame);
		stompClient.subscribe('/player/ttt/reply', onJoinMsgReceived);
		
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	
	console.log("Disconnected");
}

function onJoinMsgReceived(joinResp) {
	var parsedResp = JSON.parse(joinResp.body);

	gameId = parsedResp.gameId;
	playerId = parsedResp.playerId;
	playerName = parsedResp.playerName;

	idOfPlayerWithNextMove = parsedResp.idOfPlayerWithNextMove;

	showJoinMessage(parsedResp.respMsg);
	whoseTurnIsIt();

	stompClient.subscribe('/topic/' + gameId, onTopicMsgReceived);
}

function onTopicMsgReceived(gameUpdates) {
	var parsedUpdates = JSON.parse(gameUpdates.body);

	idOfPlayerWithNextMove = parsedUpdates.idOfPlayerWithNextMove;

	idOfWinner = parsedUpdates.idOfWinner;
	isGameOver = parsedUpdates.gameOver;

	var idOfPlayerWithLastMove = parsedUpdates.playerId;
	var idOfPositionOfLastMove = parsedUpdates.positionId

	whoseTurnIsIt();

	if (idOfPositionOfLastMove && idOfPlayerWithLastMove && playerId !== idOfPositionOfLastMove) {
		$("#" + idOfPositionOfLastMove).text(idOfPlayerWithLastMove);
	}
	

	determineWinner();
}

function determineWinner() {
	var endOfGameTextPrefix ="GAME OVER: ";
	var playAgainText = " Click 'Play' to start a new game.";
	var winnerMsg = endOfGameTextPrefix + "YOU WIN!!!" + playAgainText;
    var drawMsg = endOfGameTextPrefix + "DRAW." + playAgainText;
    var loserMsg = endOfGameTextPrefix + "YOU LOST :( " + playAgainText;
    
	if(isGameOver) {
		if(idOfWinner === playerId) {
			showMessage (winnerMsg);
		}
		else if (idOfWinner === NO_WINNER_ID) {
			showMessage (drawMsg);
		}
		else {
			showMessage (loserMsg);
		}
		resetGame();
	}
	else {
		if(idOfWinner  !== NO_WINNER_ID) {
			if(idOfWinner === playerId) {
				showMessage (winnerMsg);
			}

			else {
				showMessage (loserMsg);
			}
			resetGame();
		}
	}
}

function resetGame() {
	disconnect();
	gameId = null;
	playerId = null;
	isPlayersTurn = false;
	idOfPlayerWithNextMove = null;
	idOfWinner = null;
	isGameOver = false;
		
	$("#init-form").show();
	
	connect();
}

function resetBoard () {
    $(".board-pos").each(function() {
	    $(this).text("");
    });
    
	$("#other-message").text("");
	$("#join-message").text("");
}

function whoseTurnIsIt() {
	if (idOfPlayerWithNextMove != null ) {
		if (idOfPlayerWithNextMove === playerId) {
			isPlayersTurn = true;
			showMessage ("Your turn");
		}
		else {
			isPlayersTurn = false;
			showMessage (idOfPlayerWithNextMove + "'s turn");
		}
	}
}


function sendJoinReq() {
	resetBoard();
	stompClient.send("/app/join", {}, JSON.stringify({'playerName': $("#name").val()}));
	$("#init-form").hide();
}

function sendPlayerMoveReq(clickedPositionId) {
	stompClient.send("/app/play/"+gameId, {}, JSON.stringify({'gameId': gameId, 'playerId': playerId, 'positionId': clickedPositionId}));
}

function showMessage(message) {
	$("#other-message").text(message);
}


function showJoinMessage(message) {
	
	$("#join-message").text(message);

}




$(function () {
	$("form").on('submit', function (e) {
		e.preventDefault();
	});
	connect();

	$( "#play-game" ).click(function() { sendJoinReq(); });

	$(".board-pos").click(function(event) {

		if (isPlayersTurn) {
			var cellId = event.target.id;
			var cellText = $("#" + cellId).text();

			if (cellText === null || cellText === "" ) {

				sendPlayerMoveReq(cellId);
				$("#" + cellId).text(playerId);
			}
			else {
				showMessage("** already selected **");
			}
		}
		else {
			showMessage ("** Not your turn **");
		}
	});
});