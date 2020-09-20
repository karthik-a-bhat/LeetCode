//https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums==null || nums.length==0) return nums;
        
        //Resultant array. Size is = nums.length - k + 1
        int[] res = new int[nums.length-k+1];
        
        //Index to loop through the resultant array 
        int idx=0;
        
        
        MonoQueue mq = new MonoQueue();
        
        for(int i=0;i<nums.length;i++){
            
            int val = nums[i];
            
            //If value of i is less than k-1, then push to Monotonic queue
            if(i<k-1){
                mq.push(val);  
            }
            else{
                //Push value to queue
                mq.push(val);
                
                //Front of the queue is the maximum of the sliding window
                res[idx]=mq.front();
                
                //Pop value outside sliding window
                mq.pop(nums[i-k+1]);
                
                //Increment index of resultant array
                idx++;
            }
            
        }
        return res;
    }
}

class MonoQueue{
    
    Deque<Integer> dq = new ArrayDeque();
    
    //Push value to queue, such that the queue is always decresing (Maximum at the left(first))
    public void push(Integer n){
        
        while(!dq.isEmpty() && dq.peekLast().compareTo(n)<0){
            dq.pollLast();
        }
        dq.addLast(n);
        
    }
    
    //Maximum value of q stored at front
    public int front(){
        return dq.peekFirst();
    }
    
    //Pop only if first value equals to the integer to be popped
    public void pop(Integer n){
        if(n.equals(dq.peekFirst())){
            dq.pollFirst();
        }
    }
    
}
