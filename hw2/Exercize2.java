package exception.homeWork.hw2;

public class Exercize2 {
    public static void main(String[] args) {
        // 2. Если необходимо, исправьте данный код:
        int[] intArray = new int[]{3,5,12,33,1};
        int d = 1;
        int arraySize = 8;
        if (arraySize == 0){
            System.out.println("Пустой массив! Необходимо заполнить его...");
            return;
        }
        if (d == 0) System.out.println("Делить на 0 нельзя!");
        else if (arraySize < intArray.length) {
            double catchedRes1 = intArray[arraySize] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } else {
            arraySize = intArray.length - 1;
            double catchedRes1 = intArray[arraySize] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }

//        try {
//            int d = 0;
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }
    }
}
