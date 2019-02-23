import java.util.*;

import java.io.*;
import java.math.*;

public class FloodFill_DFS {
	static int numRows;
	static int numCols;
	static int[][] pixelGraph;
	static int newRow;
	static int newCol;
	static int newColor;
	static boolean[][] visitedPixels;
	static int count = 0;
	static int targetPixel;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/**
		 * function dfs (square s) if square is already visited, stop if square is
		 * outside region, stop dfs (above square) dfs (below square) dfs (left square)
		 * dfs (right square)
		 */

		Scanner sc = new Scanner(new File("floodfill.in"));
		PrintWriter out = new PrintWriter(new FileWriter("floodfill.out"));
		numRows = sc.nextInt();
		numCols = sc.nextInt();
		pixelGraph = new int[numRows][numCols];
		visitedPixels = new boolean[numRows][numCols];

		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				int pixel = sc.nextInt();
				pixelGraph[r][c] = pixel;
			}
		}
		newRow = sc.nextInt();
		newCol = sc.nextInt();
		targetPixel = pixelGraph[newRow][newCol];
		newColor = sc.nextInt();

		OUTER_LOOP: for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if (pixelGraph[r][c] == targetPixel) {
					dfs(r, c);
					break OUTER_LOOP;
				}
			}
		}
		// for (int r = 0; r < numRows; r++) {
		// for (int c = 0; c < numCols; c++) {
		// if (visitedPixels[r][c] == false) {
		// dfs(r, c);
		// }
		// }
		// }
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				out.print(pixelGraph[i][j] + " ");
			}
			out.println();
		}
		out.close();
	}

	public static void dfs(int currPixelRow, int currPixelCol) {
		if (currPixelRow < 0 || currPixelRow == pixelGraph.length) {
			return;
		}
		if (currPixelCol < 0 || currPixelCol == pixelGraph[0].length) {
			return;
		}
		if (pixelGraph[currPixelRow][currPixelCol] != targetPixel) {
			return;
		}
		if (visitedPixels[currPixelRow][currPixelCol] == true) {
			return;
		} else if (visitedPixels[currPixelRow][currPixelCol] == false) {
			visitedPixels[currPixelRow][currPixelCol] = true;
		}
		if (pixelGraph[currPixelRow][currPixelCol] == targetPixel) {
			pixelGraph[currPixelRow][currPixelCol] = newColor;

		}
		dfs(currPixelRow - 1, currPixelCol);
		dfs(currPixelRow + 1, currPixelCol);
		dfs(currPixelRow, currPixelCol - 1);
		dfs(currPixelRow, currPixelCol + 1);
	}
}
