package JavaAssessment.SingletonPattern;

// Singleton class to manage configuration
public class ConfigManager {
    // Private static variable to hold the single instance
    private static ConfigManager configInstance;

    // Private constructor to restrict instantiation
    private ConfigManager() {
        System.out.println("ConfigManager initialized.");
    }

    // Public method to provide global access to the instance
    public static ConfigManager getInstance() {
        if (configInstance == null) {
            configInstance = new ConfigManager();
        }
        return configInstance;
    }

    // Sample method to demonstrate functionality
    public void printConfig() {
        System.out.println("Loading application configuration...");
    }
}

