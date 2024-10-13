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
    public static final int DEFAULT_PRICE = 10;
    public static final int DEFAULT_LENGTH = 5;
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
        flower = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH, FlowerColor.RED, FlowerType.ROSE);
        Assertions.assertEquals(DEFAULT_PRICE, flower.getPrice());
        Assertions.assertEquals(DEFAULT_LENGTH, flower.getSepalLength());
        Assertions.assertEquals("#FF0000", flower.getColor());
        Assertions.assertEquals(FlowerType.ROSE, flower.getType());
    }

    @Test
    public void testMatch() {
        flower = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH, FlowerColor.RED, FlowerType.ROSE);
        Flower flowerA = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH, FlowerColor.RED, FlowerType.ROSE);
        Flower flowerB = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH, FlowerColor.BLUE, FlowerType.ROSE);
        Assertions.assertTrue(flower.matches(flowerA));
        Assertions.assertFalse(flower.matches(flowerB));
    }

    @Test
    public void testCopyConstructor() {
        flower = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH, FlowerColor.RED, FlowerType.ROSE);
        Flower flowerA = new Flower(flower);
        Assertions.assertEquals(DEFAULT_PRICE, flowerA.getPrice());
        Assertions.assertEquals(DEFAULT_LENGTH, flowerA.getSepalLength());
        Assertions.assertEquals("#FF0000", flowerA.getColor());
        Assertions.assertEquals(FlowerType.ROSE, flowerA.getType());
        Assertions.assertNotSame(flower, flowerA);
    }
}
