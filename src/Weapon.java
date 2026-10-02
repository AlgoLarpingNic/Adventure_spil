public abstract class Weapon extends Item {
    private final int damage;
    private final String attackText;

    public Weapon(String shortName, String longName, int damage, String attackText) {
        super(shortName, longName);
        this.damage = damage;
        this.attackText = attackText;
    }

    public int getDamage(){
    return  damage;
    }

    public String getAttackText(){
        return attackText;

    }

    public abstract boolean canUse();
    public abstract int Use();
    public abstract int remainingUses();
}