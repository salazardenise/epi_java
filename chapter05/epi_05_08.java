package chapter05;

/*
 * Program takes an array A of n integers and rearranes A's elements to get a new array B
 * having the property that B[0] <= B[1] >= B[2] <= <[3] >= B[4] <= ...
 */

import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_08 {
    
    public static List<Integer> rearrange(List<Integer> A) {
	Collections.sort(A);
	List<Integer> B = new ArrayList<Integer>();
	int i = 0, j = A.size() - 1;
	boolean left = true;
	while (i < j) {
	    if (left) {
		B.add(A.get(i));
	        i++;
		left = false;
	    } else {
		B.add(A.get(j));
		j--;
		left = true;
	    }
        }
	return B;
    }

    public static void main(String[] args) {
	List<Integer> A = Arrays.asList(new Integer[] {0, 1, 4, 3, 8, -1, 8, 5, 9, -2, 2, 2});
	List<Integer> B = rearrange(A);
	System.out.println("original list:\n" + A);
	System.out.println("new list:\n" + B);	
    }
}
