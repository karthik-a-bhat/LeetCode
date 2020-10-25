//https://leetcode.com/problems/encode-and-decode-tinyurl/

public class Codec {

    HashMap<String, String> shortToLongMap = new HashMap();
    HashMap<String, String> longToShortMap = new HashMap();
    
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    String BASE_HOST="http://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        if(longToShortMap.containsKey(longUrl)) return BASE_HOST+longToShortMap.get(longUrl);
        
        String key=null;
        
        do{
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<10;i++){
                int index = (int)(Math.random()*(charSet.length()));
                
                sb.append(charSet.charAt(index));
                
            }
            
            key=sb.toString();
            
        }while(shortToLongMap.containsKey(key));
        
        shortToLongMap.put(key,longUrl);
        longToShortMap.put(longUrl,key);
        
        return BASE_HOST+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
       return shortToLongMap.get(shortUrl.replace(BASE_HOST, ""));
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
