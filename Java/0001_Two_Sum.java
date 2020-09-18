//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        HashMap<Integer, Integer> hm = new HashMap();
        
        
        for(int i=0;i<nums.length;i++){
            
            int val = target-nums[i];
            
            if(hm.containsKey(val)){
                return new int[]{hm.get(val),i};
            }
            
            hm.put(nums[i],i);
            
        }
        
        //Control won't get to this point, since there will definitely be a solution (Given in problem statement)
        return nums;
    }
}
