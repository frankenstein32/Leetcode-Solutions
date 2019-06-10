import java.util.*;

public class FindSecondMin{
		
	class TreeNode{

		int val;
		TreeNode right;
		TreeNode left;

		public TreeNode(int x){ val = x; }
	}
		
	public boolean findTarget(TreeNode root, int target){

        return find(root, target, new HashSet<>());

    }

    public boolean find(TreeNode root, int target, Set<Integer> processed){

        if(root == null){
            return false;
        }

        if(processed.contains(target - root.val)){
            return true;
        }

        processed.add(root.val);

        return find(root.left, target, processed) || find(root.right, target, processed);
    }

    public boolean findBFS(TreeNode root, int target){

        Set<Integer> processed = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            TreeNode rp = q.poll();

            if(q.contains(target - rp.val)){
                return true;
            }

            q.add(rp.val);

            if(rp.left != null)
                q.add(rp.left);
            if(rp.right != null)
                a.add(rp.right);
        }

        return false;
    }

    public boolean findTargetBST(TreeNode root, int target){

        List<Integer> ans = new ArrayList<>();
        Inorder(root, ans);

        int i = 0, j = ans.size() - 1;

        while(i <= j){

            int sum = ans.get(i) + ans.get(j);

            if(target == sum){
                return true;
            }else if(target > sum){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }

    public void Inorder(TreeNode root, List<Integer> ans){

        if(root == null)
            return;

        Inorder(root.left, ans);
        ans.add(root.val);
        Inorder(root.right, ans);

    }
	
}