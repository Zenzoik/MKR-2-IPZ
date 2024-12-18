import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вибір типу персонажа гравцем
        System.out.println("Оберіть тип персонажа: воїн, маг, лучник");
        String type = scanner.nextLine();

        System.out.println("Введіть ім'я персонажа:");
        String name = scanner.nextLine();

        // Створення гравця за допомогою фабричного методу
        Character player = CharacterFactory.createCharacter(type, name);
        player.display();

        // Створення медіатора (Арена)
        Arena arena = new Arena();
        arena.registerCharacter(player);

        // Додавання ще декількох персонажів
        Character enemy1 = CharacterFactory.createCharacter("воїн", "Ворог Воїн");
        Character enemy2 = CharacterFactory.createCharacter("маг", "Ворог Маг");
        arena.registerCharacter(enemy1);
        arena.registerCharacter(enemy2);

        // Дії гравця
        System.out.println("Рухаємо персонажа...");
        player.move(2, 3);

        System.out.println("Гравець атакує ворога...");
        player.attack(enemy1);

        // Спостерігач для повідомлень
        CharacterObserver observer = new CharacterObserver("Лучник Спостерігач", 100, 40);
        arena.registerCharacter(observer);

        // Надсилання команд через медіатор
        arena.sendCommand(player, "Підготувався до наступної атаки");
        arena.sendCommand(enemy2, "Використовує магію на гравця");

        // Сповіщення для спостерігача
        observer.update("Гравець атакував Ворога Воїна!");
        observer.update("Ворог Маг використовує магію!");

        scanner.close();
    }
}
