package TreePackage;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	} // end default constructor

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end setTree

	public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	} // end setTree

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();

		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	} // end privateSetTree

	public BinaryNode<T> getRoot() {
		return root;
	}

	public T getRootData() {
		T rootData = null;

		if (root != null)
			rootData = root.getData();

		return rootData;
	} // end getRootData

	public T getLeftmostData() {
		// Calls private method getLeftmostData(BinaryNode<T> node) below.
		return getLeftmostData(root);
	}
	private T getLeftmostData(BinaryNode<T> node) {
		if (node.getLeftChild() == null)
			return node.getData();
		else
			return getLeftmostData(node.getLeftChild());
	} // end getLeftmostData

	public T getRightmostData() {
		// Calls private method getRightmostData(BinaryNode<T> node) below.
		return getRightmostData(root);
	}
	private T getRightmostData(BinaryNode<T> node) {
		if (node.getRightChild() == null)
			return node.getData();
		else
			return getRightmostData(node.getRightChild());
	} // end getRightmostData

	public int getHeight() {
		// Calls private method getHeight(BinaryNode<T> node) below.
		return getHeight(root);
	}	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;

		if (node != null)
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));

		return height;
	} // end getHeight

	public int getNumberOfNodes() {
		// Calls private method getNumberOfNodes(BinaryNode<T> node) below.
		return getNumberOfNodes(root);
	}
	private int getNumberOfNodes(BinaryNode<T> node) {
		int leftNumber = 0;
		int rightNumber = 0;

		if (node.getLeftChild() != null)
			leftNumber = getNumberOfNodes(node.getLeftChild());

		if (node.getRightChild() != null)
			rightNumber = getNumberOfNodes(node.getRightChild());

		return 1 + leftNumber + rightNumber;
	} // end getNumberOfNodes

	public boolean isEmpty() {
		return root == null;
	} // end isEmpty

	public void clear() {
		root = null;
	} // end clear

	public void preorderTraversal() {
		// Calls private method preorderTraversal(BinaryNode<T> node) below.
		preorderTraversal(root);
	}
	private void preorderTraversal(BinaryNode<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorderTraversal(node.getLeftChild());
			preorderTraversal(node.getRightChild());
		}
	} // end preorderTraversal

	public void postorderTraversal() {
		// Calls private method postorderTraversal(BinaryNode<T> node) below.
		postorderTraversal(root);
	}
	private void postorderTraversal(BinaryNode<T> node) {
		if (node != null) {
			postorderTraversal(node.getLeftChild());
			postorderTraversal(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	} // end postorderTraversal

	public void inorderTraversal() {
		// Calls private method inorderTraversal(BinaryNode<T> node) below.
		inorderTraversal(root);
	}
	private void inorderTraversal(BinaryNode<T> node) {
		if (node != null) {
			inorderTraversal(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorderTraversal(node.getRightChild());
		} 
	} // end inorderTraversal

} // end BinaryTree