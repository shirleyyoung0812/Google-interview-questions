
public class DLLToBST {
	private static class Node{
		public Node prev, next;
		public int key;
	}
	public static Node convertToTree(Node head){
		Node mid = findMid(head);
		Node right = mid.next;
		mid.prev.next = null;
		mid.prev = null;
		mid.next = null;
		mid.prev = convertToTree(head);
		mid.next = convertToTree(right);
		return mid;
	}
	private static Node findMid(Node head){
		Node fast = head.next;
		Node slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
