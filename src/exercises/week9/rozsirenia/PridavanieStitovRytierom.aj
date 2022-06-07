package rozsirenia;
import gui.*;
import postavy.*;
import stret.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public privileged aspect PridavanieStitovRytierom {

	StretOkno okno;
	
	private boolean Rytier.stit; // kazdy rytier bude mat indikator toho, ci je chraneny stitom
	private CheckBox StretOkno.stitPrepinac = new CheckBox("Pridaj rytierom stity"); // na prepinanie ochrany stitmi bude sluzit checkbox - zatial priadny iba ako atribut okna
	
	// ak rytier ma zapnuty stit, odveta sa neuskutocni 
	void around(Rytier r): call(* Obor+.odveta(..)) && args(r) {
		if (!r.stit)
			proceed(r);
	}
	
	// checkbox treba skutocne pridat do okna
	after() returning(StretOkno o): call(StretOkno.new(..)) {
		okno = o;
		Platform.runLater(new Runnable(){
			public void run() {
				((FlowPane) ((ScrollPane) o.getScene().getRoot()).getContent()).getChildren().add(o.stitPrepinac);
			}
		});
	}
	
	// zapnutie stitov sa sleduje po inicializacii: ak je zapnute, vsetkym rytierom sa nastavi indikator ochrany stitom na true 
	after(Stret stret): call(void Stret.vytvorBojovnikov(..)) && target(stret) {
		if (okno.stitPrepinac.isSelected()) {
			for (Rytier r : stret.rytier)
				r.stit = true;
		}
	}
}
