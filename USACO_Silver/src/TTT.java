import java.io.*;
import java.math.*;
import java.util.*;
public class TTT {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader in_file = new FileReader("tttt.in");
		BufferedReader buff_in = new BufferedReader(in_file);
		FileWriter out_file = new FileWriter("tttt.out");
		BufferedWriter buff_out = new BufferedWriter(out_file);
		PrintWriter output = new PrintWriter(buff_out);

		StringTokenizer st = new StringTokenizer(buff_in.readLine());
		
		HashSet <Character> row1 = new HashSet <>(); 
		HashSet <Character> row2 = new HashSet <>();
		HashSet <Character> row3 = new HashSet <>();
		HashSet <Character> col1 = new HashSet <>(); 
		HashSet <Character> col2 = new HashSet <>();
		HashSet <Character> col3 = new HashSet <>();
		HashSet <Character> dia1 = new HashSet <>();
		HashSet <Character> dia2 = new HashSet <>();
		
		String r1 = st.nextToken();
		for (int i = 0; i < 3; i++) {
			row1.add(r1.charAt(i));
			if (i == 0) {
				col1.add(r1.charAt(0));
				dia1.add(r1.charAt(0));
			}
			if (i == 1) {
				col2.add(r1.charAt(1));
			}
			if (i == 2) {
				col3.add(r1.charAt(2));
				dia2.add(r1.charAt(2));
			}
		}
		st = new StringTokenizer(buff_in.readLine());
		String r2 = st.nextToken();
		for (int i = 0; i < 3; i++) {
			row2.add(r2.charAt(i));
			if (i == 0) {
				col1.add(r2.charAt(0));
			}
			if (i == 1) {
				col2.add(r2.charAt(1));
				dia1.add(r2.charAt(1));
				dia2.add(r2.charAt(1));
			}
			if (i == 2) {
				col3.add(r2.charAt(2));
			}
		}
		st = new StringTokenizer(buff_in.readLine());
		String r3 = st.nextToken();
		for (int i = 0; i < 3; i++) {
			row3.add(r3.charAt(i));
			if (i == 0) {
				col1.add(r3.charAt(0));
				dia2.add(r3.charAt(0));
			}
			if (i == 1) {
				col2.add(r3.charAt(1));
			}
			if (i == 2) {
				col3.add(r3.charAt(2));
				dia1.add(r3.charAt(2));
			}
		}
		HashSet <HashSet> allHS = new HashSet<>();
		allHS.add(row1);
		allHS.add(row2);
		allHS.add(row3);
		allHS.add(col1);
		allHS.add(col2);
		allHS.add(col3);
		allHS.add(dia1);
		allHS.add(dia2);
		int threeInARow = 0;
		int twoSame = 0;
		for (HashSet hs : allHS) {
			if (hs.size() == 1) {
				threeInARow++;
			}
			else if (hs.size() == 2) {
				twoSame++;
			}
		}
		output.println(threeInARow);
		output.println(twoSame);
		output.close();

	}

}
