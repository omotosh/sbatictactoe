package pers.drew.sbatictactoe.msgs.rsp;

public class JoinRsp {
   private String respMsg;
   private String gameId;
   private String playerId;
   private String playerName;
   private boolean readyToStart;
   private String idOfPlayerWithNextMove;
   


   public String getGameId() {
      return gameId;
   }

   public void setGameId(String gameId) {
      this.gameId = gameId;
   }

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

   public String getPlayerName() {
      return playerName;
   }

   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }

   public boolean isReadyToStart() {
      return readyToStart;
   }

   public void setReadyToStart(boolean readyToStart) {
      this.readyToStart = readyToStart;
   }

   public String getIdOfPlayerWithNextMove() {
      return idOfPlayerWithNextMove;
   }

   public void setIdOfPlayerWithNextMove(String idOfPlayerWithNextMove) {
      this.idOfPlayerWithNextMove = idOfPlayerWithNextMove;
   }
   
   
}
