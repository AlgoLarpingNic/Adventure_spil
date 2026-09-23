public class Adventure {
    private Room currentRoom;

    public Adventure() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1, ", "you can move south or east from here\n");
        Room room2 = new Room("Room 2, ", "you can move west or east from here\n");
        Room room3 = new Room("Room 3, ", "you can move west or south from here\n");
        Room room4 = new Room("Room 4, ", "you can move north or south from here\n");
        Room room5 = new Room("Room 5, ", "you can move south from here\n");
        Room room6 = new Room("Room 6, ", "you can move north or east from here\n");
        Room room7 = new Room("Room 7, ", "you can move north or east from here\n");
        Room room8 = new Room("Room 8, ", "you can move north, west or east from here\n");
        Room room9 = new Room("Room 9, ", "you can move north or west from here\n");

        connectEastWest(room1, room2);
        connectNorthSouth(room1, room4);
        connectEastWest(room2, room3);
        connectNorthSouth(room3, room6);
        connectNorthSouth(room4, room7);
        connectNorthSouth(room6, room9);
        connectEastWest(room7, room8);
        connectEastWest(room8, room9);
        connectNorthSouth(room5, room8);

        currentRoom = room1;
    }

    private void connectEastWest(Room westRoom, Room eastRoom) {
        westRoom.setEast(eastRoom);
        eastRoom.setWest(westRoom);
    }

    private void connectNorthSouth(Room northRoom, Room southRoom) {
        northRoom.setSouth(southRoom);
        southRoom.setNorth(northRoom);
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

    public String getCurrentRoomDescription() {
        return "You are in " + currentRoom.getName() + System.lineSeparator() + currentRoom.getDescription();
    }
}
