package chapter05;

// given an array of integers, reorder entries so that even numbers appear first

import java.util.Arrays;

public class epi_05_bootcamp {

    // Runetime O(n), Space O(1)
    public static void evensToFrontVersion1(int[] A) {
        int n = A.length, i = 0, j = n-1;
        while (i < j) {
            if (A[i] % 2 == 0) {
                i++;
            }
            else {
                swap(A, i, j);
                j--;
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;    
    }

    // Runtime O(n), Space O(n)
    public static int[] evensToFrontVersion2(int[] A) {
        int n = A.length, i = 0, j = n-1;
        int[] B = new int[n];
        for (int k = 0; k < n; k++) {
            if (A[k] % 2 == 0) {
                B[i] = A[k];
                i++;
            } else { 
                B[j] = A[k];
                j--;
            }
        }
        return B;
    }

    public static void evensToFront(int[] A) {
        int n = A.length;
        int[] A_v1 = Arrays.copyOf(A, n);
        int[] A_v2 = Arrays.copyOf(A, n);
        evensToFrontVersion1(A_v1);
        int[] B = evensToFrontVersion2(A_v2);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(A_v1));
        System.out.println(Arrays.toString(B)); 
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 8, 5, 4, 20, 3, 4, 73};
        evensToFront(arr); 
    }

}
