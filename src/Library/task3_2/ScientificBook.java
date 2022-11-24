package Library.task3_2;

import Library.task3_1.Book;
import Library.task5_2.IBook;
import java.util.Objects;

public class ScientificBook extends Book implements IBook, Cloneable{
    private double indexCit;
    private int minAge;

    public ScientificBook(){
        super();
        indexCit = 0;
    }

    public ScientificBook(String author, int year){
        super(author, year);
        indexCit = 0;
    }

    public ScientificBook(String author, String name, double price, int year, double indexCit){
        super(author, name, price, year);
        this.indexCit = indexCit;
    }

    public double getIndexCit() {
        return indexCit;
    }

    public void setIndexCit(double indexCit) {
        this.indexCit = indexCit;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return getName() + " " + getYear() + " " + getAuthor() + " " + getPrice() + " " + getIndexCit();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        else if (object == null || object.getClass() != getClass())
            return false;
        else {
            ScientificBook book = (ScientificBook) object;
            return book.indexCit == indexCit && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getName().equals(getName()) && book.getYear() == getYear();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), indexCit);
    }

    @Override
    public ScientificBook clone() {
        ScientificBook book = null;
        try {
            book = (ScientificBook) super.clone();
        } catch (CloneNotSupportedException ignored) {

        }
        return book;
    }


}
