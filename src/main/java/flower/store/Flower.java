package flower.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Flower extends FlowerInfo {

    private double price;

    public Flower(Flower flower) {
        this.price = flower.price;
        this.sepalLength = flower.getSepalLength();
        this.color = flower.color;
        this.type = flower.getType();
    }

    public Flower(double price, double sepalLength,
                 FlowerColor color, FlowerType type) {
        this.price = price;
        this.sepalLength = sepalLength;
        this.color = color;
        this.type = type;
    }
}