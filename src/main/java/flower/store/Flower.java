package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @AllArgsConstructor
public class Flower {

    @Getter
    private double price;

    @Getter
    private double sepalLength;

    private FlowerColor color;

    @Getter
    private FlowerType type;

    public String getColor() {
        return color.toString();
    }

}