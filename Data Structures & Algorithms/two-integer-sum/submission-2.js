class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const map = {}

        for(let i = 0; i < nums.length; i++) {
            const num = nums[i]
            console.log(map)

            if(map[num] !== undefined) {
                return [map[num], i]
            }

            const result = target - num

            map[result] = i
        }
    }
}
