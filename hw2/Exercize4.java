package exception.homeWork.hw2;

import java.util.Scanner;

public class Exercize4 {
    public static void main(String[] args) {
        /*
        4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        Далее запросить повторный ввод строки
         */

        try {
            notEmptyLine();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            notEmptyLine();
        }
    }

    public static void notEmptyLine() {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        s = sc.nextLine();
        if (s.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }
    }
}
