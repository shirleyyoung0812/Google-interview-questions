
public class DiameterOfTree {
	public static int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	public static int Diameter(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return Math.max(Math.max(Diameter(root.left), Diameter(root.right)), maxDepth(root.left) + maxDepth(root.right));
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n8;
		n5.right = n9;
		n3.left = n6;
		n3.right = n7;
		System.out.println(Diameter(n1));

	}

}
