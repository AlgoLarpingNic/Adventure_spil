public class Adventure {
    private final Map map;
    private final Player player;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartRoom());
    }



    public String handleCommand(String command) {
        return switch (command) {
            case "look" -> player.getCurrentRoomDescription();
            case "help" -> "Commands: quit, look, north, south, east, west";
            case "north", "south", "east", "west" -> player.move(command);
            case "quit" -> "Goodbye looser";
            default -> "Unknown command, type help to se commands";
        };
    }
    public String getCurrentRoomDescription() {
        return player.getCurrentRoomDescription();
    }

}
