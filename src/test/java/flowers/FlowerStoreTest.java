package flowers;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flower.store.Flower;
import flower.store.FlowerBucket;
import flower.store.FlowerColor;
import flower.store.FlowerInfo;
import flower.store.FlowerPack;
import flower.store.FlowerStore;
import flower.store.FlowerType;

public class FlowerStoreTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerStore flowerStore;

    @BeforeEach
    public void init() {
        flowerStore = new FlowerStore();
    }

    @Test
    public void testSearch() {
        Flower flower1 = new Flower(5.0, 5.0, FlowerColor.RED, FlowerType.ROSE);
        Flower flower2 = new Flower(5.0, 5.0, FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfo1 = new FlowerInfo(5.0, FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfo2 = new FlowerInfo(5.0, FlowerColor.RED, FlowerType.ROSE);
        FlowerInfo flowerInfo3 = new FlowerInfo(5.0, FlowerColor.RED, FlowerType.TULIP);

        FlowerPack flowerPack1 = new FlowerPack(flower1, 5);
        FlowerPack flowerPack2 = new FlowerPack(flower2, 5);

        FlowerBucket flowerBucket1 = new FlowerBucket();
        flowerBucket1.add(flowerPack1);
        flowerBucket1.add(flowerPack2);

        FlowerBucket flowerBucket2 = new FlowerBucket();
        flowerBucket2.add(flowerPack1);

        FlowerStore flowerStore = new FlowerStore();
        flowerStore.addBucket(flowerBucket1);
        flowerStore.addBucket(flowerBucket2);

        List<FlowerInfo> matchingList = List.of(flowerInfo1);
        List<FlowerInfo> notMatchingList = List.of(flowerInfo1, flowerInfo2, flowerInfo3);

        List<FlowerBucket> expectedMatching = List.of(flowerBucket1);
        List<FlowerBucket> expectedNotMatching = List.of();

        Assertions.assertEquals(expectedMatching, flowerStore.Search(matchingList));
        Assertions.assertEquals(expectedNotMatching, flowerStore.Search(notMatchingList));
    }
}

