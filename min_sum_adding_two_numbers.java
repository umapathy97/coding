/*
Example 1 : Consider the following 3 activities sorted by
        by finish time.
        start[]  =  {10, 12, 20};
        finish[] =  {20, 25, 30};
        A person can perform at most two activities. The
        maximum set of activities that can be executed
        is {0, 2} [ These are indexes in start[] and
        finish[] ]

        Example 2 : Consider the following 6 activities
        sorted by by finish time.
        start[]  =  {1, 3, 0, 5, 8, 5};
        finish[] =  {2, 4, 6, 7, 9, 9};
        A person can perform at most four activities. The
        maximum set of activities that can be executed
        is {0, 1, 3, 4} [ These are indexes in start[] and  finish[] ]

*/




/*
Input: arr[] = {6, 8, 4, 5, 2, 3}
        Output: 604
        246 + 358 = 604
*/



public class Main {
    public static void main(String[] args){
        int nums[] = {9,8,3,5,3,5,1,2,3};
       int result =  minimum_sum(nums);
       System.out.println(result);


    }

    private static int minimum_sum(int[] nums) {
        int ans=0;
        int num1=0,num2=0;
        int frequency[] = new int[10];
        for(int i=0;i<nums.length;i++)    /
        int k=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<frequency[i];j++){
                nums[k++] = i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                num1=num1*10+nums[i];
            else
                num2=num2*10+nums[i];
        }
        ans = num1+num2;

        return ans;
    }

}

/*
time complexity: O(n) as we touching each elements once. we minimized from 0(nlogn) to O(n) by using frequency based sorting.
instead of normal sorting.
space complexity;O(1) as we maintain constant space.


