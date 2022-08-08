package pokemon.fight.service.pokemon.dto;

public class PlayersConfig {
    private String playerOneChoice;
    private String playerTwoChoice;

    public PlayersConfig(){};

    public String getPlayerOneChoice() {return playerOneChoice;}

    public String getPlayerTwoChoice() {return playerTwoChoice;}

    public void setPlayerOneChoice(String playerOneChoice) {
        this.playerOneChoice = playerOneChoice;
    }

    public void setPlayerTwoChoice(String playerTwoChoice) {
        this.playerTwoChoice = playerTwoChoice;
    }
}
