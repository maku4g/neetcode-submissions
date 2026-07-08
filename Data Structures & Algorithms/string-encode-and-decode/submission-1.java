class Solution {

    public String encode(List<String> strs) {
        String result = "";

        for(String curStr : strs) {
            result = result + curStr.length() + "#" + curStr;
        }

        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        while(str.length() > 0) {
            String[] splittedStr = str.split("#", 2);
            result.add(splittedStr[1].substring(0, Integer.parseInt(splittedStr[0])));
            str = splittedStr[1].substring(Integer.parseInt(splittedStr[0]));
        }

        return result;
    }
}
