class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
         char[] ch = s.toCharArray(); 
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i]))
                map.put(ch[i],map.get(ch[i])+1);
            else
                map.put(ch[i],1);
        }
        for(int i=0;i<ch.length;i++){
          if(map.get(ch[i])==1)
              return i;
        }
        return -1;
    }
}
//better sol
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        for(int i=0;i<s.length();i++){
          if(map.get(s.charAt(i))==1)
              return i;
        }
        return -1;
    }
}
// best sol beats 98%space and 99% time
class Solution {
    public int firstUniqChar(String s) {
       char[] map = new char[26];
         char[] ch = s.toCharArray(); 
        
        for(int i=0;i<ch.length;i++){
            map[ch[i]-'a']++;
        }
        for(int i=0;i<ch.length;i++){
          if(map[ch[i]-'a']==1)
              return i;
        }
        return -1;
    }
}

/*time complexity:O(n)
space complexity:O(1) since we have fixed set of ascii characters
*/
