     class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficiency =0;
        int start =0;
        int sum=0;
        for(int i=0;i<gas.length;i++){
            sum = sum+ gas[i]-cost[i];
                if (sum<0){
                 start=i+1;
                    deficiency+=sum ;
                    sum=0;
                }
                
        } 
        return (sum+deficiency>=0)?start:-1;
    }
}

/*
refer:  https://www.youtube.com/watch?v=nTKdYm_5-ZY
Time Complexity : o(n)
Space Complexity : o(1)
beats 💯 space && time
*/
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
