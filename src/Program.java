import java.util.Date;

public class Program {
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresebter presenter = new BookingPresebter(model, view);

        presenter.updateTablesUI();
        view.reservationTable(new Date(), 3, "Иван");

        view.changeReservationTable(101, new Date(), 4, "Иван");

    }
}
