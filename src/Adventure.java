public class Adventure {
    //vi skal have fat i en player for at kunne kalde- og instanciere metoderne
    private final Player player;
    private boolean running = true;

    //vi bygger vores map med metoder og objekter fra rooms
    public Adventure() {
        GameMap map = new GameMap();
        this.player = new Player(map.getStartRoom());
    }

    //vi skal kunne se hvor vores cursor/player er henne
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    //getters til player i adventure så vi kan nøjes med at player har en 'has-a' relation til adventure men ikke andet
    public int getHealth() {
        return player.getHealth();
    }

    //eat-metode fra player i adventure
    public EatResult eat(String shortName){
        return player.eat(shortName);
    }
    //equip-metode fra player i adventure
    public EquipResult equip(String shortName) {
        return player.equip(shortName);
    }

    public AttackResult attack() {
        return player.attack();
    }

    public Weapon getEquippedWeapon() {
        return player.getEquippedWeapon();
    }

    //vi skal kunne se om tingen vi søger findes i inv eller rummet
    public Item findItemAnywhere(String shortName){
        Item item = player.findItem(shortName);
        if (item != null) {
            return item;
        }
        return player.getCurrentRoom().findItem(shortName);
    }

    //move funktion fra player/cursor til selve adventure/map
    public boolean move(String direction) {
        return player.move(direction);
    }

    //arraylisten inventory fra player som består af Item(s)
    public java.util.List<Item> getInventory() {
        return player.getItems();
    }

    //take metode fra player
    public Item take(String shortName) {
        return player.takeItem(shortName);
    }

    //drop metode fra player
    public Item drop(String shortName) {
        return player.dropItem(shortName);
    }

    //metode til at "slukke" while-loopet/spillet
    public boolean isRunning() {
        return running;
    }
    public void quit() {
        running = false;
    }
}