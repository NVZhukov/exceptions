package exception.homeWork.hw2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFloatNum());
    }

    /*
     1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
     и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
      вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */

    public static float getFloatNum() {
        String num;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число: ");
            num = sc.nextLine();
            if (num.matches("[0-9]+")) return Float.parseFloat(num);
            if (num.contains(",")) num = num.replace(",", ".");
        }
        while (!num.matches("^[0-9+]+\\.[0-9+]+$"));
        return Float.parseFloat(num);
    }
}
