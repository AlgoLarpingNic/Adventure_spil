import java.util.ArrayList;

public class GameMap {
  ArrayList<Room> createMap = new ArrayList<>();
  private final Room startRoom;

  public GameMap() {

    Room room1 = new Room("Room 1, ", "you can move south or east from here");
    Room room2 = new Room("Room 2, ", "you can move west or east from here");
    Room room3 = new Room("Room 3, ", "you can move west or south from here");
    Room room4 = new Room("Room 4, ", "you can move north or south from here");
    Room room5 = new Room("Room 5, ", "you can move south from here");
    Room room6 = new Room("Room 6, ", "you can move north or south from here");
    Room room7 = new Room("Room 7, ", "you can move north or east from here");
    Room room8 = new Room("Room 8, ", "you can move north, west or east from here");
    Room room9 = new Room("Room 9, ", "you can move north or west from here");

    this.startRoom = room1;

    createMap.add(room1);
    createMap.add(room2);
    createMap.add(room3);
    createMap.add(room4);
    createMap.add(room5);
    createMap.add(room6);
    createMap.add(room7);
    createMap.add(room8);
    createMap.add(room9);

    connectEastWest(room1, room2);
    connectNorthSouth(room1, room4);
    connectEastWest(room2, room3);
    connectNorthSouth(room3, room6);
    connectNorthSouth(room4, room7);
    connectNorthSouth(room6, room9);
    connectEastWest(room7, room8);
    connectEastWest(room8, room9);
    connectNorthSouth(room5, room8);

    room1.add(new Item("Lamp", "shiny brass lamp"));
    room2.add(new Item("Potion", "a magical potion"));
    room3.add(new Item("Coin", "a polished gold coin"));
    room5.add(new Item("Shoe", "a long lost shoe"));
    room7.add(new Item("Mirror", "the ugly mirror"));

    room2.add(new Food("Bread", "a loaf of stale bread", 10));
    room4.add(new Food("Bunny", "a delicious little Bunny", 40));
    room5.add(new Food("Mushroom", "a pale glowing mushroom", -30));
    room6.add(new Food("Steak", "a big fat juicy steak", 80));
    room8.add(new Food("Potato", "a boring rotten potato", -50));
    room9.add(new Food("Carrot", "The golden carrot", 100));

    room1.add(new MeleeWeapon("Sword", "a dusty third legged friend", 25,
            "You swing your third legged friend at the empty air."));
    room2.add(new RangedWeapon("Revolver", "colt 1851 navy cartridge conversion revolver", 35,
            "You fire the colt revolver into the empty air.", 6));  // 6 skud!

    room4.addEnemy(new Enemy("Skeleton", "a silent striker enemy", "lurks in the corners", 60,
            new RangedWeapon("Bow", "a deadly bow", 20, "you shot and hit the player", 4), room4));
    room2.addEnemy(new Enemy("Sødkat", "Puss in boots", "Quick and fearless", 50,
            new MeleeWeapon("Saber", "a Narrow pointy saber", 9, "you stabbed and hit the player"), room2));
    room7.addEnemy(new Enemy("goraffen", "the mix between a giraffe and gorilla", "fills the room with terror", 80,
            new MeleeWeapon("Brass knuckles", "a gold metal fist", 30, "you punched and hit the player"), room7));
  }

  //connectors til at bygge logikken mellem "døre"
  private void connectEastWest(Room westRoom, Room eastRoom) {
    westRoom.setEast(eastRoom);
    eastRoom.setWest(westRoom);
  }

  private void connectNorthSouth(Room northRoom, Room southRoom) {
    northRoom.setSouth(southRoom);
    southRoom.setNorth(northRoom);
  }

  public Room getStartRoom() {
    return startRoom;
  }
}