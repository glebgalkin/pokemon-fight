package pokemon.application.service.game.dto;

import org.springframework.beans.factory.annotation.Autowired;
import pokemon.application.domain.entity.Pokemon;
import pokemon.application.util.EventCollector;

import java.util.Random;

public class Player {

    private String name;
    private int healthPoints;
    private int roundsWon;
    private boolean isRoundWinner;

    public Player(){};

    public Player(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.isRoundWinner = false;
    }

    public static Player toGamePokemon(Pokemon pokemon) {
        return new Player(pokemon.getName(), pokemon.getHealthPoints());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public boolean isRoundWinner() {
        return isRoundWinner;
    }

    public void setRoundWinner(boolean roundWinner) {
        isRoundWinner = roundWinner;
    }

    public void defaultAttack(Player otherPlayer){
        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;

        if(otherPlayer.getHealthPoints()-randomNum < 0){
            otherPlayer.setHealthPoints(0);
            System.out.println("Player " + this.getName()+ " hits another player " + otherPlayer.getName() + " with default hit: " + randomNum +
                    "points! And wins the round");
            System.out.println(this.getName() + ": " + this.healthPoints + " . " + otherPlayer.getName() + ": " + otherPlayer.getHealthPoints());
            setRoundWinner(true);
            setRoundsWon(this.getRoundsWon()+1);
        } else {
            otherPlayer.setHealthPoints(otherPlayer.getHealthPoints()-randomNum);
            System.out.println("Player " + this.getName()+ " hits another player " + otherPlayer.getName() + " with default hit: " + randomNum +
                    " points!");
            System.out.println(this.getName() + ": " + this.healthPoints + " . " + otherPlayer.getName() + ": " + otherPlayer.getHealthPoints());
        }
    }

    public void specialAttack(Player otherPLayer){
        System.out.println(this.getName() + "generates special attack!");
        Random rand = new Random();
        int randomNum = 5 + rand.nextInt(11);
        generateHit(randomNum/2);
        generateHit(randomNum-(randomNum/2));
    }

    private void generateHit(int i) {
    }
}
