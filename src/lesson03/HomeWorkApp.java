package lesson03;


import java.util.Scanner;

public class HomeWorkApp {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // P.S. Осознанно использовал пользовательский ввод только в задаче №5.
        //      В условиях к задачам этого нет, но на уроке давали, и поэтому не понял -
        //      нужно ли его вообще где-то применять,
        //      т.к. вводить вручную массивы - это жестоко.
        //      ¯\_(ツ)_/¯

        System.out.println("Задача №1: инвертировать значения массива нулей и единиц");
        int[] bitArray = {1, 0, 0, 1, 1, 0, 1, 0, 0};
        printIntArray(bitArray);
        printIntArray(inverseBitArray(bitArray));

        System.out.println("\nЗадача №2: получить массив [1..100]");
        printIntArray(getRange100());

        System.out.println("\nЗадача №3: умножить значения меньше 6 на 2");
        int[] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printIntArray(intArray);
        printIntArray(selectiveMultiplier(intArray, 6, 2));

        System.out.println("\nЗадача №4: заполнить диагонали матрицы единицами");
        int[][] matrix = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        printIntMatrix(matrix);
        System.out.println("");
        printIntMatrix(fillDiagonals(matrix));

        System.out.println("\nЗадача №5: получить массив каждая ячейка которого равна заданному значению");
        int length = inputIntData("Введите требуемую длину массива: ");
        int value = inputIntData("Введите целое число для заполнения массива: ");
        printIntArray(getArrayWithDuplicatedValues(length, value));

        System.out.println("\nЗадача №6: найти наименьший и наибольший элемент");
        int[] testArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printIntArray(testArray);
        int[] minMax = getMinMax(testArray);
        System.out.println("Min: " + minMax[0] + ", Max: " + minMax[1]);

        System.out.println("\nЗадача №7: проверить массив на сбалансированность");
        int[] numbers = {1, 1, 1, 1, 1, 1, 4, 10};
        printIntArray(numbers);
        System.out.println("Массив сбалансирован? Ответ: " + checkBalance(numbers));
    }


    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     *    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     *    С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static int[] inverseBitArray(int[] bitArray) {
        for (int i = 0; i < bitArray.length; i++) {
            bitArray[i] = (bitArray[i] == 1) ? 0 : 1;
        }
        return bitArray;
    }


    /**
     * 2. Задать пустой целочисленный массив длиной 100.
     *    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100.
     */
    public static int[] getRange100() {
        int[] range100 = new int[100];
        for (int i = 0; i < range100.length; i++) {
            range100[i] = i + 1;
        }
        return range100;
    }


    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     *    и числа меньшие 6 умножить на 2.
     */
    public static int[] selectiveMultiplier(int[] intArray, int lessThan, int multiplier) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (intArray[i] < lessThan) ? intArray[i] *  multiplier : intArray[i];
        }
        return intArray;
    }



    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     *    и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     *    (можно только одну из диагоналей, если обе сложно).
     *    Определить элементы одной из диагоналей можно по следующему принципу:
     *    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n].
     */
    public static int[][] fillDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i == j || (i + j) == (matrix.length - 1)) ? 1 : matrix[i][j];
            }
        }
        return matrix;
    }


    /**
     * 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
     *    и возвращающий одномерный массив типа int длиной len,
     *    каждая ячейка которого равна initialValue.
     */
    public static int[] getArrayWithDuplicatedValues(int len, int initialValue) {
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = initialValue;
        }
        return result;
    }


    /**
     * 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы.
     */
    public static int[] getMinMax(int[] intArray) {
        int min = intArray[0];
        int max = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            min = (intArray[i] < min) ? intArray[i] : min;
            max = (intArray[i] > max) ? intArray[i] : max;
        }
        int[] result = {min, max};
        return result;
    }

    /**
     * 7. ** Написать метод, в который передается непустой одномерный целочисленный массив,
     *    метод должен вернуть `true`, если в массиве есть место, в котором сумма левой и правой части массива равны.
     *    **Примеры:
     *    checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     *    checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     *    checkBalance([1, 1, 1, 1, 1, 1, 4 ||| 10]) → true, т.е. 1 + 1 + 1 + 1 + 1 + 1 + 4 = 10
     *    checkBalance([1, 1, 10]) → false
     *    граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */
    public static boolean checkBalance(int[] intArray) {
        if(intArray.length < 2) {
            return false;
        }

        int leftIndex = 0;
        int leftSum = intArray[leftIndex];

        int rightIndex = intArray.length - 1;
        int rightSum = intArray[rightIndex];

        while (rightIndex - leftIndex > 1) {
            if(leftSum >= rightSum) {
                rightIndex--;
                rightSum += intArray[rightIndex];
            } else {
                leftIndex++;
                leftSum += intArray[leftIndex];
            }
        }

        return leftSum == rightSum;
    }

    private static void printIntArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.print("\n");
    }

    private static void printIntMatrix(int[][] inputMatrix) {
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int inputIntData(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }

}
