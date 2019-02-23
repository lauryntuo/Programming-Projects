import java.util.*;
import java.io.*;
import java.math.*;

public class MilkPails{
	static int X, Y, k, m;
	static int min;
	static boolean[][][] visited;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("pails.in"));
		PrintWriter out = new PrintWriter(new FileWriter("pails.out"));
		X = sc.nextInt();
		Y = sc.nextInt();
		k = sc.nextInt();
		m = sc.nextInt();

		min = Integer.MAX_VALUE;
		visited = new boolean[k + 1][X + 1][Y + 1];
		dfs(0, 0, 0);
		out.print(min);
		out.close();

	}

	static void dfs(int op, int x, int y) {
		if (op > k) {
			return;
		}

		if (visited[op][x][y]) {
			return;
		}

		if (Math.abs(m - (x + y)) < min) {
			min = Math.abs(m - (x + y));
		}
		visited[op][x][y] = true;
		dfs(op + 1, 0, y);
		dfs(op + 1, x, 0);
		dfs(op + 1, X, y);
		dfs(op + 1, x, Y);
		int x_y = Math.min(x, Y - y);
		dfs(op + 1, x - x_y, y + x_y);

		int y_x = Math.min(X - x, y);
		dfs(op + 1, x + y_x, y - y_x);

	}

}
