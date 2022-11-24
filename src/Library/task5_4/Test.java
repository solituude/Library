package Library.task5_4;

import Library.task3_2.ChildrenBook;
import Library.task3_3.ChildrenLibraryHall;
import Library.task3_4.ChildrenLibrary;
import Library.task5_1.BookIndexOutOfBoundsException;
import Library.task5_1.HallIndexOutOfBoundsException;
import Library.task5_1.InvalidBookCountException;
import Library.task5_1.InvalidBookPriceException;

public class Test {
    public static void main(String[] args) {
        ChildrenBook[] books = new ChildrenBook[3];
        books[0] = new ChildrenBook("author01", "name01", 1200, 1812, 7);
        books[1] = new ChildrenBook("author02", "name02", 1600, 1856, 12);
        books[2] = new ChildrenBook("author03", "name03", 1400, 1867, 12);
        ChildrenBook[] books1 = new ChildrenBook[3];
        books1[0] = new ChildrenBook("author11", "name11", 2000, 1980, 16);
        books1[1] = new ChildrenBook("author12", "name12", 1900, 102, 16);
        books1[2] = new ChildrenBook("author13", "name13", 1300, 1970, 16);
        ChildrenBook[] books2 = new ChildrenBook[3];
        books2[0] = new ChildrenBook("author21", "name21", 500, 1980, 14);
        books2[1] = new ChildrenBook("author22", "name22", 300, 1980, 14);
        books2[2] = new ChildrenBook("author23", "name23", 1200, 1980, 14);
        ChildrenLibraryHall[] Hall = new ChildrenLibraryHall[3];
        Hall[0] = new ChildrenLibraryHall("12+", books);
        Hall[1] = new ChildrenLibraryHall("16+", books1);
        Hall[2] = new ChildrenLibraryHall("14+", books2);
        ChildrenBook temp = new ChildrenBook("new_author", "new_name", 1200, 1869, 16);
        ChildrenLibrary library = new ChildrenLibrary(Hall);
        try {
            System.out.println(library.getBook(2).getAuthor());
            library.delBook(-1);
            library.addBook(6, temp);
            System.out.println(library);
            library.delBook(-1);
            System.out.println(library);
            library.changeBook(0, temp);
        } catch (BookIndexOutOfBoundsException error) {
            System.out.println(error.getExpect());
        } catch (HallIndexOutOfBoundsException error) {
            System.out.println(error.getExpect());
        } catch (InvalidBookPriceException error) {
            System.out.println(error.getExpect());
        } catch (InvalidBookCountException error) {
            System.out.println(error.getExpect());
        } catch (NegativeArraySizeException error ){
            System.out.println("Index of massive less zero");
        }
    }
}
