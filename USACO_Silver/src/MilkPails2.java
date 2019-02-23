import java.util.*;
import java.io.*;
import java.math.*;

public class MilkPails2 {
	static class State {
		int op, x, y;

		State(int o, int left, int right) {
			op = o;
			x = left;
			y = right;
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("pails.in"));
		PrintWriter out = new PrintWriter(new FileWriter("pails.out"));
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		int min = Integer.MAX_VALUE;
		LinkedList<State> q = new LinkedList<>();
		State s = new State(0, 0, 0);
		q.add(s);
		boolean[][] visited = new boolean[x + 1][y + 1];
		while (!q.isEmpty()) {
			State curr = q.remove();
			if (!visited[curr.x][curr.y]) {
				visited[curr.x][curr.y] = true;
				min = Math.min(min, Math.abs(m - (curr.x + curr.y)));
				if (curr.op < k) {
					q.add(new State(curr.op + 1, 0, curr.y));
					q.add(new State(curr.op + 1, curr.x, 0));
					q.add(new State(curr.op + 1, x, curr.y));
					q.add(new State(curr.op + 1, curr.x, y));
					int x_y = Math.min(curr.x, y - curr.y);
					q.add(new State(curr.op + 1, curr.x - x_y, curr.y + x_y));
					int y_x = Math.min(x - curr.x, curr.y);
					q.add(new State(curr.op + 1, curr.x + y_x, curr.y - y_x));
				}
			}
		}
		out.print(min);
		out.close();

	}

}
