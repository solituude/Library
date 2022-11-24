package Library.task3_1;

public class testTask1 {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("author1", 2019);
        Book book3 = new Book("author2", "name2", 354, 1999);
        book1.setAuthor("author3");
        System.out.println(book1.getAuthor());  // author3
        book2.setName("name1");
        System.out.println(book2.getName());  // name1
        System.out.println(book1.getPrice());  // 0
        book1.setPrice(999.56);
        System.out.println(book1.getPrice());  // 999.56

    }
}
