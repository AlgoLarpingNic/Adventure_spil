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
      IO.println("You hit a wall, please choose another direction");
    }
  }

  public void adventureGame() {
    boolean adventureDone = false;
    IO.println();
    IO.println("Welcome to the adventure game");
    IO.println();
    IO.println("INTRUCTIONS:");
    IO.println("Write north/n, south/s, east/e or west/w to move around");
    IO.println("Type 'help' for commands and 'look' to look around");
    IO.println("If you wish to give up, type 'quit'");
    IO.println();
    IO.println("ITEMS:");
    IO.println("If an item is available, you can collect the item by typing 'take' and the name of the item");
    IO.println("If you wish to leave a item behind, type 'drop' and the name of the item");
    IO.println("You can at any time type 'inventory' or 'inv' to see what you are carrying");
    IO.println();
    IO.println("START");
    IO.println(adventure.getCurrentRoomDescription());

    while (!adventureDone) {
      String input = IO.readln().trim();
      if (input.isEmpty()) continue;

      // Deler string[] op i var (parts), og splitter efter første ord. (fx "take lamp" → ["take", "lamp"])
      String[] parts = input.split("\\s+", 2);
      String command = parts[0].toLowerCase();
      String argument = parts.length > 1 ? parts[1].trim() : "";

      switch (command) {
        case "north", "n" -> go("north");
        case "south", "s" -> go("south");
        case "east", "e" -> go("east");
        case "west", "w" -> go("west");
        case "look", "l" -> IO.println(adventure.getCurrentRoomDescription());
        case "help", "h" -> IO.println("Commands: quit, look, north, south, east and west");
        case "quit", "q" -> {
          IO.println("Goodbye looser");
          adventureDone = true;
        }
        case "take" -> {
          if (argument.isEmpty()) {
            IO.println("Take what?");
          } else {
            Item taken = adventure.take(argument);
            if (taken != null) {
              IO.println("You have taken the " + taken.longName());
            } else {
              IO.println("There is nothing like " + argument + " to take around here");
            }
          }
        }
        case "drop" -> {
          if (argument.isEmpty()) {
            IO.println("Drop what?");
          } else {
            Item dropped = adventure.drop(argument);
            if (dropped != null) {
              IO.println("You have dropped " + dropped.longName());
            } else {
              IO.println("You don't have anything like " + argument + " in your inventory");
            }
          }
        }
        case "inventory", "inv", "invent" -> {
          var inv = adventure.getInventory();
          if (inv.isEmpty()) {
            IO.println("You are carrying nothing.");
          } else {
            IO.println("You are carrying: " + inv);
          }
        }
        default -> IO.println("Unknown command, type help to see commands");
      }
    }
  }
}