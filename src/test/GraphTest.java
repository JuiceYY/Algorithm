package test;

import function.graph.DepthFirstPaths;
import function.graph.Graph;

import java.util.Scanner;

/**
 * Created by 12694 on 18-5-19.
 */
public class GraphTest {
    //图论算法测试

    public static Graph graph;

    public static void testDFSPath(int v, int w){
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, v);
        System.out.println("从v到w的一条可行路径为");
        for(int path : depthFirstPaths.pathTo(w)){
            System.out.print(path + " <- ");
        }
    }

    public static void main(String[] args) {
        System.out.println("输入图，先输入顶点数和边数，再输入每条边：");
        Scanner reader = new Scanner(System.in);
        graph = new Graph(reader);
        System.out.println("dfs求图中路径，输入起点和终点：");
        int v, w;
        v = reader.nextInt();
        w = reader.nextInt();
        reader.close();

        testDFSPath(v,w);
    }

}
