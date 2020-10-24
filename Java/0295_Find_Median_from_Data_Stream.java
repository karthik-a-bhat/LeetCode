//https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        
        minHeap.add(num);
        
        maxHeap.add(minHeap.poll());
        
        if(maxHeap.size()>minHeap.size()){
            minHeap.add(maxHeap.poll());
        }
        
        
    }
    
    public double findMedian() {
        
        if(maxHeap.size()==minHeap.size()) return (maxHeap.peek()+minHeap.peek())/2.0;
        
        return (double)minHeap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
