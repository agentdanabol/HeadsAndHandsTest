package entity;

import action.Heal;

public class Player extends Creature implements Heal {

    private int healCount = 4;

    public Player(int attack, int defense, int initialHealth, int damageStart, int damageEnd) {
        setAttack(attack);
        setDefense(defense);
        setInitialHealth(initialHealth);
        setDamage(damageStart, damageEnd);
    }

    @Override
    public boolean heal() {
        if(healCount > 0) {
            int healthRestore = ((int) (this.getInitialHealth() * 0.3)) + getCurrentHealth();
            this.setCurrentHealth(Math.min(healthRestore, this.getInitialHealth()));
            healCount --;
            System.out.println(this + " восстановил часть здоровья");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Игрок";
    }

}
