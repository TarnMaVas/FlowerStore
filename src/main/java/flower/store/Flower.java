package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @AllArgsConstructor
public class Flower {

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private double sepalLength;

    @Setter
    private FlowerColor color;

    @Getter
    @Setter
    private FlowerType type;

    public String getColor() {
        return color.toString();
    }

}