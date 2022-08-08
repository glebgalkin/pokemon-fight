package pokemon.fight.controller;

import org.springframework.http.HttpStatus;
import pokemon.fight.service.pokemon.PokemonService;
import pokemon.fight.service.pokemon.dto.PlayersConfig;
import pokemon.fight.service.pokemon.dto.PokemonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.fight.service.game.GameService;
import pokemon.fight.engine.util.EventCollector;

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
    public ResponseEntity<EventCollector> runTheGame(@RequestBody PlayersConfig playersConfig){
        try{
            EventCollector gameReport = gameService.assembleAndStartTheGame(playersConfig);
            return ResponseEntity.ok(gameReport);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
