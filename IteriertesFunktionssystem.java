/*
 * Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IteriertesFunktionssystem {
	private static EingabeMaske eingabeMaske;
	private static Fraktal frak;
	
	public static int w=1000, h=1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		frak = new Fraktal();

		JFrame frame = new JFrame("Layout");
		frame.setSize(w, h+20);
		eingabeMaske = new EingabeMaske(frak);
		frame.add(eingabeMaske);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JFrame toolbar = new JFrame("Werkzeuge");
		JPanel toolbarContainer = new JPanel();
		toolbar.add(toolbarContainer);
		toolbar.setVisible(true);
		toolbar.setLocation(1050,350);


		JButton add = new JButton ("Neues Quadrat");
		add.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				frak.rects.add(new DoubleRectangle());
			}

		});


		toolbarContainer.add(add);
		
		
		JButton create = new JButton ("Fraktal rendern");
		create.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				frak.render();
			}

		});


		toolbarContainer.add(create);
		
		toolbar.pack();

	}

	public static void repaint() {
		eingabeMaske.repaint();

	}

}
