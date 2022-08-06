package pokemon.application.service.game.dto;

public class Game {

    private Player player1;
    private Player getPlayer2;
    private int round;
    private int normalAttack;
    private int specialAttack;
    private String gameWinner;

    public Game(Player player1, Player getPlayer2) {
        this.player1 = player1;
        this.getPlayer2 = getPlayer2;
        this.round = 1;
        this.gameWinner = null;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getGetPlayer2() {
        return getPlayer2;
    }

    public void setGetPlayer2(Player getPlayer2) {
        this.getPlayer2 = getPlayer2;
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
}
