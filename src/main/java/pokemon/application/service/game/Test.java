package pokemon.application.service.game;

import pokemon.application.engine.GameEngine;
import pokemon.application.engine.model.Player;
import pokemon.application.util.EventCollector;

public class Test {
    public static void main(String[] args){


        Player player1 = new Player("Viking", 20);
        Player player2 = new Player("Spider-Man", 20);

        GameEngine gameEngine = new GameEngine(player1, player2);
        EventCollector eventCollector = gameEngine.startTheGame();

        for(String k : eventCollector){
            System.out.println(k);
        }
    }
}
