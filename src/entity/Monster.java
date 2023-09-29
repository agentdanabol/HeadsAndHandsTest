package entity;

public class Monster extends Creature {

    public Monster(int attack, int defense, int initialHealth, int damageStart, int damageEnd) {
        setAttack(attack);
        setDefense(defense);
        setInitialHealth(initialHealth);
        setDamage(damageStart, damageEnd);
    }

    @Override
    public String toString() {
        return "Монстр";
    }

}
