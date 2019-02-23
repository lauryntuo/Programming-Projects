import java.io.*;
import java.math.*;
import java.util.*;

public class Hopscotch {

	static char [][] board;
	public static int getPathCount(int r, int c) {
		int totalPaths = 0;
		if (r == board.length - 1 && c == board[r].length - 1 ) {
			return 1;
		}
		for (int i = r + 1; i < board.length; i++) {
			for (int j = c + 1; j < board[i].length; j++) {
				if (board[r][c] != board[i][j]) {
					totalPaths += getPathCount (i,j);
				}
			}
		}
		return totalPaths;
	}

	public static void main(String[] args) throws IOException, FileNotFoundException{
		Scanner sc = new Scanner(new File("hopscotch.in"));
		PrintWriter out = new PrintWriter(new FileWriter("hopscotch.out"));
		int r = sc.nextInt();
		int c = sc.nextInt();
		board = new char [r][c];
		for (int i = 0; i < r; i++) {
			String line = sc.next();
			for (int j = 0; j < c; j++) {
				board[i][j] = line.charAt(j); 
			}
		}
		out.print(getPathCount(0,0));
		out.close();
		
		System.out.println(!((!true || !false) && (true || false)));
		System.out.println((true && false) || (!true && !false));
	}

}
