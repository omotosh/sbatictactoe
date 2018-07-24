package pers.drew.sbatictactoe.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import pers.drew.sbatictactoe.Game;
import pers.drew.sbatictactoe.GameEngine;
import pers.drew.sbatictactoe.msgs.rqs.JoinRqs;
import pers.drew.sbatictactoe.msgs.rqs.MoveRqs;
import pers.drew.sbatictactoe.msgs.rsp.JoinRsp;
import pers.drew.sbatictactoe.msgs.rsp.MoveRsp;

@Controller
public class GameController {

   @MessageMapping("/play/{gameId}")
   @SendTo("/topic/{gameId}")
   public MoveRsp moveRequest(MoveRqs message) throws Exception {

      MoveRsp moveRsp = respondToMoveRequest(message);

      return moveRsp;
   } 

   protected MoveRsp respondToMoveRequest(MoveRqs moveRqs) {
      MoveRsp resp = new MoveRsp();

      Game aGame = 
            GameEngine.getInstance().getGamesMap().get(moveRqs.getGameId());

      if (aGame != null && aGame.isGameOver() == false) {

         boolean turnPlayed = aGame.playATurn(moveRqs.getPlayerId(), Integer.parseInt(moveRqs.getPositionId()));
         
         if (turnPlayed) {

            resp.setPositionId(moveRqs.getPositionId());
            resp.setPlayerId(moveRqs.getPlayerId());
            
            resp.setIdOfPlayerWithNextMove(aGame.getIdOfPlayerWithNextMove());
            
            resp.setGameOver(aGame.isGameOver());
            resp.setIdOfWinner(aGame.getWinnerPlayerId());            
            
         }
      }
      return resp;
   }   
   

   @MessageMapping("/join")    
   @SendToUser ("/ttt/reply")   
   public JoinRsp joinGame(JoinRqs message) throws Exception {

      JoinRsp joinRsp = respondToJoinRequest(message);

      return joinRsp;
   }

   protected JoinRsp respondToJoinRequest(JoinRqs joinRqs) {
      JoinRsp resp = new JoinRsp();

      String playerName = HtmlUtils.htmlEscape(joinRqs.getPlayerName());

      Object [] assignedIdAndGame = 
            GameEngine.getInstance().joinAGame(playerName);

      String assignedId = (String) assignedIdAndGame[0];
      Game aGame = (Game) assignedIdAndGame[1];

      resp.setPlayerName(playerName);
      resp.setGameId(aGame.getGameId());
      resp.setPlayerId(assignedId);
      resp.setReadyToStart(aGame.isReadyToStart());
      resp.setIdOfPlayerWithNextMove(aGame.getIdOfPlayerWithNextMove());
      resp.setRespMsg("Joined game: " + resp.getGameId() + " Your Token is: " + resp.getPlayerId());
      return resp;
   }

}