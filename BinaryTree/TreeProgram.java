package TreePackage;

public class TreeProgram {

	public static void main(String[] args) {

		BinaryTree<String> H = new BinaryTree<>("H");
		BinaryNode<String> nodeH = H.getRoot();

		BinaryTree<String> G = new BinaryTree<>("G");
		BinaryNode<String> nodeG = G.getRoot();

		BinaryTree<String> F = new BinaryTree<>("F");
		BinaryNode<String> nodeF = F.getRoot();

		BinaryTree<String> E = new BinaryTree<>("E", G, H);
		BinaryNode<String> nodeE = E.getRoot();

		BinaryTree<String> D = new BinaryTree<>("D", F, null);
		BinaryNode<String> nodeD = D.getRoot();

		BinaryTree<String> C = new BinaryTree<>("C", D, E);
		BinaryNode<String> nodeC = C.getRoot();

		BinaryTree<String> B = new BinaryTree<>("B");
		BinaryNode<String> nodeB = B.getRoot();

		BinaryTree<String> A = new BinaryTree<>("A", B, C);

		// TREE A OPERATIONS. CALLS BINARYTREE METHODS ONLY.
		System.out.println("Tree A operations:");

		System.out.println("A.getRootData(): " + A.getRootData());

		System.out.print("A.preorderTraversal(): ");
		A.preorderTraversal();
		System.out.println();

		System.out.print("A.postorderTraversal(): ");
		A.postorderTraversal();
		System.out.println();

		System.out.print("A.inorderTraversal(): ");
		A.inorderTraversal();
		System.out.println();

		System.out.println("A.getNumberOfNodes(): " + A.getNumberOfNodes());
		System.out.println("A.getHeight(): " + A.getHeight());
		System.out.println("A.getLeftmostData(): " + A.getLeftmostData());
		System.out.println("A.getRightmostData(): " + A.getRightmostData());
		
		System.out.println();

		// SUBTREE C OPERATIONS. CALLS BINARYNODE METHODS ONLY.
		System.out.println("Subtree C operations:");

		System.out.println("nodeC.getData(): " + nodeC.getData());

		System.out.print("nodeC.preorderTraversal(): ");
		nodeC.preorderTraversal();
		System.out.println();

		System.out.print("nodeC.postorderTraversal(): ");
		nodeC.postorderTraversal();
		System.out.println();

		System.out.print("nodeC.inorderTraversal(): ");
		nodeC.inorderTraversal();
		System.out.println();

		System.out.println("nodeC.getNumberOfNodes(): " + nodeC.getNumberOfNodes());
		System.out.println("nodeC.getHeight(): " + nodeC.getHeight());
		System.out.println("nodeC.getLeftmostData(): " + nodeC.getLeftmostData());
		System.out.println("nodeC.getRightmostData(): " + nodeC.getRightmostData());
		
	}

}