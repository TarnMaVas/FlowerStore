package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Flower extends FlowerInfo {

    private double price;

    public Flower(Flower flower) {
        this.price = flower.price;
        this.sepalLength = flower.getSepalLength();
        this.color = flower.color;
        this.type = flower.getType();
    }
}