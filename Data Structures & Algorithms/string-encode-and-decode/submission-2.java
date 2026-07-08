class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String curStr : strs) {
            result.append(curStr.length()).append("#").append(curStr);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        while(str.length() > 0) {
            String[] splittedStr = str.split("#", 2);
            int len = Integer.parseInt(splittedStr[0]);
            result.add(splittedStr[1].substring(0, len));
            str = splittedStr[1].substring(len);
        }

        return result;
    }
}
