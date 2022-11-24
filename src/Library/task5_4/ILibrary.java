package Library.task5_4;

import Library.task5_1.BookIndexOutOfBoundsException;
import Library.task5_2.IBook;
import Library.task5_3.IHall;


public interface ILibrary extends IHall {
    public int getCountHalls();

    public int getCountBooks();

    public double getSumAllBooks();

    public IHall[] getChildrenLibAllHalls();

    public IHall getHall(int index);

    public Object clone();

    public IHall sortHall(IHall sortHall, IHall currHall) throws BookIndexOutOfBoundsException;

    public void printAllNameHallWithCountBooks();

    public void changeHall(int indexHall, IHall newChildLibHall);

    public void changeBook(int number, IBook newBook) throws BookIndexOutOfBoundsException;

    public void addBookInLib(int indexInLib, IBook newBook);
    public void delBookInLib(int indexInLib) throws BookIndexOutOfBoundsException;
    public IBook getBestBookInLib();

}


