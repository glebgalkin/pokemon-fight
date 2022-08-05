package pokemon.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pokemon.application.model.PokemonListResponse;
import pokemon.application.service.PokemonService;

@RestController
@RequestMapping("/api/v1")
public class GameController {

    private PokemonService pokemonService;

    public GameController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/check")
    public ResponseEntity<PokemonListResponse> checkStatus() {
        PokemonListResponse result = pokemonService.getOriginalPokemonList();
        return ResponseEntity.ok(result);
    }
}
