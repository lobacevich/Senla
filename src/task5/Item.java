package task5;

public class Item {
    private final String name;
    private final int volume;
    private final int price;
    private final double pricePerVolume;

    public Item(String name, int volume, int price) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.pricePerVolume = (double) price / volume;
    }

    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }

    public double getPricePerVolume() {
        return pricePerVolume;
    }

    @Override
    public String toString() {
        return name;
    }
}
