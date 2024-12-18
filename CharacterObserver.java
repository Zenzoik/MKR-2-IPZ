// Персонаж як Спостерігач
class CharacterObserver extends Character implements Observer {
    public CharacterObserver(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " отримав повідомлення: " + message);
    }

    @Override
    public void display() {
        System.out.println("Спостерігач " + name + " готовий до бою.");
    }
}
