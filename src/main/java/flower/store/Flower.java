package flower.store;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Flower extends FlowerInfo {

    private double price;

    public Flower(Flower flower) {
        this.price = flower.price;
        this.setSepalLength(flower.getSepalLength());
        this.setColor(FlowerColor.getColor(flower.getColor()));
        this.setType(flower.getType());
    }

    public Flower(double price, double sepalLength,
                 FlowerColor color, FlowerType type) {
        this.setPrice(price);
        this.setSepalLength(sepalLength);
        this.setColor(color);
        this.setType(type);
    }
}