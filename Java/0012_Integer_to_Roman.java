//https://leetcode.com/problems/integer-to-roman/

class Solution {
    public String intToRoman(int num) {
        
        //One Thousand to Three Thousand
        String[] thousands = {"","M","MM","MMM"};
        
        //One Hundred to Nine Hundred
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};        
        
        //Ten to Ninety
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        
        //One to Nine
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        
        
        String res = thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[(num%10)];
        
        
        return res;
        
    }
}
