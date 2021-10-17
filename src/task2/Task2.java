package task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите целое число");
        try {
            long num = Math.abs(Long.parseLong(getConsoleInput())), i = 2;
            if (num == 0 || num == 1) {
                System.out.println("Это число не имеет простых множителей");
            }
            while (num > 1) {
                if (num % i == 0) {
                    System.out.print(i + (num / i == 1 ? "" : " "));
                    num /= i;
                    i = 1;
                }
                i++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Введенное значение не является целым числом");
        }
    }

    private static String getConsoleInput() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.next();
        }
    }
}