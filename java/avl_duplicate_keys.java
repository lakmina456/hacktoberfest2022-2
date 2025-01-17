import java.util.*;

class solution {

	static class node {
		int key;
		node left;
		node right;
		int height;
		int count;
	}


	static int height(node N)
	{
		if (N == null)
    {
			return 0;
    }
		return N.height;
	}

	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}

	static node newNode(int key)
	{
		node node = new node();
		node.key = key;
		node.left = null;
		node.right = null;
		node.height = 1; 
		node.count = 1;
		return (node);
	}


	static node rightRotate(node y)
	{
		node x = y.left;
		node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	static node leftRotate(node x)
	{
		node y = x.right;
		node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
    
		return y;
	}

	static int getBalance(node N)
	{
		if (N == null)
    {
			return 0;
    }
		return height(N.left) - height(N.right);
	}

	static node insert(node node, int key)
	{

		if (node == null)
    {
			return (newNode(key));
    }

		if (key == node.key) {
			(node.count)++;
			return node;
		}


		if (key < node.key)
    {
			node.left = insert(node.left, key);
    }
		else
    {
			node.right = insert(node.right, key);
    }

		node.height = max(height(node.left), height(node.right)) + 1;

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key)
    {
			return rightRotate(node);
    }


		if (balance < -1 && key > node.right.key)
    {
			return leftRotate(node);
    }

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	static node minValueNode(node node)
	{
		node current = node;

		while (current.left != null)
    {
			current = current.left;
    }

		return current;
	}

	static node deleteNode(node root, int key)
	{
		if (root == null)
    {
			return root;
    }

		if (key < root.key)
    {
			root.left = deleteNode(root.left, key);
    }

		else if (key > root.key)
    {
			root.right = deleteNode(root.right, key);
    }

		else {
			if (root.count > 1) {
				(root.count)--;
				return null;
			}

			if ((root.left == null) || (root.right == null)) {
				node temp = root.left != null ? root.left : root.right;

				// No child case
				if (temp == null) {
					temp = root;
					root = null;
				}
				else
        {
					root = temp;
        }
			}
			else {
				node temp = minValueNode(root.right);
				root.key = temp.key;
				root.count = temp.count;
				temp.count = 1;
				root.right = deleteNode(root.right, temp.key);
			}
		}

		if (root == null)
    {
			return root;
    }

		root.height = max(height(root.left), height(root.right)) + 1;
		int balance = getBalance(root);
    
		if (balance > 1 && getBalance(root.left) >= 0)
    {
			return rightRotate(root);
    }

		if (balance > 1 && getBalance(root.left) < 0) 
    {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0)
    {
			return leftRotate(root);
    }

		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	static void preOrder(node root)
	{
		if (root != null) {
			System.out.printf("%d(%d) ", root.key, root.count);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String args[])
	{
		node root = null;

		root = insert(root, 9);
		root = insert(root, 5);
		root = insert(root, 10);
		root = insert(root, 5);
		root = insert(root, 9);
		root = insert(root, 7);
		root = insert(root, 17);

		System.out.printf("Pre order traversal of the constructed AVL tree is \n");
		preOrder(root);

		deleteNode(root, 9);

		System.out.printf("\nPre order traversal after deletion of 9 \n");
		preOrder(root);
	}
}
