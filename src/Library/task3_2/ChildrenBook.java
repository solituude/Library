package Library.task3_2;

import Library.task3_1.Book;
import Library.task5_2.IBook;

public class ChildrenBook extends Book implements IBook {
    private int minAge;

    public ChildrenBook(){
        super();
        minAge = 0;
    }

    public ChildrenBook(String author, int year){
        super(author, year);
        minAge = 0;
    }

    public ChildrenBook(String author, String name, double price, int year, int minAge){
        super(author, name, price, year);
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return getName() + " " + getYear() + " " + getAuthor() + " " + getPrice() + " " + getMinAge();
    }
}
