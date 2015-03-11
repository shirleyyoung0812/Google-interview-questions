/**
 * Given two binary trees, A and B, 
 * we can define A as a subset of B if the root of A exists 
 * in B and if we can superimpose A on B at that location without changing B. 
 * (That is, the subtrees from the root of A and the node in B 
 * that is the same as the root of A are the same), 
 * 
 * Example: 
 * A: 
 * 5 
 * 4	7 
 * 
 * B: 
 * 6 
 * 5	12 
 * 4	7	8	10 
 * 
 * A is a subset of B in this case. 
 * 
 * B1: 
 * 6 
 * 5	12 
 * 4	7	8	10 
 * 1 
 * 
 * A is still a subset of B1, even though B1 extends one more level than A. 
 * Write an algorithm to determine if one tree is a subset of another tree
 * @author shirleyyoung
 *
 */
public class SubsetTree {
	public static boolean isSubset(TreeNode a, TreeNode b) {
		if ((a == null && b != null) || (a != null && b == null))
			return false;
		if (a.val == b.val)
			return checkTree(a, b);
		return isSubset(a, b.left) || isSubset(a, b.right);
	}
	private static boolean checkTree(TreeNode a, TreeNode b) {
		if (a == null)
			return true;
		if (a != null && b == null)
			return false;
		if(a.val != b.val)
			return false;
		return checkTree(a.left, b.left) && checkTree(a.right, b.right);
	}
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(5);
		TreeNode a2 = new TreeNode(4);
		TreeNode a3 = new TreeNode(7);
		a1.left = a2;
		a1.right = a3;
		TreeNode b1 = new TreeNode(6);
		TreeNode b2 = new TreeNode(12);
		TreeNode b3 = new TreeNode(5);
		TreeNode b4 = new TreeNode(8);
		TreeNode b5 = new TreeNode(10);
		TreeNode b6 = new TreeNode(4);
		TreeNode b7 = new TreeNode(7);
		TreeNode b8 = new TreeNode(13);
		b1.left = b2;
		b1.right = b3;
		b2.left = b4;
		b2.right = b5;
		b3.left = b6;
		b3.right = b7;
		b4.left = b8;
		System.out.println(isSubset(a1, b1));

	}

}
