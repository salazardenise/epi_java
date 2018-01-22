package chapter05;

/*
 * Program takes in an array denoting daily stock prices
 * and returns the max profit that could be made by
 * buying and then selling one share of stock
 * There is no need to buy if no profit is possible
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_06 {

    // Runtime O(n), Space O(1)
    public static int getMaxProfitVersion1(List<Integer> A) {
	int min = Integer.MAX_VALUE;
	int maxDiff = 0;
	for (int i = 0; i < A.size(); i++) {
	    maxDiff = Math.max(maxDiff, A.get(i) - min);
	    min = Math.min(min, A.get(i));
	}
	return maxDiff;
    }

    // Runtime O(n^2), Space O(1)
    public static int getMaxProfitVersion2(List<Integer> A) {
	int maxDiff = 0;
	for (int i = A.size()-1; i >= 0; i--) {
	    for (int j = 0; j < i; j++) {
		int diff = A.get(i) - A.get(j);
		if (diff > maxDiff) maxDiff = diff;
            }
        }
	return maxDiff;
    }

    public static void main(String[] args) {
	List<Integer> prices = Arrays.asList(new Integer[] {310, 315, 275, 295, 260, 270, 290, 230, 255, 250});
	int maxProfit_v1 = getMaxProfitVersion1(prices);
	int maxProfit_v2 = getMaxProfitVersion2(prices);
	System.out.println("stock prices:\n" + prices);
	if (maxProfit_v1 == maxProfit_v2) {
	    System.out.println("max profit: " + maxProfit_v1);
	} else {
	    System.out.println("max profit: " + maxProfit_v1 + " : " + maxProfit_v2);
	}
    }

}
