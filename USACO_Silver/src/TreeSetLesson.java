import java.util.*;

import javax.sound.midi.Synthesizer;

public class TreeSetLesson {
	static class cow implements Comparable<cow> {
		int age;
		int weight;

		cow(int a, int w) {
			age = a;
			weight = w;
		}

		@Override
		public int compareTo(cow c) {
			return weight - c.weight;
		}

		public String toString() {
			return "a cow: age = " + age + ", weight = " + weight;
		}
	}

	public static void main(String[] args) {
		TreeSet<cow> cowSet = new TreeSet<>();
		cowSet.add(new cow(5, 2)); // cow#1
		cowSet.add(new cow(1, 1)); // cow#2
		cowSet.add(new cow(4, 9));
		cowSet.add(new cow(2, 3));
		cowSet.add(new cow(7, 7));
		System.out.println("Before cow #2 gains weight: ");
		for (cow c : cowSet) {
			System.out.println(c);
		}

		cow firstCow = cowSet.first(); // cow #2
		firstCow.weight = 10;
		System.out.println("After cow#2 gains weight: ");
		for (cow c : cowSet) {
			System.out.println(c);
		}
		System.out.println();
		cowSet.add(new cow(5, 8));
		for (cow c : cowSet) {
			System.out.println(c);
		}


		TreeSet<Integer> myTreeSet = new TreeSet<>();
		myTreeSet.add(5);
		myTreeSet.add(1);
		myTreeSet.add(9);
		myTreeSet.add(6);
		myTreeSet.add(5);
		// 1569
		System.out.println("Testing out different functions:");
		System.out.println(myTreeSet.floor(6)); // inclusive
		System.out.println(myTreeSet.lower(6)); // exclusive
		System.out.println(myTreeSet.ceiling(6)); // inclusive
		System.out.println(myTreeSet.higher(6)); // exclusive
		System.out.print("Headset of 6: ");
		System.out.println(myTreeSet.headSet(6)); // exclusive
		System.out.print("Tailset of 6: ");
		System.out.println(myTreeSet.tailSet(6)); // inclusive
		myTreeSet.add(-8);
		myTreeSet.add(10);
		myTreeSet.remove(5);
		System.out.println(myTreeSet);

	}

}