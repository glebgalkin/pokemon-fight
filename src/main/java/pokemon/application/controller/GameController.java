package pokemon.application.controller;

import pokemon.application.service.game.dto.Game;
import pokemon.application.service.pokemon.PokemonService;
import pokemon.application.service.pokemon.dto.PokemonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.application.service.game.GameService;
import pokemon.application.service.game.dto.Player;
import pokemon.application.service.game.dto.GameReport;
import pokemon.application.service.pokemon.dto.PlayersConfig;

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
        List<Player> players = gameService.assemblePlayersForBattle(playersConfig);
        Game game = gameService.assembleTheGame(players);
        GameReport gamereport = gameService.startTheGame(game);
        return ResponseEntity.ok(gamereport);
    }
}
