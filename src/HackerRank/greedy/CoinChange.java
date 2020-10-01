package HackerRank.greedy;

import java.util.Arrays;

/**
 * @author c59785a
 * Created on 2020-09-24 16:51
 **/
public class CoinChange {

    int coinChange(int [] coins, int total){
        int numCoins =0;

        int currTotal = total;

        Arrays.sort(coins);
        for (int i=coins.length; i>=0; i--){
            if(coins[i] < currTotal){
                int num = currTotal/coins[i];
                numCoins += num;
                currTotal = currTotal - coins[i]*num;
            }
        }
        if(currTotal >0){
            return -1;
        }

        return numCoins;
    }

}
