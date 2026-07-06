class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> store = new HashMap();

        for(int i = 0; i < strs.length; i++) {
            String currentString = strs[i];
            char[] manyZeroes = "00000000000000000000000000".toCharArray();

            for(int k = 0; k < currentString.length(); k++) {
                int letterAsIndex = currentString.charAt(k) - 'a';
                
                int currentValue = Character.getNumericValue(manyZeroes[letterAsIndex]);
                int newValue = currentValue + 1;

                manyZeroes[letterAsIndex] = Character.forDigit(newValue, 10);
            }

            store.computeIfAbsent(new String(manyZeroes), j -> new ArrayList<>())
                    .add(currentString);
        }

        return new ArrayList<>(store.values());
    }
}
