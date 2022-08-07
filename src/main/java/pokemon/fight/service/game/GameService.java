package pokemon.fight.service.game;

import pokemon.fight.domain.entity.Pokemon;
import pokemon.fight.domain.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import pokemon.fight.engine.GameEngine;
import pokemon.fight.engine.model.Player;
import pokemon.fight.service.pokemon.dto.PlayersConfig;
import pokemon.fight.engine.util.EventCollector;

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
