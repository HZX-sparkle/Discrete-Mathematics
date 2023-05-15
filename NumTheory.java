import java.util.*;
import java.lang.Math;
public class NumTheory {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a and b: ");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("The gcd of a and b is " + gcd(57, 13));
		System.out.println("The bezout's coefficients of a and b are " + bez(57, 13)[0] + "," + bez(57, 13)[1]);
		CRT();
		char[] cipher = RSA.encry("Hello world!");
		System.out.println("Encrypted Message: " + String.valueOf(cipher));
		char[] M = RSA.decry(String.valueOf(cipher));
		System.out.println("Decrypted Message: " + String.valueOf(M));
	}
	//Euclid's Algorithm
	public static int gcd(int a, int b) {
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}//ensure that a>b
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}//gcd(a,b)=gcd(b,a mod b)
		return a;
	}
	//Bezout's Theorem
	public static int[] bez(int a, int m) {
		int[] s = new int[100];
		int[] t = new int[100];
		//a=s[0]a+t[0]m, m=s[1]a+t[1]m
		s[0] = 1;
		s[1] = 0;
		t[0] = 0;
		t[1] = 1;
		int r, q, cnt;
		for (cnt = 0; m != 0 ; cnt++ ) {
			r = a % m;
			q = a / m; //a=qm+r, so r=a-qm
			s[cnt + 2] = s[cnt] - q * s[cnt + 1];
			t[cnt + 2] = t[cnt] - q * t[cnt + 1];
			a = m;
			m = r;
		}
		int[] ret = new int[] {s[cnt], t[cnt]};
		return ret;
	}
	//Chinese Reminder Theorem
	public static void CRT() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the number of linear congruence equations:");
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] m = new int[n];
		System.out.println("Please input the a and m of each equation:");
		//form a[i], m[i] and m
		//m[i] should be pairwise relatively prime!!!
		int mp = 1;
		int x = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			m[i] = sc.nextInt();
			mp *= m[i];
		}
		for (int i = 0; i < n ; i++ ) {
			int M = mp / m[i];
			int y = bez(M, m[i])[0]; //M[i]*y[i]=1(mod m[i]), inverse of M[i] module m[i]
			x += a[i] * M * y;
		}
		System.out.printf("x = %d (mod %d)\n", x, mp);
	}
	//RSA
	public class RSA {
		//generate PU and PR
		private static int p = 17;
		private static int q = 11;
		static int n = q * p;
		private static int f = (p - 1) * (q - 1);
		static int e = 7;
		private static int d = bez(e, f)[0];
		//PU=(e,n),PR=(d,n)
		//Encryption
		private static char[] encry(String M) {
			char[] cipher = M.toCharArray();
			for (int i = 0; i < M.length(); i++) {
				int r = 1;
				for (int j = 0; j < e; j++) {
					r *= cipher[i];
					if (r > n) r = (r % n);
				}
				cipher[i] = (char)(r % n);
			}
			return cipher;
		}
		//Decryption
		private static char[] decry(String cipher) {
			char[] M = cipher.toCharArray();
			for (int i = 0; i < M.length ; i++ ) {
				int r = 1;
				for (int j = 0; j < d; j++) {
					r *= M[i];
					if (r > n) r = (r % n);
				}
				M[i] = (char)(r % n);
			}
			return M;
		}
	}
}