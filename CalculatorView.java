import java.util.Scanner;

public class CalculatorView {

    private Scanner scanner = new Scanner(System.in);
 
    //некоторое время сомневался больше кода повторяющегося или отдать puttern целиком в "performOperation", выбрал второе
    public double getPartNumber(String pattern) {
        while (true) {
            try {
                System.out.print(pattern);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }

    public String getOperation() {
        while (true) {
            System.out.print("Выберите операцию (+, *, /): ");
            String operation = scanner.next();
            if (operation.equals("+") || operation.equals("*") || operation.equals("/")) {
                return operation;
            } else {
                System.out.println("Некорректная операция. Пожалуйста, выберите +, * или /.");
            }
        }
    }

    public void displayResult(ComplexNumber result) {
        System.out.println("Результат: " + result);
    }

    public void closeScanner() {
        scanner.close();
    }
}
