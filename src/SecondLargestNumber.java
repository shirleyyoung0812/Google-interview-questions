/**
 * Find second largest number in an unsorted array using least comparison
 * find the largest element (n - 1) comparison
 * The second largest element must have been compared with the largest and 
 * eliminated by the largest, so compare all numbers that have been compared with
 * the maximum, total log2n - 1 (height of the tree)
 * 1. construct the tree and find the element
 * 2. back track all the elements that have been compared with the maximum
 * 
 * @author shirleyyoung
 *
 */
public class SecondLargestNumber {
	public static int secondLargest(int[] array) {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("Null or empty array!");
		int[][] arrayTree = getTree(array);
		int maxEle = arrayTree[arrayTree.length - 1][0];
		int maxPos = 0;
		int secondMax = Integer.MIN_VALUE;
		for (int i = arrayTree.length - 2; i >= 0; i--) {
			maxPos = arrayTree[i][maxPos * 2] == maxEle ? maxPos * 2 : maxPos * 2 + 1;
			if (arrayTree[i].length % 2 != 0 && maxPos == arrayTree[i].length - 1) {
				//System.out.println(i);
				continue;
			}
			//the position of the potential second max
			//if max position is at odd index, second max = maxPos - 1;
			//else maxPos + 1
			int secondPos = maxPos % 2 == 0 ? maxPos + 1 : maxPos - 1;
			secondMax = Math.max(secondMax, arrayTree[i][secondPos]);
		}
		return secondMax;
	}
	private static int[][] getTree(int[] array) {
		int depth = (int)Math.ceil((Math.log((double)array.length) / Math.log(2.0))) + 1;
		int[][] tree = new int[depth][];
		tree[0] = array;
		for (int i = 1; i < depth; i++) {
			int length = tree[i - 1].length % 2 == 0 ? tree[i - 1].length / 2 : tree[i - 1].length / 2 + 1;
			tree[i] = new int[length];
			int index = 0;
			for (int j = 0; j < tree[i - 1].length - 1; j += 2) {
				tree[i][index] = Math.max(tree[i - 1][j], tree[i - 1][j + 1]);
				index++;
			}
			if (index < length)
				tree[i][index] = tree[i - 1][tree[i - 1].length - 1];
		}
		return tree;
	}
	
	public static void main(String[] args) {
		int[] array = {13, 29, 7, 8, 4, 5, 1, 10, 7, 39};
		System.out.println(secondLargest(array));

	}

}
