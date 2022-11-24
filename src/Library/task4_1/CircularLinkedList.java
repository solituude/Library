package Library.task4_1;


import Library.task3_2.ScientificBook;
import Library.task5_2.IBook;

public class CircularLinkedList {
    private Node head; // ссылка на голову
    int countElem = 0; // количество элементов

    public CircularLinkedList(){
        head = new Node();
    }

    public Node getHead() {return head;}


    public void insertFirst(IBook data) {
        Node newNode = new Node();
        newNode.setData(data);

        if (isEmpty()){newNode.setNext(head);}
        else{newNode.setNext(head.getNext());}
        head.setNext(newNode);
        this.countElem++;
    }


    // Метод, возвращающий ссылку на элемент по номеру:
    public IBook getElem(int num){
        if(isEmpty() && num > countElem) {
            return null;
        }
        Node curr = head.getNext();
        int count = 0;
        while (count != num && curr != head){
            count++;
            curr = curr.getNext();
        }
        return curr.getData();
    }

    // Метод изменения элемента по номеру
    public IBook setElem(int num, IBook newData){
        if(isEmpty() && num > countElem) {
            return null;
        }
        Node curr = head.getNext();
        int count = 0;
        while (count != num && curr != head){
            count++;
            curr = curr.getNext();
        }
        curr.setData(newData);
        return curr.getData();

    }


    public boolean isEmpty(){return head.getNext() == null;}

    // Метод, возвращающий количество элементов
    public int CountElem(){
        if(isEmpty()) { return 0; }
        Node curr = head.getNext();
        int count = 0;
        while (curr != head){
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    // Метод добавление элемента по заданному номеру
    public boolean addElem(IBook newBook, int num){
        if (isEmpty() && num > countElem){return false;}
        if (num == 0){
            Node tempNode = head.getNext();
            head.setNext(new Node(newBook, tempNode));
            this.countElem++;
        }
        else {
            Node currNode = head.getNext();
            int currCount = 0;
            while (currCount < num - 1 && currNode.getNext() != head) {
                currNode = currNode.getNext();
                currCount++;
            }
            if (currCount == num-1){
                currNode.setNext(new Node(newBook, currNode.getNext()));
                this.countElem++;
            }
            else {return false;}
        }
        return true;
    }

    // Метод удаления элемента по заданному номеру
    public boolean delElem(int num){
        if (isEmpty() && num > countElem){return false;}
        if (num == 0){
            Node delNode = head.getNext();
            head.setNext(delNode.getNext());
            delNode.setNext(null);
            this.countElem--;
        }
        else {
            Node currNode = head.getNext();
            int currCount = 0;
            while (currCount < num - 1 && currNode.getNext() != head) {
                currNode = currNode.getNext();
                currCount++;
            }
            if (currCount == num-1){
                Node delNode = currNode.getNext();
                currNode.setNext(delNode.getNext());
                delNode.setNext(null);
                countElem--;
            }
            else {return false;}
        }
        return true;
    }

    public void delAll(){
        while (countElem > 0){
            Node delNode = head.getNext();
            head.setNext(delNode.getNext());
            delNode.setNext(null);
            this.countElem--;
        }
        head = null;

    }

    public void printLinkedList() {
        Node current = head.getNext();
        while (current != head) {
            current.displayNodeData();
            current = current.getNext();
        }
    }
}


class Lab4{
    public static void main(String[] args) {
        ScientificBook book1 = new ScientificBook();
        Node node1 =  new Node(book1);

        ScientificBook book2 = new ScientificBook("fdsjf", 2013);
        Node node2 = new Node(book2);

        ScientificBook book3 = new ScientificBook("fffffff", 568);
        Node node3 = new Node(book3);

        ScientificBook newBook = new ScientificBook("AAAAAAAAAA", 568);


        CircularLinkedList linkedList = new CircularLinkedList();

        linkedList.insertFirst(book1); // ok
        linkedList.insertFirst(book2); // ok
        linkedList.insertFirst(book3); // ок
        linkedList.printLinkedList();
        System.out.println(linkedList.CountElem()); // 3
        System.out.println(linkedList.getHead().getNext().getNext().getNext().getNext().getNext().getData().getAuthor()); // fffffff
        System.out.println(linkedList.getElem(1).getAuthor()); // fdsjf
        System.out.println(linkedList.getElem(5)); // null
        System.out.println("\nAdd new element ");
        System.out.println(linkedList.addElem(newBook, 0));
        linkedList.printLinkedList();

        System.out.println("\nAdd new element ");
        System.out.println(linkedList.addElem(newBook, 3));
        linkedList.printLinkedList();

        System.out.println("\nAdd new element ");
        System.out.println(linkedList.addElem(newBook, 5));
        linkedList.printLinkedList();

        System.out.println("\nAdd new element ");
        System.out.println(linkedList.addElem(newBook, 7));
        linkedList.printLinkedList();


        System.out.println("\nDelete new element ");
        System.out.println(linkedList.delElem(1));
        linkedList.printLinkedList();

        System.out.println("\nDelete new element ");
        System.out.println(linkedList.delElem(0));
        linkedList.printLinkedList();

        System.out.println("\nDelete new element ");
        System.out.println(linkedList.delElem(3));
        linkedList.printLinkedList();

        System.out.println("\nDelete new element ");
        System.out.println(linkedList.delElem(5));
        linkedList.printLinkedList();
        System.out.println();

        linkedList.delAll();
        System.out.println(linkedList.countElem);
    }
}


