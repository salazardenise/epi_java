package chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class epi_05_03 {

    public static List<Integer> multiplyNums(List<Integer> A, List<Integer> B) {
	int signed = (A.get(0) < 0 | B.get(0) < 0) ? -1 : 1;     
	A.set(0, Math.abs(A.get(0)));
	B.set(0, Math.abs(B.get(0)));

	List<Integer> C = new ArrayList<Integer>(Collections.nCopies(A.size()+B.size(), 0));
	for (int i = A.size() - 1; i >= 0; i--) {
	    for (int j = B.size() - 1; j >= 0; j--) {
		int product = A.get(i) * B.get(j);
		C.set(i+j+1, C.get(i+j+1) + product);
		int carry = C.get(i+j+1) / 10;
		C.set(i+j, C.get(i+j) + carry);
		C.set(i+j+1, C.get(i+j+1) % 10);
            }
        }
	// remove leading zeros
	int k = 0;
	while (C.get(k) == 0) {
	    k++;
	}
	C = C.subList(k, C.size());
	if (C.isEmpty()) return new ArrayList<>();
	if (signed == -1) C.set(0, C.get(0)*signed);
	return C;
    }

    public static void main(String[] args) {
	List<Integer> x = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3}));
	List<Integer> y = new ArrayList<Integer>(Arrays.asList(new Integer[] {-9, 2}));
	List<Integer> product = multiplyNums(x, y);
        System.out.println(x + " x " + y + " = " + product);	
    }

}
