// Logger.java - Singleton Logger Class
public class Logger {
    // Private static instance of the Logger class (thread-safe with volatile)
    private static volatile Logger instance;
    
    // Private constructor to prevent instantiation from outside
    private Logger() {
        // Initialize any logging configurations here
        System.out.println("Logger instance created!");
    }
    
    // Public static method to get the single instance (Double-checked locking)
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    // Logging methods
    public void log(String message) {
        System.out.println("[LOG] " + java.time.LocalDateTime.now() + ": " + message);
    }
    
    public void logError(String errorMessage) {
        System.err.println("[ERROR] " + java.time.LocalDateTime.now() + ": " + errorMessage);
    }
    
    public void logInfo(String infoMessage) {
        System.out.println("[INFO] " + java.time.LocalDateTime.now() + ": " + infoMessage);
    }
    
    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }
}
