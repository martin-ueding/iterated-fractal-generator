/*
 * Copyright 2010 Martin Ueding <mu@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
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
