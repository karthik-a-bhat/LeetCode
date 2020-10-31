//https://leetcode.com/problems/word-ladder-ii/

//Explanation:

//Ladder is only used to keep track of nodes and their levels!!

//1. Keep a Map called Ladder to keep track of level of the word
//2. Keep a Map called map to keep the adjacency list for the dfs
//3. Like Word Ladder 1, take the first word, put in the queue
//4. Try to form other words. Keep track of level of new word in ladder. If level > current level, dont put it
//5. Else,  put it into ladder and with the level and to the Queue. 
//6. Also put it into the adj list called map. 
//7. DFS into the adjacency list till you reach the endword. 
//8. Put all of this into the result and return it. 

class Solution {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    
        List<List<String>> res = new ArrayList<List<String>>();
        Set<String> set = new HashSet<String>(wordList);
        Map<String, Integer> ladder = new HashMap<String, Integer>();
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        
        ladder.put(beginWord, 0);
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            
            String word = queue.poll();
            if (word.equals(endWord)) {
                break;
            }
            
            int step = ladder.get(word) + 1;
            
            for(int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(i)) {
                        continue;
                    }
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    
                    if (!set.contains(newWord)) {
                        continue;
                    }
                    
                    //To check if the same level nodes are not being put into the map
                    //Eg- You can go to hot-> dot or, hot->lot->dot
                    //We dont want the latter as it will cause errors in the dfs
                    if (step <= ladder.getOrDefault(newWord, Integer.MAX_VALUE)) {
                        queue.add(newWord);
                        ladder.put(newWord, step);
                        if (!map.containsKey(word)) {
                            map.put(word, new HashSet<String>());
                        }
                        map.get(word).add(newWord);
                    }
                }
            }
        }
        
        List<String> list = new ArrayList<String>();
        dfs(res, list, map, beginWord, endWord);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, Map<String, Set<String>> map, String word, String endWord) {
        if (word.equals(endWord)) {
            list.add(word);
            res.add(new ArrayList<String>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(word);
        if (map.containsKey(word)) {
            for (String s : map.get(word)) {
                dfs(res, list, map, s, endWord);
            }
        }
        list.remove(list.size() - 1);
    }
}
