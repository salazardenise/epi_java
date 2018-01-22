package chapter05;
/*
 * Program computes the max profut that can be made by
 * buying and selling a share at most twice
 * the second buy must be made on another data after the frist sell
 */


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_07 {

    public static int getMaxProfitBuySellTwice(List<Integer> A) {
        // forward pass, find max profit if we sell on a particular day and record
	int minPrice = Integer.MAX_VALUE, maxDiff = 0;
	List<Integer> maxProfitBySellDay = new ArrayList<Integer>();
	for (int i = 0; i < A.size(); i++) {
	    minPrice = Math.min(minPrice, A.get(i));
	    maxDiff = Math.max(maxDiff, A.get(i) - minPrice);
	    maxProfitBySellDay.add(maxDiff);
        }
	maxProfitBySellDay.add(0, 0);
	// backward pass, find max profit if we buy on a particular day
	int maxPrice = Integer.MIN_VALUE;
	maxDiff = 0;
	List<Integer> maxProfitByBuyDay = new ArrayList<Integer>();
	for (int i = A.size() - 1; i >= 0; i--) {
	    maxPrice = Math.max(maxPrice, A.get(i));
	    maxDiff = Math.max(maxDiff, maxPrice - A.get(i));
	    maxProfitByBuyDay.add(0, maxDiff);
	}
	// combine forward and backward passes to find maxProfit total
        List<Integer> maxProfitByDay = new ArrayList<Integer>();
	int maxTotal = 0;
	for (int i = 0; i < A.size(); i++) {
	    maxProfitByDay.add(i, maxProfitBySellDay.get(i) + maxProfitByBuyDay.get(i));
	    maxTotal = Math.max(maxTotal, maxProfitByDay.get(i));
        }
	return maxTotal;
    }


    public static void main(String[] args) {
	List<Integer> A = Arrays.asList(new Integer[] {310, 315, 275, 295, 260, 270, 290, 230, 255, 250});
        System.out.println(A);
	System.out.println("max profit: " + getMaxProfitBuySellTwice(A));
	System.out.println("answer: 55");
	List<Integer> B = Arrays.asList(new Integer[] {12, 11, 13, 9, 12, 8, 14, 13, 15});
        System.out.println(B);
	System.out.println("max profit: " + getMaxProfitBuySellTwice(B));
	System.out.println("answer: 10");
    }

}
