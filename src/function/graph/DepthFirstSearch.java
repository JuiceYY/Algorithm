package function.graph;

/**
 * Created by 12694 on 18-5-18.
 */
public class DepthFirstSearch {

    private boolean[] marked;//标记每个顶点的状态
    private int count;
    private int s;//起点

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getCount() {
        return count;
    }

    public  DepthFirstSearch(Graph graph, int s){
        //已图graph和起点s构造dfs对象
        marked = new boolean[graph.getNv()];//分配数组空间
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        count ++;
        for(int w: graph.getAdjV(v)){
            if(! marked[w]){
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int w){
        //判断w与v是否连通
        return true;
    }

    public int countNv(){
        //返回连通子图中点的个数
        return count;
    }
}
