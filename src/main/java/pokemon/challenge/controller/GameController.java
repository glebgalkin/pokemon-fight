package pokemon.challenge.controller;

import org.springframework.http.HttpStatus;
import pokemon.challenge.service.pokemon.PokemonService;
import pokemon.challenge.service.pokemon.dto.PlayersConfig;
import pokemon.challenge.service.pokemon.dto.PokemonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.challenge.service.game.GameService;
import pokemon.challenge.engine.util.EventCollector;

import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<EventCollector> setPlayers(@RequestBody PlayersConfig playersConfig){
        try{
            EventCollector gameReport = gameService.assembleAndStartTheGame(playersConfig);
            return ResponseEntity.ok(gameReport);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
