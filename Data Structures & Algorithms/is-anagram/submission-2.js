class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if(s.length !== t.length) {
            return false
        }
        const map = {}

        for(let letter of s) {
            if(map[letter]) {
                map[letter]++
                continue
            }
            map[letter] = 1
        }

        for(let letter of t) {
            if(map[letter]) {
                map[letter]--
            } else {
                return false
            }
        }

        return true
    }
}
