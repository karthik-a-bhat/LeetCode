//https://leetcode.com/problems/number-of-ships-in-a-rectangle/

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    
    int count=0;
    
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        
        count(sea,bottomLeft,topRight);
        return count;
        
    }
    
    public void count(Sea sea, int[] bottomLeft, int[] topRight){
        
        if(!sea.hasShips(topRight, bottomLeft)) return;
        
        if(bottomLeft[0]==topRight[0] && bottomLeft[1]==topRight[1]){
            count++;
            return;
        }
        
        
        int midX = bottomLeft[0]+(topRight[0]-bottomLeft[0])/2;
        int midY = bottomLeft[1]+(topRight[1]-bottomLeft[1])/2;
        
        
        count(sea,bottomLeft, new int[]{midX, midY});
        
        count(sea,new int[]{midX+1,bottomLeft[1]}, new int[]{topRight[0],midY});
        
        count(sea, new int[]{midX+1, midY+1}, topRight);
        
        count(sea, new int[]{bottomLeft[0],midY+1}, new int[]{midX, topRight[1]});

        
    }
    
}
