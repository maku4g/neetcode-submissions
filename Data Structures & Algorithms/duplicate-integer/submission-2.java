class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap store = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            if(store.containsKey(nums[i])) {
                return true;
            }

            store.put(nums[i], true);
        }

        return false;
    }
}