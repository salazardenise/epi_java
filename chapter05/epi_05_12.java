package chapter05;

/*
 * The input consists of an array of distinct elements and a size k.
 * Return a subset of the given size of array elements.
 * All subsets should be equally likely.
 * Return result in input array itself.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class epi_05_12 {

    public static void getSample(List<Integer> A, int k) {
	int n = A.size();
	Random rand = new Random();
	for (int i = 0; i < k; i++) {
	    int ind = i + rand.nextInt(n-i);
	    Collections.swap(A, i, ind);
	}
    }

    public static void main(String[] args) {
	List<Integer> A = new ArrayList<Integer>();
	A.add(3);
	A.add(7);
	A.add(5);
	A.add(11);
	System.out.println("original list:\n" + A);
	System.out.println("Random sample size desired: 3");
	getSample(A, 3);
	System.out.println("new list:\n" + A);
    }

}
