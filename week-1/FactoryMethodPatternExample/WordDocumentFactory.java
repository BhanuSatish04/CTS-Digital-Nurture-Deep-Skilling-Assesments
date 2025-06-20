public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("WordDocumentFactory: Creating Word Document instance");
        return new WordDocument();
    }
}

