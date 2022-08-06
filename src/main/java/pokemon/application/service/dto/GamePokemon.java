package pokemon.application.service.dto;

import pokemon.application.domain.entity.Pokemon;

public class GamePokemon {

    private String name;
    private int healthPoints;

    public GamePokemon(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public static GamePokemon toGamePokemon(Pokemon pokemon) {
        return new GamePokemon(pokemon.getName(), pokemon.getHealthPoints());
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
}
