class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer resIndex = store.get(nums[i]);

            if(resIndex != null) {
                return new int[]{resIndex, i};
            }

            store.put(target - nums[i], i);
        }

        return new int[]{0, 0};
    }
}