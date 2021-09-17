package lesson02;

public class HomeWorkApp {

    public static void main(String[] args) {
        System.out.println("Сумма чисел 3 и 8 лежит в пределах от 10 до 20? Ответ: " + checkSum(3, 8));
        printSign(-50);
        System.out.println("Число -50 является отрицательным? Ответ: " + isNegativeNumber(-50));
        printStringNTimes("Отпечатай меня 4 раза", 4);
        System.out.println("Текущий 2021 год високосный? Ответ: " + isLeapYear(2021));
    }

    /**
    * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
    *    что их сумма лежит в пределах от 10 до 20 (включительно),
    *    если да – вернуть true, в противном случае – false.
    */
    public static boolean checkSum(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    /**
     * 2. Написать метод, которому в качестве параметра передается целое число,
     *    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     *    Замечание: ноль считаем положительным числом.
     */
    public static void printSign(int a) {
        if (a >= 0) {
            System.out.println("Передано положительное число " + a);
        } else {
            System.out.println("Передано отрицательное число " + a);
        }
    }

    /**
     * 3. Написать метод, которому в качестве параметра передается целое число.
     *    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isNegativeNumber(int a) {
        return a < 0;
    }

    /**
     * 4. Написать метод, которому в качестве аргументов передается строка и число,
     *    метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    public static void printStringNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    /**
     * 5. * Написать метод, который определяет, является ли год високосным,
     *    и возвращает boolean (високосный - true, не високосный - false).
     *    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}
