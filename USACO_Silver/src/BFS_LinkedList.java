import java.util.LinkedList;

public class BFS_LinkedList {
	public static class Node {
		private int value;
		Node left;
		Node right;

		public Node(int v) {
			value = v;
		}
	}

	static void bfs(Node root) {
		LinkedList<Node> l = new LinkedList<>();
		l.add(root);
		while (!l.isEmpty()) {
			Node n = l.remove();
			System.out.println(n.value + " ");
			if (n.left != null) {
				l.add(n.left);
			}
			if (n.right != null) {
				l.add(n.right);
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
