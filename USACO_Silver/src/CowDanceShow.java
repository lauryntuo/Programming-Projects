import java.io.*;
import java.util.*;
import java.math.*;

public class CowDanceShow {

	static ArrayList<Integer> time;
	static int numCows;
	static int maxTime;

	static boolean canFinishInTimeLimit(int k) {
		int totalTime = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			q.add(time.get(i) + totalTime);

		}
		int next = k;
		while (!q.isEmpty()) {

			totalTime = q.remove();

			if (totalTime > maxTime) {
				return false;
			}
			if (next < numCows) {
				q.add(time.get(next) + totalTime);
				next++;
			}
		}
		return true;

	}

	public static void main(String[] args) throws IOException, FileNotFoundException {
		Scanner sc = new Scanner(new File("cowdance.in"));
		PrintWriter out = new PrintWriter(new FileWriter("cowdance.out"));
		numCows = sc.nextInt();
		maxTime = sc.nextInt();
		time = new ArrayList<>();
		for (int cowNum = 1; cowNum <= numCows; cowNum++) {
			time.add(sc.nextInt());

		}
		int K = 1;
		while (K <= numCows) {
			if (!canFinishInTimeLimit(K)) {
				K++;
			} else {
				break;
			}
		}
		out.print(K);
		out.close();
	}

}
