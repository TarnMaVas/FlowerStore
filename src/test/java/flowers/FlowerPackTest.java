package flowers;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import flower.store.Flower;
import flower.store.FlowerColor;
import flower.store.FlowerPack;
import flower.store.FlowerType;

public class FlowerPackTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private static final double MAX_LENGTH = 100.0;
    private static final int MAX_QUANTITY = 1000;
    public static final int DEFAULT_PRICE = 10;
    public static final int DEFAULT_LENGTH = 5;
    public static final int DEFAULT_COUNT = 5;

    @Test
    public void testPrice() {
        double price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        double sepalLength = RANDOM_GENERATOR.nextDouble(MAX_LENGTH);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower(price, sepalLength,
                            FlowerColor.RED, FlowerType.ROSE);

        Assertions.assertEquals(price * quantity,
                         new FlowerPack(flower, quantity).getPrice());

    }

    @Test
    public void testMatches() {
        Flower flower = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                             FlowerColor.RED, FlowerType.ROSE);
        FlowerPack flowerPack = new FlowerPack(flower, DEFAULT_COUNT);
        Assertions.assertTrue(flowerPack.matches(flower));
    }
}