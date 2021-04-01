//Keep 3 HashMaps. 
// 1) Key to Value 
// 2) Key to Count 
// 3) Count to LinkedHashSet of all keys with that count

//GET Method: Check (1). If not present, then return -1
//Get the count of the key from (2)
//Go to (3) and remove the entry. Also check if count is min and if size of HashSet in (3) for this count is 0. If so, increment min
//Update value in (2) and (3) -> putCount


//PUT Method: Check if present in (1) if so, change value in (1) and call GET method and return 
//If not, check capacity and evice LRU from min of (3)
// Change min to 1
//Add to (2) and (3) using method -> putCount


class LFUCache {
    
    private int min;

    private final int capacity;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache(int capacity) {
        min=0;
        this.capacity=capacity;
        keyToVal = new HashMap();
        keyToCount = new HashMap();
        countToLRUKeys = new HashMap();
    }
    
    public int get(int key) {
        
        if(!keyToVal.containsKey(key)) return -1;     
        
        int count = keyToCount.get(key);
        
        countToLRUKeys.get(count).remove(key);
        
        if(count==min && countToLRUKeys.get(count).size()==0) min++;
        
        putCount(key,count+1);
        
        return keyToVal.get(key); 
        
    }
    
    public void put(int key, int value) {
        
        if (capacity <= 0) return;

        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            get(key);
            return;
        }
        
        if(keyToVal.size()>=capacity){
            
            remove(countToLRUKeys.get(min).iterator().next());
        }
        min=1;
        keyToVal.put(key,value);
        putCount(key,1);
    
    }
    
    private void remove(int toRemove){
        
        keyToVal.remove(toRemove);
        countToLRUKeys.get(min).remove(toRemove);
        keyToCount.remove(toRemove);
        
    }
    
    private void putCount(int key, int count){
        
        keyToCount.put(key,count);
        
        countToLRUKeys.computeIfAbsent(count, k->new LinkedHashSet());
        countToLRUKeys.get(count).add(key);
    }
}
