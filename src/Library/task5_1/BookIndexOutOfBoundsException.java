package Library.task5_1;

public class BookIndexOutOfBoundsException extends Exception{
    private String expect;
    int index;

    public BookIndexOutOfBoundsException(int index, String expect) {
        this.expect = expect;
        this.index = index;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
