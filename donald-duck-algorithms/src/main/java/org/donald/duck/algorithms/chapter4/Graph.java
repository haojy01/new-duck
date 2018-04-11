package org.donald.duck.algorithms.chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 无向图
 */
public class Graph {

	// 顶点数
	private int V;
	// 边数
	private int E;
	// 顶点
	private Node[] node;

	public Graph(int V) {
		this.V = V;
		this.node = new Node[V];
		for (int i = 0; i < V; i++) {
			node[i] = new Node();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	// 添加一条边
	public void addEdage(int v, int w) {
		node[v].add(w);
		node[w].add(v);
		E++;
	}

	// 计算v的度数
	// 度数是什么？ 依赖该顶点的边数
	public static int degree(Graph g, int v) {
		return g.adj(v).size();
	}

	// 计算所有顶点的最大度数
	public static int maxDegree(Graph g) {
		int max = 0;
		for (int v = 0; v < g.V(); v++) {
			if (max < degree(g, v)) {
				max = degree(g, v);
			}
		}
		return max;
	}

	// 计算自环的个数
	public static int numberOfSelfLoops(Graph g) {
		int num = 0;
		for (int v = 0; v < g.V(); v++) {
			for (Integer w : g.adj(v)) {
				if (w == v)
					num++;
			}
		}
		return num / 2;
	}

	// 与ｖ相邻的所有顶点
	public List<Integer> adj(int v) {
		return node[v].getVlist();
	}

	// 找到和ｖ连通的所有顶点
	// union_find 算法
	// 广度遍历
	// 深度遍历
	public static void search(Graph g, int v) {
		// 深度优先遍历
		DepthFitstSearch dfs = new DepthFitstSearch(g, v);
		int i = 0;
		for (boolean a : dfs.getMarked()) {
			if (a)
				System.out.print(i);
			i++;
		}
	}

	// ｖ和ｗ是连通的吗
	public static boolean marked(int v, int w) {
		return false;
	}

	// 与ｓ连通的顶点数
	public static int count(int v) {
		return 0;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdage(1, 3);
		g.addEdage(1, 1);
		g.addEdage(2, 3);
		System.out.println("顶点数　" + g.V());
		System.out.println("边数　" + g.E());
		System.out.println("相邻的顶点数　" + g.adj(0));
		System.out.println("度数　" + degree(g, 0));
		System.out.println("最大度数　" + maxDegree(g));
		System.out.println("自环的个数　" + numberOfSelfLoops(g));
		System.out.println("连通的顶点");
		search(g, 1);
		System.out.println("");
		System.out.println("深度路径");
		Paths path = new Paths(g, 3);
		List<Integer> pathTo = path.pathTo(0);
		if (pathTo != null) {
			Iterator<Integer> iterator = pathTo.iterator();
			while (iterator.hasNext()) {
				Integer next = iterator.next();
				System.out.println(next);
			}
		}
		System.out.println("广度路径");
		BreadthFirstPaths bfs = new BreadthFirstPaths(g, 3);
		List<Integer> bfsPathTo = bfs.pathTo(0);
		if (bfsPathTo != null) {
			Iterator<Integer> iterator2 = bfsPathTo.iterator();
			while (iterator2.hasNext()) {
				Integer next = iterator2.next();
				System.out.println(next);
			}
		}
		System.out.println("查看有连通分量");
		CC cc = new CC(g);
		int count = cc.count();
		System.out.println("看图有几个连通分量" + count);
	}
}

class BreadthFirstPaths {

	private boolean marked[];
	private int edgeTo[];
	private int s;

	BreadthFirstPaths(Graph g, int v) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.s = v;
		bfs(g, v);
	}

	private void bfs(Graph g, int v) {
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		queue.add(v);
		marked[v] = true;
		while (!queue.isEmpty()) {
			Integer w = queue.poll();
			List<Integer> adj = g.adj(w);
			for (int e : adj) {
				if (!marked[e]) {
					marked[e] = true;
					edgeTo[e] = w;
					queue.add(e);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public List<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}

		Stack<Integer> path = new Stack<Integer>();
		// 迭代
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}

class DepthFitstSearch {

	private boolean[] marked;
	private int count;

	public DepthFitstSearch(Graph g, int v) {
		marked = new boolean[g.V()];
		dfs(g, v);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		count++;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
	}

	public boolean marked(int w) {
		return marked[w];
	}

	public int count() {
		return count;
	}

	public boolean[] getMarked() {
		return marked;
	}

	public void setMarked(boolean[] marked) {
		this.marked = marked;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

class Paths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	Paths(Graph g, int s) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.s = s;
		dfs(g, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public List<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}

		Stack<Integer> path = new Stack<Integer>();
		// 迭代
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);

		return path;
	}

	boolean hasPathTo() {
		return true;
	}
}

class CC {
	public boolean[] marked;
	private int[] id;
	private int count;

	public CC(Graph g) {
		marked = new boolean[g.V()];
		id = new int[g.V()];
		for (int s = 0; s < g.V(); s++) {
			if (!marked[s]) {
				dfs(g, s);
				count++;
			}
		}
	}

	private void dfs(Graph g, int s) {
		marked[s] = true;
		for (int w : g.adj(s)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count++;
	}
}

class Node {
	List<Integer> vlist = new ArrayList<Integer>();

	public void add(int w) {
		vlist.add(w);
	}

	public List<Integer> getVlist() {
		return vlist;
	}

	public void setVlist(List<Integer> vlist) {
		this.vlist = vlist;
	}
}