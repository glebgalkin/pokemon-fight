package pokemon.fight.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import pokemon.fight.domain.entity.Pokemon;
import pokemon.fight.domain.repository.PokemonRepository;
import pokemon.fight.service.pokemon.PokemonService;
import pokemon.fight.service.pokemon.dto.PokemonResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PokemonServiceTest {

    private PokemonService pokemonService;
    private static final String URL_ADDRESS = "someURLAddress";
    private static final String POKEMON_NAME = "somePokemonName";

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private Pokemon pokemon;

    private List<PokemonResponse> responses;

    private Iterable<Pokemon> iterable;


    @Before
    public void init(){
        pokemonService = new PokemonService(restTemplate, pokemonRepository);
        iterable = new ArrayList<>();
        responses = new ArrayList<>();
        setUpMocks();
    }

    public void setUpMocks(){
        BDDMockito.willReturn(iterable).given(pokemonRepository).findAll();
    }

    @Test
    public void whenGettingPokemons_returnListOfPokemons(){
        List<PokemonResponse> pokemonResponses = pokemonService.getPokemons();

        assertEquals(responses, pokemonResponses);
    }

    @Test
    public void whenGettingPokemons_thenCallPokemonRepository(){
        pokemonService.getPokemons();

        BDDMockito.verify(pokemonRepository).findAll();
    }
}
