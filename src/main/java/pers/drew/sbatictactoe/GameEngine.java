package pers.drew.sbatictactoe;

import java.util.HashMap;
import java.util.Set;

public class GameEngine {

   public static GameEngine gameEngine = null;;
   private HashMap<String, Game> gamesMap;
   private GameEngine() {
      gamesMap = new HashMap<String, Game> ();
   }
  
   public static GameEngine getInstance() {
      if (gameEngine == null) {
         gameEngine = new GameEngine();
      }
      
      return gameEngine;
   }

   public HashMap<String, Game> getGamesMap() {
      return gamesMap;
   }
   

   public synchronized Object[] joinAGame(String playerName) {

      Object [] assignedIdAndGame = new Object [2] ;
      
      Set<String> keys = gamesMap.keySet();
      Game joinedGame = null;
      String assignedId = null;
      
      for(String key: keys){
         
        Game aGame = gamesMap.get(key);
        
        if (aGame.isReadyToStart() == false) {
           if (aGame.getPlayerOneId() == null) {
              assignedId = Game.TOKEN_1;
              aGame.setPlayerOneId(Game.TOKEN_1);
              aGame.setPlayerOneName(playerName);
              
           }
           else {
              assignedId = Game.TOKEN_2;
              aGame.setPlayerTwoId(Game.TOKEN_2);
              aGame.setPlayerTwoName(playerName);
              aGame.setIdOfPlayerWithNextMove(aGame.getPlayerTwoId());
           }
           joinedGame = aGame;
           break;
        }
        
      }
      
      if (joinedGame == null) {
         joinedGame = new Game();
         
         gamesMap.put(joinedGame.getGameId(), joinedGame);
         
         assignedId = Game.TOKEN_1;
         joinedGame.setPlayerOneId(Game.TOKEN_1);
         joinedGame.setPlayerOneName(playerName);
         
      }
      assignedIdAndGame[0] = assignedId;
      assignedIdAndGame[1] = joinedGame;
      return assignedIdAndGame ;
      
   }
}
