package flowers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flower.store.Flower;
import flower.store.FlowerInfo;
import flower.store.FlowerColor;
import flower.store.FlowerType;
import flower.store.FlowerBucket;
import flower.store.FlowerPack;

public class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }

    @Test
    public void testMatches() {

        Flower flower1 = new Flower(5.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        Flower flower2 = new Flower(5.0, 5.0, FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfo1 = new FlowerInfo(5.0, FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfo2 = new FlowerInfo(5.0, FlowerColor.RED, FlowerType.ROSE);
        FlowerInfo flowerInfo3 = new FlowerInfo(5.0, FlowerColor.RED, FlowerType.TULIP);
    
        List<FlowerInfo> matchingList = new ArrayList<>();
        matchingList.add(flowerInfo1);
        matchingList.add(flowerInfo2);

        List<FlowerInfo> notMatchingList = new ArrayList<>();
        notMatchingList.add(flowerInfo1);
        notMatchingList.add(flowerInfo3);
    
        FlowerPack flowerPack1 = new FlowerPack(flower1, 5);
        FlowerPack flowerPack2 = new FlowerPack(flower2, 5);

        flowerBucket.add(flowerPack1);
        flowerBucket.add(flowerPack2);
    
        Assertions.assertTrue(flowerBucket.matches(matchingList));
        Assertions.assertFalse(flowerBucket.matches(notMatchingList));
    }
}
