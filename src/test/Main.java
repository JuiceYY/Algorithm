package test;

import function.mysort.SelectionSort;

import java.util.Scanner;

/**
 * Created by 12694 on 18-5-14.
 */
public class Main {
    public static void main(String[] args) {

        int n;
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        Test[] test = new Test[n];
        for(int i = 0; i < n; i++){
            Test t = new Test();
            t.setData(reader.nextInt());
            test[i] = t;
        }
        reader.close();
        SelectionSort.sort(test);
        for(int i = 0; i < n; i++){
            test[i].show();
        }
        System.out.println();

    }
}
