import java.util.*;
public class PrintPath {
	
	public static boolean findPath(TreeNode root, TreeNode n1, List<TreeNode> path){
		if(root == null)
			return false;
		path.add(root);
		if(root == n1)
			return true;
		if(findPath (root.left, n1, path) || findPath(root.right, n1, path))
			return true;
		path.remove(path.size() - 1);
		return false;
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
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n6.right = n8;
		List<TreeNode> path = new ArrayList<TreeNode> ();
		if(findPath(n1, n6, path)){
			for(TreeNode n : path)
				System.out.print(n.val + " ");
		}
		System.out.println();

	}

}
