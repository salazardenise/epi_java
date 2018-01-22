package chapter05;

/*
 * Assuming that the keys take one of three values, 
 * reorder the array so that all the objects with the same key appear together.
 * The order of the subarrays don't matter.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class epi_05_01_variant1 {

    public static void partitionByThree(List<Integer> A) {
	// determine the 3 values
	List<Integer> values = new ArrayList<Integer>();
	for (Integer a : A) {
	    if (!values.contains(a)) values.add(a);
    	}
        if (values.size() != 3) {
	    System.out.println("ERROR: input list must be composed of 3 possible values only");
	    return;
        }
        int l = 0, m = 0, r = A.size() - 1;
        while (m <= r) {
            if (A.get(m) == values.get(0)) {
                Collections.swap(A, l, m);
		l++;
		m++;
	    } else if (A.get(m) == values.get(1)) {
		m++;
	    } else { // (A.get(m) == values.get(2)) 
		Collections.swap(A, m, r);
 		r--;
	    }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
	list.add(1);
	list.add(3);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println("original list:\n" + list);
        partitionByThree(list);
        System.out.println("new list:\n" + list);
    }

}
