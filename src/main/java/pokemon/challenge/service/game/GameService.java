package pokemon.challenge.service.game;

import pokemon.challenge.domain.entity.Pokemon;
import pokemon.challenge.domain.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import pokemon.challenge.engine.GameEngine;
import pokemon.challenge.engine.model.Player;
import pokemon.challenge.service.pokemon.dto.PlayersConfig;
import pokemon.challenge.engine.util.EventCollector;

@Service
public class GameService {

    private PokemonRepository pokemonRepository;

    public GameService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public EventCollector assembleAndStartTheGame(PlayersConfig playersConfig) {

        Player playerOne = assemblePlayerForBattle(playersConfig.getPlayerOneChoice());
        Player playerTwo = assemblePlayerForBattle(playersConfig.getPlayerTwoChoice());

        GameEngine gameEngine = new GameEngine(playerOne, playerTwo);
        EventCollector eventCollector = gameEngine.startTheGame();

        return eventCollector;
    }

    private Player assemblePlayerForBattle(String playerChoice){
        Pokemon pokemonP1 = pokemonRepository.findByName(playerChoice).get();
        return Player.toPlayer(pokemonP1);
    }

}
