/*
 * Copyright 2010 Martin Ueding <mu@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EingabeMaske extends JPanel {
	
	Fraktal frak;
	
	DoubleRectangle marked;
	
	EingabeMaske (Fraktal x) {
		frak = x;
		this.addMouseMotionListener(new MyMouseMotionListener());
	}

	
	protected void paintComponent (Graphics h) {		
		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		g.clearRect(0, 0, getWidth(), getHeight());
		
		
		
		for (DoubleRectangle rect : frak.rects) {
			if (rect == marked)
				g.setColor(Color.RED);
			else
				g.setColor(Color.BLACK);
			rect.paint(g);
		}
		
	}
	
	class MyMouseMotionListener implements MouseMotionListener {
		
		
		int x, y;

		public void mouseDragged(MouseEvent e) {
	
			int dx = e.getX() - x;
			int dy = e.getY() - y;
			
			if (marked != null) {
				marked.x += dx;
				marked.y += dy;
			}
			
			x = e.getX();
			y = e.getY();
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			
			marked = null;
			
			for (DoubleRectangle rect : frak.rects) {
				if (rect.isInRect(new Point(x, y)))
					marked = rect;
			}
			
			repaint();
			
		}
		
	}

}
