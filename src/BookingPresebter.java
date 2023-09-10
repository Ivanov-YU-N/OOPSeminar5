import java.util.Collection;
import java.util.Date;

public class BookingPresebter implements  ViewObserver{

    private final  Model module;
    private  final  View view;

    public BookingPresebter(Model model, View view) {
        this.module = model;
        this.view = view;
        this.view.setObserver(this);
    }
    public Collection<Table> loadtable(){
        return module.loadTables();
    }

    public void updateTablesUI(){
        view.showTables(loadtable());
    }

    public  void updateReservationResultUI(int reservationNo){
        view.showReservationResult(reservationNo);
    }
    public  void updateChengeReservationResultUI(int reservationNo, int reservationNewNo){
        view.showChengeReservationResult(reservationNo, reservationNewNo);
    }

    @Override
    public void onResevationTable(Date reservationDate, int tableNo, String name) {
       int resrvationNo =  module.reservationTable(reservationDate, tableNo, name);
       updateReservationResultUI(resrvationNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNewNo = module.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateChengeReservationResultUI(oldReservation,reservationNewNo);
    }
}
