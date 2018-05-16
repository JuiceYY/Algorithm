package function.mysort;

/**
 * Created by 12694 on 18-5-16.
 */
public class MergeSort extends MySort {

    private static Comparable[] tmp;

    public static void sort(Comparable[] a){
        //统一对外接口
        tmp = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int low, int high){
        if(high <= low) return;
        int mid = (low+high)/2;
        sort(a, low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);
    }

    private static void merge(Comparable[] a, int low, int mid, int high){
        //先把要排序的数组存入临时数组
        for(int i= low; i<=high; i++){
            tmp[i] = a[i];
        }

        int i = low, j = mid+1;
//        while(i <= mid && j <= high){
//            if(less(tmp[i], tmp[j])){
//                a[idx++] = tmp[i++];
//            }else{
//                a[idx++] = tmp[j++];
//            }
//        }
//        while (i <= mid){
//            a[idx++] = tmp[i++];
//        }
//        while (j <= high){
//            a[idx++] = tmp[j++];
//        }

        for(int idx = low; idx <= high; idx++){
            if(i > mid) a[idx] = tmp[j++];
            else if(j > high) a[idx] = tmp[i++];
            else if(less(tmp[j], tmp[i])) a[idx] = tmp[j++];
            else a[idx] = tmp[i++];
        }
    }
}
