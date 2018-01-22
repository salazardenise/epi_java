package chapter05;

/*
 * Program takes an array of n integers
 * where A[i] denotes the max you can advance from index i
 * Program returns whether it is possible to advance to the last index
 * starting rom the beginning of the array
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_04 {

    public static boolean canReachEnd(List<Integer> A) {
	int furthestSoFar = 0, lastIndex = A.size()-1;
	for (int i = 0; i <= furthestSoFar && furthestSoFar < lastIndex; i++) {
	    furthestSoFar = Math.max(furthestSoFar, i + A.get(i));
        }
	return (furthestSoFar >= lastIndex);
    }

    public static int getMinSteps(List<Integer> A) {
	int furthestSoFar = 0, n = A.size(), lastIndex = A.size()-1;
	List<Integer> maxSoFars = new ArrayList<Integer>();
	for (int i = 0; i < n; i++) {
	    furthestSoFar = Math.max(furthestSoFar, i + A.get(i));
	    maxSoFars.add(furthestSoFar);
        }
	if (furthestSoFar < lastIndex) return -1;
	int count = 0;
	for (int i = maxSoFars.size() - 1; i-1 >= 0; i--) {
            if (maxSoFars.get(i) != maxSoFars.get(i-1)) count++;
        }
	return count;
    }

    public static void main(String[] args) {
	List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 3, 1, 0, 2, 0, 1}));
	System.out.println(list1 + " : " + canReachEnd(list1));
        System.out.println("minimum number of steps to reach end: " + getMinSteps(list1));

	List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 2, 0, 0, 2, 0, 1}));
	System.out.println(list2 + " : " + canReachEnd(list2));

	List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 1, 0, 1, 5, 1, 0, 0, 2, 0, 2, 3, 1, 4, 0, 0, 0, 1}));
	System.out.println(list3 + " : " + canReachEnd(list3));
        System.out.println("minimum number of steps to reach end: " + getMinSteps(list3));
    }

}
