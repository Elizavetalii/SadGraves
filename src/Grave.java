public class Grave {
    private int row;
    private int column;
    private Mourners mourners;

    public Grave(int Row, int Column, Mourners mourners) {
        this.row = Row;
        this.column = Column;
        this.mourners = mourners;
    }

    public Mourners getMourners() {
        return mourners;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
