package mylearning;

public class DeleteBinaryTree {
	
	public static void main(String[] args) {
		
		//int[] arr = new int[] { 5,2,22,1,3,18,31,29,35,24,27 };
		//int[] arr = new int[] { 50,20,80,10,30,90,5,15,40,35,45 };
		//int[] arr = new int[] { 40,20,70,45,55,65,10,15,5 };
		int[] arr = new int[] { 2,1,3 };

		DeleteBinaryTree obj = new DeleteBinaryTree();
		TreeNode root = null;

		// Create Binary Search Tree
		root = obj.insert(arr);

		System.out.println("Before deleting Tree values ::::: ");
		obj.printTree(root);

		//root = obj.deleteTreeNode(root, 45);
		root = obj.deleteRec(root, 2);

		System.out.println("\n\nAfter deleting Tree values ::::: ");
		obj.printTree(root);
	}

	
	public TreeNode deleteRec(TreeNode root, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (key < root.data) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.data) 
            root.right = deleteRec(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.data = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.data); 
        } 
  
        return root; 
    } 
	
	int minValue(TreeNode root) 
    { 
        int minv = root.data; 
        while (root.left != null) 
        { 
            minv = root.left.data; 
            root = root.left; 
        } 
        return minv; 
    } 
	
	/*
	public TreeNode deleteTreeNode(TreeNode node, int val) {

		if (node != null && node.data == val) {

			// If deleting node is a left node
			if (node.left == null && node.right == null) {
				node = null;
				// If deleting node has any 1 left or right child
			} else if (node.left == null || node.right == null) {
				if (node.left == null) {
					node.right = node.right;
					node = null;
				} else if (node.right == null) {
					node.left = node.left;
					node = null;
				}
				
				// If deleting node contains both left and child
			} else {
				
				// Iterate to get lowest node from right side
				//TreeNode minNode = node.right;
				//TreeNode minParent = node;
				while (node.right != null && node.right.left != null) {
					node = node.right;
					node.right = node.right.left;
				}
				node.data = node.right.data;
				
				if (node.left ==  node.right) {
					node.left = node.right.right;
					node.right = null;
				}else if(node.right == node.right) {
					node.right = node.right.right;
					node.right = null;
				}
			}
		} else if (node != null) {
			if (node.data > val)
				node.left = deleteTreeNode(node.left, val);
			else if (node.data < val)
				node.right = deleteTreeNode(node.right, val);

		}
		
		return node;

	}*/

	public void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.data+", ");
			printTree(root.right);
		}
	}

	public TreeNode insert(int[] arr) {

		TreeNode root = null;

		for (int i : arr) {
			if (root == null) {
				root = new TreeNode(i);
			} else
				insertTreeNode(root, i);
		}
		return root;
	}

	public TreeNode insertTreeNode(TreeNode root, int val) {

		if (root.data > val) {
			if (root.left == null) {
				TreeNode newTreeNode = new TreeNode(val);
				root.left = newTreeNode;
			} else {
				return insertTreeNode(root.left, val);
			}
		} else if (root.data < val) {
			if (root.right == null) {
				TreeNode newTreeNode = new TreeNode(val);
				root.right = newTreeNode;
			} else {
				return insertTreeNode(root.right, val);
			}
		} else {
			return new TreeNode(val);
		}
		return root;
	}
}
