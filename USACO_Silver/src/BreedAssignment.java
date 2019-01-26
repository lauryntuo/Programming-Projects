import java.util.*;
import java.io.*;
import java.math.*;

public class BreedAssignment {
	static int n;
	static int count;
	static int [] assignment;
	static char [][] relations;

	public static void main(String[] args) throws IOException, FileNotFoundException{
		Scanner sc = new Scanner(new File("assign.in"));
		PrintWriter out = new PrintWriter(new FileWriter("assign.out"));
		n = sc.nextInt();
		int K = sc.nextInt();
		count = 0;
		assignment = new int [n + 1];
		relations = new char [n + 1][n + 1];
		for (int i = 0; i < K; i++) {
			String s = sc.next();
			char sd = s.charAt(0);
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			relations[c1][c2] = relations [c2][c1] = sd;
		}
		assignment[1] = 1;
		dfs(2);
		out.print(count * 3);
		out.close();
	}
	public static void dfs(int currCow) {		
		if (currCow == n + 1) {
			count ++;
			return;
		}
		HashSet<Integer> possibleBreeds = new HashSet (Arrays.asList(1,2,3));
		System.out.println(possibleBreeds);
		for (int c = 1; c < currCow; c++) {
			if (relations[currCow][c] == 'S') { //same
				possibleBreeds.clear();
				possibleBreeds.add(assignment[c]);
				break;
			}
			else if (relations[currCow][c] == 'D') { //different
				possibleBreeds.remove(assignment[c]);
			}
		}
		for (int b: possibleBreeds) {
			assignment[currCow] = b;
			dfs(currCow + 1);
		}
	}

}
