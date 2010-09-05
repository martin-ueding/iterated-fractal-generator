/**
 * Iteriertes Funktionssystem
 * 
 * Martin Ueding - www.martin-ueding.de
 * 
 * @author Martin Ueding
 */

import java.awt.Graphics2D;

public class DoublePoint {
	double x, y;
	
	DoublePoint () {
		
	}
	
	DoublePoint (double a, double b) {
		x = a;
		y = b;
	}
	
	static DoublePoint P00 = new DoublePoint (0, 0);
	static DoublePoint P10 = new DoublePoint (1, 0);
	static DoublePoint P01 = new DoublePoint (0, 1);
	static DoublePoint P11 = new DoublePoint (1, 1);
	
	static DoublePoint PM = new DoublePoint (0.5, 0.5);
	
	void paint (Graphics2D g) {
		g.drawLine((int)x, (int)y, (int)x, (int)y);
	}
}
