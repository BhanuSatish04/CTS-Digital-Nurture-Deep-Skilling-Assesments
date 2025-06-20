// Document.java - Abstract Document Interface
public interface Document {
    void create();
    void open();
    void save();
    void close();
    String getType();
    String getFileExtension();
}

