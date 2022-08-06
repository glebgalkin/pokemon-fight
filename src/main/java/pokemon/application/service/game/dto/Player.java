package pokemon.application.service.game.dto;

import pokemon.application.domain.entity.Pokemon;

public class Player {

    private String name;
    private int healthPoints;
    private int roundsWon;

    public Player(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
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
}
