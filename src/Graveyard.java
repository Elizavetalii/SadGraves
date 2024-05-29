import org.example.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graveyard {
    private int rows;
    private int сolumns;
    private List<Grave> graves;

    public Graveyard(int rows, int columns) {
        this.rows = rows;
        this.сolumns = columns;
        this.graves = new ArrayList<>();
    }
    static Log myLogGraveyard;
    static {
        try {
            myLogGraveyard = new Log("myLogGraveyard.log", "LogGraveyard");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public void displayMourners() {
        boolean hasMourners = false;
        for (Grave grave : graves) {
            if (grave != null) {
                Mourners mourners = grave.getMourners();
                if (mourners != null) {
                    System.out.println(mourners.getFullName());
                    hasMourners = true;
                }
            }
        }
        if (!hasMourners) {
            myLogGraveyard.logger.info("Умерших пока нет!");
        }
    }

    public void deleteGrave(int row, int column) {
        Grave grave = findGrave(row, column);
        if (grave != null) {
            graves.remove(grave);
            System.out.println("Могила успешно удалена");
        } else {
            myLogGraveyard.logger.info("Могила не найдена");
        }
    }

    public boolean isGraveTaken(int row, int column) {
        for (Grave grave : graves) {
            if (grave.getRow() == row && grave.getColumn() == column) {
                return true;
            }
        }
        return false;
    }

    public Grave findGrave(int row, int column) {
        for (Grave grave : graves) {
            if (grave.getRow() == row && grave.getColumn() == column) {
                return grave;
            }
        }
        return null;
    }


    public int countGraves() {
        return graves.size();
    }

    public void displayGraves() {
        for (Grave grave : graves) {
            System.out.println("Номер вертикального ряда: " + grave.getRow()
                    + "\nНомер горизонтального ряда: " + grave.getColumn());
        }
    }

    public boolean NullGrave(){
        return graves.isEmpty();
    }

    public void addGrave(Grave grave) {
        graves.add(grave);
    }
}


