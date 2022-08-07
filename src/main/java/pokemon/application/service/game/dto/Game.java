package pokemon.application.service.game.dto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Game {

    private Player player1;
    private Player player2;
    private int round;
    private int normalAttack;
    private int specialAttack;
    private String gameWinner;

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

    public int getNormalAttack() {
        return normalAttack;
    }

    public void setNormalAttack(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(String gameWinner) {
        this.gameWinner = gameWinner;
    }

    public void startTheRound(){
        this.round ++;

        Queue<Player> playerQueue = generateQueue();
        

    }

    public Queue<Player> generateQueue(){
        Queue<Player> playersQueue = new LinkedList<>();
        Random rand = new Random();
        int randomNum = rand.nextInt(2) + 1;

        if(randomNum == 1){
            playersQueue.offer(player1);
            playersQueue.offer(player2);
        } else {
            playersQueue.offer(player2);
            playersQueue.offer(player1);
        }
        return playersQueue;
    }
    
    public Player startRoundBattle(Queue<Player> playersQueue){
        boolean winnerFound = false;
        Player roundWinner = new Player();
        while(!winnerFound){
            Player player = playersQueue.poll();
            if(playersQueue.peek().isRoundWinner()){
                winnerFound = true;
                player.setRoundsWon(player.getRoundsWon()+1);
                System.out.println("Player " + player.getName() + " has won the round." + " Ended up with health: " + player.getHealthPoints()
                        + "while other player" + playersQueue.peek().getName()+ " health is: " + playersQueue.peek().getHealthPoints());
                roundWinner = player;
            } else{
                player.defaultAttack(playersQueue.peek());
                playersQueue.offer(player);
            }
        }
        return roundWinner;
    }
}
