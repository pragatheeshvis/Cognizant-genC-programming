public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        double futureValue = forecast(currentValue, growthRate, years - 1);
        return futureValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        double current = 10000; // current value in rupees
        double rate = 0.10;     // 10% annual growth
        int years = 5;          // forecasting for 5 years

        double result = forecast(current, rate, years);
        System.out.printf("Predicted value after %d years: ₹%.2f", years, result);
    }
}
