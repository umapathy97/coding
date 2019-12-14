class Solution {
    public int maxProfit(int[] prices) {
        int previous_buy = 0;    // storing previous buy value
        int buy = Integer.MIN_VALUE; // storing current buy value
        int sell = 0; // current sell vslue
        int previous_sell = 0; // previous sell value
        for(int price:prices){
        /*three possibilities:
           buy
           sell
           no action
           */
            previous_buy = buy;     
            /* previous_sell stores previous profit, for buying we need to subtract current price from previous.or no action
               we can take previous buy value */
            buy = Math.max(previous_sell-price,previous_buy);
            previous_sell = sell;
            /* previous_buy + price gives current selling price , or for no action take previous_sell.  */
            sell = Math.max(previous_sell,previous_buy+price);
        }
        return sell;
    }
}

  
  
 /* 
  time complexity: o(n)
  space complexity: o(1)
  */
