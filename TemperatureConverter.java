import java.util.Scanner;

public class TemperatureConverter {

    private static final Scanner scanner = new Scanner(System.in);

    private static final double MIN_CELSIUS = -273.15;
    private static final double MIN_FAHRENHEIT = -459.67;

    public static void main(String[] args) {

        System.out.println("===== TEMPERATURE CONVERTER =====");

        int choice;

        do {
            showMenu();
            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> {
                    double celsius = readTemperature(
                            "Enter temperature in Celsius: ", MIN_CELSIUS);

                    double fahrenheit = celsiusToFahrenheit(celsius);

                    System.out.printf("%.2f °C = %.2f °F%n",
                            celsius, fahrenheit);
                }

                case 2 -> {
                    double fahrenheit = readTemperature(
                            "Enter temperature in Fahrenheit: ", MIN_FAHRENHEIT);

                    double celsius = fahrenheitToCelsius(fahrenheit);

                    System.out.printf("%.2f °F = %.2f °C%n",
                            fahrenheit, celsius);
                }

                case 3 -> System.out.println("Thanks for using the converter!");

                default -> System.out.println(
                        "That option isn't available. Please choose 1, 2 or 3.");
            }

        } while (choice != 3);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.println("3. Exit");
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    private static int readInt(String prompt) {

        while (true) {
            System.out.print(prompt);

            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option number.");
            }
        }
    }

    private static double readTemperature(String prompt, double minimum) {

        while (true) {
            System.out.print(prompt);

            try {
                double temperature = Double.parseDouble(
                        scanner.nextLine().trim());

                if (Double.isNaN(temperature)
                        || Double.isInfinite(temperature)) {

                    System.out.println("Please enter a valid temperature.");

                } else if (temperature < minimum) {

                    System.out.println(
                            "Temperature cannot be below absolute zero ("
                                    + minimum + ").");

                } else {
                    return temperature;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Try entering a number, such as 36.6.");
            }
        }
    }
}
