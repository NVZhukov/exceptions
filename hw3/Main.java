package exception.homeWork.hw3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите свои данные в формате ФИО дата рождения телефон пол: ");
        String data = scanner.nextLine();
        String[] arrayData = data.split(" ");
        String[] resultData = null;
        if (checkDataSize(arrayData) == -1) {
            System.out.println("Введено недостаточное кочество данных!");
        }
        if (checkDataSize(arrayData) == -2) {
            System.out.println("Введены лишние данные!");
        }
        try {
            resultData = checkData(arrayData);
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты!");
            e.printStackTrace();
            return;
        } catch (NumberFormatException | InputMismatchException e) {
            e.printStackTrace();
            return;
        }
        saveData(resultData);
    }

    private static void saveData(String[] array) {
        String fileName = array[0] + ".txt";
        File f = new File(fileName);
        if (f.isFile()) {
            try (FileWriter fileWriter = new FileWriter(fileName, true)){
                fileWriter.write("\n");
                fileWriter.write(String.join(" ", array));
            }catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (FileWriter fileWriter = new FileWriter(fileName, false)){
                fileWriter.write(String.join(" ", array));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static int checkDataSize(String[] array) {
        if (array.length < 6) return -1;
        else if (array.length > 6) return -2;
        else return 0;
    }

    private static String[] checkData(String[] array) throws DateTimeParseException {

        String[] result = fullNameAhead(array);
        String[] result2 = Arrays.copyOf(result, result.length);
        result2[4] = isPhoneNumber(result);
        result2[5] = isGenderSpecified(result);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && (array[i].equals(result2[4]) || array[i].equals(result2[5]))) {
                array[i] = null;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && isDate(array[i])) {
                result2[3] = array[i];
            }
        }
        return result2;
    }

    private static boolean isDate(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate.parse(date, formatter);
        return true;
    }

    private static String isPhoneNumber(String[] array) {
        int numIsPresent = 0;
        String phoneNumber = null;
        for (String s : array) {
            if (s.length() > 10 && s.matches("[0-9]+")) {
                numIsPresent++;
                phoneNumber = s;
            }
        }
        if (numIsPresent != 1) {
            throw new NumberFormatException("Неверный формат номера телефона!");
        }
        return phoneNumber;
    }

    private static String[] fullNameAhead(String[] array) {
        int index = 0;
        int index2 = array.length / 2;
        String[] fullName = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i].matches("[А-Яа-я]+") && array[i].length() > 1) {
                fullName[index] = array[i];
                array[i] = null;
                index++;
            }
        }
        if (index < 3) throw new InputMismatchException("ФИО введено неверно/неполноценно!");
        else {
            for (String s : array) {
                if (s != null) {
                    fullName[index2] = s;
                    index2++;
                }
            }
        }
        return fullName;
    }

    private static String isGenderSpecified(String[] array) {
        int genderIsPresent = 0;
        String gender = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase("f") || array[i].equalsIgnoreCase("m")) {
                genderIsPresent++;
                gender = array[i];
            }
        }
        if (genderIsPresent != 1) {
            throw new InputMismatchException("Укажите Ваш пол");
        }
        return gender;
    }
}
