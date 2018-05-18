package function.graph;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by 12694 on 18-5-18.
 */
public class Graph {

    private int nv;
    private int ne;
    private ArrayList<Integer>[] adj;

    public int getNv() {
        return nv;
    }

    public void setNv(int nv) {
        this.nv = nv;
    }

    public int getNe() {
        return ne;
    }

    public void setNe(int ne) {
        this.ne = ne;
    }

    public Graph(int nv){
        //创建一个含有v个顶点不含有边的图,使用邻接表
        this.nv = nv;
        this.ne = 0;
        adj = new ArrayList[nv];
        for(int i = 0; i < nv; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public Graph(Scanner reader){
        //从Scanner读入一个图
        this.nv = reader.nextInt();
        this.ne = reader.nextInt();
        adj = new ArrayList[nv];
        for(int i = 0; i < nv; i++){
            adj[i] = new ArrayList<Integer>();
        }
        int v, w;
        for(int i = 0; i < ne; i++){
            v = reader.nextInt();
            w = reader.nextInt();
            addEdge(v,w);
            ne--;
        }
    }

    public Graph(String file){
        //从文件中读入一张图

    }

    public void addEdge(int v, int w){
        //向图中添加一条边v-w
        adj[v].add(w);
        adj[w].add(v);
        ne++;
    }

    public Iterable<Integer> getAdjV(int v){
        //和v相邻的所有顶点
        //实现Iterable接口允许对象成为foreach语句的目标

        return adj[v];
    }

    public String toString(){
        //顶点对象的字符串表示
        return null;
    }

    public static int degree(Graph graph, int v){
        //返回v的度数
        int degree = 0;
        for(int w : graph.getAdjV(v)){
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph graph){
        //计算所有顶点的最大度数
        int max = 0;
        for(int v = 0; v < graph.getNv(); v++){
            if(degree(graph,v) > max){
                max = degree(graph, v);
            }
        }
        return max;
    }

    public static double avgDegree(Graph graph){
        //计算所有顶点的平均度数
        double sum = 0.0;
        for(int v = 0; v < graph.getNv(); v++){
            sum += degree(graph, v);
        }
        return sum/graph.getNv();
    }

    public static int numberOfSelfLoops(Graph graph){
        //计算自环的个数
        int count = 0;
        for(int v = 0; v < graph.getNv(); v++){
            for(int w : graph.getAdjV(v)){
                if(v == w){
                    count ++;
                }
            }
        }
        return count;
    }

}
