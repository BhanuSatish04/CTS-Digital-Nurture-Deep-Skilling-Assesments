public abstract class DocumentFactory {
    // Factory Method - to be implemented by concrete factories
    public abstract Document createDocument();
    
    // Template method that uses the factory method
    public Document newDocument() {
        Document document = createDocument();
        document.create();
        return document;
    }
    
    // Common method for all factories
    public void displayFactoryInfo() {
        System.out.println("Using " + this.getClass().getSimpleName() + " to create documents");
    }
}
