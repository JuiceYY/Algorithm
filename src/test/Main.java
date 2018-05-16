package test;

import function.mysort.SelectionSort;
import function.mysort.SortCompare;

import java.util.Scanner;

/**
 * Created by 12694 on 18-5-14.
 */
public class Main {

    private static Obj[] cobj;

    private static void showAndCompare(String alg, Obj[] a){
        //如果传接口，怎么让传的接口参数可以直接show()?
        double totleTime = SortCompare.customInputTime(alg, a);
        for(int i = 0; i < a.length; i++){
            a[i].show();
        }
        System.out.println();
        System.out.println(alg + " wastes " + totleTime + " m.");
    }


    public static void main(String[] args) {

        int n;
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        Obj[] obj = new Obj[n];
        for(int i = 0; i < n; i++){
            Obj t = new Obj();
            t.setData(reader.nextInt());
            obj[i] = t;
        }
        reader.close();
//        SelectionSort.sort(obj);
//        for(int i = 0; i < n; i++){
//            obj[i].show();
//        }
//        System.out.println();

        cobj = new Obj[obj.length];
        String[] algs = {"QuickSort", "MergeSort", "SelectionSort", "InsertionSort"};
        for (String alg : algs){
            //这里要对需要排序的数组做一个深拷贝, 可以实现Cloneable接口
//            Obj[] cobj = new Obj[n];
            for(int i = 0; i < obj.length; i++){
                cobj[i] = new Obj();
                cobj[i].setData(obj[i].getData());
            }
            showAndCompare(alg, cobj);
        }
    }
}
