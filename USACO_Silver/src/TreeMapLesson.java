import java.util.*;

public class TreeMapLesson {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		TreeMap<String, String> tm1 = new TreeMap<>();
		TreeMap<Integer, String> tm2 = new TreeMap<>();

		TreeMap<String, Integer> tm3 = new TreeMap<>();
		tm3.put("Hello", 100);
		tm3.put("TreeMap", 89);
		tm3.put("HashSet", 40);
		tm3.put("Arraylist", 30);
		tm3.put("Hello", 200);
		System.out.println(tm3); // ordered alphabetically by keys
		System.out.println("Iterating through the treemap:");
		// for each loop
		// entrySet(), getKey(), getValue()
		for (Map.Entry<String, Integer> e : tm3.entrySet()) {
			System.out.print("an entry e: ");
			System.out.print(e.getKey() + " -- ");
			System.out.println(e.getValue());
		}
		for (String aKey : tm3.keySet()) {
			System.out.print("an entry e: ");
			System.out.print(aKey + " -- ");
			System.out.println(tm3.get(aKey));
		}
		int pageNumHello = tm3.get("Hello");
		int a = 3;

	}

}
