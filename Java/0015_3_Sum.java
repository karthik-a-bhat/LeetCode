//https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList();
        
        
        Arrays.sort(nums);
        
        
      
        
        for(int i=0;i<nums.length;i++){
            
            int l=i+1;
            
            int r=nums.length-1;
            
            
            while(l<r){
                
                int a=nums[i];
                int b=nums[l];
                int c=nums[r];
                
                int sum = a+b+c;
                
                if(sum==0){
                    List<Integer> tempList = new ArrayList();
                    
                    tempList.add(a); tempList.add(b); tempList.add(c);
                    
                    res.add(tempList);
                    
                    l++;r--;
                    
                    while(l<nums.length-1 && nums[l-1]==nums[l]) l++;
                    while(r>=0 && nums[r+1]==nums[r]) r--;
                    
                }
                else if(sum<0){
                    
                    l++;
                    while(l<nums.length-1 && nums[l-1]==nums[l]) l++;
                }
                else if(sum>0){
                    r--;
                    while(r>=0 && nums[r+1]==nums[r]) r--;
                }
                
                
            }
            
            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
            
        }
        
        return res;
    }
}
