package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerStore {
   private final List<FlowerBucket> flowerBuckets; 

   public FlowerStore(ArrayList<FlowerBucket> flowerBuckets) {
       this.flowerBuckets = flowerBuckets;
   }

   public FlowerStore() {
       this.flowerBuckets = new ArrayList<>();
   }

   public void addBucket(FlowerBucket flowerBucket) {
       flowerBuckets.add(flowerBucket);
   }

   public List<FlowerBucket> search(List<FlowerInfo> flowerDescriptions) {
       List<FlowerBucket> searchResult = new ArrayList<>();
       for (FlowerBucket flowerBucket: flowerBuckets) {
           if (flowerBucket.matches(flowerDescriptions)) {
               searchResult.add(flowerBucket);
           }
       }
       return searchResult;
   }
}
