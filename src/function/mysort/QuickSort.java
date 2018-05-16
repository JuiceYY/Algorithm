package function.mysort;

/**
 * Created by 12694 on 18-5-16.
 */
public class QuickSort extends MySort {

    public static void sort(Comparable[] a){
        //统一对外接口
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int low, int high){
        if(high <= low) return;

        int flagIdx = partition(a, low, high);
        sort(a, low, flagIdx-1);
        sort(a, flagIdx+1, high);

    }

    private static int partition(Comparable [] a, int low, int high){
        //返回切分中间位置
        Comparable flag = a[low];
        int i = low, j = high+1;
        while(true){
            while(less(a[++i], flag)){
                if(i == high){
                    break;
                }
            }
            while(less(flag, a[--j])){
                if(j == low){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j; //i==j +1
    }

}
