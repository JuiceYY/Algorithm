package function.graph;

import java.util.Stack;

/**
 * Created by 12694 on 18-5-18.
 */
public class DepthFirstPaths {
    //dfs查找图中的路径
    private boolean[] marked;
    private int[] edgeTo;//edgeTo[w]为从起点到w的路径上w之前的顶点
    private int s;
    private int count;//路径上点的个数

    public DepthFirstPaths(Graph graph, int s){
        marked = new boolean[graph.getNv()];
        edgeTo = new int[graph.getNv()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        for(int w : graph.getAdjV(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        //marked数组为true的索引为graph与s的同一个连通子图
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            //不存在路径时返回null
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
