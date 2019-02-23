import java.util.*;

public class MatchingParentheses_Stack {
	public static boolean isValid(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				s.push(c);
			}
			if (c == ']' || c == '}' || c == ')') {
				if (s.isEmpty()) {
					return false;
				}
				char last = s.pop();
				if (!isMatchingPair(last, c)) {
					return false;
				}
			}

		}
		return s.isEmpty();
	}

	public static boolean isMatchingPair(Character f, Character l) {
		if (f == '[' && l == ']') {
			return true;
		}
		if (f == '{' && l == '}') {
			return true;
		}
		if (f == '(' && l == ')') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "a[bc(def){z[e]}ga{d}xyz]";
		System.out.println(isValid(str));

	}

}
