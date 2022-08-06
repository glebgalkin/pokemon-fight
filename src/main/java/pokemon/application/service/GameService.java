package pokemon.application.service;

import org.springframework.stereotype.Service;
import pokemon.application.domain.repository.PokemonRepository;

@Service
public class GameService {

    private PokemonRepository pokemonRepository;

    public GameService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }


}
