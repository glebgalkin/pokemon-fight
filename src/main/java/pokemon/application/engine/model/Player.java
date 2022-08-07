package pokemon.application.engine.model;

import pokemon.application.domain.entity.Pokemon;

public class Player {

    private String name;
    private int healthPoints;
    private boolean isRoundWinner;

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

    public boolean isRoundWinner() {
        return isRoundWinner;
    }

    public void setRoundWinner(boolean roundWinner) {
        isRoundWinner = roundWinner;
    }

}
