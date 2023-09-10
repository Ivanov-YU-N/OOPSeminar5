import java.util.Collection;

public interface View {

    void setObserver(ViewObserver observer);
    void showTables(Collection<Table> tables);
    void showReservationResult(int reservation);
    void showChengeReservationResult(int reservationNo, int reservationNewNo);
}
