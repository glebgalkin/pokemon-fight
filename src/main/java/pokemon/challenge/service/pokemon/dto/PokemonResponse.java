package pokemon.challenge.service.pokemon.dto;

import pokemon.challenge.domain.entity.Pokemon;

public class PokemonResponse {

    private String name;
    private String weight;
    private String height;

    public PokemonResponse() {};

    public static PokemonResponse toPokemonResponse(Pokemon pokemon){
        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse.setName(pokemon.getName());
        pokemonResponse.setWeight(pokemon.getWeight());
        pokemonResponse.setHeight(pokemon.getHeight());
        return pokemonResponse;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
