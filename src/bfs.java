import javax.swing.tree.TreeNode;
import java.util.*;

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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result = new ArrayList<>();
        if(root==null)return result;
        Deque<TreeNode> queue=new LinkedList<>();
        queue.addFirst(root);
        boolean flag = false;
        while(!queue.isEmpty())
        {
            int levelSize =queue.size();
            List<Integer>currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++)
            {
                if(!flag)
                {
                    TreeNode node = queue.pollFirst();
                    currentLevel.add(node.val);
                    if(node.left!=null)
                        queue.addLast(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }
                else
                {
                    TreeNode node = queue.pollLast();
                    currentLevel.add(node.val);
                    if(node.right!=null)
                        queue.addFirst(node.right);
                    if(node.left!=null)
                        queue.addFirst(node.left);

                }
            }
            flag=!flag;
            result.add(currentLevel);
        }
        return result;
    }
}







