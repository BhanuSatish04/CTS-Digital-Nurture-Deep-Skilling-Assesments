public class ExcelDocument implements Document {
    private String fileName;
    private int numberOfSheets;
    
    public ExcelDocument() {
        this.fileName = "Untitled.xlsx";
        this.numberOfSheets = 1;
    }
    
    @Override
    public void create() {
        System.out.println("Creating Excel Document: " + fileName);
        System.out.println("Setting up workbook with " + numberOfSheets + " sheet(s)...");
    }
    
    @Override
    public void open() {
        System.out.println("Opening Excel Document: " + fileName);
        System.out.println("Loading spreadsheet data and formulas...");
    }
    
    @Override
    public void save() {
        System.out.println("Saving Excel Document: " + fileName);
        System.out.println("Recalculating formulas and saving workbook...");
    }
    
    @Override
    public void close() {
        System.out.println("Closing Excel Document: " + fileName);
    }
    
    @Override
    public String getType() {
        return "Microsoft Excel Spreadsheet";
    }
    
    @Override
    public String getFileExtension() {
        return ".xlsx";
    }
    
    // Excel-specific methods
    public void addWorksheet(String sheetName) {
        numberOfSheets++;
        System.out.println("Added new worksheet: " + sheetName);
    }
    
    public void insertFormula(String cell, String formula) {
        System.out.println("Inserting formula in cell " + cell + ": " + formula);
    }
}