import java.io.*;
import java.math.*;
import java.util.*;

public class MilkingOrder {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		FileReader in_file = new FileReader("milkorder.in");
		BufferedReader buff_in = new BufferedReader(in_file);
		FileWriter out_file = new FileWriter("milkorder.out");
		BufferedWriter buff_out = new BufferedWriter(out_file);
		PrintWriter output = new PrintWriter(buff_out);
		StringTokenizer st = new StringTokenizer(buff_in.readLine());

		int numCows = Integer.parseInt(st.nextToken());
		int hierarchyCows = Integer.parseInt(st.nextToken());
		int specificCows = Integer.parseInt(st.nextToken());

		ArrayList<Integer> cowArray = new ArrayList<>();

	
		for (int i = 0; i < numCows; i++) {
			cowArray.add(0);
		}

		st = new StringTokenizer(buff_in.readLine());
		ArrayList<Integer> hc = new ArrayList<>();
		for (int i = 0; i < hierarchyCows; i++) {
			hc.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < specificCows; i++) {
			st = new StringTokenizer(buff_in.readLine());
			int cowNumber = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			for (int j = 0; j < numCows; j++) {
				if (j == position - 1) {
					cowArray.set(j, cowNumber);
				}
			}
		}
		System.out.println(hc);
		System.out.println(cowArray);



	}

}

