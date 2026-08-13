class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int length=str.length();
            sb.append(length).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int delimiterIndex = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, delimiterIndex));

            i=delimiterIndex+1;
            String str = s.substring(i, i + length);
            res.add(str);
            i+=length;
        }
    return res;
    }
}
