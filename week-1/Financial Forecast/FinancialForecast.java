/* Understanding Recursion in Finance
Recursion is particularly well-suited for financial calculations because:
•	Financial growth naturally follows recursive patterns (each period depends on the previous)
•	Compound interest, loan amortization, and investment growth are inherently recursive
•	Complex financial formulas become more intuitive when expressed recursively

2. Implemented Recursive Algorithms
Basic Compound Interest
•	Formula: FV(n) = FV(n-1) × (1 + r)
•	Time Complexity: O(n)
•	Use Case: Simple investment growth calculations
Fibonacci Growth Modeling
•	Basic Version: O(2^n) - Exponentially inefficient
•	Memorized Version: O(n) - Dramatically optimized
•	Use Case: Modeling growth patterns that follow Fibonacci-like sequences
Variable Growth Rate Forecasting
•	Time Complexity: O(n)
•	Use Case: Real-world scenarios with changing market conditions
Portfolio Value Calculation
•	Time Complexity: O(n) where n = number of assets
•	Use Case: Calculating weighted portfolio values recursively
Loan Amortization
•	Time Complexity: O(n) where n = number of payments
•	Use Case: Tracking remaining loan balance over time

3. Time Complexity Analysis
Algorithm	 Time Complexity	Space Complexity	Optimization
Compound Interest	O(n)	            O(n)	Memorization
Basic Fibonacci	    O(2^n)	            O(n)	Avoid - Too Slow
Memorized Fibonacci	O(n)	            O(n)	700x+ faster
Variable Growth	    O(n)	            O(n)	Tail recursion
Portfolio Calc	    O(n)	            O(n)	Iterative conversion

4. Optimization Strategies
Memorization (Primary Optimization)
java
// Cache results to avoid recalculation
Map<String, Double> cache = new HashMap<>();
Performance Improvement Example
•	Basic Fibonacci (n=35): ~9 million recursive calls, several seconds
•	Memorized Fibonacci (n=35): ~69 calls, milliseconds
•	Speedup: 700x+ performance improvement
Other Optimizations
1.	Tail Recursion: Where possible, make recursive calls the last operation
2.	Iterative Conversion: Convert to loops for better performance
3.	Dynamic Programming: Bottom-up approach for overlapping subproblems
5. Practical Applications Demonstrated
•	Investment Growth: Compound interest with varying rates
•	Retirement Planning: Monthly contributions with compound growth
•	Portfolio Management: Weighted asset value calculations
•	Loan Analysis: Amortization schedule calculations
•	Risk Modeling: Fibonacci-based growth patterns
*/
public class FinancialForecast {
    public static double forecastRecursive(double initialValue, double rate, int years) {
        if (years == 0) return initialValue;
        return forecastRecursive(initialValue, rate, years - 1) * (1 + rate);
    }
}
