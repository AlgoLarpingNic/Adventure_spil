import java.util.ArrayList;

public class Room {
  private final String name;
  private final String description;
  //listen vi bruger til ting i rummene
  private final ArrayList<Item> items;
  private final ArrayList<Enemy> enemies;
  private Room north;
  private Room east;
  private Room south;
  private Room west;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
    this.items = new ArrayList<>();
    this.enemies = new ArrayList<>();
  }

  //getters til rummet
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  //getters til at bygge map
  public Room getNorth() {
    return north;
  }

  public Room getEast() {
    return east;
  }

  public Room getSouth() {
    return south;
  }

  public Room getWest() {
    return west;
  }

  //setters til connectors
  public void setNorth(Room room) {
    north = room;
  }

  public void setEast(Room room) {
    east = room;
  }

  public void setSouth(Room room) {
    south = room;
  }

  public void setWest(Room room) {
    west = room;
  }

  //add funktion/metode til gamemap
  public void add(Item item) {
    items.add(item);
  }

  //remove -||-
  public void remove(Item item) {
    items.remove(item);
  }

  //items i rum(met)
  public ArrayList<Item> getItems() {
    return items;
  }

  //søger efter items i rum og safeguarded med samme sn
  public Item findItem(String shortName) {
    for (Item item : items) {
      if (item.getShortName().equalsIgnoreCase(shortName)) {
        return item;
      }
    }
    return null;
  }

  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
  }

  public void removeEnemy(Enemy enemy) {
    enemies.remove(enemy);
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  // Finder en fjende ud fra shortName. Returnerer null hvis ikke fundet.
  public Enemy findEnemy(String shortName) {
    if (shortName == null || shortName.isEmpty()) {
      return null;
    }
    for (Enemy enemy : enemies) {
      if (enemy.getShortName().equalsIgnoreCase(shortName)) {
        return enemy;
      }
    }
    return null;
  }

  // Returnerer den første fjende i rummet, eller null hvis rummet er tomt.
  public Enemy getFirstEnemy() {
    if (enemies.isEmpty()) {
      return null;
    }
    return enemies.get(0);
  }


  @Override
  public String toString() {
    return "You are in " + this.getName() + System.lineSeparator() + this.getDescription()
            + "Available items: " + this.getItems() + "\n";
  }
}
