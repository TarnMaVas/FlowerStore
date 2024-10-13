package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @AllArgsConstructor
public class FlowerInfo {

    @Getter
    private double sepalLength;

    private FlowerColor color;

    @Getter
    private FlowerType type;

    public FlowerInfo(FlowerInfo flowerInfo) {
        this.sepalLength = flowerInfo.getSepalLength();
        this.color = flowerInfo.color;
        this.type = flowerInfo.getType();
    }

    public String getColor() {
        return color.toString();
    }

    public boolean matches(FlowerInfo flowerInfo) {
        return this.sepalLength == flowerInfo.getSepalLength()
               && this.getColor().equals(flowerInfo.getColor())
               && this.type == flowerInfo.getType();
    }

}
