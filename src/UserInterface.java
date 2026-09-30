import java.util.List;

public class UserInterface {
  private final Adventure adventure;

   /*
    Det er vel sådan her tingene hænger sammen?

                      FOOD--------->ITEM
                       |           /    \
                       |          /      \
                       |         /        \
                      HP<--->PLAYER      GAME-MAP-->ROOM
                                 \        /
                                  \      /
                                  ADVENTURE
                                      |
                                      |
                               USER-INTERFACE

    */

  public UserInterface(Adventure adventure) {
    this.adventure = adventure;
  }

  public void adventureGame() {
    boolean adventureDone = false;
    IO.println("Welcome to the adventure game");
    IO.println("Write north/n, south/s, east/e or west/w to move around");
    IO.println("Type 'help' for commands and 'look' to look around");
    IO.println("If you wish to give up, type quit");
    IO.println(adventure.getCurrentRoom().getDescription());

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
        case "health", "hp" -> showHealth();
        case "look", "l" -> showCurrentRoom();
        case "help", "h" -> showHelp();
        case "quit", "q" -> {
          IO.println("Goodbye");
          adventureDone = true;
        }
        case "take" -> outputTake(argument);
        case "drop" -> outputDrop(argument);
        case "inventory", "inv", "invent" -> showInventory();
        default -> IO.println("Unknown command, type help to see commands");
      }
    }
  }

  private void go(String direction) {
    if (adventure.move(direction)) {
      IO.println("Going " + direction);
      IO.println(adventure.getCurrentRoom().getDescription());
    } else {
      IO.println("You hit a wall, please choose another direction");
    }
  }

  //viser rum + items i det
  private void showCurrentRoom() {
    Room room = adventure.getCurrentRoom();
    IO.println("You are in " + room.getName());
    IO.println(room.getDescription());

    List<Item> items = room.getItems();
    if (!items.isEmpty()) {
      IO.print("Here you see: ");
      for (int i = 0; i < items.size(); i++) {
        if (i > 0) {
          IO.print(", ");
        }
        IO.print(items.get(i).getLongName());
      }
      IO.println();
    }
  }

  //det visuelle output til take
  private void outputTake(String itemName) {
    if (itemName.isEmpty()) {
      IO.println("Take what?");
      return;
    }
    Item taken = adventure.take(itemName);
    if (taken != null) {
      IO.println("You have taken the " + taken.dopeGrammatics());
    } else {
      IO.println("There is nothing like " + itemName + " to take around here");
    }
  }

  //det visuelle output til drop
  private void outputDrop(String itemName) {
    if (itemName.isEmpty()) {
      IO.println("Drop what?");
      return;
    }
    Item dropped = adventure.drop(itemName);
    if (dropped != null) {
      IO.println("You have dropped the " + dropped.dopeGrammatics());
    } else {
      IO.println("You don't have anything like " + itemName + " in your inventory");
    }
  }

  //inv metode/funktion
  private void showInventory() {
    List<Item> inv = adventure.getInventory();
    if (inv.isEmpty()) {
      IO.println("You are carrying nothing.");
    } else {
      IO.print("You are carrying: ");
      for (int i = 0; i < inv.size(); i++) {
        if (i > 0) {
          IO.print(", ");
        }
        IO.print(inv.get(i).getLongName());
      }
      IO.println();
    }
  }

  //selvforklarende
  private void showHelp() {
    IO.println("""
            Available commands:
              go <direction>   - move north, east, south or west (also n/e/s/w)
              look             - describe the current room again
              inventory / inv  - list the items you are carrying
              take <item>      - pick up an item from the room
              drop <item>      - leave an item in the current room
              eat <food>       - eat something from the room or your inventory
              health           - show your current health
              help             - show this help text
              exit / quit      - end the game
            """);
  }

  //hp-"viser"
  private void showHealth() {
    int hp = adventure.getHealth();
    IO.println("Your health-points are now: " + hp);
  }
  //sikre input fra player
  private void outputEat(String itemName) {
    if (itemName.isEmpty()) {
      IO.println("Eat what?");
    }
    //switch-case der sikrer de rigtige outputs til players EatResult
    Item item = adventure.findItemAnywhere(itemName);
    EatResult result = adventure.eat(itemName);
    switch (result) {
      case NOT_FOUND -> IO.println("There is nothing like " + itemName + "to eat around here");
      case NOT_FOOD -> IO.println("You cannot eat the " + item.dopeGrammatics());
      case EATEN -> {
        IO.println("You eat the " + item.dopeGrammatics() + ".");
        int hp = adventure.getHealth();
        IO.println("Your health-points are now: " + hp + ".");
      }
    }
  }
}



