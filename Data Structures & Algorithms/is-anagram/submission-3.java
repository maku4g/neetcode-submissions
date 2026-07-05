class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> store = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int sCounter = store.getOrDefault(s.charAt(i), 0);
            store.put(s.charAt(i), sCounter + 1);

            int tCounter = store.getOrDefault(t.charAt(i), 0);
            store.put(t.charAt(i), tCounter - 1);
        }

        return store.values().stream().allMatch(v -> v == 0);
    }
}