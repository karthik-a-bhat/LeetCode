//https://leetcode.com/problems/design-browser-history/

class BrowserHistory {

    List<String> list = null;
    
    int index=0;
    
    public BrowserHistory(String homepage) {
        
        list= new ArrayList();
        list.add(homepage);
    }
    
    public void visit(String url) {
        
        list.subList(index+1,list.size()).clear();
        list.add(url);
        index++;
    }
    
    public String back(int steps) {
        
        index = (index-steps)<0 ? 0:index-steps;
        
        return list.get(index);
        
    }
    
    public String forward(int steps) {
        
        index = ((index+steps)>=list.size()) ? list.size()-1:index+steps;
        
        return list.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
