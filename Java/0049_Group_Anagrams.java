//https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList();
        
        HashMap<String, List<String>> hm = new HashMap();
        
        for(String s : strs){
            
            char[] s_arr = s.toCharArray();
            
            //Arrays.sort(s_arr);
            
            //Can make it faster. Linear time
            
            int[] char_arr = new int[26];
            
            for(int i=0;i<s_arr.length;i++){
                char_arr[s_arr[i]-'a']++;
            }
            
            
            String sorted = Arrays.toString(char_arr);
            
 //           String sorted = new String(s_arr);
            
            List<String> tempList = hm.getOrDefault(sorted,new ArrayList());
            
            tempList.add(s);
            
            hm.put(sorted,tempList);
            
        }
        
        res.addAll(hm.values());
        
        return res;
    }
}
