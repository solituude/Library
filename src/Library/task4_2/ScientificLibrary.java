package Library.task4_2;


import Library.task3_2.ScientificBook;
import Library.task4_1.ScientificLibraryHall;
import Library.task5_1.BookIndexOutOfBoundsException;
import Library.task5_2.IBook;
import Library.task5_3.IHall;
import Library.task5_4.ILibrary;
import java.util.Arrays;
import java.util.Objects;

public class ScientificLibrary implements Cloneable{
    private int countHalls; // количество залов всего
    private int[] countBooksInHalls;
    private DoubleLinkedList library;

    /**Конструктор принимающий количество залов и массив количеств книг по залам*/
    public ScientificLibrary(int countHalls, int[] countBooksInHalls){
        this.countHalls = countHalls;
        this.library = new DoubleLinkedList();
        for (int i = 0; i < countHalls; i++){
            ScientificLibraryHall hall = new ScientificLibraryHall("not defined", countBooksInHalls[i]);
            library.insertFirst2(hall);
        }
    }

    /**Конструктор, принимающий массив залов*/
    public ScientificLibrary(ScientificLibraryHall[] ScientificLibAllHalls){
        this.countHalls = ScientificLibAllHalls.length;
        this.library = new DoubleLinkedList();
        int[] countBooksInHalls = new int[ScientificLibAllHalls.length];
        for (int i = 0; i < ScientificLibAllHalls.length; i++){
            library.insertFirst2(ScientificLibAllHalls[i]);
        }
        this.countBooksInHalls = countBooksInHalls;
        this.countHalls = countBooksInHalls.length;
    }

    /*Метод получения количества залов*/
    public int getCountHalls(){
        return countHalls;
    }

    /*Метод получения количества книг*/
    public int getCountBooks(){
        int ans = 0;
        for (int i = 0; i < countHalls; i++){
            ans += library.CountElem2();
        }
        return ans;
    }

    /*Метод получения суммы всех книг в библиотеке*/
    public double getSumAllBooks(){
        double ans = 0;
        for (int i = 0; i < countHalls; i++){
            ans += library.getElem2(i).getCountPriceAll();
        }
        return ans;
    }

    /*Метод получения массива залов библиотеки*/
    public DoubleLinkedList getChildrenLibAllHalls() {
        return library;
    }

    /*Метод получения объекта зала по его номеру в бибилиотеке*/
    public IHall getHall(int index){
        if (index < countHalls){
            return library.getElem2(index);
        }
        else{
            return null;
        }
    }

    /*Метод получения объекта книги по его номеру в библиотеке*/
    public IBook getBook(int number) throws BookIndexOutOfBoundsException {
        if (number < getCountBooks()) {
            int indexHall = 0;
            int indexBook = 0;
            int count = 0;
            for (int i = 0; i < countHalls; i++) {
                for (int j = 0; j < library.getElem2(i).getCountBook(); j++) {
                    if (count != number) {
                        count++;
                    } else {
                        return library.getElem2(i).getBook(j);
                    }
                }
            }
        }
        return null;
    }


    /*Метод получения отсортированного по убыванию цены массива книг библиотеки*/
    public IHall sortHall(IHall currHall) throws BookIndexOutOfBoundsException {
        for (int i = 0; i < currHall.getCountBook(); i++){
            for (int j = 1; j < currHall.getCountBook(); j++){
                if (currHall.getBook(i).getPrice() < currHall.getBook(j).getPrice()){
                    IBook temp = currHall.getBook(i);
                    currHall.setBook(i, currHall.getBook(j));
                    currHall.setBook(j, temp);
                }
            }
        }
        return currHall;
    }


    /*Метод, выводящий на экран список названий всех залов с колчеством книг в них*/
    public void printAllNameHallWithCountBooks(){
        for (int i = 0; i < countHalls; i++){
            System.out.println(library.getElem2(i).getNameHall() + " " + library.getElem2(i).getCountBook());
        }
    }

