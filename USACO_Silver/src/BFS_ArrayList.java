import java.util.*;

public class BFS_ArrayList {

	public static class Node {
		private int value;
		Node left;
		Node right;

		public Node(int v) {
			value = v;
		}
	}

	static void bfs(Node root) {
		ArrayList<Node> a = new ArrayList<>();
		a.add(root);
		while (!a.isEmpty()) {
			Node n = a.get(0);
			a.remove(0);
			System.out.println(n.value + " ");
			if (n.left != null) {
				a.add(n.left);
			}
			if (n.right != null) {
				a.add(n.right);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		bfs(root);
	}

}
