/*
4 & 9 series are special . Hence we added in mapping separately.
Take nearest possible number for each and add it our output and reduce the number.
*/
class Solution {
    public String intToRoman(int num) {
        int arabics [] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        String[] matching = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<arabics.length;i++){
            while(num-arabics[i]>=0){
                sb.append(matching[i]);
                num=num-arabics[i];
                
            }
                
        }
        return sb.toString();
    }
}

/*
time complexity:O(n)
space complexity:O(1)
*/

