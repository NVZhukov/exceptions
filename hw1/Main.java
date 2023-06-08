package exception.homeWork.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //nullPointer();
        //fileNotFound("1.txt");
        //arithmetic(10);

        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,2,3,0};
        try{
            System.out.println(Arrays.toString(newArray(arr1, arr2)));
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static int arithmetic(int a) {
        return a / 0;
    }

    public static void nullPointer() {
        throw null;
    }

    public static void fileNotFound(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
    }


    /*
    NumberFormatException
    ArrayIndexOutOfBoundsException
     */
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    public static int[] newArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) throw new RuntimeException("Длины массивов не равны!");
        int[] newArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0 || arr2[i] == 0) {
                throw new RuntimeException("Нельзя делить на 0");
            }
            newArray[i] = arr1[i] / arr2[i];
        }
        return newArray;
    }
}
