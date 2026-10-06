class RangedWeapon extends Weapon{
    private int ammo;

    public RangedWeapon(String shortName, String longName, int damage, String attackText, int ammo) {
        super(shortName, longName, damage, attackText);
        this.ammo = ammo;
    }

@Override
    public boolean canUse(){
        return ammo > 0;
    }

    @Override
    public int use() {
       if (ammo > 0) {
        ammo--;
       }
       return ammo;
    }
    @Override
    public int remainingUses() {
        return ammo;
    }

}


