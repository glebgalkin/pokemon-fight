package pokemon.application.service.game;

import pokemon.application.domain.entity.Pokemon;
import pokemon.application.domain.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import pokemon.application.engine.model.Player;
import pokemon.application.service.pokemon.dto.PlayersConfig;

import java.util.ArrayList;
import java.util.List;

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

}
