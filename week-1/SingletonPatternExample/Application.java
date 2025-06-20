public class Application {
    public static void main(String[] args) {
        System.out.println("=== Singleton Logger in Action ===\n");
        
        // Simulate different parts of the application using the logger
        simulateUserService();
        simulatePaymentService();
        simulateEmailService();
    }
    
    private static void simulateUserService() {
        Logger logger = Logger.getInstance();
        logger.logInfo("UserService: User registration started");
        logger.log("UserService: Validating user data");
        logger.logInfo("UserService: User registered successfully");
    }
    
    private static void simulatePaymentService() {
        Logger logger = Logger.getInstance();
        logger.logInfo("PaymentService: Processing payment");
        logger.log("PaymentService: Connecting to payment gateway");
        logger.logInfo("PaymentService: Payment processed successfully");
    }
    
    private static void simulateEmailService() {
        Logger logger = Logger.getInstance();
        logger.logInfo("EmailService: Sending welcome email");
        try {
            // Simulate some processing
            Thread.sleep(100);
            logger.log("EmailService: Email sent successfully");
        } catch (InterruptedException e) {
            logger.logError("EmailService: Failed to send email - " + e.getMessage());
        }
    }
}
