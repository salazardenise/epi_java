package chapter05;

/* Given a sorted array, this program updates it so that
 * all duplicates are removed and remaining elements are shifted left
 * to fill empty indicies
 * The number of valid elements is returned
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_05 {

    // Runtime O(n^2), space O(1)
    public static int removeDuplicates(List<Integer> A) {
	if (A.isEmpty()) {
	    return 0;
	}
	if (!isSorted(A)) {
	    System.out.println("ERROR: input array must be sorted");
	    return 0;
	}
	int n = A.size(), valids = 1;
	for (int i = 1; i < n && i <= valids; i++) {
	    if (A.get(i) == A.get(n-1)) {
		valids++;
		break;
	    }
	    if (A.get(i-1) == A.get(i)) {
		shiftLeft(A, i);
		i--;
	    } else {
		valids++;
	    }
        }
	return valids;
    }

    private static boolean isSorted(List<Integer> A) {
	for (int i = 0; i+1 < A.size(); i++) {
	    if (A.get(i) > A.get(i+1)) return false;
        }
	return true;
    }

    private static void shiftLeft(List<Integer> A, int i) {
	for (int j = i; j+1 < A.size(); j++) {
	    A.set(j, A.get(j+1));
        }
    }

    public static void main(String[] args) {
	List<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 3, 5, 5, 7, 11, 11, 11, 13}));
	System.out.println("original list:\n" + list);
	int valids = removeDuplicates(list);
	System.out.println("new list:\n" + list);
	System.out.println("number of valid elements: " + valids);
	System.out.println();    
	
	list = new ArrayList<Integer>(Arrays.asList(new Integer[] {-1, 0, 1, 3, 5, 8, 20}));
	System.out.println("original list:\n" + list);
	valids = removeDuplicates(list);
	System.out.println("new list:\n" + list);
	System.out.println("number of valid elements: " + valids);
	System.out.println();    
	
	list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 1, 1, 1, 2, 2, 2, 2,  2, 3, 3, 3, 3}));
	System.out.println("original list:\n" + list);
	valids = removeDuplicates(list);
	System.out.println("new list:\n" + list);
	System.out.println("number of valid elements: " + valids);
	System.out.println();    
    }

}
