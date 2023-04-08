import java.util.Scanner;
import java.util.Arrays;

public class MatrixMul {
	public static void main(String[] args) {
		System.out.println("Welcome to Java!");
		Scanner input = new Scanner(System.in);

		int[][] a = matrixMake();
		int[][] b = matrixMake();

		int[][] c = matrixMul(a, b);

	}

	public static int[][] matrixMake() {
		System.out.println("Please type row and colume: ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] matrix = new int[m][n];
		System.out.println("the matrix: ");
		for (int i = 0; i < m ; i++ ) {
			for (int j = 0; j < n ; j++ ) {
				matrix[i][j] = sc.nextInt();
			}
		}

		return matrix;
	}

	public static int[][] matrixMul(int[][] a, int[][] b) {
		int m1 = a.length;
		int n1 = a[1].length;
		int m2 = b.length;
		int n2 = b[1].length;
		if (n1 != m2 || m1 != n2) {
			System.out.println("Matrixes cannot be multiplied. Please check and try again!");
			System.exit(0);
		}
		int[][] c = new int[m1][n2];

		for (int i = 0; i < m1; i++) {
			Arrays.fill(c[i], 0);
			for (int j = 0; j < n2; j++ ) {
				for (int k = 0; k < n1; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		// for (int[] element1 : c) {
		// 	for (int  element2 : element1) {
		// 		System.out.println(element2);
		// 	}
		// }
		return c;
	}
}