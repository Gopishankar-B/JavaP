import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private final Map<String, Double> currencyRates;

    // Constructor
    public CurrencyConverter() {
        this.currencyRates = new HashMap<>();
    }

    // Add a new currency with its rate
    public void addCurrency(String currency, double rate) {
        currencyRates.put(currency.toUpperCase(), rate);
    }

    // Convert currency
    public double convert(String fromCurrency, String toCurrency, double amount) {
        fromCurrency = fromCurrency.toUpperCase();
        toCurrency = toCurrency.toUpperCase();

        if (!currencyRates.containsKey(fromCurrency) || !currencyRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("One or both currencies are not supported.");
        }

        double fromRate = currencyRates.get(fromCurrency);
        double toRate = currencyRates.get(toCurrency);

        // Convert from source currency to INR, then to target currency
        double amountInINR = amount / fromRate;
        return amountInINR * toRate;
    }

    // Display available currencies
    public void displayCurrencies() {
        if (currencyRates.isEmpty()) {
            System.out.println("No currencies available.");
        } else {
            System.out.println("Available currencies and their rates (to INR):");
            for (Map.Entry<String, Double> entry : currencyRates.entrySet()) {
                System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
