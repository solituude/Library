package Library.task3_2;

public class testTask2 {
    public static void main(String[] args) {
        ScientificBook scienceBook = new ScientificBook("authorSB", 1999);
        System.out.println(scienceBook);  // Not defined authorSB 0 1999 0


        ChildrenBook lib1Book1 = new ChildrenBook("author11","name11", 899, 2000, 12);
        ChildrenBook lib1Book2 = new ChildrenBook("author12","name12", 120, 2003, 16);
        ChildrenBook lib1Book3 = new ChildrenBook("author13","name13", 156, 1994, 6);


        System.out.println(lib1Book1);
        System.out.println(lib1Book2);
    }
}
