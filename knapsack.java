import java.util.HashMap;

class Knapsack{
    public static void main(String [] args){
        int weight []= {1, 2,  3,  8,  7, 4 };
        int value []= {20, 5, 10, 40, 15, 25};
        int W = 10;
        Main m = new Main();
       int result =  m.topDownknapsackUtil(weight,value,W); 
       int result2 = m.bottomUpknapsack(weight,value,W);
       System.out.println(result);
        System.out.println(result2);

    }

    private int bottomUpknapsack(int[] weight, int[] value, int w) {
        int cache[][] = new int[value.length+1][w+1];
        /* initializing first row and column zero as with 0 weight nothing is possoble and also with 0 values we can't make any weight.*/
        for(int i=0;i<=w;i++) {
            cache[0][i] = 0;
        }
        for(int i=0;i<=value.length;i++)
            cache[i][0]=0;
            /* for each value we pick the weight if it's value is greater than it's previous.
            we have two possobilities.
            either we pick a weight and add its value and then separate current value weight from remaning weight or we omit current weight.
            */
     for(int i=1;i<cache.length;i++){
         for(int j=1;j<cache[i].length;j++){
             if(j-weight[i-1]>=0)
               cache[i][j]=Math.max(value[i-1]+cache[i-1][j-weight[i-1]], cache[i-1][j]);
             else
                 cache[i][j]=cache[i-1][j];
         }
     }
  return cache[value.length][w];
    }

    public int topDownknapsackUtil(int[] weight, int[] value, int w) {
        HashMap<String,Integer>map = new HashMap<>();
       return  topDownknapsack(weight,value,value.length-1,w,map);

    }

    int topDownknapsack(int[] weight, int[] value, int v,int w, HashMap<String, Integer> map) {
        String key = v + "|" + w;
        if(w<0)
            return Integer.MIN_VALUE;
        if(v<0 || w==0)   // base case
            return 0;
        if(!map.containsKey(key))
        {
            int include = value[v] + topDownknapsack(weight,value,v-1,w-weight[v],map);
            int exclude = topDownknapsack(weight,value,v-1,w,map);
            map.put(key,Math.max(include,exclude));
        }
        return map.get(key);

    }
}
/*
time complexity: both bottom up and top down have time complexities have O(vw) time complexity.
where v is value length and w is weight capacity.
top down approach has O(vw) time complexity as for each value v it runs w times.
space complexity: bottom up have O(vw) space for 2d array.
topdown uses hashmap.
*/
