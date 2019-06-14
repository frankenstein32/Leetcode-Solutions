import java.util.*;

public class SumOfDistances{
		
	class Node{

		int val;
		Node right;
		Node left;
		Node next;

		public Node(int x){ val = x; }
	}

	int[] res, int count ;
	ArrayList<HashSet<Integer>> tree;

	public int[] sumOfDistancesInTree(int N, int[][] edges){

		tree = new HashSet<>();
		count = new int[N];
		res = new int[N];

		for(int i = 0;i < N;i++){
			tree.add(new HashSet<>());
		}

		for(int[] e : edges){

			tree.get(e[0]).add(e[1]);
			tree.get(e[1]).add(e[0]);
		}

		dfs1();
		dfs2();
	}

	public void dfs1(int root, int pre){

		for(int i : tree.get(root)){
			if(i == pre) continue;
			dfs1(i, root);
			count[root] += count[i];
			res[root] += res[i] + count[i];
		}

		count[root]++;
	}
	
	public void dfs2(int root, int pre){

		for(int i : tree.get(root)){
			if(i == pre) continue;
			res[i] = res[root] - count[i] + count.length - count[i];
			dfs2(i, root);
		}
	}


}