package function.mysort;

/**
 * Created by 12694 on 18-5-15.
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a){
        long startTime = System.nanoTime();
        if(alg.equals("SelectionSort")) SelectionSort.sort(a);
        if(alg.equals("InsertionSort")) InsertionSort.sort(a);
        long endTime = System.nanoTime();
        return (double) (endTime-startTime) /1000000000;
    }

    public static double randomInputTime(String alg, int n, int t){
        //t组数据，每组数据n个数
        double totle = 0.0;
        Double[] a = new Double[n];
        for(int i = 0; i < t; i++){
            for(int j = 0; j < n; j++){
                a[j] = Math.random();
            }
            totle += time(alg,a);
        }
        return totle;
    }

    public static double customInputTime(String alg, Comparable[] a){
        //自定义数据算法时间比较
        double totle = 0.0;
        totle += time(alg, a);
        return totle;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int t = Integer.parseInt(args[3]);
        double t1 = randomInputTime(alg1,n,t);
        double t2 = randomInputTime(alg2, n, t);
        System.out.println("For " + n + " random doubles");
        System.out.println(alg1 + " wastes " + t1 + " m; while "+ alg2 + " wastes " + t2 + " m.");
    }
}
