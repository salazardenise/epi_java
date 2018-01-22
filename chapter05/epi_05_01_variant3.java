package chapter05;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class epi_05_01_variant3 {

    public static void partitionBooleanList(List<Boolean> A) {
	int l = 0, r = A.size()-1;
	while (l < r) {
	    if (A.get(l) == false) {
		l++;	
	    } else {
		Collections.swap(A, l, r);
		r--;
	    }
	}
    }

    public static void main(String[] args) {
        List<Boolean> list = new ArrayList<Boolean>();
	list.add(true);
	list.add(false);
	list.add(false);
	list.add(true);
	list.add(true);
	list.add(false);
	list.add(false);
	list.add(false);
	list.add(true);
	System.out.println("original list:\n" + list);
	partitionBooleanList(list);
	System.out.println("new list:\n" + list);
    }

}
