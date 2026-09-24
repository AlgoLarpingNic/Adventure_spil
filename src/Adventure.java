public class Adventure {
    private Map map;
    private Player player;

    public Adventure() {
      map = new Map();
      player = new Player(map.getStartRoom());
    }

    public boolean move(String direction) {
      return player.move(direction);
    }

    public String getCurrentRoomDescription() {
      return player.getCurrentRoomDescription();
    }
  }