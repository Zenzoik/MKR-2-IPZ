import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вибір типу персонажа
        System.out.println("Оберіть тип персонажа: воїн, маг, лучник");
        String type = scanner.nextLine();

        System.out.println("Введіть ім'я персонажа:");
        String name = scanner.nextLine();

        // Створення персонажа за допомогою фабричного методу
        Character player = CharacterFactory.createCharacter(type, name);
        player.display();

        // Дії персонажа
        System.out.println("Рухаємо персонажа...");
        player.move(5, 3);

        System.out.println("Атакуємо противника...");
        Character enemy = new Warrior("Ворог");
        player.attack(enemy);

        scanner.close();
    }
}
