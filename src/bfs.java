

import javax.swing.tree.TreeNode;
import java.util.*;

public class bfs {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
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

   // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
    // important with o(1) space complexity
    public TreeNode connect(TreeNode root) {
        if(root==null)return null;
        TreeNode leftNode = root;
        while(leftNode.left!=null)
        {
            TreeNode current = leftNode;
            while(current!=null)
            {
                current.left.next = current.right;
                if(current.next!=null)
                {
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            leftNode=leftNode.left;
        }
        return root;
    }

    //https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)return result;

        Queue<TreeNode>q= new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int levelsize = q.size();

            for(int i=0;i<levelsize;i++)
            {
                TreeNode node = q.poll();
                if(i==levelsize-1)
                    result.add(node.val);

                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
        }
        return result;
    }

    //https://leetcode.com/problems/symmetric-tree/description/
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty())
        {
            TreeNode left =  q.poll();
            TreeNode right =  q.poll();
            if(left==null && right==null)
                continue;
            if(left==null || right==null)
                return false;
            if(left.val!=right.val)
                return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}







