import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Integer> romanNumerals = new HashMap<>();

    static {
        romanNumerals.put("I", 1);
        romanNumerals.put("V", 5);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        String firstInput = scanner.nextLine();
        int firstOperand = parseNumber(firstInput);

        System.out.print("Введите оператор (+, -, *, /): ");
        String operator = scanner.nextLine();

        System.out.print("Введите второе число: ");
        String secondInput = scanner.nextLine();
        int secondOperand = parseNumber(secondInput);

        int result = calculate(firstOperand, operator, secondOperand);

        System.out.println("Результат: " + result);
    }

    public static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return parseRomanNumeral(input);
        }
    }

    public static int parseRomanNumeral(String input) {
        int result = 0;
        int previousValue = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            int currentValue = romanNumerals.get(String.valueOf(currentChar));

            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
                previousValue = currentValue;
            }
        }

        return result;
    }

    public static int calculate(int a, String operator, int b) {
        int result = 0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }

        return result;
    }
}