abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int x, y; // Координати

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.x = 0; // Початкові координати
        this.y = 0;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        System.out.println(name + " перемістився на позицію (" + x + ", " + y + ")");
    }

    public void attack(Character target) {
        System.out.println(name + " атакує " + target.name + " і завдає " + attackPower + " шкоди!");
        target.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " отримав " + damage + " шкоди. Залишилось здоров'я: " + health);
    }

    public abstract void display();
}

// Воїн
class Warrior extends Character {
    public Warrior(String name) {
        super(name, 150, 20);
    }

    @Override
    public void display() {
        System.out.println("Воїн " + name + ": Здоров'я = " + health + ", Атака = " + attackPower);
    }
}

// Маг
class Mage extends Character {
    public Mage(String name) {
        super(name, 120, 30);
    }

    @Override
    public void display() {
        System.out.println("Маг " + name + ": Здоров'я = " + health + ", Атака = " + attackPower);
    }
}

// Лучник
class Archer extends Character {
    public Archer(String name) {
        super(name, 100, 40);
    }

    @Override
    public void display() {
        System.out.println("Лучник " + name + ": Здоров'я = " + health + ", Атака = " + attackPower);
    }
}

// Фабрика персонажів
class CharacterFactory {
    public static Character createCharacter(String type, String name) {
        switch (type.toLowerCase()) {
            case "воїн":
                return new Warrior(name);
            case "маг":
                return new Mage(name);
            case "лучник":
                return new Archer(name);
            default:
                throw new IllegalArgumentException("Невідомий тип персонажа");
        }
    }
}
