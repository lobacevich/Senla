package task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task3 {
    private static final String VOWELS = "аеёиоуыэюя";

    public static void main(String[] args) {
        String[] arr = getConsoleInput().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = firstVowelToUpperCase(arr[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(Task3::getVowelsCount).reversed());
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static String getConsoleInput() {
        try (Scanner sc = new Scanner(System.in)) {
            return sc.nextLine();
        }
    }

    private static int getVowelsCount(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.indexOf(word.toLowerCase().charAt(i)) != -1)
                count++;
        }
        return count;
    }


    private static String firstVowelToUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.indexOf(word.toLowerCase().charAt(i)) != -1) {
                return word.substring(0, i) + Character.toUpperCase(word.charAt(i)) +
                        (i == word.length() - 1 ? "" : word.substring(i + 1));
            }
        }
        return word;
    }
}
