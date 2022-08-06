package pokemon.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pokemon.application.domain.entity.Pokemon;
import pokemon.application.domain.repository.PokemonRepository;
import pokemon.application.service.dto.GamePokemon;
import pokemon.application.service.dto.GameReport;
import pokemon.application.service.dto.PlayersConfig;
import pokemon.application.service.dto.PokemonResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private RestTemplate restTemplate;
    private PokemonRepository pokemonRepository;

    @Value("${pokemon.list.original}")
    private String URL;

    public PokemonService(RestTemplate restTemplate, PokemonRepository pokemonRepository){
        this.restTemplate = restTemplate;
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonResponse> getPokemons(){
        savePokemonsToDB();
        List<PokemonResponse> pokemonResponses = assembleResponse();
        return pokemonResponses;
    }

    private void savePokemonsToDB(){
        for(int k=1; k<=5; k++){
            String urlAddress = URL + k;
            Pokemon pokemon = restTemplate.getForObject(urlAddress, Pokemon.class);
            if(!pokemonRepository.findByName(pokemon.getName()).isPresent()){
                pokemonRepository.save(pokemon);
            }
        }
    }

    private List<PokemonResponse> assembleResponse(){
        List<Pokemon> pokemons = (List<Pokemon>) pokemonRepository.findAll();

        List<PokemonResponse> pokemonResponses = new ArrayList<>();
        for(Pokemon pokemon : pokemons){
            pokemonResponses.add(PokemonResponse.toPokemonResponse(pokemon));
        }
        return pokemonResponses;
    }

    public List<GamePokemon> assemblePokemonsForGame(PlayersConfig playersConfig) {
        return null;
    }

    public GameReport startTheGame(List<GamePokemon> gamePokemons) {
        return null;
    }
}
