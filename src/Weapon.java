public abstract class Weapon extends Item {
    private final int damage;
    private final String attack;

    public Weapon(String shortName, String longName, int damage, String attack) {
        super(shortName, longName);
        this.damage = damage;
        this.attack = attack;
    }
    abstract boolean canUse();
    abstract int use();

    @Override
    public String getShortName() {
        return super.getShortName();
    }

    @Override
    public String getLongName() {
        return super.getLongName();
    }

    public int getDamage() {
        return damage;
    }

    public String getAttack() {
        return attack;
    }

}


