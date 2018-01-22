package chapter05;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class epi_05_01_variant2 {

    public static void partitionByFour(List<Integer> A) {
	List<Integer> values = new ArrayList<Integer>();
	for (Integer a : A) {
	    if (!values.contains(a)) values.add(a);
        }
	if (values.size() != 4) {
	    System.out.println("ERROR: input list must be composed of 4 possible values only");
	    return;
        }
	int l = 0, m1 = 0, r = A.size() -1;
	while (m1 <= r) {
	    if (A.get(m1) == values.get(0)) {
 		Collections.swap(A, l, m1);
		l++;
		m1++;	
	    } else if (A.get(m1) == values.get(1)) {
		m1++;
	    } else { // (A.get(m1) == values.get(2) || A.get(m1) == values.get(3))
		Collections.swap(A, m1, r);
		r--;
	    }
        }
	int m2 = m1;
	r = A.size() - 1;
	while (m2 <= r) {
	    if (A.get(m2) == values.get(2)) {
		m2++;
	    } else { // (A.get(m2) == values.get(3)) {
		Collections.swap(A, m2, r);
		r--;
            }
	}
    }

    public static void main(String[] args) {
	List<Integer> list = new ArrayList<Integer>();
	list.add(1);
	list.add(4);
	list.add(2);
	list.add(2);
	list.add(4);
	list.add(1);
	list.add(3);
	list.add(1);
	list.add(3);
	list.add(4);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(4);
	list.add(4);
	list.add(1);
	list.add(2);
	list.add(2);
	System.out.println("original list:\n" + list);
	partitionByFour(list);
	System.out.println("new list:\n" + list);
    }
}
