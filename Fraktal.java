/**
 * Iteriertes Funktionssystem
 * 
 * Martin Ueding - www.martin-ueding.de
 * 
 * @author Martin Ueding
 */

import javax.swing.JFrame;
import java.util.ArrayList;

public class Fraktal {

	int stufen = 0;

	ArrayList<DoubleRectangle> rects;

	Fraktal () {
		rects = new ArrayList<DoubleRectangle>();
		rects.add(new DoubleRectangle());
		rects.add(new DoubleRectangle());
		rects.add(new DoubleRectangle());
	}

	public void render() {
		DoublePoint start = new DoublePoint();
		start.x = 0;
		start.y = 0;

		ArrayList<DoublePoint> aktivList = new ArrayList<DoublePoint>();
		ArrayList<DoublePoint> neuList = new ArrayList<DoublePoint>();

		aktivList.add(start);

		for (int i = 0; i < 11; i++) {

			for (DoubleRectangle rect : rects) {
				for (DoublePoint aktiv : aktivList) {
					neuList.add(rect.project(aktiv));
				}
			}

//			for (DoubleRectangle aktiv : aktivList) {
//				sammelList.add(aktiv);
//			}

			aktivList = neuList;
			neuList = new ArrayList<DoublePoint>();
		}

		JFrame ausgabe = new JFrame("Ausgabe");
		AusgabePanel ausgabePanel = new AusgabePanel(aktivList);
		ausgabe.add(ausgabePanel);
		ausgabe.setSize(IteriertesFunktionssystem.w,IteriertesFunktionssystem.h+20);
		ausgabe.setVisible(true);
	}

}
