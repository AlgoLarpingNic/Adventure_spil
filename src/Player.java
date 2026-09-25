import java.util.ArrayList;

public class Player {
  private Room currentRoom;
private ArrayList<Item> items = new ArrayList<>();

  public Player(Room startRoom) {
    this.currentRoom = startRoom;
  }

  public boolean move(String direction) {
    Room nextRoom;

    switch (direction) {
      case "north":
        nextRoom = currentRoom.getNorth();
        break;
      case "east":
        nextRoom = currentRoom.getEast();
        break;
      case "south":
        nextRoom = currentRoom.getSouth();
        break;
      case "west":
        nextRoom = currentRoom.getWest();
        break;
      default:
        return false;
    }

    if (nextRoom == null) {
      return false;
    }

    currentRoom = nextRoom;
    return true;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void add(Item item) {
    items.add(item);
  }

  public void remove(Item item){
    items.remove(item);
  }
}
