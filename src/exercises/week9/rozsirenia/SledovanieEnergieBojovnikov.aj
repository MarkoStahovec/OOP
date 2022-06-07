package rozsirenia;
import java.util.ArrayList;
import java.util.List;
import gui.*;
import stret.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public privileged aspect SledovanieEnergieBojovnikov {
	Stret stret;
	
	// do triedy stret pridame rad sledovatelov a metody na pridavanie a upovedomovanie sledovatelov
	transient private List<SledovatelStretu> Stret.sledovatelia = new ArrayList<>();

	public void Stret.pridajSledovatela(SledovatelStretu sledovatelStavu) {
		sledovatelia.add(sledovatelStavu);
	}
	public void Stret.upovedomSledovatelov() {
		for (SledovatelStretu s : sledovatelia)
			s.upovedom();
	}
	
	// do okna pridame atribut, v ktorom bude uchovany sledovatel energie bojovnikov
	public EnergiaBojovnikov StretOkno.energiaBojovnikov;

	// po urcitych metodach stretu treba upovedomit sledovatelov
	after(Stret stret): this(stret) && (execution(void Stret.vytvorBojovnikov(..))
		|| execution(String Stret.stret(..))
		|| execution(String Stret.dalsiStret1na1(..))
		|| execution(void Stret.nacitaj(..))) {
			stret.upovedomSledovatelov();
	}

	// potrebujeme ziskat objekt stretu spojeny s danym oknom
	after() returning(Stret s): cflow(call(StretOkno.new(..))) && call(Stret.new()) {
		stret = s;
	}
	
	// samotny sledovatel energie bojovnikov treba pridat do okna
	after() returning(StretOkno o): call(StretOkno.new(..)) {
		o.energiaBojovnikov = new EnergiaBojovnikov(stret);
		stret.pridajSledovatela(o.energiaBojovnikov);
		
		Platform.runLater(new Runnable(){
			public void run() {
				((FlowPane) ((ScrollPane) o.getScene().getRoot()).getContent()).getChildren().add(o.energiaBojovnikov);
			}
		});
	}
}

