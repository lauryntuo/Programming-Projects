import java.util.*;
public class Test {
	public static void main (String args []) {
		Stack <Integer> s = new Stack <>();
		s.push(3);
		int i = s.peek();
		System.out.println(i);
		s.pop();
		if (s.isEmpty()) {
			System.out.println("s is empty");
		}
		ArrayList <Integer> a = new ArrayList <>();
		a.add(0,5); //mimic stack behavior, always adding to front
		a.remove(0);
	}

}
