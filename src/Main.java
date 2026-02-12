import javax.swing.tree.TreeNode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        bfs bfs = new bfs();
        bfs.TreeNode root = bfs.new TreeNode(); root.val = 1;
        bfs.TreeNode node2 = bfs.new TreeNode();
        node2.val = 2;
        bfs.TreeNode node3 = bfs.new TreeNode();
        node3.val = 3;
        bfs.TreeNode node4 = bfs.new TreeNode();
        node4.val = 4;
        bfs.TreeNode node5 = bfs.new TreeNode();
        node5.val = 5;
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        bfs.TreeNode successor = bfs.findSuccessor(root, node5);
        if(successor != null) {
            System.out.println(successor.val);
        } else {
            System.out.println("No successor found.");
        }

    }
}