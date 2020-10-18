//https://leetcode.com/problems/two-city-scheduling/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int allToA=0;
        
        int[] ref = new int[costs.length];
        
        
        for(int i=0;i<costs.length;i++){
            allToA+=costs[i][0];
            ref[i]=costs[i][1]-costs[i][0];
        }
        
        Arrays.sort(ref);
        
        for(int i=0;i<costs.length/2;i++){
            allToA+=ref[i];
        }
     
        return allToA;
        
    }
}
