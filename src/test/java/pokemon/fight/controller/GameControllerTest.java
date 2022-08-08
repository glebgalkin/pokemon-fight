package pokemon.fight.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pokemon.fight.engine.util.EventCollector;
import pokemon.fight.service.game.GameService;
import pokemon.fight.service.pokemon.PokemonService;
import pokemon.fight.service.pokemon.dto.PlayersConfig;
import pokemon.fight.service.pokemon.dto.PokemonResponse;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @Mock
    private PokemonService pokemonService;

    @Mock
    GameService gameService;

    private GameController gameController;

    @Mock
    List<PokemonResponse> pokemonList;

    private PlayersConfig playersConfig;

    private static final String PLAYER_ONE_CHOICE = "someP1Choice";
    private static final String PLAYER_TWO_CHOICE = "someP2Choice";

    @Before
    public void init(){
        gameController = new GameController(pokemonService, gameService);
        playersConfig = new PlayersConfig();
        playersConfig.setPlayerOneChoice(PLAYER_ONE_CHOICE);
        playersConfig.setPlayerTwoChoice(PLAYER_TWO_CHOICE);

        setUpMocks();
    }

    public void setUpMocks(){
        BDDMockito.willReturn(pokemonList).given(pokemonService).getPokemons();
    }

    @Test
    public void whenGettingPokemons_thenAssertResponseNotNull(){
        ResponseEntity<List<PokemonResponse>> response = gameController.getPokemons();

        assertNotNull(response);
    }

    @Test
    public void whenGettingPokemons_thenReturnResponse(){
        ResponseEntity<List<PokemonResponse>> response = gameController.getPokemons();

        assertEquals(pokemonList, response.getBody());
    }

    @Test
    public void whenGettingPokemons_thenCallPokemonService(){
        gameController.getPokemons();

        BDDMockito.verify(pokemonService).getPokemons();
    }

    @Test
    public void whenStartingTheGame_callGameService(){
        BDDMockito.willThrow(NoSuchElementException.class).given(gameService).assembleAndStartTheGame(playersConfig);
        ResponseEntity<EventCollector> response = gameController.runTheGame(playersConfig);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


}
