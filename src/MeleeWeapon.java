class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortName, String longName, int damage, String attack) {
        super(shortName, longName, damage, attack);
    }
    boolean canUse() {
        return true;
    }
    int use(){
        return -1;
    }




}