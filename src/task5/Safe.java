package task5;

import java.util.ArrayList;

public class Safe {
    private final int maxVolume;
    private ArrayList<Item> itemsSet = new ArrayList<>();
    private int currVolume = 0;
    private int currPrice = 0;

    public Safe(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Safe(Safe another) {
        this.maxVolume = another.maxVolume;
        this.itemsSet = (ArrayList<Item>) another.itemsSet.clone();
        this.currVolume = another.currVolume;
        this.currPrice = another.currPrice;
    }

    public boolean addItem(Item item) {
        if (this.getCurrVolume() + item.getVolume() > maxVolume)
            return false;
        itemsSet.add(item);
        currVolume += item.getVolume();
        currPrice += item.getPrice();
        return true;
    }

    public int getCurrVolume() {
        return currVolume;
    }

    public int getCurrPrice() {
        return currPrice;
    }

    public ArrayList<Item> getItems() {
        return itemsSet;
    }

    public void clear() {
        itemsSet.clear();
        currPrice = 0;
        currVolume = 0;
    }

    public String toString() {
        return this.itemsSet.toString();
    }
}
