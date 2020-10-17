//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap();
        
        int maxFreq=0;
        
        for(int i:nums){
            
            hm.put(i,hm.getOrDefault(i,0)+1);
            
            maxFreq = Math.max(maxFreq,hm.get(i));
            
        }
        
        LinkedList[] buckets = new LinkedList[maxFreq+1];
        
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList();
        }
        
        
        for(int key:hm.keySet()){
            
            int freq = hm.get(key);
            
            List<Integer> tempList = buckets[freq];
            
            tempList.add(key);
        
        }
        
        int[] res = new int[k];
        int idx=0;
        
        for(int i=maxFreq;i>=0;i--){
            
            List<Integer> tempList = buckets[i];
            
            for(int ele:tempList){
                
                res[idx++]=ele;
                if(idx==k){
                    return res;
                }
                
            }
        }
        
        return res;
        
    }
}
