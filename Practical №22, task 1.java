import java.util.Stack;

// Объявление публичного класса
public class RPNCalculator {
    // Метод для вычисления выражения в обратной польской нотации
    public static double evaluateRPN(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    double dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

// Главный метод программы — точка входа
    public static void main(String[] args) {
        String expression = "3 4 + 2 * 7 /";
        double result = evaluateRPN(expression);
        System.out.println("Result: " + result);
    }
}
