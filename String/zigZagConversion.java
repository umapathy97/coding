/*
intution:
create string builder array of size equals to number of rows.
initialize each index in a string builder array to be stringbuilder.
for each character in string add it to its appropriate index.
this involves filling in rowwise pattern.
*/
class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==0)
            return s;
        if(numRows<=1)
            return s;
        int index=0;
        int counter=1;
        StringBuilder sb[]= new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");
        }
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0)
                counter=1;
            if(index==numRows-1)
                counter=-1;
            index+=counter;
        }
        String result="";
        for(int i=0;i<sb.length;i++){
            result=result+sb[i];
        }
        return result;
    }
}
/*
time complexity:O(n)
space complexity:O(n)
beats 37% time and 68% space.
*/


// visit by row
class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        
        if (numRows > length || numRows <= 1) {
            return s;
        }
        
        char[] zigZagChars = new char[length];
        int count = 0;
        
        int interval = 2 * numRows - 2;
        
        for (int i = 0; i < numRows; i++) {
            int step = interval - 2 * i;
            for (int j = i; j < length; j += interval) {
                zigZagChars[count] = s.charAt(j);
                count++;
                if (step > 0 && step < interval && j + step < length) {
                    zigZagChars[count] = s.charAt(j + step);
                    count++;
                }                
            }            
        }
        
        return new String(zigZagChars);
    }
}
/*
time complexity:O(n)
space complexity:O(n)
beats 100% space and 100% time.
*/
