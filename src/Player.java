import java.util.Random;

public class Player {
    private final int playerId;
    private final String playerName;

    public Player(String playerName) {
        this.playerId = new Random().nextInt(100000);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }
}