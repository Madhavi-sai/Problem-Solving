class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
            else{
                hm.put(s.charAt(i), 1);
            }
        }
        for (Character c: hm.keySet()){
            if(hm.get(c) == 1){
                return s.indexOf(c);
            }
        } 
        return -1;
    }
}