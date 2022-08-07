package pokemon.application.service.game;

import pokemon.application.service.game.dto.Game;
import pokemon.application.service.game.dto.Player;

import java.util.Queue;

public class Test {
    public static void main(String[] args){
        Player player1 = new Player("Viking" +
                "", 20);
        Player player2 = new Player("Spider-Man", 20);

        Game game = new Game(player1, player2);

        Queue<Player> playersQueue = game.generateQueue();
        Player player = game.startRoundBattle(playersQueue);
        System.out.println("Here!" + player.getName());
    }
}
