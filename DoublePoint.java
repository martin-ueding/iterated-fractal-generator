/*
 * Copyright 2010 Martin Ueding <mu@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
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
