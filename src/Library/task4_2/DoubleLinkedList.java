package Library.task4_2;

import Library.task3_2.ScientificBook;
import Library.task4_1.ScientificLibraryHall;
import Library.task5_3.IHall;

public class DoubleLinkedList {
    private Node2 head2; // ссылка на голову
    int countElem = 0; // количество элементов

    DoubleLinkedList(){
        head2 = new Node2();
    }

    public Node2 getHead2() {return head2;}


    public void insertFirst2(IHall data) {  // ok
        Node2 newNode = new Node2();
        newNode.setData2(data);

        if (isEmpty2()){
            newNode.setNext2(head2);
            newNode.setPrev2(head2);
        }
        else{
            newNode.setNext2(head2.getNext2());
            newNode.setPrev2(head2);
        }
        head2.setNext2(newNode);
        this.countElem++;
    }


    // Метод, возвращающий ссылку на элемент по номеру:
    public  IHall getElem2(int num){  // ok
        if(isEmpty2() && num > countElem) {
            return null;
        }
        Node2 curr = head2.getNext2();
        int count = 0;
        while (count != num && curr != head2){
            count++;
            curr = curr.getNext2();
        }
        return curr.getData2();
    }

    // Метод изменения элемента по номеру
    public  IHall setElem2(int num,  IHall newData){  // ok
        if(isEmpty2() && num > countElem) {
            return null;
        }
        Node2 curr = head2.getNext2();
        int count = 0;
        while (count != num && curr != head2){
            count++;
            curr = curr.getNext2();
        }
        curr.setData2(newData);
        return curr.getData2();

    }


    public boolean isEmpty2(){return head2.getNext2() == null;}

    // Метод, возвращающий количество элементов (OK)
    public int CountElem2(){
        if(isEmpty2()) { return 0; }
        Node2 curr = head2.getNext2();
        int count = 0;
        while (curr != head2){
            count++;
            curr = curr.getNext2();
        }
        return count;
    }

    // Метод добавление элемента по заданному номеру
    public boolean addElem2(IHall newBook, int num){
        if (isEmpty2() && num > countElem){return false;}

        if (num == 0){
            Node2 tempNode = head2.getNext2();
            Node2 newNode = new Node2(newBook, head2, tempNode);
            head2.setNext2(newNode);
            tempNode.setPrev2(newNode);
            this.countElem++;
        }
        else {
            Node2 currNode = head2.getNext2();
            int currCount = 0;
            while (currCount < num - 1 && currNode.getNext2() != head2) {
                currNode = currNode.getNext2();
                currCount++;
            }
            if (currCount == num-1){
                Node2 newNode = new Node2(newBook, currNode, currNode.getNext2());
                currNode.getNext2().setPrev2(newNode);
                currNode.setNext2(newNode);
                this.countElem++;
            }
            else {return false;}
        }
        return true;
    }

    // Метод удаления элемента по заданному номеру (OK)
    public boolean delElem2(int num){
        if (isEmpty2() && num > countElem){return false;}
        if (num == 0){
            Node2 delNode = head2.getNext2();
            head2.setNext2(delNode.getNext2());
            delNode.getNext2().setPrev2(head2);
            delNode.setNext2(null);
            delNode.setPrev2(null);
            this.countElem--;
        }
        else {
            Node2 currNode = head2.getNext2();
            int currCount = 0;
            while (currCount < num - 1 && currNode.getNext2() != head2) {
                currNode = currNode.getNext2();
                currCount++;
            }
            if (currCount == num-1){
                Node2 delNode = currNode.getNext2();
                delNode.getNext2().setPrev2(currNode);
                currNode.setNext2(delNode.getNext2());
                delNode.setNext2(null);
                delNode.setPrev2(null);
                countElem--;
            }
            else {return false;}
        }
        return true;
    }

    public void delAll2(){
        while (countElem > 0){
            Node2 delNode = head2.getNext2();
            delNode.getNext2().setPrev2(head2);
            head2.setNext2(delNode.getNext2());
            delNode.setNext2(null);
            delNode.setPrev2(null);
            this.countElem--;
        }
        head2.setPrev2(null);
        head2.setNext2(null);

    }

    public void printDoubleLinkedList() {  //ok
        Node2 current = head2.getNext2();
        while (current != head2) {
            current.displayNode2Data();
            current = current.getNext2();
        }
    }
}


class Lab4{
    public static void main(String[] args) {
        ScientificBook lib1Book1 = new ScientificBook("author11","name11", 879, 2000, 6);
        ScientificBook lib1Book2 = new ScientificBook("author12","name12", 120, 2003, 6);


        ScientificBook lib2Book1 = new ScientificBook("author21","name21", 79, 2000, 16);
        ScientificBook lib2Book2 = new ScientificBook("author22","name22", 120, 2003, 16);
        ScientificBook lib2Book3 = new ScientificBook("author23","name23", 156, 1994, 16);
        ScientificBook lib2Book4 = new ScientificBook("author24","name24", 1959, 1963, 16);

        ScientificBook lib3Book1 = new ScientificBook("author31","name31", 8879, 2000, 12);
        ScientificBook lib3Book2 = new ScientificBook("author32","name32", 1230, 2003, 16);
        ScientificBook lib3Book3 = new ScientificBook("author33","name33", 156, 1994, 6);


        ScientificBook[] Lib1Hall1ArrBooks = new ScientificBook[]{lib1Book1, lib1Book2};
        ScientificBook[] Lib1Hall2ArrBooks = new ScientificBook[]{lib2Book1, lib2Book2, lib2Book3, lib2Book4};
        ScientificBook[] Lib1Hall3ArrBooks = new ScientificBook[]{lib3Book1, lib3Book2, lib3Book3};

        ScientificLibraryHall Lib1Hall1 = new  ScientificLibraryHall("hall1", Lib1Hall1ArrBooks);
        ScientificLibraryHall Lib1Hall2 = new  ScientificLibraryHall("hall2", Lib1Hall2ArrBooks);
        ScientificLibraryHall Lib1Hall3 = new  ScientificLibraryHall("hall3", Lib1Hall3ArrBooks);

        DoubleLinkedList list = new DoubleLinkedList();
        list.insertFirst2(Lib1Hall1);
        list.insertFirst2(Lib1Hall2);
        list.insertFirst2(Lib1Hall3);
        list.printDoubleLinkedList();
        System.out.println(list.getElem2(2)); // hall1
        System.out.println(list.getElem2(5)); // null
        list.insertFirst2(Lib1Hall3);
        System.out.println("\nList:");
        list.printDoubleLinkedList();
        list.setElem2(0, Lib1Hall1);
        System.out.println("\nUpdated list:");
        list.printDoubleLinkedList();
        System.out.println(list.CountElem2()); // 4
        list.addElem2(Lib1Hall3, 3);
        list.printDoubleLinkedList();
        list.delElem2(1);
        System.out.println();
        list.printDoubleLinkedList();
        list.delAll2();
        System.out.println(list.CountElem2()); // 0
    }
}
