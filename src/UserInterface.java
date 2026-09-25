public class UserInterface {
  private final Adventure adventure;

  public UserInterface(Adventure adventure) {
    this.adventure = adventure;
  }

  private void go(String direction) {
    if (adventure.move(direction)) {
      IO.println("Going " + direction);
      IO.println(adventure.getCurrentRoomDescription());
    } else {
      IO.println("This path is not available, you hit a wall, please choose another direction");
    }
  }

  public void adventureGame() {

    boolean adventureDone = false;
    IO.println();
    IO.println("Welcome to adventure game");
    IO.println();
    IO.println("Write north, south, east or west to move around");
    IO.println("Type help for commands and look to look around");
    IO.println("If you wish to give up, type quit");
    IO.println(adventure.getCurrentRoomDescription());

    while (!adventureDone) {
      String command = IO.readln();

      switch (command) {

        case "look" -> IO.println(adventure.getCurrentRoomDescription());
        case "help" -> IO.println("Commands: quit, look, north, south, east and west");
        case "north" -> go(command);
        case "south" -> go(command);
        case "east" -> go(command);
        case "west" -> go(command);
        case "quit" -> {
          IO.println("Goodbye looser");
          adventureDone = true;
        }
        default -> IO.println("Unknown command, type help to see commands");

            }
          }
        }
      }



