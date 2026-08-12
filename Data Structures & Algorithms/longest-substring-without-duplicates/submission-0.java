class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        int maxLength=0, start=0;
        for(int i =0;i<s.length();i++){
            char c=s.charAt(i);
            start=Math.max(map.getOrDefault(c,0),start);
            maxLength=Math.max(maxLength, i-start+1);
            map.put(c,i+1);
        }
        return maxLength;
    }
}
