import java.util.*;
/**
 Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 */
// /**
//  Definition for a binary tree node.
//  public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
//  */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
     private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
    }
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);    // Traverse left subtree
        postOrderTraversal(root.right);   // Traverse right subtree
        System.out.print(root.val + " "); // Process the current node
    }
    public static void main(String args){
        int N;
        Scanner sc= new Scanner(System.in);
        System.out.println("Entre the Size in& pre order");
        N=sc.nextInt();
        int[] inorder= new int[N];
        int[] preorder= new int[N];
        System.out.println("Entre the inorder");
        for(int i=0;i<N;i++)
        {
            inorder[i]=sc.nextInt();
        }
        System.out.println("Entre the preorder");
        for(int i=0;i<N;i++)
        {
            preorder[i]=sc.nextInt();
        }
        TreeNode obj= new TreeNode();
        obj.buildTree(preorder,inorder);
        obj.helper(preorder,preorder[0],preorder[N],inorder,inorder[0],inorder[N],);


    }
 }
