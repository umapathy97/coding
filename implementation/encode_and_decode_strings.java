/*

Description
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Example
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
*/






// SOLUTION

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder cur = new StringBuilder();
        for (String s : strs) {
            cur.append(s.length());
            cur.append("#");
            cur.append(s);
        }

        return cur.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        int i = 0;
        int j = i;
        List<String> result = new ArrayList<>();
        while (i < str.length()) {
            while (i < str.length() && Character.isDigit(str.charAt(i)))
              i++;
              Integer num = Integer.parseInt(str.substring(j, i));
              i++;
              result.add(str.substring(i, i + num));
              i = i + num;
              j=i;
        }

        return result;
    }
}






/*


lint4code4love4you3



*/
