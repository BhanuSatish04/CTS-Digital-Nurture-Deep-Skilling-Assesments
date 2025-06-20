public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("PdfDocumentFactory: Creating PDF Document instance");
        return new PdfDocument();
    }
}
