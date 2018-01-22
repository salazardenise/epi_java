package chapter05;

/*
 * Program takes an array of integers and find the length
 * of the longest subarray all of whose entries are equal.
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_06_variant1 {

    public static int getLongestSubarrayLength(List<Integer> A) {
	int longestLength = 0, i = 0;
	while (i < A.size() - 1) {
	    if (A.get(i) == A.get(i+1)) {
		int len = 1;
		int j = i;
		while (j < A.size() - 1 && A.get(j) == A.get(j+1)) {
		    len++;
		    j++;
		}
		if (len > longestLength) longestLength = len;
		i = j + 1;
	    } else {
		i++;
	    }
        }
	return longestLength;
    }

    public static void main(String[] args) {
	List<Integer> list = Arrays.asList(new Integer[] {1, 2, 2, 3, 3, 3, 3, 4, 8, 3, 9, 9, 9, 9, 9, 2});
	int longestLength = getLongestSubarrayLength(list);
	System.out.println("original list:\n" + list);
	System.out.println("longest subarray length: " + longestLength);
    }

}
