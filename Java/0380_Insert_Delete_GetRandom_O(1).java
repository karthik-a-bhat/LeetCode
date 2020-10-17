//https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {

    //K=Number, V=Index in List
    HashMap<Integer, Integer> hm;
    
    List<Integer> al;
    
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        al = new ArrayList();
        hm = new HashMap();
        rand = new Random();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {       
        
        if(hm.containsKey(val)) return false;
        
        al.add(val);
        hm.put(val,al.size()-1);
        
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!hm.containsKey(val)) return false;
        
        int idx = hm.get(val);
        
        int alLastEle = al.get(al.size()-1);
        
        al.set(idx,alLastEle);
        
        hm.put(alLastEle,idx);
        
        hm.remove(val);
     
        al.remove(al.size()-1);
        
       
     
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    
        int randomVal = rand.nextInt(al.size());
        
        return al.get(randomVal);
        
    
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
