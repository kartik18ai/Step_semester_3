public class Problem1_HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getHealth());

        c.heal(50);
        System.out.println("Health after healing 50: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health after 150 damage: " + c.getHealth());
    }
}

class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException("Maximum health cannot be negative.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health = Math.min(maxHealth, health + amount);
        }
    }

    public int getHealth() {
        return health;
    }
}
