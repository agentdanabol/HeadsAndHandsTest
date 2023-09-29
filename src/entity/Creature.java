package entity;

import action.Hit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Creature implements Hit<Creature> {

    private int attack;
    private int defense;
    private int currentHealth;
    private int initialHealth;
    private List<Integer> damage;
    private boolean isAlive = true;

    @Override
    public boolean hit(Creature enemy) {
        if (!isAlive()) {
            return false;
        }
        int attackModifier = this.getAttack() - enemy.getDefense()  + 1;
        boolean success = false;

        if(attackModifier < 1) {
            attackModifier = 1;
        }
        for (int  i = 0; i < attackModifier; i++) {
            int res = (int) (Math.random() * 5) + 1;
            if(res == 5 || res == 6) {
                success = true;
                break;
            }
        }
        if(success) {
            Random r = new Random();
            int dmg = getDamage().get(r.nextInt(getDamage().size()));
            System.out.println(this + " успешно атаковал " + enemy + " и нанес ему "
                    + dmg + " урона");
            enemy.setCurrentHealth(enemy.getCurrentHealth() - dmg);
        }
        else {
            System.out.println(enemy + " парировал атаку " + this);
        }
        return success;
    }

    public Creature() {}

    public Creature(int attack, int defense, int initialHealth, int damageStart, int damageEnd) {
        setAttack(attack);
        setDefense(defense);
        setInitialHealth(initialHealth);
        setDamage(damageStart, damageEnd);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if(attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Неверно задан параметр!");
        }
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if(defense < 1 || defense > 30) {
            throw new IllegalArgumentException("Неверно задан параметр!");
        }
        this.defense = defense;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        if(currentHealth <= 0) {
            this.setAlive(false);
            System.out.println(this + " убит");
        }
        this.currentHealth = currentHealth;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
        setCurrentHealth(initialHealth);
    }

    public List<Integer> getDamage() {
        return damage;
    }

    public void setDamage(int damageStart, int damageEnd) {
        if(damageStart < 0 || damageEnd < 0) {
            throw new IllegalArgumentException("Неверно задан параметр!");
        }
        List<Integer> list = new ArrayList<>();
        for(int i = damageStart; i <= damageEnd; i ++) {
            list.add(i);
        }
        this.damage = list;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
