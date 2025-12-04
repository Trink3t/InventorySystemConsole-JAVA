import java.util.Scanner;

/**
 * Utility class that provides user input handling helpers for both
 * optional and required values. All methods automatically validate
 * the input and provide appropriate fallbacks or re-prompts.
 *
 * <p>This class cannot be instantiated.</p>
 */
public final class InputHelper {

    private static final Scanner input = new Scanner(System.in);

    private InputHelper() {
        // Prevent instantiation
    }

    /**
     * Reads a string input from the user. If the user presses Enter without typing,
     * the current value is returned.
     *
     * @param prompt       The message displayed to the user.
     * @param currentValue The existing value to return if input is empty.
     * @return The entered string, or the current value if empty.
     */
    public static String readOptionalString(String prompt, String currentValue) {
        System.out.print(prompt);
        String inputStr = input.nextLine().trim();
        return inputStr.isEmpty() ? currentValue : inputStr;
    }

    /**
     * Reads a double input from the user. If the user presses Enter without typing,
     * the current value is returned. Invalid numbers are ignored and the current
     * value is preserved.
     *
     * @param prompt       The message displayed to the user.
     * @param currentValue The existing value to return if input is empty or invalid.
     * @return The entered double value, or the current value if empty or invalid.
     */
    public static double readOptionalDouble(String prompt, double currentValue) {
        System.out.print(prompt);
        String line = input.nextLine().trim();

        if (line.isEmpty()) return currentValue;

        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, keeping current value.");
            return currentValue;
        }
    }

    /**
     * Reads an integer input from the user. If the user presses Enter without typing,
     * the current value is returned. Invalid integers are ignored and the current
     * value is kept.
     *
     * @param prompt       The message displayed to the user.
     * @param currentValue The existing value to return if input is empty or invalid.
     * @return The entered integer, or the current value if empty or invalid.
     */
    public static int readOptionalInt(String prompt, int currentValue) {
        System.out.print(prompt);
        String line = input.nextLine().trim();

        if (line.isEmpty()) return currentValue;

        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, keeping current value.");
            return currentValue;
        }
    }

    /**
     * Reads a required string from the user. The user will be repeatedly prompted
     * until a non-empty value is provided.
     *
     * @param prompt The message displayed to the user.
     * @return A non-empty string entered by the user.
     */
    public static String readRequiredString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputStr = input.nextLine().trim();
            if (!inputStr.isEmpty()) {
                return inputStr;
            }
            System.out.println("This field is required. Please enter a value.");
        }
    }

    /**
     * Reads a required double value from the user. The method will continue prompting
     * until a valid numeric value is entered.
     *
     * @param prompt The message displayed to the user.
     * @return A valid double entered by the user.
     */
    public static double readRequiredDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();

            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
            }
        }
    }

    /**
     * Reads a required integer value from the user. The method will continue prompting
     * until a valid integer is entered.
     *
     * @param prompt The message displayed to the user.
     * @return A valid integer entered by the user.
     */
    public static int readRequiredInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Please enter a valid whole number.");
            }
        }
    }
}
