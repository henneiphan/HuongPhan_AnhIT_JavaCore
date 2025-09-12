package Buoi1_BTVN_NangCao;

import java.util.Random;

class Player {
    private String ten;
    private int hp;
    static final int MAX_HP = 100;

    public Player(String ten) {
        this.ten = ten;
        this.hp = MAX_HP;
    }

    public void attack(Player enemy) {
        Random rand = new Random();
        int damage = rand.nextInt(21) + 10; // random 10 -> 30
        enemy.hp -= damage;
        if (enemy.hp < 0) enemy.hp = 0;

        System.out.println(this.ten + " tấn công " + enemy.ten +
                " gây " + damage + " sát thương. " +
                "Máu còn lại của " + enemy.ten + ": " + enemy.hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Player p1 = new Player("Người chơi 1");
        Player p2 = new Player("Người chơi 2");

        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Lượt " + i + " ---");
            p1.attack(p2);
            if (!p2.isAlive()) break;
            p2.attack(p1);
            if (!p1.isAlive()) break;
        }
    }
}
