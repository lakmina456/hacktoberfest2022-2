import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node {
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	class Values {
		int max, min;
	}

	public void verticalOrder(Node node)
	{
		Values val = new Values();

		Map<Integer, List<Integer> > map
			= new TreeMap<Integer, List<Integer> >();

		findHorizontalDistance(node, val, val, 0, map);

		for (List<Integer> list : map.values()) {
			System.out.println(list);
		}

		System.out.println("done");
	}

	public void findHorizontalDistance(
		Node node, Values min, Values max, int hd,
		Map<Integer, List<Integer> > map)
	{

		if (node == null)
		{
			return;
		}

		if (hd < min.min)
		{
			min.min = hd;
		}


		if (hd > max.max)
		{
			max.max = hd;
		}


		map.computeIfAbsent(hd,
			k -> new ArrayList<Integer>())
			.add(node.data);

		findHorizontalDistance(node.left, min, max, hd - 1, map);

		findHorizontalDistance(node.right, min, max, hd + 1, map);
	}

	public static void main(String[] args)
	{

		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		System.out.println("vertical order traversal is :");

		tree.verticalOrder(tree.root);
	}
}
