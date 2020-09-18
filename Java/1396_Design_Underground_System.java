//https://leetcode.com/problems/design-underground-system/

class UndergroundSystem {
    
    HashMap<Integer, Pair<String, Integer>> checkInMap=null;
    HashMap<String, Pair<Integer, Integer>> checkOutMap = null;
    
    public UndergroundSystem() {
        
        checkInMap=new HashMap();
        checkOutMap = new HashMap();
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        
        checkInMap.put(id, new Pair(stationName, t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        String prevStation = checkInMap.get(id).getKey();
        int checkInTime = checkInMap.get(id).getValue();
        
        String route = prevStation + "_"+ stationName;
        
        int count=0;
        int timePresentInMap=0;
        
        if(checkOutMap.containsKey(route)){
            count=checkOutMap.get(route).getValue();
            timePresentInMap = checkOutMap.get(route).getKey();
        }
        
        
        
        int totalTime = t-checkInTime+timePresentInMap;
        
        count+=1;
        
        checkOutMap.put(route,new Pair(totalTime,count));
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String route = startStation + "_" + endStation;
        
        int time = checkOutMap.get(route).getKey();
        int count = checkOutMap.get(route).getValue();
        
        return (double)time/count;
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
