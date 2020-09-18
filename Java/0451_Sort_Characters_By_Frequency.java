//https://leetcode.com/problems/sort-characters-by-frequency/

//Implemented using Bucket-Sort
class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> hm = new HashMap();
        
        int maxFreq = 0;
        
        for(char c: s.toCharArray()){
            
            hm.put(c,hm.getOrDefault(c,0)+1);
            
            maxFreq = Math.max(maxFreq,hm.get(c));
            
        }
        
        //Create a bucket
        
        ArrayList<Character>[] bucket = new ArrayList[maxFreq+1];
        
        for(int i=1;i<=maxFreq;i++){
            bucket[i]=new ArrayList();
        }
        
        
        for(char key : hm.keySet()){
            
            int val= hm.get(key);
            
            List<Character> al = bucket[val];
            
            al.add(key);
        
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=maxFreq;i>0;i--){
            
            List<Character> al = bucket[i];
            
            for(char c:al){
                
                for(int j=0;j<i;j++){
                    sb.append(c);
                }
                
            }
            
        }
        return sb.toString();
        
        
    }
}
