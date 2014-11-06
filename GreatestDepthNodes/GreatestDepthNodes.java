import java.util.ArrayList;
import java.util.HashMap;



public class GreatestDepthNodes {
	private static HashMap<Integer, ArrayList<TreeNode>> depth_to_list;
	
	public static ArrayList<TreeNode> getGreatestDepthNodes(TreeNode root) {
		if (root == null) {
			return new ArrayList<TreeNode>();
		}
		depth_to_list = new HashMap<Integer, ArrayList<TreeNode>>();
		explore(root, 0);
		int max_depth = 0;
		for (Integer i : depth_to_list.keySet()) {
			if (i > new Integer(max_depth)) {
				max_depth = i;
			}
		}
		return depth_to_list.get(max_depth);
		
	}
	
	public static void explore(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> node_list = depth_to_list.get(new Integer(depth));
		if (node_list == null) {
			node_list = new ArrayList<TreeNode>();
			node_list.add(root);
			depth_to_list.put(new Integer(depth), node_list);
		} else {
			node_list.add(root);
		}
		
		explore(root.leftChild(), depth+1);
		explore(root.rightChild(), depth+1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7, new TreeNode(3, new TreeNode(10), null), new TreeNode(5, new TreeNode(11), null));
		for (TreeNode n : getGreatestDepthNodes(root)) {
			System.out.println(n.value());
		}
	}
}
