import java.util.ArrayList;

public class Player {
  private Room currentRoom;
  private final ArrayList<Item> items = new ArrayList<>();
  private int health = 100;

  public Player(Room startRoom) {
    this.currentRoom = startRoom;
  }

  //getters fra player til adventure og hp-metoder
  public Room getCurrentRoom() {
    return currentRoom;
  }
  public int getHealth(){
    return health;
  }
  public void changeHealth(int amount){
    health += amount;
  }

  //bevægelsesmetode for cursor
  public boolean move(String direction) {
    Room nextRoom;

    switch (direction) {
      case "north", "n" : nextRoom = currentRoom.getNorth();
        break;
      case "east", "e" : nextRoom = currentRoom.getEast();
        break;
      case "south", "s" : nextRoom = currentRoom.getSouth();
        break;
      case "west", "w" : nextRoom = currentRoom.getWest();
        break;
      default: return false;
    }
    if (nextRoom == null) {
      return false;
    }
    currentRoom = nextRoom;
    return true;
  }

  //ITEM OG INVENTORY METODER

  //getters til rum og item(s)

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
  //FOOD OG EATRESULT METODE TIL PLAYER
  public EatResult eat(String shortName) {
    //find tingen i inv
    Item item = findItem(shortName);
    boolean fromInventory = (item != null);

    if (item == null){
      item = currentRoom.findItem(shortName);
    }
    if (item == null){
      return EatResult.NOT_FOUND;
    }
    //fandt endelig ud af hvordan man bruger ! på instanceof
    if (!(item instanceof Food food)) {
      return EatResult.NOT_FOOD;
    }
    changeHealth(food.getHealthPoints());
    if (fromInventory) {
      items.remove(item);
    }
    else {
      currentRoom.remove(item);
    }
    return EatResult.EATEN;
  }





}
