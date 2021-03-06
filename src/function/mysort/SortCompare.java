package function.mysort;

/**
 * Created by 12694 on 18-5-15.
 */
public class SortCompare {

//    private static String[] algs = {"SelectionSort", "InsertionSort", "MergeSort", "QuickSort"};

    public static double time(String alg, Comparable[] a){
        long startTime = System.nanoTime();
        if(alg.equals("SelectionSort")) SelectionSort.sort(a);
        else if(alg.equals("InsertionSort")) InsertionSort.sort(a);
        else if(alg.equals("QuickSort"))  QuickSort.sort(a);
        else if(alg.equals("MergeSort")) MergeSort.sort(a);
        else System.out.println("请在SortCompare.time()中添加排序");
        long endTime = System.nanoTime();
        return (double) (endTime-startTime) /1000000000;
    }

    public static double randomInputTime(String alg, int n, int t){
        //t组数据，每组数据n个数

        Double[] a = new Double[n];
        double totle = 0.0;
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
//        String alg1 = args[0];
//        String alg2 = args[1];
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        String[] algs = {"SelectionSort", "InsertionSort", "MergeSort", "QuickSort"};

        Double[] ts = new Double[algs.length];
        System.out.println("For " + n + " random numbers: ");
        for(int i = 0; i < algs.length; i++){
            ts[i] = randomInputTime(algs[i], n, t);
            System.out.println(algs[i] + " wastes " + ts[i]/t + " m; ");
        }

    }
}
