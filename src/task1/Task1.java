package task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        int sum = 0;
        for (char chr : line.toCharArray()) {
            if (Character.isDigit(chr))
                sum += Character.getNumericValue(chr);
        }
        System.out.println(sum);
    }
}
