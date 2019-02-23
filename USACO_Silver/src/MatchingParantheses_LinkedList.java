import java.util.*;

public class MatchingParantheses_LinkedList {
	public static boolean isValid(String str) {
		LinkedList<Character> l = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				l.add(c);
			}
			if (c == ']' || c == '}' || c == ')') {
				if (l.isEmpty()) {
					return false;
				}
				char last = l.remove(l.size() - 1);
				if (!isMatchingPair(last, c)) {
					return false;
				}
			}

		}
		return l.isEmpty();
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
