package pokemon.fight.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pokemon.fight.domain.entity.Pokemon;
import pokemon.fight.domain.repository.PokemonRepository;
import pokemon.fight.engine.util.EventCollector;
import pokemon.fight.service.game.GameService;
import pokemon.fight.service.pokemon.dto.PlayersConfig;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    private GameService gameService;
    private static final String POKEMON_NAME = "somePokemonName";
    private static final String POKEMON_WEIGHT = "somePokemonName";
    private static final String POKEMON_HEIGHT = "somePokemonName";

    private Pokemon pokemon;
    private PlayersConfig playersConfig;

    @Mock
    PokemonRepository pokemonRepository;

    @Mock
    EventCollector eventCollector;

    @Before
    public void init(){
        gameService = new GameService(pokemonRepository);
        pokemon = new Pokemon();
        pokemon.setName(POKEMON_NAME);
        pokemon.setWeight(POKEMON_WEIGHT);
        pokemon.setHeight(POKEMON_HEIGHT);

        playersConfig = new PlayersConfig();
        playersConfig.setPlayerOneChoice(POKEMON_NAME);
        playersConfig.setPlayerTwoChoice(POKEMON_NAME);

        setUpMocks();
    }

    public void setUpMocks(){
        BDDMockito.willReturn(Optional.of(pokemon)).given(pokemonRepository).findByName(POKEMON_NAME);
    }

    @Test
    public void whenAssemblingPlayer_callPokemonRepository(){
        gameService.assembleAndStartTheGame(playersConfig);

        BDDMockito.verify(pokemonRepository, Mockito.times(2)).findByName(POKEMON_NAME);
    }

    @Test
    public void whenGameFinishes_thenReturnTheReport(){
        EventCollector report = gameService.assembleAndStartTheGame(playersConfig);

        assertNotNull(report);
    }
}
