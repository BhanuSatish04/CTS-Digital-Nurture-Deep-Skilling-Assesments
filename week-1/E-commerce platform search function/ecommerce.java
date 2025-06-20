import java.util.*;

/**
 * E-commerce Platform Search Function Implementation
 * 
 * This program demonstrates different search algorithms for an e-commerce platform
 * and analyzes their time complexity using Big O notation.
 */

// Product class representing items in the e-commerce platform
class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;
    private double price;
    
    public Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
    
    // Getters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    
    // For sorting products by ID (required for binary search)
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
    
    @Override
    public String toString() {
        return String.format("Product{ID=%d, Name='%s', Category='%s', Price=$%.2f}", 
                           productId, productName, category, price);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId == product.productId;
    }
}

