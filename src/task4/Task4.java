package task4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String number = getConsoleInput();
        Map<Character, String[]> digitsMap= makeDigitsMapWithMaxDigit(number);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < number.length(); j++)
                System.out.print(digitsMap.get(number.charAt(j))[i] + (j == number.length() - 1 ? "\n" : ""));
        }
    }

    private static String getConsoleInput() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.next();
        }
    }

    private static Map<Character, String[]> makeDigitsMap() {
        HashMap<Character, String[]> digits = new HashMap<>();
        digits.put('0', new String[] {"   ***   ", "  *   *  ", " *     * ", " *     * ", " *     * ", "  *   *  ", "   ***   "});
        digits.put('1', new String[] {"    *    ", "   **    ", "  * *    ", "    *    ", "    *    ", "    *    ", " ******* "});
        digits.put('2', new String[] {"  ****   ", " *    *  ", "     *   ", "    *    ", "   *     ", "  *      ", " ******  "});
        digits.put('3', new String[] {" ******  ", "       * ", "       * ", " ******  ", "       * ", "       * ", " ******  "});
        digits.put('4', new String[] {"    ***  ", "   *  *  ", "  *   *  ", " *    *  ", " ******* ", "      *  ", "      *  "});
        digits.put('5', new String[] {" ******  ", " *       ", " *       ", " *****   ", "      *  ", "      *  ", " *****   "});
        digits.put('6', new String[] {"  *****  ", " *       ", " *       ", " ******  ", " *     * ", " *     * ", "  *****  "});
        digits.put('7', new String[] {" ******* ", "      *  ", "     *   ", "    *    ", "   *     ", "  *      ", " *       "});
        digits.put('8', new String[] {"  *****  ", " *     * ", " *     * ", "  *****  ", " *     * ", " *     * ", "  *****  "});
        digits.put('9', new String[] {"  *****  ", " *     * ", " *     * ", "  ****** ", "       * ", "       * ", "  *****  "});
        return digits;
    }

    private static char getMaxDigit(String num) {
        if (num.length() == 1)
            return num.charAt(0);
        char max = num.charAt(0);
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) > max)
                max = num.charAt(i);
        }
        return max;
    }

    private static Map<Character, String[]> makeDigitsMapWithMaxDigit(String num) {
        Map<Character, String[]> digitsMap= makeDigitsMap();
        char maxDigit = getMaxDigit(num);
        for (int i = 0; i < 7; i ++)
            digitsMap.get(maxDigit)[i] = digitsMap.get(maxDigit)[i].replace('*', maxDigit);
        return digitsMap;
    }
}
