import java.util.*;
import java.io.*;
import java.math.*;

public class Photo {
	static class pair implements Comparable<pair> {
		int low;
		int high;

		pair(int l, int h) {
			low = l;
			high = h;
		}

		@Override
		public int compareTo(pair other) {
			if (low > other.low) {
				return -1;
			} else if (low < other.low) {
				return 1;
			}
			return 0;
		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("photo.in"));
		PrintWriter out = new PrintWriter(new FileWriter("photo.out"));
		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayList<pair> enemyPairs = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			pair aPair = new pair(Math.min(c1, c2), Math.max(c1, c2));
			enemyPairs.add(aPair);

		}
		Collections.sort(enemyPairs);
		//System.out.println(enemyPairs);
		TreeSet<Integer> photos = new TreeSet<>();
		photos.add(1);
		for (pair enemy : enemyPairs) {
			int high = photos.floor((int) enemy.high);
			int low = photos.floor(enemy.low);
			if (high == low) {
				photos.add(enemy.low + 1);
			}

		}
		out.print(photos.size());
		out.close();

	}

}
