package pokemon.application.controller;

import pokemon.application.service.PokemonService;
import pokemon.application.service.dto.PokemonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.application.service.GameService;
import pokemon.application.service.dto.GamePokemon;
import pokemon.application.service.dto.GameReport;
import pokemon.application.service.dto.PlayersConfig;

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
        List<GamePokemon> gamePokemons = pokemonService.assemblePokemonsForBattle(playersConfig);
        GameReport gamereport = gameService.startTheGame(gamePokemons);
        return ResponseEntity.ok(gamereport);
    }
}
