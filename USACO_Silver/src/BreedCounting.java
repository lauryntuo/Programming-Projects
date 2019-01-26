import java.util.*;
import java.io.*;
import java.math.*;

public class BreedCounting {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("bcount.in"));
		PrintWriter out = new PrintWriter(new FileWriter("bcount.out"));
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[][] prefixCount = new int[n + 1][4];
		for (int i = 1; i <= n; i++) {
			int cowBreed = sc.nextInt();
			for (int breed = 1; breed <= 3; breed++) {
				prefixCount[i][breed] = prefixCount[i - 1][breed];
			}
			prefixCount[i][cowBreed]++;
		}
		for (int i = 0; i < q; i++) {
			String result = "";
			int low = sc.nextInt();
			int high = sc.nextInt();
			for (int breed = 1; breed <= 3; breed++) {
				result += prefixCount[high][breed] - prefixCount[low - 1][breed] + " ";
			}
			out.println(result.trim());
		}
		out.close();

	}

}
