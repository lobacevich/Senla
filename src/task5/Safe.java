package task5;

import java.util.ArrayList;
import java.util.List;

public class Safe {
    private final int maxVolume;
    private List<Item> itemsList = new ArrayList<>();
    private int currVolume = 0;
    private int currPrice = 0;

    public Safe(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Safe(Safe another) {
        this.maxVolume = another.maxVolume;
        this.itemsList =  new ArrayList<>(another.itemsList);
        this.currVolume = another.currVolume;
        this.currPrice = another.currPrice;
    }

    public boolean addItem(Item item) {
        if (this.getCurrVolume() + item.getVolume() > maxVolume)
            return false;
        itemsList.add(item);
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

    @Override
    public String toString() {
        return String.format("%s\nЦенность - %s\nОбъем - %s", itemsList.toString(), getCurrPrice(), getCurrVolume());
    }
}
