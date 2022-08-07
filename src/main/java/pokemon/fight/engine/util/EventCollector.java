package pokemon.fight.engine.util;

import pokemon.fight.engine.model.Player;

import java.util.ArrayList;

public class EventCollector extends ArrayList<String> {

    public void reportRoundNumber(int round){
        this.add("ROUND: " + round);
    }

    public void reportRoundWinner(String playerName){
     this.add("Round winner: " + playerName);
    }

    public void reportAttack(String attacker, String defender, int damage){
        this.add("Player " + attacker + " attacks another player " + defender + " with " + damage +
                " points of damage!");
    }

    public void reportScore(Player player1, Player player2){
        this.add(player1.getName() + " : " + player1.getHealthPoints() + " . " + player2.getName() + " : " + player2.getHealthPoints());
    }

    public void reportSpecialAttack(String name, int damage){
        this.add(name + " generates special attack worth of " + damage + " points! Special attack takes two turns.");
    }

    public void reportGameWinner(String name){
        this.add("The game winner is: " + name);
    }
}
