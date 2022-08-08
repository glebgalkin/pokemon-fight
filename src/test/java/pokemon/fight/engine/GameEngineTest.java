package pokemon.fight.engine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pokemon.fight.engine.model.Player;
import pokemon.fight.engine.util.EventCollector;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {

    private static final String PLAYER_ONE_NAME = "somePlayerOneName";
    private static final String PLAYER_TWO_NAME = "somePlayerTwoName";
    private static final int HEALTH_POINTS = 20;

    private GameEngine gameEngine;

    Player player1;
    Player player2;

    @Before
    public void init(){
        player1 = new Player(PLAYER_ONE_NAME, HEALTH_POINTS);
        player2 = new Player(PLAYER_TWO_NAME, HEALTH_POINTS);

        gameEngine = new GameEngine(player1, player2);
    }

    @Test
    public void whenFinishTheGame_thenGenerateReport(){
        EventCollector eventCollector = gameEngine.startTheGame();

        assertNotNull(eventCollector);
    }

    @Test
    public void whenStartingTheGame_themGenerateOrder(){
        Queue<Player> players = gameEngine.generatePlayerOrder();

        assertNotNull(players);
    }

    @Test
    public void whenStartingRoundBattle_thenReturnRoundWinner(){
        Queue<Player> playersQueue = new LinkedList<>();
        playersQueue.offer(player1);
        playersQueue.offer(player2);
        Player roundWinner = gameEngine.startRoundBattle(playersQueue);

        assertNotNull(roundWinner);
    }

    @Test
    public void whenStartingRoundBattle_thenReturnRoundWinnerName(){
        Queue<Player> playersQueue = new LinkedList<>();
        playersQueue.offer(player1);
        playersQueue.offer(player2);
        Player roundWinner = gameEngine.startRoundBattle(playersQueue);

        assertNotNull(roundWinner.getName());
    }
}
