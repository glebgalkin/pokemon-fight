package pokemon.application.service.game;

import pokemon.application.domain.entity.Pokemon;
import pokemon.application.domain.repository.PokemonRepository;
import pokemon.application.service.game.dto.Game;
import pokemon.application.service.game.dto.Player;
import pokemon.application.util.EventCollector;
import org.springframework.stereotype.Service;
import pokemon.application.service.pokemon.dto.PlayersConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class GameService {

    private PokemonRepository pokemonRepository;

    public GameService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public List<Player> assemblePlayersForBattle(PlayersConfig playersConfig) {

        List<Player> players = new ArrayList<>();
        Player p1Player = assemblePlayerForBattle(playersConfig.getPlayerOneChoice());
        Player p2Player = assemblePlayerForBattle(playersConfig.getPlayerTwoChoice());
        players.add(p1Player);
        players.add(p2Player);

        return players;
    }

    private Player assemblePlayerForBattle(String playerChoice){
        Pokemon pokemonP1 = pokemonRepository.findByName(playerChoice).get();
        return Player.toGamePokemon(pokemonP1);
    }

    public Game assembleTheGame(List<Player> players) {
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        return new Game(player1, player2);
    }

    public EventCollector startTheGame(Game game) {

        boolean winnerFound = false;

        while(!winnerFound){
            Queue<Player> playersQueue = game.generateQueue();
            Player player = game.startRoundBattle(playersQueue);
            if (player.getRoundsWon() == 2){
                winnerFound = true;
                System.out.println("Match winner is " + player.getName());
            }
        }
        return  null;
    }

}
