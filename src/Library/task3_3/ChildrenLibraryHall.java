package Library.task3_3;

import Library.task3_1.Book;
import Library.task3_2.ChildrenBook;
import Library.task5_1.BookIndexOutOfBoundsException;
import Library.task5_1.InvalidBookPriceException;
import Library.task5_2.IBook;
import Library.task5_3.IHall;

public class ChildrenLibraryHall extends ChildrenBook implements IHall {
    private String NameHall;
    private int CountBook;
    private IBook[] Books;

    /**Конуструктор принимающий имя зала и кол-во книг в зале*/
    public ChildrenLibraryHall(String NameHall, int CountBook){
        this.NameHall = NameHall;
        this.Books = new IBook[CountBook];
        for (int i = 0; i < CountBook; i++){
            IBook chbook = new ChildrenBook();
            Books[i] = chbook;
        }
        this.CountBook = Books.length;
    }


    /**Конструктор принимающий имя зала и массив книг*/
    public ChildrenLibraryHall(String NameHall, ChildrenBook[] Books){
        this.NameHall = NameHall;
        this.Books = Books;
        this.CountBook = Books.length;
    }

    public ChildrenLibraryHall() {

    }

    /**Геттер и сеттер имени зала*/
    public String getNameHall() {
        return NameHall;
    }

    public void setNameHall(String nameHall) {
        NameHall = nameHall;
    }

    /**Метод получения общего количества книг в зале*/
    public int getCountBook(){
        return CountBook;
    }

    /**Метод, выводящий на экран список названий всех книг в зале*/
    public void getBooks(){
        System.out.println("All book's name:");
        for (IBook book : Books) {
            System.out.println(book.getName());
        }
    }

    /**Метод получения общей стоимости всех книг в зале*/
    public double getCountPriceAll(){
        double Counter = 0;
        for (IBook book: Books){
            Counter += book.getPrice();
        }
        if (Counter < 0)
            throw new InvalidBookPriceException("Invalid book's price");
        else
            return Counter;
    }

    /**Метод получения книги по ее номеру в зале */
    public IBook getBook(int Number) throws BookIndexOutOfBoundsException{
        if (Number > Books.length || Number < 0){
            throw new BookIndexOutOfBoundsException(Number, " invalid");
        }
        else{
            return Books[Number];
        }
    }

    /**Метод изменения книги по ее номеру*/
    public void setBook(int CountBookInHall, IBook newChildrenBook) throws BookIndexOutOfBoundsException{
        if (CountBookInHall < 0 || CountBookInHall > Books.length){
            throw new BookIndexOutOfBoundsException(CountBookInHall, "invalid");
        }
        else{
            IBook book = Books[CountBookInHall];
            book.setAuthor(newChildrenBook.getAuthor());
            book.setName(newChildrenBook.getName());
            book.setPrice(newChildrenBook.getPrice());
            book.setYear(newChildrenBook.getYear());
            book.setMinAge(newChildrenBook.getMinAge());
        }

    }

    /**Метод добавления книги по номеру*/
    public void addBook(int NumberBookInHall, IBook newChildrenBook){
        if (NumberBookInHall < CountBook){
            IBook[] newBooksInLib = new IBook[CountBook + 1];
            for (int i = 0; i < NumberBookInHall; i++){
                newBooksInLib[i] = Books[i];
            }
            newBooksInLib[NumberBookInHall] = newChildrenBook;
            for (int i = NumberBookInHall + 1; i < newBooksInLib.length; i++){
                newBooksInLib[i] = Books[i - 1];
            }
            this.Books = newBooksInLib;
            this.CountBook = newBooksInLib.length;
        }
        else {
            System.out.println("NumberBookInHall out of range");
        }

    }

    /**Метод удаления книги по номеру*/
    public void delBook(int NumberBookInHall) throws BookIndexOutOfBoundsException{
        if (NumberBookInHall < CountBook || NumberBookInHall > 0){
            IBook[] newBooksInLib = new IBook[CountBook - 1];
            for (int i = 0; i < NumberBookInHall; i++){
                newBooksInLib[i] = Books[i];
            }
            for (int i = NumberBookInHall + 1; i < CountBook; i++){
                newBooksInLib[i-1] = Books[i];
            }
            this.Books = newBooksInLib;
            this.CountBook = newBooksInLib.length;
        }
        else{
            throw new BookIndexOutOfBoundsException(NumberBookInHall, " invalid");
        }
    }

    /**Метод возвращающий книгу с самой высокой стоимостью*/
    public IBook getBestBook(){
        double maxPrice = 0;
        int indexBestBook = 0;
        for (int i = 0; i < CountBook; i++){
            if (Books[i].getPrice() > maxPrice){
                maxPrice = Books[i].getPrice();
                indexBestBook = i;
            }
        }
        return Books[indexBestBook];
    }

}
