package Library.task5_1;

public class HallIndexOutOfBoundsException extends IndexOutOfBoundsException{
    String expect;

    public HallIndexOutOfBoundsException(String expect) {
        this.expect = expect;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }
}
