package Library.task4_2;

import Library.task3_1.Book;
import Library.task3_2.ScientificBook;
import Library.task4_1.ScientificLibraryHall;
import Library.task5_3.IHall;


public class Node2 {
    private IHall data2;
    private Node2 next2;
    private Node2 prev2;


    public Node2(){
        super();
        next2 = null;
        prev2 = null;
    }

    public Node2(IHall data){
        this.data2 = data;
        next2 = null;
    }

    public Node2(IHall data,Node2 prev, Node2 next){
        this.data2 = data;
        this.next2 = next;
        this.prev2 = prev;
    }

    public Node2 getNext2() {
        return next2;
    }

    public void setNext2(Node2 next) {
        this.next2 = next;
    }

    public Node2 getPrev2() {
        return prev2;
    }

    public void setPrev2(Node2 prev) {
        this.prev2 = prev;
    }

    public IHall getData2() {
        return data2;
    }

    public void setData2(IHall data2) {
        this.data2 = data2;
    }

    public void displayNode2Data() {
        System.out.println( data2.getNameHall() +  " -> ");
    }
}
