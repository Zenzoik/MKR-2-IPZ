import java.util.ArrayList;
import java.util.List;

// Конкретний медіатор
class Arena implements Mediator {
    private List<Character> characters = new ArrayList<>();

    public void registerCharacter(Character character) {
        characters.add(character);
        System.out.println(character.name + " доданий на арену.");
    }

    public void sendCommand(Character sender, String action) {
        System.out.println(sender.name + " виконує дію: " + action);
        for (Character c : characters) {
            if (c != sender) {
                System.out.println("Сповіщення для " + c.name + ": " + sender.name + " виконав дію " + action);
            }
        }
    }

    // Новий метод для широкомовних повідомлень
    public void broadcastMessage(String message) {
        for (Character c : characters) {
            System.out.println("Повідомлення для " + c.name + ": " + message);
        }
    }
}
