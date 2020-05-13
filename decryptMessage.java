import java.io.*;
import java.util.*;

class Solution {

  static String decrypt(String word) {
    if(word.length()==0)
      return word;
    char arr[] = word.toCharArray();
        char arr2[] = word.toCharArray();
    for(int j=1;j<arr.length;j++){
       int c = arr[j];
       int n=0;
       int prev = 0;
      for(int i = 97 ;i<=122;i++){
        prev = arr[j-1];
          if((i-c+prev)%26==0)
            n=(i-c+prev)/26;
       }
       c= c+ (n*26)-prev;
      arr2[j]=(char)c;
    }
    arr2[0]=(char)(arr[0]-1);
   return String.valueOf(arr2);
  }

  public static void main(String[] args) {
    System.out.println(new Solution().decrypt("dnotq"));
  }

}


  

// E = D + Step 2 (i-1) - 26n 
// D = E + 26n - Step 2(i-1)

// 'd' -> 'c' -1 
// E1 = 100 (step 2 (i-1))
// E2 = D2 + 100 - 26n
// 110 = D2 + 100 - 26n 
// D2 = 110-100+26n = 10+26n = 114 
// D2 => 10 + 26 + 26 + 26... (number of 26 = n)
// D2 => 97-122 = x => number 26 => n 


// 'r'
// D = 110 + 26n - 100 = D = 10 + 26n => 10 + 26n -> 97-122
// 114 = 10 + 26n
// 104 = 26n
// a-z : 97-122
