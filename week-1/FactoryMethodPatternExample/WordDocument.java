public class WordDocument implements Document {
    private String fileName;
    private String content;
    
    public WordDocument() {
        this.fileName = "Untitled.docx";
        this.content = "";
    }
    
    @Override
    public void create() {
        System.out.println("Creating Word Document: " + fileName);
        System.out.println("Setting up Word document formatting and styles...");
    }
    
    @Override
    public void open() {
        System.out.println("Opening Word Document: " + fileName);
        System.out.println("Loading Word-specific features (styles, tables, etc.)");
    }
    
    @Override
    public void save() {
        System.out.println("Saving Word Document: " + fileName);
        System.out.println("Applying Word compression and formatting...");
    }
    
    @Override
    public void close() {
        System.out.println("Closing Word Document: " + fileName);
    }
    
    @Override
    public String getType() {
        return "Microsoft Word Document";
    }
    
    @Override
    public String getFileExtension() {
        return ".docx";
    }
    
    // Word-specific methods
    public void insertTable(int rows, int columns) {
        System.out.println("Inserting table with " + rows + " rows and " + columns + " columns");
    }
    
    public void applyStyle(String styleName) {
        System.out.println("Applying style: " + styleName);
    }
}
