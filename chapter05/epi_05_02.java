package chapter05;

// Given an array of digits encoding a non-negative integer D
// Update the array to represent the integer D+1
// Input is assumed to be non-negative

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class epi_05_02 {

    public static List<Integer> plusOne(List<Integer> A) {
	if (A.get(0) < 0) {
	    System.out.println("ERROR: input must represent a non-negative integer");
	    return null;
	}
        int i = A.size() - 1;
        A.set(i, A.get(i) + 1);
        while (i > 0 && A.get(i) == 10) {
            A.set(i, 0);
	    A.set(i-1, A.get(i-1)+1);
            i--;
        }
        List<Integer> B = new ArrayList<>(A);
        if (B.get(0) == 10) {
            B.set(0, 0);
	    B.add(0, 1);
        }
	return B;
    }

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(new Integer[] {1, 2, 9});
	System.out.println(num + " + 1 = " + plusOne(num));
        num = Arrays.asList(new Integer[]{9, 9, 9});
	System.out.println(num + " +  1 = " + plusOne(num));
        num = Arrays.asList(new Integer[]{1, 0, 3, 2, 4, 5, 3});
	System.out.println(num + " +  1 = " + plusOne(num));
    }

}
