public class Main {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(new CalculatorView()); 
        controller.performOperation();
    }
}
