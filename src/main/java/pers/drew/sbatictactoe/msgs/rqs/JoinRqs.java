package pers.drew.sbatictactoe.msgs.rqs;

public class JoinRqs {

   private String gameId;
   private String playerId;
   private String playerName;
   
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
   public String getPlayerName() {
      return playerName;
   }
   public void setPlayerName(String playerName) {
      this.playerName = playerName;
   }
}
