import java.util.*;
import java.math.*;
import java.io.*;

public class PQ {
	static class cow implements Comparable<cow>{
		int id;
		int age;
		int weight;
		String name;

		cow(int i, int a, int w) {
			id = i;
			age = a;
			weight = w;
		}

		@Override
		public int compareTo(cow other) {
			//return name.compareTo(other.name); compares string
			if (age == other.age) {
				return weight - other.weight;
			}
			return age - other.age;
		}

		
	}

	public static void main(String[] args) {
		PriorityQueue<cow> cowPQ = new PriorityQueue<>();
		cowPQ.add(new cow(1, 5, 6));
		cowPQ.add(new cow(2, 7, 1));
		cowPQ.add(new cow(3, 9, 3));
		cowPQ.add(new cow(4, 7, 8));
		cowPQ.add(new cow(5, 5, 2));
		System.out.println("Dequeue based on age, if age is same, dequeue on weight: ");
		while (!cowPQ.isEmpty()) {
			cow aCow = cowPQ.remove();
			System.out.println("PQ dequed the cow#:" + aCow.id + ", age: " + aCow.age + ", weight: " + aCow.weight);
		}

		int[] inputs = { 3, 5, 1, -1, -5 };
		LinkedList<Integer> q = new LinkedList<>();
		// enqueue all the numbers
		for (int num : inputs) {
			q.addLast(num);
		}
		System.out.println("queue: " + q);
		// dequeue all the numbers and print them out
		while (!q.isEmpty()) {
			int n = q.removeFirst();
			System.out.println("dequeue: " + n);
		}
		System.out.println("Using priority queue:");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// enqueue all the numbers to priority queue
		for (int num : inputs) {
			pq.add(num); // enqueue with "add"
		}
		System.out.println("priority queue: " + pq);
		// dequeue all the numbers and print them out
		while (!pq.isEmpty()) {
			int n = pq.remove(); // dequeue with "remove"
			System.out.println("dequeue: " + n);
		}
	}

}
