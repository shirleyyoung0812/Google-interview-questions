import java.util.*;
public class FindKthSmallestInBST {
	public static int kthNode(TreeNode root, int k){
		if (root == null)
			return -1;
		int numNodes = getNumber(root.left) + 1;
		if (numNodes == k)
			return root.val;
		else if (numNodes > k)
			return kthNode(root.left, k);
		else 
			return kthNode(root.right, k - numNodes);
	}
	private static int getNumber(TreeNode root){
		if (root == null)
			return 0;
		return getNumber(root.left) + getNumber(root.right) + 1;
	}
	static boolean found = false;
	public static int kthNode2(TreeNode root, int k){
		List<TreeNode> traverse = new ArrayList<TreeNode>();
		getKth(root, traverse, k);
		return found ? traverse.get(traverse.size() - 1).val : -1;
	}
	private static void getKth(TreeNode root, List<TreeNode> traverse, int k){
		if (root == null || found)
			return;
		getKth(root.left, traverse, k);
		if (found)
			return;
		traverse.add(root);
		if (traverse.size() == k){
			found = true;
			return;
		}
		getKth(root.right, traverse, k);
		
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		final long StartTime1 = System.nanoTime();
		System.out.println(kthNode(n1, 7));
		System.out.println("No extra space time: " + ((System.nanoTime() - StartTime1)/1000) + "ms");
		//final long StartTime2 = System.nanoTime();
		//System.out.println(kthNode2(n1, 7));
		//System.out.println("No extra space time: " + ((System.nanoTime() - StartTime2)/1000) + "ms");

	}

}
