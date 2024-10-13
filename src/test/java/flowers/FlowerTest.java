package flowers;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flower.store.Flower;
import flower.store.FlowerColor;
import flower.store.FlowerType;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final double MAX_LENGTH = 100.0;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testType() {
        FlowerType type = FlowerType.ROSE;
        flower.setType(type);
        Assertions.assertEquals(type, flower.getType());
    }

    @Test
    public void testSepalLength() {
        double sepalLength = RANDOM_GENERATOR.nextDouble(MAX_LENGTH);
        flower.setSepalLength(sepalLength);
        Assertions.assertEquals(sepalLength, flower.getSepalLength());
    }

    @Test
    public void testConstructor() {
        Flower flower = new Flower(10.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        Assertions.assertEquals(10.0, flower.getPrice());
        Assertions.assertEquals(5.0, flower.getSepalLength());
        Assertions.assertEquals("#FF0000", flower.getColor());
        Assertions.assertEquals(FlowerType.ROSE, flower.getType());
    }

    @Test
    public void testMatch() {
        Flower flower = new Flower(10.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        Flower flower2 = new Flower(20.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        Flower flower3 = new Flower(10.0, 5.0, FlowerColor.BLUE, FlowerType.ROSE);
        Assertions.assertTrue(flower.matches(flower2));
        Assertions.assertFalse(flower.matches(flower3));
    }

    @Test
    public void testCopyConstructor() {
        Flower flower = new Flower(10.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        Flower flower2 = new Flower(flower);
        Assertions.assertEquals(10.0, flower2.getPrice());
        Assertions.assertEquals(5.0, flower2.getSepalLength());
        Assertions.assertEquals("#FF0000", flower2.getColor());
        Assertions.assertEquals(FlowerType.ROSE, flower2.getType());
        Assertions.assertNotSame(flower, flower2);
    }
}
