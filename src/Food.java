public class Food extends Item {
    final private int healthPoints;

    //food class med arv fra Item
    public Food(String shortName, String longName, int healthPoints) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }

    //det eneste ekstra det skal indeholde (+-hp)
    public int getHealthPoints() {
        return healthPoints;
    }
}
