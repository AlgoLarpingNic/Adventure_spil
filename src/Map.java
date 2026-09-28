public class Map {
    private Room startRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1, ", "You can move south or east from here\n");
        Room room2 = new Room("Room 2, ", "You can move west or east from here\n");
        Room room3 = new Room("Room 3, ", "You can move west or south from here\n");
        Room room4 = new Room("Room 4, ", "You can move north or south from here\n");
        Room room5 = new Room("Room 5, ", "You can move south from here\n");
        Room room6 = new Room("Room 6, ", "You can move north or south from here\n");
        Room room7 = new Room("Room 7, ", "You can move north or east from here\n");
        Room room8 = new Room("Room 8, ", "You can move north, west or east from here\n");
        Room room9 = new Room("Room 9, ", "You can move north or west from here\n");

        connectEastWest(room1, room2);
        connectNorthSouth(room1, room4);
        connectEastWest(room2, room3);
        connectNorthSouth(room3, room6);
        connectNorthSouth(room4, room7);
        connectNorthSouth(room6, room9);
        connectEastWest(room7, room8);
        connectEastWest(room8, room9);
        connectNorthSouth(room5, room8);

        startRoom = room1;

        room1.add(new Item("Lamp", "shiny brass lamp"));
        room2.add(new Item("Potion", "a magical potion"));
        room3.add(new Item("Coin", "a polished gold coin"));
        room4.add(new Item("Sword", "sword - the third leg"));
        room5.add(new Item("Shoe", "a long lost shoe"));
        room7.add(new Item("Mirror", "the ugly mirror"));
    }

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