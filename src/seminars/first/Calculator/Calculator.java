package seminars.first.Calculator;

import static org.assertj.core.api.Assertions.*; // Импортируем классы библиотеки assertJ

public class Calculator {


    public static void main(String[] args) {
        testCalculatingDiscount();
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }
    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи

    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }
    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ

    // Примерная сигнатура и тело метода:

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if (purchaseAmount <= 0 || discountAmount >= 100 || discountAmount < 0) {
            throw new ArithmeticException();
        }

        // Метод должен возвращать сумму покупки со скидкой
        return purchaseAmount * (1 - (double) discountAmount / 100);
    }
    public static void testCalculatingDiscount(){
        assertThat(calculatingDiscount(100,20)).isEqualTo(80);
        assertThat(calculatingDiscount(1000,15)).isEqualTo(850);
        assertThatThrownBy(()->calculatingDiscount(0,20)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(()->calculatingDiscount(50,100)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(()->calculatingDiscount(50,-1)).isInstanceOf(ArithmeticException.class);
    }
}
