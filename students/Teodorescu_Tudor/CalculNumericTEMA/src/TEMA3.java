import java.util.Scanner;
public class TEMA3 {

	public static double max(double a, double b) {
		if (a > b)
			return a;
		return b;
	}

	public static double norm(double[] x, double[] y, int n) {
		double max = 0;
		for (int i = 0; i < n; i++) {
			max = max(max, Math.abs(x[i] - y[i]));
		}
		return max;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double a[][] = new double[n][n];
		int k = 1, kmax = n;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextDouble();
			}
		double y[] = new double[n];
		double x[] = new double[n];
		for (int i = 0; i < n; i++)
			x[i] = 0;
		double b[] = new double[n];
		for (int i = 0; i < n; i++)
			b[i] = sc.nextDouble();
		double ep = 1/(1000);
		double nor;

		do {

			for (int i = 0; i < n; i++) {
				double c = 0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						c = c + a[i][j] * x[j];
					}
				}
				y[i] = (1 / a[i][i]) * (b[i] - c);
			}
			k++;

			nor = norm(x, y, n);
			for (int i = 0; i < n; i++) {
				x[i] = y[i];
			}

		} while ((nor >= ep) && (k < kmax));

		for (int i = 0; i < n; i++)
			System.out.println(x[i] + " ");
	}
}