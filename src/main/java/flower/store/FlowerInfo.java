package flower.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @AllArgsConstructor
public class FlowerInfo {

    @Getter
    protected double sepalLength;

    protected FlowerColor color;

    @Getter
    protected FlowerType type;

    public FlowerInfo(FlowerInfo flowerInfo) {
        this.sepalLength = flowerInfo.getSepalLength();
        this.color = flowerInfo.color;
        this.type = flowerInfo.getType();
    }

    public String getColor() {
        return color.toString();
    }

    public boolean matches(FlowerInfo flowerInfo) {
        return this.sepalLength == flowerInfo.sepalLength && 
               this.color == flowerInfo.color && 
               this.type == flowerInfo.type;
    }

}
