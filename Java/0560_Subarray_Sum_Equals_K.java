//https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //Key=Sum, Val=count of sum 
        HashMap<Integer, Integer> hm = new HashMap();
     
        hm.put(0,1);
        int count=0;
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            
            sum+=nums[i];
            
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
            }
            
            hm.put(sum,hm.getOrDefault(sum,0)+1);
                
        }
        return count;
    }
}
