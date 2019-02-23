import java.util.*;

import java.io.*;
import java.math.*;

public class IcyPerimeter {
//	static class obj {
//		int area;
//		int perimeter;
//
//		obj(int a, int p) {
//			area = a;
//			perimeter = p;
//		}
//
//	}

	static int n;
	static String[][] machine;
	static boolean[][] visited;
	static String hashtag;
	static int count;
	static int peri;
	static String dot;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// FileReader in_file = new FileReader("perimeter.in");
		// BufferedReader buff_in = new BufferedReader(in_file);
		// FileWriter out_file = new FileWriter("perimeter.out");
		// BufferedWriter buff_out = new BufferedWriter(out_file);
		// PrintWriter output = new PrintWriter(buff_out);
		Scanner sc = new Scanner(new File("perimeter.in"));
		PrintWriter out = new PrintWriter(new FileWriter("perimeter.out"));
		n = sc.nextInt();
		// StringTokenizer st = new StringTokenizer(buff_in.readLine());
		// int n = Integer.parseInt(st.nextToken());

		machine = new String[n][n];
		visited = new boolean[n][n];

		for (int r = 0; r < n; r++) {
			String str = sc.next();
			System.out.println(str);
			for (int c = 0; c < n; c++) {
				// System.out.println(str);
				String x = str.substring(c, c + 1);
				machine[r][c] = x;
			}
		}
		hashtag = "#";
		dot = ".";
		int max = Integer.MIN_VALUE;
		int maxPeri = 0;
		//obj maxIceCream = new obj(max, 0);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (machine[r][c].equals(hashtag) && visited[r][c] == false) {
					System.out.println("Row:" + r + " Col:" + c);
					dfs(r, c);
				}
				if (count > max) {
					//maxIceCream = new obj(count, peri);
					max = count;
					maxPeri = peri;

				} else if (count == max) {
					if (peri > maxPeri) {
						maxPeri = peri;
					}
				}
				count = 0;
				peri = 0;
			}
		}
		System.out.println(max + " " + maxPeri );
		out.print(max + " " + maxPeri );
		out.close();

	}

	public static void dfs(int currRow, int currCol) {
		// System.out.println("Row:" + currRow + " Col:" + currCol);
		if (currRow < 0 || currRow == n ) {
			return;
		}
		if (currCol < 0 || currCol == n) {
			return;
		}
		String curr = machine[currRow][currCol];
		boolean currVisited = visited[currRow][currCol];
		int RM1 = currRow - 1;
		int RA1 = currRow + 1;
		int CM1 = currCol - 1;
		int CA1 = currCol + 1;
		if (!curr.equals(hashtag)) {
			return;
		}
		if (currVisited == true) {
			return;
		} else if (currVisited == false) {
			visited[currRow][currCol] = true;
		}
		if (curr.equals(hashtag)) {
			count++;

			if (RM1 < 0 || machine[RM1][currCol].equals(dot)) {
				peri++;
			}
			if (RA1 >= n || machine[RA1][currCol].equals(dot)) {
				peri++;
			}
			if (CM1 < 0 || machine[currRow][CM1].equals(dot)) {
				peri++;
			}
			if (CA1 >= n || machine[currRow][CA1].equals(dot)) {
				peri++;
			}

		}
		dfs(RM1, currCol);
		dfs(RA1, currCol);
		dfs(currRow, CM1);
		dfs(currRow, CA1);
	}

}