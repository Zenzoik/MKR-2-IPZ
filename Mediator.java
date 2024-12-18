interface Mediator {
    void registerCharacter(Character character);
    void sendCommand(Character sender, String action);
}
