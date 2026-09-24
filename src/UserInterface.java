public class UserInterface {
    private final Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }


    public void adventureGame() {
        IO.println("Welcome to adventure game");
        IO.println();
        IO.println("Write north, south, east or west to move around");
        IO.println("Type help for commands and look to look around");
        IO.println("If you wish to give up type quit");
        IO.println(adventure.getCurrentRoomDescription());

        boolean playing = true;


        while (playing) {
            IO.println("> ");
            String command = IO.readln().trim().toLowerCase();

            String response = adventure.handleCommand(command);

            IO.println(response);

            if (command.equals("quit")) {
                playing = false;
            }
        }
    }
}


