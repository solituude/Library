package Library.task3_4;

import Library.task3_2.ChildrenBook;
import Library.task3_3.ChildrenLibraryHall;
import Library.task5_1.BookIndexOutOfBoundsException;

public class testTask4 {
    public static void main(String[] args) throws BookIndexOutOfBoundsException {
        ChildrenBook lib1Book1 = new ChildrenBook("author11","name11", 879, 2000, 6);
        ChildrenBook lib1Book2 = new ChildrenBook("author12","name12", 120, 2003, 6);


        ChildrenBook lib2Book1 = new ChildrenBook("author21","name21", 79, 2000, 16);
        ChildrenBook lib2Book2 = new ChildrenBook("author22","name22", 120, 2003, 16);
        ChildrenBook lib2Book3 = new ChildrenBook("author23","name23", 156, 1994, 16);
        ChildrenBook lib2Book4 = new ChildrenBook("author24","name24", 1959, 1963, 16);

        ChildrenBook lib3Book1 = new ChildrenBook("author31","name31", 8879, 2000, 12);
        ChildrenBook lib3Book2 = new ChildrenBook("author32","name32", 1230, 2003, 16);
        ChildrenBook lib3Book3 = new ChildrenBook("author33","name33", 156, 1994, 6);


        ChildrenBook[] Lib1Hall1ArrBooks = new ChildrenBook[]{lib1Book1, lib1Book2};
        ChildrenBook[] Lib1Hall2ArrBooks = new ChildrenBook[]{lib2Book1, lib2Book2, lib2Book3, lib2Book4};
        ChildrenBook[] Lib1Hall3ArrBooks = new ChildrenBook[]{lib3Book1, lib3Book2, lib3Book3};

        ChildrenLibraryHall Lib1Hall1 = new ChildrenLibraryHall("6+", Lib1Hall1ArrBooks);
        ChildrenLibraryHall Lib1Hall2 = new ChildrenLibraryHall("16+", Lib1Hall2ArrBooks);
        ChildrenLibraryHall Lib1Hall3 = new ChildrenLibraryHall("All ages", Lib1Hall3ArrBooks);

        ChildrenLibraryHall[] lib1 = new ChildrenLibraryHall[]{Lib1Hall1, Lib1Hall2, Lib1Hall3};
        ChildrenLibrary lib = new ChildrenLibrary(lib1);
        System.out.println(lib.getCountHalls());  // 3

        System.out.println(lib.getCountBooks());  // 9
        System.out.println(lib.getSumAllBooks());  // 13578

        System.out.println(lib.getHall(1).getNameHall()); // 16+
        System.out.println(lib.getHall(5));  // null
        System.out.println(lib.getBook(5).getName()); // name24
        System.out.println(lib.getBook(25));  // null

        System.out.println("\nAll halls with name and count books");
        lib.printAllNameHallWithCountBooks();

        ChildrenBook lib4Book1 = new ChildrenBook("author41","name41", 8879, 2000, 12);
        ChildrenBook lib4Book2 = new ChildrenBook("author42","name42", 1230, 2003, 16);
        ChildrenBook lib4Book3 = new ChildrenBook("author43","name43", 156, 1994, 6);
        ChildrenBook[] Lib1Hall4ArrBooks = new ChildrenBook[]{lib3Book1, lib3Book2, lib3Book3};
        ChildrenLibraryHall Lib1Hall4 = new ChildrenLibraryHall("New hall", Lib1Hall4ArrBooks);

        lib.changeHall(2, Lib1Hall4);
        System.out.println("\n" + lib.getHall(2).getNameHall());

        System.out.println("\nChange lib1book2 on lib4book3: ");
        lib.changeBook(1, lib4Book3);
        System.out.println("new name second book in lib: ");
        System.out.println(lib.getBook(1).getName()); // name43

        System.out.println("\nAdd book41 on pre-last place");
        lib.addBookInLib(8, lib4Book1);
        System.out.println("9th book in lib: " + lib.getBook(8).getName());
        lib.printAllNameHallWithCountBooks();
        System.out.println("10th book in lib: " + lib.getBook(9).getName());

        System.out.println("\nDelete book41 on pre-last place");
        lib.delBookInLib(8);
        System.out.println("9th book in lib: " + lib.getBook(8).getName());
        lib.printAllNameHallWithCountBooks();
        System.out.println("10th book in lib: " + lib.getBook(9));

        System.out.println("\nThe best book in library: ");
        System.out.println(lib.getBestBookInLib().getName() + " " + lib.getBestBookInLib().getPrice());
    }
}
