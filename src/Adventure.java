public class Adventure {
    private Room currentRoom;

    public Adventure() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        Room room4 = new Room("Room 4");
        Room room5 = new Room("Room 5");
        Room room6 = new Room("Room 6");
        Room room7 = new Room("Room 7");
        Room room8 = new Room("Room 8");
        Room room9 = new Room("Room 9");

        connectEastWest(room1, room2);
        connectEastWest(room2, room3);
        connectNorthSouth(room1, room4);
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
