import java.util.*;
import java.io.*;
import java.math.*;

public class EscapingTheFarm {
	static int maxCount;
	static void solve (int t) throws FileNotFoundException, IOException{
		
		Scanner sc = new Scanner(new File(DIRNAME + t + ".in"));
		PrintWriter out = new PrintWriter(new FileWriter(DIRNAME + "my_" + t + ".out"));
		int numCows = sc.nextInt();
		ArrayList<Integer> cowWeights = new ArrayList<>();
		for (int i = 0; i < numCows; i++) {
			cowWeights.add(sc.nextInt());
		}
		System.out.println(cowWeights);
		maxCount = 0;

	}
	public static void assign (int numCows, int startTime, int endTime)
	{
		if (numCows > sta)
	}
	public boolean hasCarry(int x, int y) {
		for (; x > 0 && y > 0; x /= 10, y /= 10) {
			if (x % 10 + y % 10 >= 10) {
				return true;
			}
		}
		return false;

	}
	static String DIRNAME = "escape_bronze_dec11";
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		for (int f = 1; f <= 10; f++) {
			System.out.print("Test # " + f + " \t" + "....");
			long lStartTime = System.currentTimeMillis();
			solve(f);
			long lEndTime = System.currentTimeMillis();
			long time = lEndTime - lStartTime;
			System.out.print("Took " + time + " milliseconds...." + "\t");
			compare(f);
		}
	}

	static void compare(int t) throws FileNotFoundException, IOException {
		BufferedReader f1 = new BufferedReader(new FileReader(DIRNAME + t + ".out"));
		BufferedReader f2 = new BufferedReader(new FileReader(DIRNAME + "my_" + t + ".out"));
		String c = f1.readLine();
		String m = f2.readLine();
		if (c.equals(m)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
			System.out.println("Expected result: " + c + ", your result: " + m + "\n");
		}
	}

	
}
