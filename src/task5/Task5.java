package task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    private static final int MAX_VOLUME = 20;
    private static Safe bestSafe = new Safe(MAX_VOLUME);

    public static void main(String[] args) {
        final Item item1 = new Item("item1", 5, 3);
        final Item item2 = new Item("item2", 7, 9);
        final Item item3 = new Item("item3", 9, 6);
        final Item item4 = new Item("item4", 3, 11);
        final Item item5 = new Item("item5", 1, 7);
        final Item item6 = new Item("item6", 5, 1);
        final Item item7 = new Item("item7", 6, 3);
        final Item item8 = new Item("item8", 2, 9);
        final Item item9 = new Item("item9", 2, 7);
        final Item item10 = new Item("item10", 4, 14);
        final Item[] itemsArr = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10};

        ArrayList<Item> items = new ArrayList<>(Arrays.asList(itemsArr));
        if (itemsArr.length < 50) {
            chooseItems(bestSafe, items);
        } else {
            putItems(bestSafe, itemsArr);
        }
        System.out.println(bestSafe);
    }

    private static void checkSafe(Safe safe) {
        if (safe.getCurrPrice() > bestSafe.getCurrPrice()) {
            bestSafe = safe;
        }
    }

    private static void chooseItems(Safe safe, List<Item> items) {
        checkSafe(safe);
        for (int i = 0; i < items.size(); i++) {
            Safe safeCopy = new Safe(safe);
            List<Item> newItems = new ArrayList<>(items);
            if (safeCopy.addItem(newItems.get(i))) {
                newItems.remove(i);
                chooseItems(safeCopy, newItems);
            }
        }
    }

    private static void putItems(Safe safe, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(Item::getPricePerVolume).reversed());
        for (Item item : items) {
            safe.addItem(item);
            if (safe.getCurrVolume() == MAX_VOLUME)
                    return;
        }
    }
}
