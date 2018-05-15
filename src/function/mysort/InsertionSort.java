package function.mysort;

/**
 * Created by 12694 on 18-5-15.
 */
public class InsertionSort extends MySort{
    public static void sort(Comparable[] a){
        int n = a.length;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a,j,j-1);
            }
        }
    }
}
