//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        
        
        Arrays.fill(dp,-1);
        
        dp[0]=0;
        
        
        for(int i=1;i<dp.length;i++){
            
            for(int c : coins){
                
                if(c<=i && dp[i-c]!=-1){
                    int preVal = dp[i];
                    
                    int val = dp[i-c]+1;
                    
                    if(preVal!=-1){
                        dp[i]=Math.min(dp[i],val);
                    }
                    else{
                        dp[i]=val;
                    }
                  
                }
 
            }
        
        }
        return dp[amount];
        
        
    }
}
