class Solution {
    public String multiply(String num1, String num2) {
       int[] result=new int[num1.length()+num2.length()];
        StringBuilder re= new StringBuilder();
        for(int i=num1.length()-1;i>=0;i--){
               int res=0;
            for(int j=num2.length()-1;j>=0;j--){
                res=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                result[i+j+1]+=res;    
             }
        }
        int carry=0;
        int sum=0;
        for(int i=result.length-1;i>=0;i--){
            sum= carry+result[i];
            carry=sum/10;
            result[i]=sum%10;
        }
       for(int i=0;i<result.length;i++){
         re.append(result[i]);}
        while (re.length() != 0 && re.charAt(0) == '0') re.deleteCharAt(0);
        return re.length() == 0 ? "0" : re.toString();
    }
}
]
