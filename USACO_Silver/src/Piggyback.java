import java.io.*;
import java.math.*;
import java.util.*;

public class Piggyback {
	static int b, e, p, n, m;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("piggyback.in"));
		PrintWriter out = new PrintWriter(new FileWriter("piggyback.out"));
		b = sc.nextInt();
		e = sc.nextInt();
		p = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= m; i++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			adj[p1].add(p2);
			adj[p2].add(p1);
		}
		for (int i = 1; i <= m; i++) {
			System.out.println(i + "->" + adj[i]);
		}
		int[] d1 = new int[n + 1];
		int[] d2 = new int[n + 1];
		int[] dn = new int[n + 1];

		bfsFrom(1, d1);
		bfsFrom(2, d2);
		bfsFrom(n, dn);
		int min = Integer.MAX_VALUE;
		for (int mp = 1; mp <= n; mp++) {
			min = Math.min(min, d1[mp] * b + d2[mp] * e
					+ dn[mp] * p);
		}
		out.print(min);
		out.close();

	}

	public static void bfsFrom(int from, int distance[]) {
		Arrays.fill(distance, -1);
		LinkedList<Integer> l = new LinkedList<>();
		distance[from] = 0;
		l.add(from);
		while (!l.isEmpty()) {
			int curr = l.remove();
			for (int c : adj[curr]) {
				if (distance[c] == -1) {
					l.add(c);
					distance[c] = distance[curr] + 1;		
				}

			}
		}
	}

}
