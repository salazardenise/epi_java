package chapter05;

/*
 * Program returns all prime numbers between 1 and given integer.
 */

import java.util.List;
import java.util.ArrayList;

public class epi_05_09 {

    public static List<Integer> getPrimes(int num) {
        List<Integer> primes = new ArrayList<Integer>();
	for (int i = 2; i <= num; i++) {
	    if (isPrime(i)) primes.add(i);
	}
	return primes;
    }

    private static boolean isPrime(int num) {
	for (int i = (int) Math.sqrt(num); i >= 2; i--) {
	    if (num % i == 0) return false;
        }
	return true;
    }

    public static void main(String[] args) {
	System.out.println("Primes from 1 to 18: " + getPrimes(18));
    }

}
