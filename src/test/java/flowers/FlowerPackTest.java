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

    @Test
    public void testPrice(){
        double price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        double sepalLength = RANDOM_GENERATOR.nextDouble(MAX_LENGTH);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower(price, sepalLength, FlowerColor.RED, FlowerType.ROSE);

        Assertions.assertEquals(price * quantity, new FlowerPack(flower, quantity).getPrice());

    }

    @Test
    public void testMatches(){
        Flower flower = new Flower(5.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        FlowerPack flowerPack = new FlowerPack(flower, 5);
        Assertions.assertTrue(flowerPack.matches(flower));
    }
}