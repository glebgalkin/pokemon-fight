package pokemon.application.service.game.dto;

import org.springframework.beans.factory.annotation.Autowired;
import pokemon.application.util.EventCollector;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Game {

    private Player player1;
    private Player player2;
    private int round;
    private String gameWinner;
    HashMap<String, Player> roundWinners;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.round = 0;
        this.gameWinner = null;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(String gameWinner) {
        this.gameWinner = gameWinner;
    }

    public Queue<Player> generateQueue(){
        Queue<Player> playersQueue = new LinkedList<>();
        Random rand = new Random();
        int randomNum = rand.nextInt(2) + 1;

        if(randomNum == 1){
            playersQueue.offer(this.player1);
            playersQueue.offer(this.player2);
        } else {
            playersQueue.offer(this.player2);
            playersQueue.offer(this.player1);
        }
        return playersQueue;
    }
    
    public Player startRoundBattle(Queue<Player> playersQueue){
        this.round++;
        System.out.println("ROUND: " + this.round);
        boolean winnerFound = false;
        Player roundWinner = null;
        while(!winnerFound){
            Player player = playersQueue.poll();
            player.defaultAttack(playersQueue.peek());
            if(player.isRoundWinner()){
                roundWinner = player;
                winnerFound = true;
            } else{
                playersQueue.offer(player);
            }

        }
        return roundWinner;
    }

    public void startTheGame(){
        boolean winnerFound = false;
        this.roundWinners = new HashMap<>();
        while(!winnerFound){
            this.player1.setHealthPoints(20);
            this.player2.setHealthPoints(20);
            this.player1.setRoundWinner(false);
            this.player2.setRoundWinner(false);
            Queue<Player> playersQueue = this.generateQueue();
            Player player = this.startRoundBattle(playersQueue);
            if(roundWinners.get(player.getName())!=null){
                winnerFound = true;
                System.out.println("The winner is: " + player.getName());
            } else {
                roundWinners.put(player.getName(), player);
            }
        }
    }
}
