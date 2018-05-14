package test;

/**
 * Created by 12694 on 18-5-14.
 */
public class Test implements Comparable<Test> {
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private int data;

    public int compareTo(Test test){
        if(this.data < test.getData()) return -1;
        else return 1;
    }

    public void show(){
        System.out.print(this.data+" ");
    }
}
