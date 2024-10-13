package flowers;

import java.util.List;

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

    public static final int DEFAULT_PRICE = 10;
    public static final int DEFAULT_LENGTH = 5;
    public static final int DEFAULT_COUNT = 5;

    private FlowerStore flowerStore;

    @BeforeEach
    public void init() {
        flowerStore = new FlowerStore();
    }

    @Test
    public void testSearch() {
        Flower flowerA = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH,
                                    FlowerColor.RED, FlowerType.ROSE);
        Flower flowerB = new Flower(DEFAULT_PRICE, DEFAULT_LENGTH, 
                                    FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfoA = new FlowerInfo(DEFAULT_LENGTH,
                                    FlowerColor.BLUE, FlowerType.TULIP);
        FlowerInfo flowerInfoB = new FlowerInfo(DEFAULT_LENGTH,
                                    FlowerColor.RED, FlowerType.ROSE);
        FlowerInfo flowerInfoC = new FlowerInfo(DEFAULT_LENGTH,
                                    FlowerColor.RED, FlowerType.TULIP);

        FlowerPack flowerPackA = new FlowerPack(flowerA, DEFAULT_COUNT);
        FlowerPack flowerPackB = new FlowerPack(flowerB, DEFAULT_COUNT);

        FlowerBucket flowerBucketA = new FlowerBucket();
        flowerBucketA.add(flowerPackA);
        flowerBucketA.add(flowerPackB);

        FlowerBucket flowerBucketB = new FlowerBucket();
        flowerBucketB.add(flowerPackA);

        flowerStore = new FlowerStore();
        flowerStore.addBucket(flowerBucketA);
        flowerStore.addBucket(flowerBucketB);

        List<FlowerInfo> matchingList = List.of(flowerInfoA);
        List<FlowerInfo> notMatchingList = List.of(flowerInfoA,
                                            flowerInfoB, flowerInfoC);

        List<FlowerBucket> expectedMatching = List.of(flowerBucketA);
        List<FlowerBucket> expectedNotMatching = List.of();

        Assertions.assertEquals(expectedMatching,
                                flowerStore.search(matchingList));
        Assertions.assertEquals(expectedNotMatching,
                                flowerStore.search(notMatchingList));
    }
}

