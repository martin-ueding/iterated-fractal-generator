import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Iteriertes Funktionssystem
 * 
 * Martin Ueding - www.martin-ueding.de
 * 
 * @author Martin Ueding
 */


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
