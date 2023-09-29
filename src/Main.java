import entity.Creature;
import entity.Monster;
import entity.Player;

public class Main {

    public static void main(String[] args) {

        Player player = new Player(4, 7, 10, 1, 6);
        Creature zombie = new Monster(2, 4, 5, 2, 4);
        Creature orc = new Monster(3, 3, 4, 0, 4);

        player.hit(zombie);
        zombie.hit(player);
        orc.hit(player);
        player.heal();
        player.hit(orc);
        player.hit(zombie);

    }
}
