package Tree;

/**
 * Author:Honghan Zhu
 * leetcode:100
 * Grade:easy
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p,q);
    }
    private boolean preOrder(TreeNode p,TreeNode q){
        if(null==p&&null==q){
            return true;
        }else if(null==p||null==q) {
            return false;
        }else if(p.val!=q.val){
            return false;
        }
        if(false==preOrder(p.left,q.left)){
            return false;
        }
        if(false==preOrder(p.right,q.right)){
            return false;
        }
        return true;
    }
}
