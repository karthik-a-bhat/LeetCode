//https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
     
        int sum=0;
        
        for(int i:nums){
            sum+=i;
        }
        
        //n(n+1)/2
        int actualSum = (nums.length*(nums.length+1))/2;
        
        return actualSum-sum;
        
    }
}
