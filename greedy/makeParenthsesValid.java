QUES: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/submissions/
class Solution {
    public int minAddToMakeValid(String S) {
        int count=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
        // for each stack element push opposite element in stack.
            if(!stack.isEmpty()&& stack.peek()==S.charAt(i)){
                stack.pop();
                count--;
            }
            else{
                if(S.charAt(i)=='(')
                    stack.push(')');
                count++;
            }
        }
        return count;
    }
}
/*
time complexity:O(n)
space complexity:O(n)
beats 32% time and 5%space
*/

optimization:
class Solution {
    public int minAddToMakeValid(String S) {
        int count=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
            if(!stack.isEmpty()&& stack.peek()==S.charAt(i)){
                stack.pop();
                count--;
            }
            else{
                if(S.charAt(i)=='(')
                    stack.push(')');
                count++;
            }
        }
        return count;
    }
}
/*
time complexity:O(n)
space complexity:O(1)
beats 100% time.
*/
