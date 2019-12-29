class Main{
    public static void main(String [] args){
        Main m = new Main();
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int result = m.topdownrodcutting(arr,arr.length);
        int result1= m.bottomuprodcutting(arr,arr.length);
        System.out.println(result);
        System.out.println(result1);
    }
/* 
building up a solution using cache
ex: for building length 4 we build from 0 to 3 considering each value and adding cache of prvious length. for length 4
we look arr[3]+cache[0] as cache[0] provides remaining length.
*/

    private int bottomuprodcutting(int[] arr, int n) {
        int[] cache = new int[n+1];
        cache[0]=0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                max = Math.max(max,arr[j]+cache[i-j-1]);
                cache[i]=max;
            }
        }
        return max;

    }

    int topdownrodcutting(int[] arr, int n){
        int[] cache = new int[n+1];
        return topdownrodcutting(arr,n,cache);
    }

     int topdownrodcutting(int[] arr, int n,int[] cache) {
        if(n<=0)
            return 0;
        if(cache[n]!=0)
            return cache[n];
        int max = Integer.MIN_VALUE;
       for(int i=1;i<=n;i++){
           max= Math.max(max,arr[i-1]+topdownrodcutting(arr,n-i,cache));
       }
       cache[n]= max;
        return cache[n];
    }
}
/*
time complexity:O(n^2)
space complexity:O(n)
