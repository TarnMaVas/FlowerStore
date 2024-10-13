package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {

    private final List<FlowerPack> flowerPacks;
    
    public FlowerBucket() {
        this.flowerPacks = new ArrayList<>();

    }

    public void add(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack: flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public boolean matches(ArrayList<FlowerInfo> flowerDescriptions) {
        for (FlowerInfo flowerInfo: flowerDescriptions) {
            if (!flowerPacks.stream().anyMatch(pack -> pack.matches(flowerInfo))) {
                return false;
            }
        }
        return true;
    }
}
