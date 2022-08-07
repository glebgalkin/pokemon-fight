package pokemon.challenge.engine;

import pokemon.challenge.engine.model.Player;
import pokemon.challenge.engine.util.EventCollector;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GameEngine {

    private Player player1;
    private Player player2;
    private int round;
    HashMap<String, Player> roundWinners;
    private EventCollector eventCollector;

    public GameEngine(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.round = 0;
        eventCollector = new EventCollector();
        this.roundWinners = new HashMap<>();
    }

    public EventCollector startTheGame(){
        boolean gameWinnerFound = false;

        while(!gameWinnerFound){
            preparePlayersForRound();
            Queue<Player> playersQueue = generatePlayerOrder();
            Player player = startRoundBattle(playersQueue);
            eventCollector.reportRoundWinner(player.getName());
            if(roundWinners.get(player.getName())!=null){
                gameWinnerFound = true;
                eventCollector.reportGameWinner(player.getName());
            } else {
                roundWinners.put(player.getName(), player);
            }
        }

        return eventCollector;
    }

    private void preparePlayersForRound(){
        player1.setHealthPoints(20);
        player2.setHealthPoints(20);
        player1.setRoundWinner(false);
        player2.setRoundWinner(false);
    }

    public Queue<Player> generatePlayerOrder(){
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
        round++;
        eventCollector.reportRoundNumber(round);

        Player roundWinner = null;
        boolean roundWinnerFound = false;

        while(!roundWinnerFound){
            Player player = playersQueue.poll();
            generateAttackType(player, playersQueue.peek());
            if(player.isRoundWinner()){
                roundWinner = player;
                roundWinnerFound = true;
            } else{
                playersQueue.offer(player);
            }
        }
        return roundWinner;
    }

    public void generateAttackType(Player attacker, Player otherPlayer) {
        Random rand = new Random();
        int probability = rand.nextInt(101);
        if(probability < 70){
            attack(attacker,otherPlayer, generateDamage("default"));
        } else {
            specialAttack(attacker, otherPlayer, generateDamage("special"));
        }
    }

    private void attack(Player attacker, Player otherPlayer, int damage){
        if(otherPlayer.getHealthPoints()-damage < 0){
            otherPlayer.setHealthPoints(0);
            attacker.setRoundWinner(true);
        } else {
            otherPlayer.setHealthPoints(otherPlayer.getHealthPoints()-damage);
        }
        eventCollector.reportAttack(attacker.getName(), otherPlayer.getName(), damage);
        eventCollector.reportScore(attacker, otherPlayer);
    }

    private void specialAttack(Player attacker, Player otherPLayer, int damage){
        eventCollector.reportSpecialAttack(attacker.getName(), damage);
        attack(attacker, otherPLayer, damage/2);
        attack(attacker, otherPLayer,damage-(damage/2));
    }

    private int generateDamage(String type){
        Random rand = new Random();
        if(type.equals("default")){
            return rand.nextInt(10) + 1;
        } else {
            return 5 + rand.nextInt(11);
        }
    }
}
