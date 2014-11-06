
public class TreeNode {
	protected TreeNode left;
	protected TreeNode right;
	protected int value;
	
	public TreeNode(int v) {
		left = right = null;
		value = v;
	}
	
	public TreeNode(int v, TreeNode l, TreeNode r) {
		left = l;
		right = r;
		value = v;
	}
	
	public int value() {
		return value;
	}
	
	public TreeNode leftChild() {
		return left;
	}
	
	public TreeNode rightChild() {
		return right;
	}
}
