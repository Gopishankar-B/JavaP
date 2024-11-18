import java.util.Scanner;

public class CurrencyConverterMain {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        // Add default currencies
        converter.addCurrency("USD", 74.85);
        converter.addCurrency("EUR", 85.17);
        converter.addCurrency("GBP", 100.45);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Convert Currency");
            System.out.println("2. Add New Currency");
            System.out.println("3. View Available Currencies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter source currency: ");
                        String fromCurrency = scanner.nextLine();
                        System.out.print("Enter target currency: ");
                        String toCurrency = scanner.nextLine();
                        System.out.print("Enter amount in " + fromCurrency.toUpperCase() + ": ");
                        double amount = scanner.nextDouble();
                        double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, toCurrency.toUpperCase());
                        break;

                    case 2:
                        System.out.print("Enter new currency code: ");
                        String newCurrency = scanner.nextLine();
                        System.out.print("Enter exchange rate to INR: ");
                        double rate = scanner.nextDouble();
                        converter.addCurrency(newCurrency, rate);
                        System.out.println("Currency added successfully!");
                        break;

                    case 3:
                        converter.displayCurrencies();
                        break;

                    case 4:
                        System.out.println("Exiting the Currency Converter. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
