package pers.drew.sbatictactoe.msgs.rqs;

public class MoveRqs {

   private String positionId;
   private String playerId;

   private String gameId;
   
   public String getPlayerId() {
      return playerId;
   }
   public void setPlayerId(String playerId) {
      this.playerId = playerId;
   }
   public String getPositionId() {
      return positionId;
   }
   public void setPositionId(String positionId) {
      this.positionId = positionId;
   }
   public String getGameId() {
      return gameId;
   }
   public void setGameId(String gameId) {
      this.gameId = gameId;
   }

}
