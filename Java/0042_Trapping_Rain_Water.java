//https://leetcode.com/problems/trapping-rain-water/
//Inspired by GoodTecher's YouTube video. 
//https://www.youtube.com/watch?v=wz00uI9mDXA

class Solution {
    public int trap(int[] height) {
        
        if(height==null || height.length==0) return 0;
        
        int res=0;
        
        int[] leftHighest = new int[height.length];
        
        leftHighest[0]=0;
        
        for(int i=1;i<leftHighest.length;i++){
            leftHighest[i]=Math.max(leftHighest[i-1],height[i-1]);
        }
        
        
        int rightHighest=0;
        
        
        for(int i=height.length-2;i>0;i--){
            
            rightHighest = Math.max(rightHighest,height[i+1]);
            
            if((Math.min(rightHighest, leftHighest[i])-height[i])>0){
                res+= (Math.min(rightHighest, leftHighest[i])-height[i]);
            }
            
            
        }
        
        return res;
    }
}
