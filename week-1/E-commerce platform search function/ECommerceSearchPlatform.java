import java.util.*;
public class ECommerceSearchPlatform {
    private Product[] products;
    private Product[] sortedProducts;
    private int size;
    
    public ECommerceSearchPlatform(int capacity) {
        this.products = new Product[capacity];
        this.size = 0;
    }
    
    // Add product to the platform
    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
            updateSortedArray();
        } else {
            System.out.println("Product array is full!");
        }
    }
    
    // Update sorted array for binary search
    private void updateSortedArray() {
        sortedProducts = Arrays.copyOf(products, size);
        Arrays.sort(sortedProducts);
    }
    
    /**
     * LINEAR SEARCH IMPLEMENTATION
     * Time Complexity Analysis:
     * - Best Case: O(1) - element found at first position
     * - Average Case: O(n) - element found at middle position
     * - Worst Case: O(n) - element not found or at last position
     */
    public Product linearSearchById(int productId) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        for (int i = 0; i < size; i++) {
            comparisons++;
            if (products[i].getProductId() == productId) {
                long endTime = System.nanoTime();
                System.out.printf("Linear Search: Found in %d comparisons, Time: %d ns\n", 
                                comparisons, (endTime - startTime));
                return products[i];
            }
        }
        
        long endTime = System.nanoTime();
        System.out.printf("Linear Search: Not found after %d comparisons, Time: %d ns\n", 
                        comparisons, (endTime - startTime));
        return null;
    }
    
    /**
     * LINEAR SEARCH BY NAME (Case-insensitive)
     * Time Complexity: O(n) in all cases
     */
    public List<Product> linearSearchByName(String productName) {
        List<Product> results = new ArrayList<>();
        long startTime = System.nanoTime();
        int comparisons = 0;
        
        for (int i = 0; i < size; i++) {
            comparisons++;
            if (products[i].getProductName().toLowerCase()
                    .contains(productName.toLowerCase())) {
                results.add(products[i]);
            }
        }
        
        long endTime = System.nanoTime();
        System.out.printf("Linear Search by Name: Found %d results in %d comparisons, Time: %d ns\n", 
                        results.size(), comparisons, (endTime - startTime));
        return results;
    }
    
    /**
     * BINARY SEARCH IMPLEMENTATION
     * Prerequisites: Array must be sorted
     * Time Complexity Analysis:
     * - Best Case: O(1) - element found at middle position
     * - Average Case: O(log n) - typical case
     * - Worst Case: O(log n) - element not found or at extreme positions
     */
    public Product binarySearchById(int productId) {
        if (sortedProducts == null || sortedProducts.length == 0) {
            System.out.println("No products available for binary search");
            return null;
        }
        
        long startTime = System.nanoTime();
        int left = 0;
        int right = size - 1;
        int comparisons = 0;
        
        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            int midProductId = sortedProducts[mid].getProductId();
            
            if (midProductId == productId) {
                long endTime = System.nanoTime();
                System.out.printf("Binary Search: Found in %d comparisons, Time: %d ns\n", 
                                comparisons, (endTime - startTime));
                return sortedProducts[mid];
            } else if (midProductId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        long endTime = System.nanoTime();
        System.out.printf("Binary Search: Not found after %d comparisons, Time: %d ns\n", 
                        comparisons, (endTime - startTime));
        return null;
    }
    
    /**
     * SEARCH BY CATEGORY (Linear approach)
     * Time Complexity: O(n)
     */
    public List<Product> searchByCategory(String category) {
        List<Product> results = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                results.add(products[i]);
            }
        }
        
        return results;
    }
    
    /**
     * Performance comparison method
     */
    public void performanceComparison(int searchId) {
        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        System.out.println("Searching for Product ID: " + searchId);
        System.out.println("Dataset size: " + size + " products\n");
        
        // Linear Search
        System.out.println("1. Linear Search:");
        Product result1 = linearSearchById(searchId);
        
        // Binary Search
        System.out.println("\n2. Binary Search:");
        Product result2 = binarySearchById(searchId);
        
        System.out.println("\nResults match: " + 
                         (Objects.equals(result1, result2) ? "Yes" : "No"));
    }
    
    // Display all products
    public void displayProducts() {
        System.out.println("\n=== ALL PRODUCTS ===");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }
    
    // Get current number of products
    public int getSize() {
        return size;
    }
    
    // Main method with comprehensive testing
    public static void main(String[] args) {
        System.out.println("E-COMMERCE PLATFORM SEARCH FUNCTIONALITY");
        System.out.println("=========================================\n");
        
        // Understanding Big O Notation
        System.out.println("BIG O NOTATION EXPLANATION:");
        System.out.println("Big O notation describes the upper bound of algorithm complexity.");
        System.out.println("It helps us understand how algorithm performance scales with input size.\n");
        
        System.out.println("Search Algorithm Complexities:");
        System.out.println("• Linear Search: O(n) - checks each element sequentially");
        System.out.println("• Binary Search: O(log n) - divides search space in half each step");
        System.out.println("• Binary search requires sorted data but is much faster for large datasets\n");
        
        // Create platform and add sample products
        ECommerceSearchPlatform platform = new ECommerceSearchPlatform(15);
        
        // Adding sample products
        platform.addProduct(new Product(101, "iPhone 15 Pro", "Electronics", 999.99));
        platform.addProduct(new Product(205, "Nike Air Max", "Footwear", 129.99));
        platform.addProduct(new Product(303, "Samsung Galaxy S24", "Electronics", 849.99));
        platform.addProduct(new Product(150, "MacBook Pro", "Electronics", 1999.99));
        platform.addProduct(new Product(278, "Adidas Ultraboost", "Footwear", 189.99));
        platform.addProduct(new Product(189, "iPad Air", "Electronics", 599.99));
        platform.addProduct(new Product(456, "Sony WH-1000XM5", "Electronics", 349.99));
        platform.addProduct(new Product(321, "Levi's 501 Jeans", "Clothing", 79.99));
        platform.addProduct(new Product(167, "Apple Watch Series 9", "Electronics", 399.99));
        platform.addProduct(new Product(234, "Canon EOS R5", "Electronics", 2499.99));
        
        // Display all products
        platform.displayProducts();
        
        // Test searches
        System.out.println("\n=== SEARCH DEMONSTRATIONS ===");
        
        // Test 1: Search for existing product
        platform.performanceComparison(205);
        
        // Test 2: Search for non-existing product
        platform.performanceComparison(999);
        
        // Test 3: Search by name
        System.out.println("\n=== SEARCH BY NAME ===");
        List<Product> nameResults = platform.linearSearchByName("iPhone");
        System.out.println("Products containing 'iPhone':");
        nameResults.forEach(System.out::println);
        
        // Test 4: Search by category
        System.out.println("\n=== SEARCH BY CATEGORY ===");
        List<Product> categoryResults = platform.searchByCategory("Electronics");
        System.out.println("Electronics products found: " + categoryResults.size());
        categoryResults.forEach(product -> System.out.println("- " + product));
        
        // Algorithm Analysis
        System.out.println("\n=== ALGORITHM ANALYSIS ===");
        System.out.println("For " + platform.getSize() + " products:");
        System.out.println("• Linear Search worst case: " + platform.getSize() + " comparisons");
        System.out.println("• Binary Search worst case: " + 
                         (int)Math.ceil(Math.log(platform.getSize()) / Math.log(2)) + " comparisons");
        
        System.out.println("\nRECOMMENDATION FOR E-COMMERCE PLATFORM:");
        System.out.println("• Use Binary Search for ID-based lookups (fast, O(log n))");
        System.out.println("• Use Linear Search for text-based searches (name, description)");
        System.out.println("• Consider indexing/hashing for category-based searches");
        System.out.println("• For large datasets (>1000 products), binary search provides significant performance gains");
        
        // Performance scaling demonstration
        System.out.println("\n=== SCALABILITY ANALYSIS ===");
        int[] sizes = {10, 100, 1000, 10000};
        System.out.println("Theoretical comparisons needed:");
        System.out.printf("%-10s %-15s %-15s %-10s\n", "Size", "Linear (worst)", "Binary (worst)", "Ratio");
        System.out.println("------------------------------------------------");
        for (int n : sizes) {
            int linearOps = n;
            int binaryOps = (int)Math.ceil(Math.log(n) / Math.log(2));
            double ratio = (double)linearOps / binaryOps;
            System.out.printf("%-10d %-15d %-15d %.1fx\n", n, linearOps, binaryOps, ratio);
        }
    }
}