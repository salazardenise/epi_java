package chapter05;

/*
 * Program takes in an array and a key and updates the array
 * so that all occurrences of the key in the array are removed
 * and the remaining elements are shifted left to fill the empitied indicies
 * The number of valid elements is returned
 */

import java.util.List;
import java.util.ArrayList;

public class epi_05_05_variant1 {
    
    public static int removeKey(List<Integer> A, int key) {
	int writeIndex = 0;
	for (int i = 0; i < A.size(); i++) {
	    if (A.get(i) != key) {
		A.set(writeIndex, A.get(i));
		writeIndex++;
	    }
	}
	return writeIndex;
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
	list.add(2);
	list.add(3);
	list.add(5);
	list.add(3);
	list.add(7);
	list.add(5);
	list.add(9);
	list.add(3);
	int key = 3;
	System.out.println("original list:\n" + list);
	System.out.println("remove key: " + key);
	int valids = removeKey(list, key);
	System.out.println("new list:\n" + list);
	System.out.println("number of remaining valid elements: " + valids);
    }
}
