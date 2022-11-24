package Library.task4_1;

import Library.task3_2.ScientificBook;
import Library.task5_2.IBook;

public class Node{
    private IBook data;
    private Node next;

    public Node(){
        super();
        next = null;
    }

    public Node(IBook data){
        this.data = data;
        next = null;
    }

    public Node(IBook data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public IBook getData() {
        return data;
    }

    public void setData(IBook data) {
        this.data = data;
    }

    public void displayNodeData() {
        System.out.println( data.getAuthor() + " "+data.getName() + " "
                + data.getYear() +  " -> ");
    }


}
