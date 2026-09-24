public class Player {
    private Room currentRoom;

    public Player(Room startRoom) {
        this.currentRoom=startRoom;
    }

    public String move(String direction) {
        Room nextRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "east" -> currentRoom.getEast();
            case "west" -> currentRoom.getWest();
            default -> null;
        };

        if (nextRoom == null) {
            return "You hit a wall";
        }

        currentRoom = nextRoom;
        return getCurrentRoomDescription();
    }

    public String getCurrentRoomDescription() {
        return "You are in " + currentRoom.getName() + System.lineSeparator() + currentRoom.getDescription();
    }
}
