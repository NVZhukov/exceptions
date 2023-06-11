package exception.homeWork.hw2;

public class Exercize3 {
    public static void main(String[] args) {
        // 3. Дан следующий код, исправьте его там, где требуется:

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(12, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArithmeticException ex) {
            System.out.println("Недопустимое арифметическое действие!");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
