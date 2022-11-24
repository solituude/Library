package Library.task3_4;

import Library.task3_3.ChildrenLibraryHall;
import Library.task3_2.ChildrenBook;
import Library.task5_1.BookIndexOutOfBoundsException;
import Library.task5_2.IBook;
import Library.task5_3.IHall;
import Library.task5_4.ILibrary;

public class ChildrenLibrary extends ChildrenLibraryHall implements ILibrary {
    private final int countHalls; // количество залов всего
    private int[] countBooksInHalls;
    private final IHall[] ChildrenLibAllHalls;

    /**Конструктор принимающий количество залов и массив количеств книг по залам*/
    public ChildrenLibrary(int countHalls, int[] countBooksInHalls){
        this.countHalls = countHalls;
        this.ChildrenLibAllHalls = new IHall[countHalls];
        for (int i = 0; i < countHalls; i++){
            ChildrenLibAllHalls[i] = new ChildrenLibraryHall("0", countBooksInHalls[i]);
        }
    }

    /**Конструктор, принимающий массив залов*/
    public ChildrenLibrary(IHall[] ChildrenLibAllHalls){
        this.ChildrenLibAllHalls = ChildrenLibAllHalls;
        this.countHalls = ChildrenLibAllHalls.length;
        int[] countBooksInHalls = new int[ChildrenLibAllHalls.length];
        for (int i = 0; i < ChildrenLibAllHalls.length; i++){
            countBooksInHalls[i] = ChildrenLibAllHalls[i].getCountBook();
        }
        this.countBooksInHalls = countBooksInHalls;
    }

    /*Метод получения количества залов*/
    public int getCountHalls(){
        return countHalls;
    }

    /*Метод получения количества книг*/
    public int getCountBooks(){
        int ans = 0;
        for (int i = 0; i < countHalls; i++){
            ans += ChildrenLibAllHalls[i].getCountBook();
        }
        return ans;
    }

    /*Метод получения суммы всех книг в библиотеке*/
    public double getSumAllBooks(){
        double ans = 0;
        for (int i = 0; i < countHalls; i++){
            ans += ChildrenLibAllHalls[i].getCountPriceAll();
        }
        return ans;
    }

    /*Метод получения массива залов библиотеки*/
    public IHall[] getChildrenLibAllHalls() {
        return ChildrenLibAllHalls;
    }

    /*Метод получения объекта зала по его номеру в бибилиотеке*/
    public IHall getHall(int index){
        if (index < countHalls){
            return ChildrenLibAllHalls[index];
        }
        else{
            return null;
        }
    }

    /*Метод получения объекта книги по его номеру в библиотеке*/
    public IBook getBook(int number) throws BookIndexOutOfBoundsException {
        if (number < getCountBooks()) {
            int count = 0;
            for (int i = 0; i < countHalls; i++) {
                for (int j = 0; j < ChildrenLibAllHalls[i].getCountBook(); j++) {
                    if (count != number) {
                        count++;
                    } else {
                        return ChildrenLibAllHalls[i].getBook(j);
                    }
                }
            }
        }
        return null;
    }


    /*Метод получения отсортированного по убыванию цены массива книг библиотеки*/
    public IHall sortHall(IHall sortHall, IHall currHall) throws BookIndexOutOfBoundsException {
        for(int i = 0; i < currHall.getCountBook(); i++){
            sortHall.addBook(0, currHall.getBook(i));
        }
        for(int i = 1; i < sortHall.getCountBook(); i++){
            for (int j = 0; j < sortHall.getCountBook(); j++){
                if(sortHall.getBook(i).getPrice() > sortHall.getBook(j).getPrice()){
                    sortHall.addBook(j, sortHall.getBook(i));
                }
                if(i < j ){
                    sortHall.delBook(i);
                }
                else if (i > j){
                    sortHall.delBook(i + 1);
                }
            }
        }
        return sortHall;
    }

    /*Метод, выводящий на экран список названий всех залов с колчеством книг в них*/
    public void printAllNameHallWithCountBooks(){
        for (int i = 0; i < countHalls; i++){
            System.out.println(ChildrenLibAllHalls[i].getNameHall() + " " + countBooksInHalls[i]);
        }
    }

    /*Метод замены зала по его номеру на другой*/
    public void changeHall(int indexHall, IHall newChildLibHall){
        if (indexHall < ChildrenLibAllHalls.length){
            ChildrenLibAllHalls[indexHall] = newChildLibHall;
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод замены книги по ее номеру на другую*/
    public void changeBook(int number, IBook newBook) throws BookIndexOutOfBoundsException {
        if (number < getCountBooks()) {
            int count = 0;
            for (int i = 0; i < countHalls; i++) {
                for (int j = 0; j < ChildrenLibAllHalls[i].getCountBook(); j++) {
                    if (count != number) {
                        count++;
                    } else {
                        ChildrenLibAllHalls[i].setBook(count, newBook);
                    }
                }
            }
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод добавления книги в библиотеку по ее номеру в библиотеке*/
    public void addBookInLib(int indexInLib, IBook newBook){
        if (indexInLib < getCountBooks()) {
            int countInd = 0;
            for (int i = 0; i < countHalls; i++) {
                if (indexInLib <= countInd + ChildrenLibAllHalls[i].getCountBook()){
                    countBooksInHalls[i]++;
                    ChildrenLibAllHalls[i].addBook(indexInLib - countInd, newBook);
                    break;
                }
                countInd += ChildrenLibAllHalls[i].getCountBook();
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
                if (indexInLib <= countInd + ChildrenLibAllHalls[i].getCountBook()){
                    countBooksInHalls[i]--;
                    ChildrenLibAllHalls[i].delBook(indexInLib - countInd);
                    break;
                }
                countInd += ChildrenLibAllHalls[i].getCountBook();
            }
        }
        else{
            System.out.println("Error!!!");
        }
    }

    /*Метод получение самой лучшей книги в библиотеке (с самой большой ценой)*/
    public IBook getBestBookInLib(){
        IBook best = new ChildrenBook();
        double maxPrice = 0;
        for (int i = 0; i < countHalls; i++){
            if (maxPrice < ChildrenLibAllHalls[i].getBestBook().getPrice()){
                maxPrice = ChildrenLibAllHalls[i].getBestBook().getPrice();
                best = ChildrenLibAllHalls[i].getBestBook();
            }
        }
        return best;
    }
}
