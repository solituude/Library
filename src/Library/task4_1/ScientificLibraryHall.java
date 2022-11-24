package Library.task4_1;
import Library.task3_2.ScientificBook;
import Library.task5_2.IBook;
import Library.task5_3.IHall;
import Library.task4_1.CircularLinkedList;

import java.util.Arrays;
import java.util.Objects;

public class ScientificLibraryHall extends ScientificBook implements IHall, Cloneable{
    private String nameHall;
    private int countBook;
    private CircularLinkedList SciBooks;

    /**Конуструктор принимающий имя зала и кол-во книг в зале*/
    public ScientificLibraryHall(String nameHall, int countBook){
        this.nameHall = nameHall;
        this.SciBooks = new CircularLinkedList();
        for (int i = 0; i < countBook; i++){
            ScientificBook book = new ScientificBook();
            SciBooks.insertFirst(book);
        }
        this.countBook = SciBooks.CountElem();
    }

    /**Конструктор принимающий имя зала и массив книг*/
    public ScientificLibraryHall(String nameHall, ScientificBook[] Books){
        this.nameHall = nameHall;
        this.countBook = Books.length;
        this.SciBooks = new CircularLinkedList();
        for (int i = 0; i < countBook; i++){
            SciBooks.insertFirst(Books[i]);
        }
        this.countBook = SciBooks.CountElem();
    }

    /**Геттер и сеттер имени зала*/
    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }


    // Метод получения количества книг в зале
    public int getCountBook(){
        return SciBooks.CountElem();
    }

    /**Метод, выводящий на экран список названий всех книг в зале*/
    public void getBooks(){
        System.out.println("All book's name:");
        for (int i = 0; i < SciBooks.CountElem(); i++){
            System.out.println(SciBooks.getElem(i).getName());
        }
    }

    /**получения	общей	стоимости	всех	книг	в	зале*/
    public double getCountPriceAll(){
        double sum = 0;
        for (int i = 0; i < SciBooks.CountElem(); i++){
            sum += SciBooks.getElem(i).getPrice();
        }
        return sum;
    }

    /**Метод получения книги по ее номеру в зале */
    public IBook getBook(int Number){
        if (Number <= SciBooks.CountElem()){
            return SciBooks.getElem(Number);
        }
        return null;
    }

    /**Метод изменения книги по ее номеру в зале*/
    public void setBook(int Number, IBook newData){
        if (Number <= SciBooks.CountElem()){
            SciBooks.setElem(Number, newData);
        }
    }

    // Метод добавления книги по номеру
    public void addBook(int num, IBook newBook){
        SciBooks.addElem(newBook, num);
        countBook++;
    }

    //Метод удаления книги по номеру
    public void delBook(int num){
        SciBooks.delElem(num);
        countBook--;
    }

    /**Метод возвращающий книгу с самой высокой стоимостью*/
    public IBook getBestBook(){
        double maxPrice = 0;
        int indexBestBook = 0;
        for (int i = 0; i < SciBooks.CountElem(); i++){
            if (SciBooks.getElem(i).getPrice() > maxPrice){
                maxPrice = SciBooks.getElem(i).getPrice();
                indexBestBook = i;
            }
        }
        return SciBooks.getElem(indexBestBook);
    }

//    public Object[] toArray() {
//        Object[] values = new Object[this.countBook];
//        int index = 0;
//        for (CircularLinkedList node = getHead().getNext(); node != this.head; node = node.getNext()) {
//            if (index == countBook)
//                break;
//            values[index] = node;
//            index++;
//        }
//        return values;
//    }

//    @Override
//    public String toString() {
//        return Arrays.toString(this.toArray());
//    }



//    @Override
//    public ScientificLibraryHall clone() {
//        ScientificLibraryHall hall = (ScientificLibraryHall) super.clone();
//        return hall;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        if (object == this)
//            return true;
//        else if (object == null || object.getClass() != getClass())
//            return false;
//        else {
//            ScientificLibraryHall book = (ScientificLibraryHall) object;
//            return book.getIndexCit() == getIndexCit() && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getName().equals(getName()) && book.getYear() == getYear();
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), countBook, nameHall);
//    }
//


    @Override
    public void setName(String name) {

    }

    @Override
    public void setAuthor(String author) {

    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public int getYear() {
        return 0;
    }

    @Override
    public void setYear(int year) {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public int getMinAge() {
        return 0;
    }

    @Override
    public void setMinAge(int minAge) {

    }
}

class Lab4_1{
    public static void main(String[] args) {
        ScientificBook lib1Book1 = new ScientificBook("author11","name11", 899, 2000, 12);
        ScientificBook lib1Book2 = new ScientificBook("author12","name12", 120, 2003, 16);
        ScientificBook lib1Book3 = new ScientificBook("author13","name13", 156, 1994, 6);
        ScientificBook lib1Book4 = new ScientificBook("author14","name14", 199, 1963, 16);
        ScientificBook lib1Book5 = new ScientificBook();
        ScientificBook lib1Book6 = new ScientificBook("author16", 2003);

        ScientificBook[] Lib1Hall1ArrBooks = new ScientificBook[]{lib1Book1, lib1Book2, lib1Book3, lib1Book4, lib1Book5,
                lib1Book6};


//        ScientificLibraryHall hall = new ScientificLibraryHall("lala", Lib1Hall1ArrBooks);
//        System.out.println(hall.getCountBook());
//        hall.getBooks();
//        System.out.println(hall.getCountPriceAll());
//        System.out.println(hall.getBook(3).getAuthor());
//        System.out.println(hall.getBook(15));
//        hall.setBook(0, lib1Book4);
//        System.out.println("\nNew list");
//        hall.getBooks();
//        hall.addBook(1, lib1Book1);
//        System.out.println("\nNew List:");
//        hall.getBooks();
//        hall.delBook(0);
//        System.out.println("\nNew List:");
//        hall.getBooks();
//        System.out.println("\nThe best book is");
//        System.out.println(hall.getBestBook().getAuthor() + " " + hall.getBestBook().getPrice());
        System.out.println(Arrays.toString(Lib1Hall1ArrBooks));
    }
}
