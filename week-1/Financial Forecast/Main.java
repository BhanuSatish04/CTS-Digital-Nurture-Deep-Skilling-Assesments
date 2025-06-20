/*Recursion is when a function calls itself to solve smaller instances of a problem. In financial forecasting, it allows us to model compound growth elegantly:

𝐹𝑉(𝑛)=𝐹𝑉(𝑛−1)×(1+𝑟)
FV(n)=FV(n−1)×(1+r)
Where FV(n) is the future value at year n, and r is the growth rate.

 */

/*Time Complexity:

Recursive: O(n) — Linear with number of years.

Tail-recursive optimization possible but Java doesn't guarantee it.

Risk: Stack overflow if years is large. */ 

public class Main {
    public static void main(String[] args) {
        double startValue = 1000.0;
        double growthRate = 0.08; // 8% annual growth
        int futureYears = 5;

        double predictedValue = FinancialForecast.forecastRecursive(startValue, growthRate, futureYears);
        System.out.printf("Predicted Future Value after %d years: %.2f", futureYears, predictedValue);
    }
}
