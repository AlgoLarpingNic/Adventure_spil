public class Room {
    private final String name;
    private final String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setNorth(Room room) {
        north = room;
    }

    public Room getNorth() {
        return north;
    }

    public void setEast(Room room) {
        east = room;
    }

    public Room getEast() {
        return east;
    }

    public void setSouth(Room room) {
        south = room;
    }

    public Room getSouth() {
        return south;
    }

    public void setWest(Room room) {
        west = room;
    }

    public Room getWest() {
        return west;
    }
}
