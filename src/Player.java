import java.util.Random;


public class Player {
    private int playerId;
    private String playerName;

    public Player(int playerId, String playerName){
        Random randomId = new Random();
        this.playerId = playerId;
        this.playerName = IO.readln("Indtast navn: ");
    }

}
