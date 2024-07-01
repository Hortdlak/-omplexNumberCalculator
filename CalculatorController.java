import java.util.logging.Logger;

public class CalculatorController {

    private CalculatorView view;
    private Logger logger = Logger.getLogger(CalculatorController.class.getName());

    public CalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void performOperation() {
        double real1 = view.getPartNumber("Введите действительную часть первого числа: ");
        double imag1 = view.getPartNumber("Введите мнимую часть первого числа: ");
        ComplexNumber num1 = new ComplexNumber(real1, imag1);

        double real2 = view.getPartNumber("Введите действительную часть второго числа: ");
        double imag2 = view.getPartNumber("Введите мнимую часть второго числа: ");
        ComplexNumber num2 = new ComplexNumber(real2, imag2);

        String operation = view.getOperation();

        ComplexNumber result = null;
        try {
            switch (operation) {
                case "+":
                    result = num1.add(num2);
                    break;
                case "*":
                    result = num1.multiply(num2);
                    break;
                case "/":
                    result = num1.divide(num2);
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция");
            }
            logger.info("Выполнена операция " + operation + " c "+ num1 + " и " + num2 + ":Результат = " + result);
            view.displayResult(result); //Неуверен что надо выводить (ведь это уже сказано в логах), но если предположить что логи будут идти не пользователю то надо оставить.
        } catch (IllegalArgumentException | ArithmeticException e) {
            logger.severe("Ошибка: " + e.getMessage());
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            view.closeScanner();
        }
    }
}
