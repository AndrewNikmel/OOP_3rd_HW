public class soldier {
    private int number;
    private String rank;
    private String name;
    Object data;
    private soldier next;
    private soldier previous;

    public soldier(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("\n%d - %s %s", number, rank, name);
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public soldier getNext() {
        return next;
    }

    void setNext(soldier soldier){
        next = soldier;
    }

    void setPrevious(soldier soldier){
        previous = soldier;
    }

    public soldier getPrevious() {
        return previous;
    }
}