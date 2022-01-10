package leetcode;

import java.util.*;

public class tree {

    private class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }


    //二叉树的层次遍历
    //For example: Given binary leetcode.tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
    // return its level order traversal as: [ 3, 9,20, 15,7 ]
    // 分析:二叉树的层次遍历通常实现方式为使用队列不断压入节点遍历,每次取出队列首个元素遍历左右子节点，继续压入子节点即可。

    // version 1: BFS
        public List<List<Integer>> levelOrder(TreeNode root) {
            List result = new ArrayList();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    level.add(head.val);
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                }
                result.add(level);
            }

            return result;
        }
   /**
    * @Author wangtong
    * @Description 验证二叉搜索树 BST
    * @Date 1:40 PM 1/11/21
    * @Param
    * @return
   **/
    //方法一： 递归法 时空间复杂度都是O(N)
    public boolean IsValidBST1(TreeNode root){

       return order(root,null,null);
    }
    private boolean order(TreeNode node , Integer Min, Integer Max){
        if(node==null){
            return  true;
        }
        int val = node.val;
        if(Min!= null && Min>=val){
            return false;
        }
        if(Max!=null && Max<=val){
            return false;
        }
        if(!order(node.left,Min,val)){
            return false;
        }
        if(!order(node.right,val,Max)){
            return false;
        }
        return true;
    }

    //方法二：二叉搜索树「中序遍历」得到的值构成的序列一定是升序的，
    // 这启示我们在中序遍历的时候实时检查当前节点的值是否大于前一个中序遍历到的节点的值即可。
    // 如果均大于说明这个序列是升序的，整棵树是二叉搜索树，否则不是
    public boolean IsValidBST2(TreeNode root){
        Integer pre = -Integer.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp!=null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                if(temp.val<= pre){
                    return false;
                }
                pre = temp.val;

                temp = temp.right;
            }
        }
        return  true;
    }
}
