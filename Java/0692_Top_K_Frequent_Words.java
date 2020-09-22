//https://leetcode.com/problems/top-k-frequent-words/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
     
        int maxFreq = 0;
        
        List<String> res = new ArrayList();
        
        HashMap<String, Integer> hm = new HashMap();
        
        for(String word : words){
            
            hm.put(word, hm.getOrDefault(word,0)+1);
            
            maxFreq = Math.max(maxFreq, hm.get(word));
            
        }
        
        ArrayList[] buckets = new ArrayList[maxFreq+1];
        
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList();
        }
        
        for(String word : hm.keySet()){
            
            int freq = hm.get(word);
            
            buckets[freq].add(word);
            
        }
        
        int count=0;
        
        for(int i=maxFreq;i>=0;i--){
            
            List<String> tempList = buckets[i];
            Collections.sort(tempList);
            
            for(String word:tempList){
                res.add(word);
                count++;
                if(count==k){
                    return res;
                }
            }
        }
        
        return res;
        
        
    }
}
