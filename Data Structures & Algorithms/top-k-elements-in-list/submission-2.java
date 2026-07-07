class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> store = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            Integer currentValue = store.get(nums[i]);

            if(currentValue == null) {
                store.put(nums[i], 1);
                continue;
            }

            store.put(nums[i], currentValue + 1);
        }

        return store.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();
    }
}
