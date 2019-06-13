/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CBTInserter {

	TreeNode root;
	Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        	
        Queue<TreeNode> queue = new LinkedList<>();
        this.root = root;
        queue.offer(root);

        while(!queue.isEmpty()){

        	TreeNode rp = queue.poll();

        	if(rp.left == null || rp.right == null){
        		deque.add(rp);
        	}

        	if(rp.left != null){
        		queue.offer(rp.left);
        	}

        	if(rp.right != null){
        		queue.offer(rp.right);
        	}
        }


    }
    
    public int insert(int v) {
        	
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));

        if(node.left == null){

        	node.left = deque.peekLast();
        }else if(node.right == null){
        	node.right = deque.peekLast();
        	deque.pollFirst();
        }

        return node.val;
    }
    
    public TreeNode get_root() {
        	
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */