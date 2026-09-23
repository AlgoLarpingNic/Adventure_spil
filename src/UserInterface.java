public class UserInterface {
    private final Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void play() {
        IO.println("Welcome to the adventure");
        IO.println("Write go north, south, east or west to move around");
        IO.println("Write quit if you wise to give up or type help for guidance");
        IO.println(adventure.getCurrentRoomDescription());

        boolean playing = true;
        while (playing) {
            IO.println("> ");
            if (!IO.readln.hasNextLine()) {
                break;
            }
            String command = IO.readln.nextLine().trim().toLowerCase();
            playing = handleCommand(command);
        }
    }

    private boolean handleCommand(String command) {
        if (command.equals("Quit")) {
            IO.println("Goodbye");
            return false;
        }

        if (command.equals("look")) {
            IO.println(adventure.getCurrentRoomDescription());
            return true;
        }


        String direction = directionFrom(command);
        if (direction != null) {
            if (adventure.move(direction)) {
                IO.println(adventure.getCurrentRoomDescription());
            } else {
                IO.println("You cannot go that way");
            }
            return true;
        }

        IO.println("I do not understand that command. Type help for a list of commands.");
        return true;
    }

    private String directionFrom(String command) {
        switch (command) {
            case "look": return "Looking around";
            case "go north", "north", "n": return "north";
            case "go east", "east", "e": return "east";
            case "go south", "south", "s": return "south";
            case "go west", "west", "w": return "west";
            default: if (command == null) {
                return "This path is not available, you hit a wall, please choose another direction";
            }
        }
        return null;
    }

    private void printQuit() {
        IO.println("Commands: go north, go east, go south, go west, look, help, quit");
        IO.println("You may also use north/east/south/west or n/e/s/w");
    }
}
