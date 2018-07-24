package pers.drew.sbatictactoe.msgs.rsp;

public class MoveRsp {
   private String positionId;
   private String respMsg;
   private String playerId;   
   private String idOfPlayerWithNextMove;
   private boolean gameOver;
   private String idOfWinner;
   
   public String getPlayerId() {
      return playerId;
   }

   public void setPlayerId(String playerId) {
      this.playerId = playerId;
   }


   public String getRespMsg() {
      return respMsg;
   }

   public void setRespMsg(String respMsg) {
      this.respMsg = respMsg;
   }


   public String getIdOfPlayerWithNextMove() {
      return idOfPlayerWithNextMove;
   }

   public void setIdOfPlayerWithNextMove(String idOfPlayerWithNextMove) {
      this.idOfPlayerWithNextMove = idOfPlayerWithNextMove;
   }

   public boolean isGameOver() {
      return gameOver;
   }

   public void setGameOver(boolean gameOver) {
      this.gameOver = gameOver;
   }

   public String getIdOfWinner() {
      return idOfWinner;
   }

   public void setIdOfWinner(String idOfWinner) {
      this.idOfWinner = idOfWinner;
   }

   public String getPositionId() {
      return positionId;
   }

   public void setPositionId(String positionId) {
      this.positionId = positionId;
   }
   
   
}
