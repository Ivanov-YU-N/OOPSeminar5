import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }
    public void showTables(Collection<Table> tables){
        for(Table table: tables){
            System.out.println(table);
        }
    }
    @Override
    public void showReservationResult(int reservationNo) {
        if(reservationNo> 0){
            System.out.printf("Столик зарезервирован  #%d\n", reservationNo);
        }
        else{
            System.out.println("Не удалось забронировать");
        }
    }

    @Override
    public void showChengeReservationResult(int reservationNo, int reservationNewNo) {
        if(reservationNewNo > 0) {
            System.out.printf("Броня на столик #%d снята.Забронирован новый столик #%d",reservationNo, reservationNewNo);
        }else{
            System.out.println("Не удалось забронировать новый столик");
        }
    }

    public void reservationTable(Date reservationDate, int tableNo, String name){
        if(observer != null) {
            observer.onResevationTable(reservationDate, tableNo, name);
        }
    }
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        if(observer != null) {
            observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
        }
    }
}
