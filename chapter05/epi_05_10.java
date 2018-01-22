package chapter05;

/*
 * Given an array A of n elements and a permutation array P,
 * apply P to A.
 * For example, P = <2, 0, 1, 3> applied to A = <a, b, c, d>,
 * results in a new A = <b, c, a, d>
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class epi_05_10 {

    // Runtime O(n), Space O(n)
    public static List<Integer> permute(List<Integer> A, List<Integer> P) {
        int n = A.size();
	if (n != P.size()) {
	    System.out.println("ERROR: A and P must have the same size");
	    return null;
	}
	if (!isPermutationFormat(P)) {
	    System.out.println("ERROR: P is not of the correct format");
	    return null;
	}
	List<Integer> B = new ArrayList<Integer>(Collections.nCopies(n, 0));
	for (int i = 0; i < n; i++) {
	    int new_i = P.get(i);
	    B.set(new_i, A.get(i));
	}
	return B;
    }

    // Runtime O(nlogn), Space(n)
    private static boolean isPermutationFormat(List<Integer> P) {
	List<Integer> Pcopy = new ArrayList<Integer>(P);
	Collections.sort(Pcopy);
	for (int i = 0; i < Pcopy.size(); i++) {
	    if (i != Pcopy.get(i)) return false;
	}
	return true;
    }

    public static void main(String[] args) {
	List<Integer> A = Arrays.asList(new Integer[] {5, 6, 7, 8, 9, 10});
	List<Integer> P = Arrays.asList(new Integer[] {1, 3, 5, 2, 4, 0});
	System.out.println("A:\n" + A);
	System.out.println("P:\n" + P);
	List<Integer> Ap = permute(A, P);
	System.out.println("new A:\n" + Ap);
	
    }

}
