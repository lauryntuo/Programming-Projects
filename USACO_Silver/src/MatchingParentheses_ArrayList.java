import java.util.*;

public class MatchingParentheses_ArrayList {
	public static boolean isValid(String str) {
		ArrayList<Character> a = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				a.add(c);
			}
			if (c == ']' || c == '}' || c == ')') {
				if (a.isEmpty()) {
					return false;
				}
				char last = a.remove(a.size() - 1);
				if (!isMatchingPair(last, c)) {
					return false;
				}
			}

		}
		return a.isEmpty();
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
		String str = "a[bc(def){z[e]}g{ad}xyz]";
		System.out.println(isValid(str));

	}

}
