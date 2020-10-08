//https://leetcode.com/problems/maximum-frequency-stack/

class FreqStack {

    List<Stack<Integer>> list;
    
    Map<Integer, Integer> freqMap;
    
    public FreqStack() {
        list = new ArrayList();
        list.add(new Stack());
        freqMap = new HashMap();
    }
    
    public void push(int x) {
        freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        
        int currFreq = freqMap.get(x);
        
        if(currFreq>=list.size()){
            list.add(new Stack<Integer>());
        }
        list.get(currFreq).push(x);
        
    }
    
    public int pop() {
        int currFreq = list.size()-1;
        
        Stack<Integer> currStack = list.get(currFreq);
        
        int val = currStack.pop();
        
        if(currStack.isEmpty()){
            list.remove(list.size()-1);
        }
        
        int freqMapVal = freqMap.get(val);
        
        if(freqMapVal==1){
            freqMap.remove(val);
        }
        else{
            freqMap.put(val,freqMapVal-1);
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
