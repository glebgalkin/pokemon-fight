package pokemon.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pokemon.application.model.PokemonListResponse;

@Service
public class PokemonService {

    private RestTemplate restTemplate;

    @Value("${pokemon.list.original}")
    private String URL;

    public PokemonService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public PokemonListResponse getOriginalPokemonList() {
        String temp = "https://pokeapi.co/api/v2/pokemon?limit=50";
        return restTemplate.getForObject(URL, PokemonListResponse.class);
    }
}
