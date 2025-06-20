public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("ExcelDocumentFactory: Creating Excel Document instance");
        return new ExcelDocument();
    }
}
