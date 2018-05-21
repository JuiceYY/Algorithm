package function.linearity;

import java.util.Iterator;

/**
 * Created by 12694 on 18-5-21.
 */
public class MyList<T> implements Iterable<T> {
    /*可迭代对象需实现Iterable<Item>接口，重写iterator方法并返回一个迭代器Iterator<Item>
     *迭代器是一个实现了hasNext()和next()方法的类的对象，由Iterator<Item>接口定义
     *Iterator接口有三个方法，hasNext(), next(), remove();
     */
    //java不允许创建泛型数组

    private class Node{
        T t;
        Node next;
        Node front;
    }

    private Node list;
    private Node last;
    private int n;

    public MyList(T t){
        this.list = null;
        this.last = null;
        this.n = 0;
    }

    public boolean isEmpty(){
        return list == null;
    }

    public int size(){
        return n;
    }

    public void append(T t){
        if(n == 0){
            Node node = new Node();
            node.t = t;
            this.list = node;
            this.last = node;
            list.next = null;
            this.n++;
        }else{
            Node node = new Node();
            node.t = t;
            node.front = last;
            this.last.next = node;
            this.last = node;
            this.n++;
        }
    }

    public void insert(int index, T t) throws Exception{
        if(index > n+1 || index < 1) {
            throw new IndexOutOfBoundsException();
        }else{
            Node p = list;
            Node newnode = new Node();
            newnode.t = t;
            for(int i = 0; i < index; i++){
                p = p.next;
            }
            newnode.front = p.front;
            newnode.next = p.next;
            p.front.next = newnode;
            p.next.front = newnode;
            this.n++;
        }
    }

    public void remove() throws NullPointerException{
        //无参数删除最后一个元素
        if(n == 0){
            throw new NullPointerException();
        }else{
            last.front.next = null;
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        //删除指定位置元素
        if(index < 1 || index > n){
            throw new IndexOutOfBoundsException();
        }else{
            Node p = list;
            for(int i = 0; i < index ;i++){
                p = p.next;
            }
            p.front.next = p.next;
            p.next.front = p.front;
            this.n --;
        }
    }

    public void remove(T t){
        //删除指定内容的元素（从开始查找的第一个）
        Node p = list;
        for(int i = 0; i < n; i++){
            if(p.t.equals(t)){
                remove(i+1);
                this.n--;
            }
            p = p.next;
        }
    }

    public void clear(){
        list = null;
        last = null;
        n = 0;
    }

    public T get(int index) throws IndexOutOfBoundsException{
        //返回第index个元素
        if(index < 1 || index > n){
            throw new IndexOutOfBoundsException();
        }
        Node p = list;
        for(int i = 1; i < index; i++){
            p = p.next;
        }
        return p.t;
    }

    public int indexOf(T t){
        //返回首次出现指定元素的位置
        Node p = list;
        for(int i = 0; i < n ;i++){
            if(p.t.equals(t)){
                return i+1;
            }
        }
        return -1;
    }

    private class MyListIterator implements Iterator<T> {

        private Node current = list;
        public boolean hasNext(){
            return current.next != null;
        }
        public T next(){
            T t = current.t;
            current = current.next;
            return t;
        }
        public void remove(){
            //留空
        }
    }

    public Iterator<T> iterator(){
        return new MyListIterator();
    }

}
