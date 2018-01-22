package chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class epi_05_01 {

    /*
     * Rearranges elements in List A around pivot A.get(pInd)
     * Runtime O(n), Space O(1)
     *
     * @param A a list of integers
     * @param pInd the index of the pivot that the elements will be rearranged around
     */
    public static void dutchFlagPartition(List<Integer> A, int pInd) {
	int l = 0, m = 0, r = A.size() - 1, pVal = A.get(pInd);
        while (m < r) {
	    if (A.get(m) < pVal) {
		Collections.swap(A, l, m);
                l++;
                m++;		
            } else if (A.get(m) == pVal) {
		m++;
	    } else { // (A.get(m) > pVal)
		Collections.swap(A, m, r);
		r--;
	    }
    	}
    }

    public static void main(String[] args) {
        Integer[] arr1 = {-3, 4, 1, 3, 1, -1, 2, 1, 0, -5, 1};
        List<Integer> list1 = Arrays.asList(arr1);

        List<Integer> listA = new ArrayList<>(list1);
        int pInd = 0;
	System.out.println("original list: \n" + list1);
        dutchFlagPartition(listA, pInd);
	System.out.println("rearrange around " + list1.get(pInd) + ": \n" + listA); 
	
        List<Integer> listB = new ArrayList<>(list1);
        pInd = 4;
        dutchFlagPartition(listB, pInd);
	System.out.println("rearrange around " + list1.get(pInd) + ": \n" + listB);
    }

}
