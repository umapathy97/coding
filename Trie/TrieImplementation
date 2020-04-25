
class Trie{
    static class TrieNode{
        char c;
        TrieNode[] children=new TrieNode[26];
        boolean isEndOfWord;
        public TrieNode(){
            isEndOfWord = false;
            for(int i=0;i<26;i++)
                children[i]=null;
        }
    }
  static  TrieNode root;
   public static void insert(String key){
        TrieNode current = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(current.children[index]==null)
                current.children[index]=new TrieNode();
            current=current.children[index];
        }
        current.isEndOfWord=true;
    }
  public static boolean search(String key){
        TrieNode current = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(current.children[index]==null)
                return false;
            current=current.children[index];
        }
        return current!=null && current.isEndOfWord;
    }
    public static void main(String args[]){
        root = new TrieNode();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        String output[] = {"Not present in trie", "Present in trie"};
        for (int i = 0; i < keys.length ; i++)
            insert(keys[i]);
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
