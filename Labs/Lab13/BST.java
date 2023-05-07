public class BST<E extends Comparable<E>> {
	protected TreeNode<E> root;
	protected int size = 0;

    /** Inner class tree node */
	public static class TreeNode<E extends Comparable<E>> {
		E element;
		TreeNode<E> left;
		TreeNode<E> right;
        TreeNode<E> parent;

		public TreeNode(E e) {
			element = e;
		}
	}
    
	/** Create a default binary search tree */
	public BST() {
		root = null;
	}

	/** Create a binary search tree from an array of objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	/**
	 * Insert element e into the binary search tree Return true if the element is
	 * inserted successfully
	 */
	public boolean insert(E e) {
		TreeNode<E> tempNode = createNewNode(e);
		if (root == null){
			tempNode.parent = root;
			root = tempNode;
			return true;
		}
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (true){
				parent = current;
				if (e.compareTo(current.element) < 0){
					current = current.left;
					if (current == null){
						tempNode.parent = parent;
						parent.left = tempNode;
						size++;
						return true;
					}
				}
				else{
					current = current.right;
					if (current == null){
						tempNode.parent = parent;
						parent.right = tempNode;
						size++;
						return true;
					}
				}
			}
		}
	}

	protected TreeNode<E> createNewNode(E e){
		return new TreeNode<E>(e);
	}

	/**
	 * Delete an element from the binary search tree. Return true if the element is
	 * deleted successfully Return false if the element is not in the tree
	 */
	public boolean delete(E e) {
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed by current
		}

		if (current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left children
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
					if (parent.left != null)
						parent.left.parent = parent;
				else
					parent.right = current.right;
					if (parent.right != null)
                        parent.right.parent = parent;
			}
		} 
		else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
				if (parentOfRightMost.right != null)
                    parentOfRightMost.right.parent = parentOfRightMost;
			else{
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
				if (parentOfRightMost.left != null)
                    parentOfRightMost.left.parent = parentOfRightMost;
			}
		}

		size--;
		return true; // Element deleted
	}

    public boolean isLeaf(E e){
        if(getNode(e).left == null && getNode(e).right == null)
            return true;

        return false;
    }

    public TreeNode<E> getNode(E e){
        TreeNode<E> current = root;
        while (current != null){
            if (current.element == e)
                return current;

            else if (e.compareTo(current.element) < 0)
                current = current.left;

            else
                current = current.right;
        }
        return null;
    }

	public int getSize() {
		return size;
	}
}



