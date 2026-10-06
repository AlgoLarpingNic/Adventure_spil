public class Enemy {
  private final String shortName;
  private final String longName;
  private String description;
  private int health;
  private Weapon weapon;
  private Room currentRoom;

  public Enemy(String shortName, String longName, String description, int health, Weapon weapon, Room currentRoom) {
    this.shortName = shortName;
    this.longName = longName;
    this.description = description;
    this.health = health;
    this.weapon = weapon;
    this.currentRoom = currentRoom;
  }

  public String getShortName() {
    return shortName;
  }

  public String getLongName() {
    return longName;
  }

  public int getHealth() {
    return health;
  }

  public void attack(Player player) {
    player.hit(weapon);
  }

  public void hit(Weapon playerWeapon) {
    health -= playerWeapon.getDamage();
    if (health <= 0) {
      die();
    }
  }

  private void die() {
    currentRoom.add(weapon);
    currentRoom.add(new Item("Corps", "the corps of: " + longName));
    currentRoom.removeEnemy(this);
  }
}