    /*Метод замены зала по его номеру на другой*/
    public void changeHall(int indexHall, IHall newHall){
        if (indexHall < countHalls){
            library.setElem2(indexHall, newHall);
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод замены книги по ее номеру на другую*/
    public void changeBook(int number, IBook newBook) throws BookIndexOutOfBoundsException {
        if (number < getCountBooks()) {
            int indexHall = 0;
            int indexBook = 0;
            int count = 0;
            for (int i = 0; i < countHalls; i++) {
                for (int j = 0; j < library.getElem2(i).getCountBook(); j++) {
                    if (count != number) {
                        count++;
                    } else {
                        library.getElem2(i).setBook(count, newBook);
                    }
                }
            }
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод добавления книги в библиотеку по ее номеру в библиотеке*/
    public void addBookInLib(int indexInLib, ScientificBook newBook){
        if (indexInLib < getCountBooks()) {
            int countInd = 0;
            for (int i = 0; i < countHalls; i++) {
                if (indexInLib <= countInd + library.getElem2(i).getCountBook()){
                    countBooksInHalls[i]++;
                    library.getElem2(i).addBook(indexInLib - countInd, newBook);
                    break;
                }
                countInd += library.getElem2(i).getCountBook();
            }
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод удаления книги по ее номеру в библиотеке*/
    public void delBookInLib(int indexInLib) throws BookIndexOutOfBoundsException {
        if (indexInLib < getCountBooks()) {
            int countInd = 0;
            for (int i = 0; i < countHalls; i++) {
                if (indexInLib <= countInd + library.getElem2(i).getCountBook()){
                    countBooksInHalls[i]--;
                    library.getElem2(i).delBook(indexInLib - countInd);
                    break;
                }
                countInd += library.getElem2(i).getCountBook();
            }
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод получение самой лучшей книги в библиотеке (с самой большой ценой)*/
    public IBook getBestBookInLib(){
        IBook best = new ScientificBook();
        double maxPrice = 0;
        for (int i = 0; i < countHalls; i++){
            if (maxPrice < library.getElem2(i).getBestBook().getPrice()){
                maxPrice = library.getElem2(i).getBestBook().getPrice();
                best = library.getElem2(i).getBestBook();
            }
        }
        return best;
    }



}

class Lab4_2{
    public static void main(String[] args) throws BookIndexOutOfBoundsException {
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

        ScientificLibraryHall Lib1Hall1 = new ScientificLibraryHall("6+", Lib1Hall1ArrBooks);
        ScientificLibraryHall Lib1Hall2 = new ScientificLibraryHall("16+", Lib1Hall2ArrBooks);
        ScientificLibraryHall Lib1Hall3 = new ScientificLibraryHall("All ages", Lib1Hall3ArrBooks);

        ScientificLibraryHall[] lib1 = new ScientificLibraryHall[]{Lib1Hall1, Lib1Hall2, Lib1Hall3};
        ScientificLibrary lib = new ScientificLibrary(lib1);

        System.out.println(lib.getCountHalls());  // 3

        System.out.println(lib.getCountBooks());  // 9
        System.out.println(lib.getSumAllBooks());  // 13578

        System.out.println(lib.getHall(1).getNameHall()); // 16+
        System.out.println(lib.getHall(5));  // null
        System.out.println(lib.getBook(5).getName()); // name24
        System.out.println(lib.getBook(25));  // null

        System.out.println("\nAll halls with name and count books");
        lib.printAllNameHallWithCountBooks();

        ScientificBook lib4Book1 = new ScientificBook("author41","name41", 8879, 2000, 12);
        ScientificBook lib4Book2 = new ScientificBook("author42","name42", 1230, 2003, 16);
        ScientificBook lib4Book3 = new ScientificBook("author43","name43", 156, 1994, 6);
        ScientificBook[] Lib1Hall4ArrBooks = new ScientificBook[]{lib3Book1, lib3Book2, lib3Book3};
        ScientificLibraryHall Lib1Hall4 = new ScientificLibraryHall("New hall", Lib1Hall4ArrBooks);

        lib.changeHall(2, Lib1Hall4);
        System.out.println("\n" + lib.getHall(2).getNameHall());//new hall

        System.out.println("\nChange lib1book2 on lib4book3: ");
        lib.changeBook(1, lib4Book3);
        System.out.println("new name second book in lib: ");
        System.out.println(lib.getBook(1).getName()); // name43

        System.out.println("\nAdd book41 on pre-last place");
        lib.addBookInLib(8, lib4Book1);
        System.out.println("9th book in lib: " + lib.getBook(8).getName());
        lib.printAllNameHallWithCountBooks();
        System.out.println("10th book in lib: " + lib.getBook(9));

        System.out.println("\nDelete book41 on pre-last place");
        lib.delBookInLib(8);
        System.out.println("9th book in lib: " + lib.getBook(8).getName());
        lib.printAllNameHallWithCountBooks();
        System.out.println("10th book in lib: " + lib.getBook(9));

        System.out.println("\nThe best book in library: ");
        System.out.println(lib.getBestBookInLib().getName() + " " + lib.getBestBookInLib().getPrice());
    }
}
