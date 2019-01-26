import java.io.*;
import java.util.*;
import java.math.*;

public class PairedUp {
	static class Group implements Comparable<Group> {
		int numCows;
		int time;

		public Group(int num, int t) {
			numCows = num;
			time = t;

		}

		public int compareTo(Group other) {
			return time - other.time;
		}

		public String toString() {
			return "Number of Cows: " + numCows + " Time: " + time;
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("pairup.in"));
		PrintWriter out = new PrintWriter(new FileWriter("pairup.out"));
		int N = sc.nextInt();
		ArrayList<Group> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int numCows = sc.nextInt();
			int time = sc.nextInt();
			Group cowGroup = new Group(numCows, time);
			arr.add(cowGroup);
		}
		Collections.sort(arr);
		for (Group g : arr) {
			System.out.println(g);
		}
		int low = 0;
		int high = arr.size() - 1;
		System.out.println(high);
		int minTime = 0;

		while (low != high) {
			minTime = Math.max(arr.get(high).time + arr.get(low).time, minTime);

			int pairSame = Math.min(arr.get(low).numCows, arr.get(high).numCows);
			if (arr.get(low).numCows < arr.get(high).numCows) {
				arr.get(high).numCows -= pairSame;
				low++;
			} else if (arr.get(high).numCows < arr.get(low).numCows) {
				arr.get(low).numCows -= pairSame;
				high--;

			} else { // both high and low
				low++;
				high--;
			}

		}
		out.print(minTime);
		out.close();
	}

}
