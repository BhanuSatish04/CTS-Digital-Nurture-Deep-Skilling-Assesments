public class DocumentManager {
    private DocumentFactory factory;
    
    public DocumentManager(DocumentFactory factory) {
        this.factory = factory;
    }
    
    public void setFactory(DocumentFactory factory) {
        this.factory = factory;
    }
    
    public Document createNewDocument() {
        factory.displayFactoryInfo();
        return factory.newDocument();
    }
    
    public void processDocument(Document document) {
        document.open();
        
        // Demonstrate type-specific operations
        if (document instanceof WordDocument) {
            WordDocument wordDoc = (WordDocument) document;
            wordDoc.insertTable(3, 4);
            wordDoc.applyStyle("Heading 1");
        } else if (document instanceof PdfDocument) {
            PdfDocument pdfDoc = (PdfDocument) document;
            pdfDoc.addWatermark("CONFIDENTIAL");
            pdfDoc.encrypt("password123");
        } else if (document instanceof ExcelDocument) {
            ExcelDocument excelDoc = (ExcelDocument) document;
            excelDoc.addWorksheet("Data Sheet");
            excelDoc.insertFormula("A1", "=SUM(B1:B10)");
        }
        
        document.save();
        document.close();
    }
}
