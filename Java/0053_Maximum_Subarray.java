//https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        
        int res = Integer.MIN_VALUE;    
        int sum=0;
        
        for(int i:nums){
            
            sum+=i;
            
            if(i>sum){
                sum=i;
            }
           
            res = Math.max(res,sum);
            
        }
        
        return res;
    }
}
