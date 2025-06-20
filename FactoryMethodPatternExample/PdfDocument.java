public class PdfDocument implements Document {
    private String fileName;
    private boolean isEncrypted;
    
    public PdfDocument() {
        this.fileName = "Untitled.pdf";
        this.isEncrypted = false;
    }
    
    @Override
    public void create() {
        System.out.println("Creating PDF Document: " + fileName);
        System.out.println("Initializing PDF structure and metadata...");
    }
    
    @Override
    public void open() {
        System.out.println("Opening PDF Document: " + fileName);
        if (isEncrypted) {
            System.out.println("PDF is encrypted - requesting password...");
        }
    }
    
    @Override
    public void save() {
        System.out.println("Saving PDF Document: " + fileName);
        System.out.println("Optimizing PDF size and applying compression...");
    }
    
    @Override
    public void close() {
        System.out.println("Closing PDF Document: " + fileName);
    }
    
    @Override
    public String getType() {
        return "Portable Document Format";
    }
    
    @Override
    public String getFileExtension() {
        return ".pdf";
    }
    
    // PDF-specific methods
    public void encrypt(String password) {
        this.isEncrypted = true;
        System.out.println("PDF encrypted with password protection");
    }
    
    public void addWatermark(String watermarkText) {
        System.out.println("Adding watermark: " + watermarkText);
    }
}

