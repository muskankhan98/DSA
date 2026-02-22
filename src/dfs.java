public class dfs {

    int diameter = 0;
    public int diameterOfBinaryTree(bfs.TreeNode root) {
        height(root);
        return diameter-1;
    }

    int height(bfs.TreeNode root)
    {

        if(root==null)return 0;
        int left = height(root.left);
        int right = height(root.right);

        int dia = left+right+1;
        diameter = Math.max(dia, diameter);
        return  Math.max(left,right)+1;
    }

    public bfs.TreeNode invertTree(bfs.TreeNode root) {
        if(root==null)return null;

        bfs.TreeNode left = invertTree(root.left);
        bfs.TreeNode right= invertTree(root.right);

        root.right=left ;
        root.left = right;


        return root;
    }
}
