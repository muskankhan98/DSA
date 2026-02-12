import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode findSuccessor(TreeNode root, TreeNode key) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return null;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelsize = queue.size();


            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.val == key.val) {
                break;
            }
        }

        return queue.peek();
    }
}







