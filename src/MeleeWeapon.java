class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortName, String longName, int damage, String attack) {
        super(shortName, longName, damage, attack);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public int use() {
        return -1;
    }
    @Override
    public int remainingUses() {
        return -1;
    }

}