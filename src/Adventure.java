public class Adventure {
    private final Map map;
    private final Player player;

    public Adventure() {
      map = new Map();
      player = new Player(map.getStartRoom());
    }

    public boolean move(String direction) {
      return player.move(direction);
    }

    public String getCurrentRoomDescription() {
      return "You are in " + player.getCurrentRoom();
    }

    public Item take(String shortName) {
        return player.takeItem(shortName);
    }

    public Item drop(String shortName) {
        return player.dropItem(shortName);
    }

    public java.util.ArrayList<Item> getInventory() {
        return player.getItems();
    }
}
