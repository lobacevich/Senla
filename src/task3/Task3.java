package task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task3 {
    private static final String vowels = "аеёиоуыэюя";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        sc.close();
        for (int i = 0; i < line.length; i++) {
            line[i] = firstVowelToUpperCase(line[i]);
        }
        Arrays.sort(line, Comparator.comparingInt(Task3::getVowelsCount).reversed());
        for (String a : line)
            System.out.println(a + " \t\tКоличество гласных - " + getVowelsCount(a));
    }

    private static int getVowelsCount(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.toLowerCase().charAt(i)) != -1)
                count++;
        }
        return count;
    }

    private static String firstVowelToUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.toLowerCase().charAt(i)) != -1) {
                return word.substring(0, i) + Character.toUpperCase(word.charAt(i)) +
                        (i == word.length() - 1 ? "" : word.substring(i + 1));
            }
        }
        return word;
    }
}
