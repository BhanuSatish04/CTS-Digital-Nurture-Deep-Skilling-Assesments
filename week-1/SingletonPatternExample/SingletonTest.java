public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Logger Pattern ===\n");
        
        // Test 1: Get multiple instances and verify they're the same
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        
        // Test if all references point to the same instance
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));
        
        // Test hash codes (should be identical)
        System.out.println("\nHash codes:");
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger3 hashCode: " + logger3.hashCode());
        
        // Test logging functionality
        System.out.println("\n=== Testing Logging Functionality ===");
        logger1.log("This is a general log message from logger1");
        logger2.logInfo("This is an info message from logger2");
        logger3.logError("This is an error message from logger3");
        
        // Test multi-threading scenario
        System.out.println("\n=== Testing Thread Safety ===");
        testThreadSafety();
    }
    
    // Method to test thread safety of Singleton
    private static void testThreadSafety() {
        Thread thread1 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Message from Thread 1");
        });
        
        Thread thread2 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Message from Thread 2");
        });
        
        Thread thread3 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Message from Thread 3");
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
        
        System.out.println("Thread safety test completed!");
    }
}
