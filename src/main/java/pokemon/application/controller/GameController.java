package pokemon.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.application.service.GameService;
import pokemon.application.service.PokemonService;
import pokemon.application.service.dto.GamePokemon;
import pokemon.application.service.dto.GameReport;
import pokemon.application.service.dto.PlayersConfig;
import pokemon.application.service.dto.PokemonResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GameController {

    private PokemonService pokemonService;
    private GameService gameService;

    public GameController(PokemonService pokemonService, GameService gameService) {
        this.pokemonService = pokemonService;
        this.gameService = gameService;
    }

    @GetMapping("/pokemons")
    public ResponseEntity<List<PokemonResponse>> getPokemons(){
        List<PokemonResponse> pokemonList = pokemonService.getPokemons();
        return ResponseEntity.ok(pokemonList);
    }

    @PostMapping("/start")
    public ResponseEntity<GameReport> setPlayers(@RequestBody PlayersConfig playersConfig){
        List<GamePokemon> gamePokemons = pokemonService.assemblePokemonsForGame(playersConfig);
        GameReport gamereport = pokemonService.startTheGame(gamePokemons);
        return ResponseEntity.ok(gamereport);
    }
}
