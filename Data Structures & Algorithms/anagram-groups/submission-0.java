class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] ch= str.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);

            map.putIfAbsent(key,new ArrayList<String>());
            map.get(key).add(str);
        }
        return map.values().stream().collect(Collectors.toList());
        
    }
}
