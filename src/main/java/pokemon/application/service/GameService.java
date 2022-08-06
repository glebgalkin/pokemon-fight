package pokemon.application.service;

import pokemon.application.domain.repository.PokemonRepository;
import pokemon.application.service.dto.GamePokemon;
import pokemon.application.service.dto.GameReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private PokemonRepository pokemonRepository;

    public GameService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public GameReport startTheGame(List<GamePokemon> gamePokemons) {
        return null;
    }
}
