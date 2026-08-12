class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> map1= new HashMap<>();
        Map<Character,Integer> map2= new HashMap<>();

        for(Character c:s.toCharArray())
            map1.put(c,map1.getOrDefault(c,0)+1);
        for(Character c:t.toCharArray())
            map2.put(c,map2.getOrDefault(c,0)+1);
        
        for(Map.Entry<Character,Integer> entry : map1.entrySet()){
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
