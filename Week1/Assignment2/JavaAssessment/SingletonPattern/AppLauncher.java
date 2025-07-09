package JavaAssessment.SingletonPattern;

public class AppLauncher {
    public static void main(String[] args) {
        ConfigManager manager1 = ConfigManager.getInstance();
        ConfigManager manager2 = ConfigManager.getInstance();

        manager1.printConfig();

        // Check if both instances are the same
        System.out.println(manager1 == manager2); // Output: true
    }
}
