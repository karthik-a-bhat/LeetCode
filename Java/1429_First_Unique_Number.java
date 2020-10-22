//https://leetcode.com/problems/first-unique-number/

class FirstUnique {
    
    HashMap<Integer, Integer> hm;
    Queue<Integer> q;

    public FirstUnique(int[] nums) {
        
        q=new LinkedList();
        hm=new HashMap();
        
        for(int i:nums){
            
            q.add(i);
            hm.put(i,hm.getOrDefault(i,0)+1);
            
        }
        
        
    }
    
    public int showFirstUnique() {
        
        //Don't update value of the HM. 
        while(!q.isEmpty() && hm.get(q.peek())>1){
            int polled = q.poll();
        }
        
        if(q.isEmpty()){
            return -1;
        }
        else{
            return q.peek();
        }
        
    }
    
    public void add(int value) {
        
        q.add(value);
        hm.put(value,hm.getOrDefault(value,0)+1);
        
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
