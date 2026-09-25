public class Map {
    private Room startRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1, ", "you can move south or east from here");
        Room room2 = new Room("Room 2, ", "you can move west or east from here");
        Room room3 = new Room("Room 3, ", "you can move west or south from here");
        Room room4 = new Room("Room 4, ", "you can move north or south from here");
        Room room5 = new Room("Room 5, ", "you can move south from here");
        Room room6 = new Room("Room 6, ", "you can move north or south from here");
        Room room7 = new Room("Room 7, ", "you can move north or east from here");
        Room room8 = new Room("Room 8, ", "you can move north, west or east from here");
        Room room9 = new Room("Room 9, ", "you can move north or west from here");

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

        room1.add(new Item("Lamp", "A shiny brass lamp"));
        room4.add(new Item("Sword", "The third leg"));
        room7.add(new Item("Mirror", "The ugly mirror"));
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