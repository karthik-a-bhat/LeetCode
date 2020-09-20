//https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        
        if(height==null || height.length==0) return 0;
        
        int area = Integer.MIN_VALUE;
        
        int l=0,r=height.length-1;
        
        while(l<r){
            
            if(height[l]<height[r]){
                
                int currArea = (r-l)*(height[l]);
                area = Math.max(area,currArea);
                l++;
            }
            else{
                int currArea = (r-l)*(height[r]);
                area = Math.max(area,currArea);
                r--;
            }
            
        }
        return area;
    }
}
