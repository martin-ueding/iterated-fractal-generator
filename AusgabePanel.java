import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class AusgabePanel extends JPanel {
	
	ArrayList<DoublePoint> liste;
	
	public AusgabePanel (ArrayList<DoublePoint> list) {
		liste = list;
	}
	
	protected void paintComponent (Graphics h) {
		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		g.clearRect(0, 0, getWidth(), getHeight());
		
		
		
		for (DoublePoint rect : liste) {
			rect.paint(g);
		}
	}

}
