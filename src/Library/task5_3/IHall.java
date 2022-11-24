package Library.task5_3;

import Library.task5_1.BookIndexOutOfBoundsException;
import Library.task5_2.IBook;

public interface IHall extends IBook{

    public int getCountBook();

    public void getBooks();

    public double getCountPriceAll();

    public IBook getBook(int Number) throws BookIndexOutOfBoundsException;

    public void setBook(int CountBookInHall, IBook newChildrenBook) throws BookIndexOutOfBoundsException;

    public void addBook(int NumberBookInHall, IBook newChildrenBook);

    public void delBook(int NumberBookInHall) throws BookIndexOutOfBoundsException;

    public IBook getBestBook();

    public String getNameHall();
    public Object clone();

}
