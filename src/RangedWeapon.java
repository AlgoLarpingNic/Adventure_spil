class RangedWeapon extends Weapon{
    int ammo;

    public RangedWeapon(String shortName, String longName, int damage, String attack, int ammo) {
        super(shortName, longName, damage, attack);
        this.ammo = ammo;
    }

    //true hvis ammo > 0
    boolean canUse(){
        return ammo > 0;
    }
    //træk 1 fra ammo når våbnet bruges
    int use(){
        if (ammo > 0) {
            ammo -= 1;
        }
    return ammo;
    }

    public boolean hasAmmo(){
        return ammo > 0;
    }

    @Override
    public String getShortName() {
        return super.getShortName();
    }

    @Override
    public String getLongName() {
        return super.getLongName();
    }

    @Override
    public int getDamage() {
        return super.getDamage();
    }

    @Override
    public String getAttack() {
        return super.getAttack();
    }

    public int getAmmo() {
        return ammo;
    }


}


