public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");
        
        // Create different document factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Create document manager
        DocumentManager manager = new DocumentManager(wordFactory);
        
        // Test 1: Create and process Word document
        System.out.println("--- Creating Word Document ---");
        Document wordDoc = manager.createNewDocument();
        manager.processDocument(wordDoc);
        System.out.println("Document Type: " + wordDoc.getType());
        System.out.println("File Extension: " + wordDoc.getFileExtension());
        
        System.out.println("\n--- Creating PDF Document ---");
        manager.setFactory(pdfFactory);
        Document pdfDoc = manager.createNewDocument();
        manager.processDocument(pdfDoc);
        System.out.println("Document Type: " + pdfDoc.getType());
        System.out.println("File Extension: " + pdfDoc.getFileExtension());
        
        System.out.println("\n--- Creating Excel Document ---");
        manager.setFactory(excelFactory);
        Document excelDoc = manager.createNewDocument();
        manager.processDocument(excelDoc);
        System.out.println("Document Type: " + excelDoc.getType());
        System.out.println("File Extension: " + excelDoc.getFileExtension());
        
        // Test 2: Demonstrate polymorphic behavior
        System.out.println("\n=== Polymorphic Document Processing ===");
        Document[] documents = {
            wordFactory.createDocument(),
            pdfFactory.createDocument(),
            excelFactory.createDocument()
        };
        
        for (Document doc : documents) {
            System.out.println("\nProcessing: " + doc.getType());
            doc.create();
            doc.open();
            doc.save();
            doc.close();
        }
        
        // Test 3: Factory selection based on file extension
        System.out.println("\n=== Dynamic Factory Selection ===");
        testDynamicFactorySelection();
    }
    
    private static void testDynamicFactorySelection() {
        String[] fileTypes = {"docx", "pdf", "xlsx", "unknown"};
        
        for (String fileType : fileTypes) {
            DocumentFactory factory = getFactoryForFileType(fileType);
            if (factory != null) {
                System.out.println("Creating document for ." + fileType + " file:");
                Document doc = factory.createDocument();
                System.out.println("Created: " + doc.getType());
            } else {
                System.out.println("No factory available for ." + fileType + " files");
            }
        }
    }
    
    private static DocumentFactory getFactoryForFileType(String fileType) {
        switch (fileType.toLowerCase()) {
            case "docx":
            case "doc":
                return new WordDocumentFactory();
            case "pdf":
                return new PdfDocumentFactory();
            case "xlsx":
            case "xls":
                return new ExcelDocumentFactory();
            default:
                return null;
        }
    }
}