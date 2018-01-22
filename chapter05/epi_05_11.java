package chapter05;

/*
 * There exists n! permutations of n elements.
 * They can be ordered using the dictionary ordering.
 * Program takes in a permutation an returns the next permutation/
 */

import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_11 {

    public static List<Integer> getNextPermutation(List<Integer> P) {
	List<Integer> nextP = new ArrayList<Integer>(P);
	if (P.isEmpty() || P.size() == 1) return nextP;
	// first, find the largest index k such that P[k] < P[k+1]
	int k = P.size() - 2;
	while (k >= 0) {
	    if (P.get(k) < P.get(k+1)) break;
	    k--;
	}
	// second, find the largest index q such that P[k] < P[q]
	int q = P.size() - 1;
	while(q > k) {
	    if (P.get(k) < P.get(q)) break;
	    q--;
        }
	// third, swap values at k and q
	Collections.swap(nextP, k, q);
	// reverse the order of elements from index k+1 to n inclusive
	int i = k+1, j = nextP.size() - 1;
	while (i < j) {
	    Collections.swap(nextP, i++, j--);
	}
	return nextP;
    }

    public static void main(String[] args) {
	List<Integer> P = Arrays.asList(new Integer[] {6, 2, 1, 5, 4, 3, 0});
	List<Integer> nextP = getNextPermutation(P);
	System.out.println("orginal permutation:\n" + P);
	System.out.println("next permutation:\n" + nextP);
    }

}
