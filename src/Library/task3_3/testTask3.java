package Library.task3_3;

import Library.task3_2.ChildrenBook;
import Library.task5_1.BookIndexOutOfBoundsException;

public class testTask3 {
    public static void main(String[] args) throws BookIndexOutOfBoundsException {
        ChildrenBook lib1Book1 = new ChildrenBook("author11","name11", 899, 2000, 12);
        ChildrenBook lib1Book2 = new ChildrenBook("author12","name12", 120, 2003, 16);
        ChildrenBook lib1Book3 = new ChildrenBook("author13","name13", 156, 1994, 6);
        ChildrenBook lib1Book4 = new ChildrenBook("author14","name14", 199, 1963, 16);
        ChildrenBook lib1Book5 = new ChildrenBook();
        ChildrenBook lib1Book6 = new ChildrenBook("author16", 2003);

        ChildrenBook[] Lib1Hall1ArrBooks = new ChildrenBook[]{lib1Book1, lib1Book2, lib1Book3, lib1Book4, lib1Book5,
                lib1Book6};

        System.out.println(Lib1Hall1ArrBooks[0].getPrice());

        ChildrenLibraryHall Lib1Hall1 = new ChildrenLibraryHall("16+", Lib1Hall1ArrBooks);
        System.out.println(Lib1Hall1.getNameHall()); // 16+

        Lib1Hall1.setNameHall("All ages");
        System.out.println(Lib1Hall1.getNameHall());  // All ages
        System.out.println(Lib1Hall1.getCountBook()); // 6
        Lib1Hall1.getBooks();
        System.out.println("\nPrice all books: "  + Lib1Hall1.getCountPriceAll());  // 1374
        System.out.println(Lib1Hall1.getBook(2).getPrice());  // 156

        ChildrenBook newLib1Book5 = new ChildrenBook("newAuthor15", "newName15", 656, 2006, 6);
        Lib1Hall1.setBook(4, newLib1Book5);
        System.out.println(lib1Book5.getAuthor());  // newAuthor

        System.out.println("\nAdd new book between 3 and 4");
        ChildrenBook Lib1Book34 = new ChildrenBook("author134", "name134", 756, 2000, 18);
        Lib1Hall1.addBook(3, Lib1Book34);
        Lib1Hall1.getBooks();

        System.out.println("\nDelete book with name name134");
        Lib1Hall1.delBook(3);
        Lib1Hall1.getBooks();

        System.out.println("The best book: " + Lib1Hall1.getBestBook().getName() + " " +
                Lib1Hall1.getBestBook().getPrice()); // name 11 899

    }
}
