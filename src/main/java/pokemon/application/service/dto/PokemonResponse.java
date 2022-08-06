package pokemon.application.service.dto;

import pokemon.application.domain.entity.Pokemon;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
