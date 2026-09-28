import java.util.ArrayList;

public class Player {
  private Room currentRoom;
  private final ArrayList<Item> items = new ArrayList<>();

  public Player(Room startRoom) {
    this.currentRoom = startRoom;
  }

  public boolean move(String direction) {
    Room nextRoom;

    switch (direction) {
      case "north" : nextRoom = currentRoom.getNorth();
        break;
      case "east" : nextRoom = currentRoom.getEast();
        break;
      case "south" : nextRoom = currentRoom.getSouth();
        break;
      case "west" : nextRoom = currentRoom.getWest();
        break;
      default: return false;
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

  public ArrayList<Item> getItems() {
    return items;
  }

  // Finder et item i spillerens inventory. Returnerer null hvis ikke fundet. */
  public Item findItem(String shortName) {
    for (Item item : items) {
      if (item.getShortName().equalsIgnoreCase(shortName)) {
        return item;
      }
    }
    return null;
  }

  // Tager et item fra det aktuelle rum og lægger det i inventory. Returnerer det flyttede Item, eller null hvis det ikke fandtes i rummet.
  public Item takeItem(String shortName) {
    Item item = currentRoom.findItem(shortName);
    if (item == null) {
      return null;
    }
    currentRoom.remove(item);
    items.add(item);
    return item;
  }


  //Lægger et item fra inventory ned i det aktuelle rum. Returnerer det flyttede Item, eller null hvis spilleren ikke har det.
  public Item dropItem(String shortName) {
    Item item = findItem(shortName);
    if (item == null) {
      return null;
    }
    items.remove(item);
    currentRoom.add(item);
    return item;
  }
}
