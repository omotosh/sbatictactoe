package pers.drew.sbatictactoe;

import java.util.HashMap;
import java.util.UUID;

public class Game {
   private String playerOneId = null;
   private String playerTwoId = null;
   
   private String playerOneName = null;
   private String playerTwoName = null;
   
   
   private String idOfPlayerWithNextMove = null;
   
   private String gameId;
   
   public static final int BOARD_SIZE = 9;
   private HashMap<String, String> board = null;
   
   public static final String TOKEN_1 = "X";
   public static final String TOKEN_2 = "O";   
   
   public static final String NO_WINNER_ID = "NO_WINNER";
 
   private static final String EMPTY_STR = "";
   
   public Game () {
      gameId =  UUID.randomUUID().toString();
      board = new HashMap<String, String>();
      
      for (int i=0; i < BOARD_SIZE; i++) {
         board.put(i+EMPTY_STR, EMPTY_STR);
      }
   }
   private int playsCounter = 0;
   public boolean isReadyToStart() {
      if (playerOneId != null && playerTwoId != null) {
         return true;
      }
      else return false;
   }


   public boolean playATurn(String playerId, int position) {
      boolean turnPlayed = false;
      if (position >=0 && position < BOARD_SIZE) {
        if (board.get (position+EMPTY_STR).isEmpty()) {
           board.put(position+EMPTY_STR, playerId);
           turnPlayed = true;
           playsCounter ++;
           
           if(playerId.compareTo(playerOneId) == 0) {
              this.setIdOfPlayerWithNextMove(playerTwoId);
           }
           else {
              this.setIdOfPlayerWithNextMove(playerOneId);
           }
        }
      }
      return turnPlayed;
   }
   
   public boolean isGameOver() {
      boolean result = false;
      if (playsCounter == BOARD_SIZE) {
         result = true;
      }
      return result;
   }
   
   public String getWinnerPlayerId () {
      String result = NO_WINNER_ID;
      if (isPlayerAWinner(playerOneId) == true) {
         result = playerOneId; 
      }
      else if (isPlayerAWinner(playerTwoId) == true) {
         result = playerTwoId;
      }
      return result;
   }

   public boolean isPlayerAWinner(String playerId) {
      boolean result = false;
      if (playerId != null && playerId.isEmpty()== false){
         if ((playerId.compareTo(board.get("0")) == 0 && playerId.compareTo(board.get("1")) == 0 && playerId.compareTo(board.get("2")) == 0 ) || 
            (playerId.compareTo(board.get("3")) == 0 && playerId.compareTo(board.get("4")) == 0 && playerId.compareTo(board.get("5")) == 0 ) ||
            (playerId.compareTo(board.get("6")) == 0 && playerId.compareTo(board.get("7")) == 0 && playerId.compareTo(board.get("8")) == 0 ) ||
            (playerId.compareTo(board.get("0")) == 0 && playerId.compareTo(board.get("3")) == 0 && playerId.compareTo(board.get("6")) == 0 ) ||
            (playerId.compareTo(board.get("1")) == 0 && playerId.compareTo(board.get("4")) == 0 && playerId.compareTo(board.get("7")) == 0 ) ||
            (playerId.compareTo(board.get("2")) == 0 && playerId.compareTo(board.get("5")) == 0 && playerId.compareTo(board.get("8")) == 0 ) ||
            (playerId.compareTo(board.get("0")) == 0 && playerId.compareTo(board.get("4")) == 0 && playerId.compareTo(board.get("8")) == 0 ) ||
            (playerId.compareTo(board.get("2")) == 0 && playerId.compareTo(board.get("4")) == 0 && playerId.compareTo(board.get("6")) == 0 )) {
            
            result = true;
         }
      }
      return result;
   }
   
   public String getPlayerOneId() {
      return playerOneId;
   }



   public void setPlayerOneId(String playerOneId) {
      this.playerOneId = playerOneId;
   }



   public String getPlayerTwoId() {
      return playerTwoId;
   }



   public void setPlayerTwoId(String playerTwoId) {
      this.playerTwoId = playerTwoId;
   }



   public String getIdOfPlayerWithNextMove() {
      return idOfPlayerWithNextMove;
   }



   public void setIdOfPlayerWithNextMove(String idOfPlayerWithNextMove) {
      this.idOfPlayerWithNextMove = idOfPlayerWithNextMove;
   }



   public String getGameId() {
      return gameId;
   }



   public void setGameId(String gameId) {
      this.gameId = gameId;
   }


   public String getPlayerOneName() {
      return playerOneName;
   }


   public void setPlayerOneName(String playerOneName) {
      this.playerOneName = playerOneName;
   }


   public String getPlayerTwoName() {
      return playerTwoName;
   }


   public void setPlayerTwoName(String playerTwoName) {
      this.playerTwoName = playerTwoName;
   }
}
