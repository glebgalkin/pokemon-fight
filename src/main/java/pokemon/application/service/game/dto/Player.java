package pokemon.application.service.game.dto;

import pokemon.application.domain.entity.Pokemon;

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
        } else {
            otherPlayer.setHealthPoints(otherPlayer.getHealthPoints()-randomNum);
            System.out.println("Player " + this.getName()+ " hits another player " + otherPlayer.getName() + " with default hit: " + randomNum +
                    " points!");
            System.out.println(this.getName() + ": " + this.healthPoints + " . " + otherPlayer.getName() + ": " + otherPlayer.getHealthPoints());
        }
    }
}
