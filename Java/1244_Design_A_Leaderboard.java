//https://leetcode.com/problems/design-a-leaderboard/

class Leaderboard {
    
    //Key = playerId and Value = score of player added up each time
    HashMap<Integer, Integer> hm;
    
    //Key = Score and Value = number of players with that score sorted in decresing order
    TreeMap<Integer, Integer> tm;
    
    public Leaderboard() {
        hm = new HashMap();
        tm = new TreeMap(Comparator.reverseOrder()); 
    }
    
    public void addScore(int playerId, int score) {
        
        //If HM does not have player, add him
        if(!hm.containsKey(playerId)){
            
            hm.put(playerId,score);
            
            //Increment count of score in TM by 1
            tm.put(score, tm.getOrDefault(score,0)+1);
            
        }
        else{
            
            //Get old score of player from HM
            int oldScore = hm.get(playerId);
            
            //Calculate the new score
            int newScore = oldScore+score;
            
            //Decrement oldscore count by 1 from TM, if 0, remove it
            tm.put(oldScore,tm.get(oldScore)-1);
            
            if(tm.get(oldScore)==0){
                tm.remove(oldScore);
            }
            
            
            //Update new score for player in HM
            hm.put(playerId,newScore);
            
            //Increment count of new score in TM by 1 
            tm.put(newScore, tm.getOrDefault(newScore,0)+1);
            
        }
        
    }
    
    public int top(int K) {
        
        int idx=0;
        int sum=0;
        
        //Get sum of top K keys in TM
        //Keys are already sorted in Descending order
        for(int key:tm.keySet()){
            
            int count = tm.get(key);
            
            for(int i=0;i<count;i++){
                sum+=key;
                idx++;
                if(idx==K){
                    break;
                }
            }
            if(idx==K){
                break;
            }
        }
       
        return sum;
    }
    
    public void reset(int playerId) {
        
        int oldScore = hm.get(playerId);
        
        ////Decrement oldscore count by 1 from TM, if 0, remove it
        tm.put(oldScore,tm.get(oldScore)-1);
            
            if(tm.get(oldScore)==0){
                tm.remove(oldScore);
            }
        
        //Remove player from HM
        hm.remove(playerId);
        
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
