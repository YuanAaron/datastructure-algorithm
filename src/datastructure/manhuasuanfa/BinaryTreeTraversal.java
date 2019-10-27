package datastructure.manhuasuanfa;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

    //二叉树节点
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    //前序遍历构建普通二叉树
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList==null || inputList.isEmpty())
            return null;

        Integer data = inputList.removeFirst();
        TreeNode root=null;
        if (data!=null) {
            root=new TreeNode(data);
            root.leftChild=createBinaryTree(inputList);
            root.rightChild=createBinaryTree(inputList);
        }

        return root;
    }

    //二叉树前序遍历，推荐！！！
    public static void preOrderTraversal(TreeNode root) {
        if (root==null)
            return;
        System.out.println(root.data);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    //二叉树中序遍历，推荐！！！
    public static void inOrderTraversal(TreeNode root) {
        if (root==null)
            return;
        inOrderTraversal(root.leftChild);
        System.out.println(root.data);
        inOrderTraversal(root.rightChild);
    }

    //二叉树后序遍历，推荐！！！
    public static void postOrderTraversal(TreeNode root) {
        if (root==null)
            return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.data);
    }

    //二叉树层序遍历
    public void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        int depth = depth(root);
        for (int i = 1; i <= depth; i++) {
            printNodeAtLevel(root, i);
        }
    }

    private void printNodeAtLevel(TreeNode root, int level) {
        if (root == null || level < 1)
            return;

        if (level == 1) {
            System.out.print(root.data + " ");
            return;
        }

        printNodeAtLevel(root.leftChild, level - 1); //左子树
        printNodeAtLevel(root.rightChild, level - 1); // 右子树
    }

    //用递归方法求树的高度
    public int depth(TreeNode root) {
        if (root == null)
            return 0;

        int l = depth(root.leftChild);
        int r = depth(root.rightChild);

        return 1+(l<r?r:l);
    }

    //二叉树前序遍历的非递归实现（这里用栈实现）
    public static void preOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (cur!=null) {
                System.out.println(cur.data);
                stack.push(cur);
                cur=cur.leftChild;
            }

            //如果cur节点没有左孩子，则弹出栈顶元素，访问cur节点的右孩子
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur=cur.rightChild;
            }
        }
    }

    //二叉树中序遍历的非递归实现（这里用栈实现）
    public static void inOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (cur!=null) {
                stack.push(cur);
                cur=cur.leftChild;
            }

            //如果cur节点没有左孩子，则弹出栈顶元素，访问cur节点的右孩子
            if (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.println(cur.data);
                cur=cur.rightChild;
            }
        }
    }

    //二叉树后序遍历的非递归实现（这里用栈实现）
    public static void postOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode prev=null;
        while (cur!=null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (cur!=null) {
                stack.push(cur);
                cur=cur.leftChild;
            }

            //思路：引入prev指针标记访问序列中的前一个二叉树节点，如果cur.rightChild==null
            //或cur.rightChild==prev，就判断已经从右子树访问返回。思路启发自:https://zhuanlan.zhihu.com/p/34520483
            //我目前感觉这段代码理解起来有点难！！！
            if(!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.rightChild==null || cur.rightChild == prev) { //判断是否从右子树访问返回
                    System.out.println(cur.data);
                    prev = stack.pop();
                    cur=null;
                } else {
                    cur = cur.rightChild;
                }
            }
        }
    }

    //二叉树层序遍历的非递归实现（这里用队列实现）,推荐！！！
    public static void levelOrderTraversalWithQueue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode cur=root;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.println(cur.data);

            if (cur.leftChild!=null) {
                queue.offer(cur.leftChild);
            }

            if (cur.rightChild!=null) {
                queue.offer(cur.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList=new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
//        LinkedList<Integer> inputList=new LinkedList<>(Arrays.asList(new Integer[]{1,2,4,null,null,5,6,null,null,null,3,null,null}));
        TreeNode root=createBinaryTree(inputList);
        System.out.println("前序遍历：");
//        preOrderTraversal(root);
        preOrderTraversalWithStack(root);
        System.out.println("中序遍历：");
//        inOrderTraversal(root);
        inOrderTraversalWithStack(root);
        System.out.println("后序遍历：");
//        postOrderTraversal(root);
        postOrderTraversalWithStack(root);
        System.out.println("层序遍历：");
        levelOrderTraversalWithQueue(root);
    }
}
