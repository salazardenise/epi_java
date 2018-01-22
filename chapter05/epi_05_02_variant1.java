package chapter05;

// Take as inputs two strings s and t of bits encoding binary numbers Bs & Bt
// Return a new string of bits representing Bs+Bt

public class epi_05_02_variant1 {

    public static String addStringBitsVersion1(String s, String t) {
        // ensure s and t have equal lengths
        int sLength = s.length(), tLength = t.length();
        if (sLength < tLength) {
	    for (int i = 0; i < tLength - sLength; i++) {
		s = '0' + s;
	    }
    	}
	else if (sLength > tLength) {
	    for (int i = 0; i < sLength - tLength; i++) {
		t = '0' + t;
	    }
    	}
        int len = s.length();	
        
        // initialize result and carry
        String result = "";
	int carry = 0;
        
        // add bits
	for (int i = len - 1; i >= 0; i--) {
            int sBit = s.charAt(i) - '0';
	    int tBit = t.charAt(i) - '0';
            int sum = (sBit ^ tBit ^ carry) + '0';
	    result = (char) sum + result;
            carry = (sBit & tBit) | (sBit & carry) | (tBit & carry);
        }

        // account for leftover carry
        if (carry == 1) {
	    result = '1' + result;
	}
	return result;
    }

    // simple version2 susceptible to overflow
    public static String addStringBitsVersion2(String s, String t) {
        int st = Integer.parseInt(s, 2) + Integer.parseInt(t, 2);
        return Integer.toBinaryString(st);
    }

    public static void main(String[] args) {
        String s = "1001", t = "1111";
        System.out.println(s + " + " + t + " = " + addStringBitsVersion1(s, t));
        System.out.println(s + " + " + t + " = " + addStringBitsVersion2(s, t));
        s = "10";
	t = "10001110110";
        System.out.println(s + " + " + t + " = " + addStringBitsVersion1(s, t));
        System.out.println(s + " + " + t + " = " + addStringBitsVersion2(s, t));
    }
}
