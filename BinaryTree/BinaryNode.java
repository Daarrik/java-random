package TreePackage;

class BinaryNode<T> implements BinaryNodeInterface<T> {

	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode() {
		this(null);
	} // end default constructor

	public BinaryNode(T dataPortion) {
		this(dataPortion, null, null);
	} // end constructor

	public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
		data = dataPortion;
		left = leftChild;
		right = rightChild;
	} // end constructor

	public T getData() {
		return data;
	} // end getData

	public void setData(T newData) {
		data = newData;
	} // end setData

	public BinaryNode<T> getLeftChild() {
		return left;
	} // end getLeftChild

	public BinaryNode<T> getRightChild() {
		return right;
	} // end getRightChild

	public void setLeftChild(BinaryNode<T> leftChild) {
		left = leftChild;
	} // end setleftChild

	public void setRightChild(BinaryNode<T> rightChild) {
		right = rightChild;
	} // end setRightChild

	public boolean hasLeftChild() {
		return left != null;
	} // end hasLeftChild

	public boolean hasRightChild() {
		return right != null;
	} // end hasRightChild

	public boolean isLeaf() {
		return (left == null) && (right == null);
	} // end isLeaf

	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;

		if (left != null)
			leftNumber = left.getNumberOfNodes();

		if (right != null)
			rightNumber = right.getNumberOfNodes();

		return 1 + leftNumber + rightNumber;
	} // end getNumberOfNodes

	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;

		if (left != null)
			leftHeight = left.getHeight();

		if (right != null)
			rightHeight = right.getHeight();

		return 1 + Math.max(leftHeight, rightHeight);
		
	} // end getHeight

	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<T>(data);

		if (left != null)
			newRoot.left = (BinaryNode<T>)left.copy();

		if (right != null)
			newRoot.right = (BinaryNode<T>)right.copy();

		return newRoot;
	} // end copy

	public T getLeftmostData() {
		if (left == null)
			return data;
		else
			return left.getLeftmostData();
	} // end getLeftmostData

	public T getRightmostData() {
		if (right == null)
			return data;
		else
			return right.getRightmostData();
	} // end getRightmostData

	public void preorderTraversal() {
		System.out.print(getData() + " ");
		if (left != null)
			left.preorderTraversal();
		if (right != null)
			right.preorderTraversal();
	} // end preorderTraversal

	public void postorderTraversal() {
		if (left != null)
			left.postorderTraversal();
		if (right != null)
			right.postorderTraversal();
		System.out.print(getData() + " ");
	} // end postorderTraversal

	public void inorderTraversal() {
		if (left != null)
			left.inorderTraversal();
		System.out.print(getData() + " ");
		if (right != null)
			right.inorderTraversal();
	} // end inorderTraversal

} // end BinaryNode