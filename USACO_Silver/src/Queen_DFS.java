public class Queen_DFS {

	static int n = 8;
	static int count = 0;
	static int [] row = new int [n + 1];
	
	public static int dfs (int currCol) {
		if (currCol > n) {
			count++;
			return 0;
		}
		for (int r = 1; r <= n; r++) {
			if (!isAttacked(r, currCol)) {
				row[currCol] = r;
				dfs(currCol + 1);
			}
		}
		return count;
	}
	public static boolean isAttacked (int test_r, int test_c) {
		for (int c = 1; c < test_c; c++) {
			if (test_r == row[c]) { //same row
				return true;
			}
			if (test_r - row[c] == test_c - c) { //diagonal 1
				return true;
			}
			if (test_r - row[c] == -(test_c - c)) { //diagonal 2
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(dfs(1));

	}

}
