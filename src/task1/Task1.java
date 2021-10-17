package task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        String line = getConsoleInput();
        System.out.println("Сумма цифр = " + getDigitsSum(line));
    }

    private static String getConsoleInput() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextLine();
        }
    } 

    private static int getDigitsSum(String line) {
        int sum = 0;
        for (char chr : line.toCharArray()) {
            if (Character.isDigit(chr)) {
                sum += Character.getNumericValue(chr);
            }
        }
        return sum;
    }
}
