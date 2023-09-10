import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model{

    private Collection<Table>  tables;

    public Collection<Table> loadTables(){

        if(tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for(Table t: tables){
            if(t.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate,name);
                t.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table t : tables) {
            if (t.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                t.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

}
