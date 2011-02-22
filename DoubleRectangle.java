/*
 * Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DoubleRectangle {
	static int auto_increment = 1;

	static final int controlWindowOffsetX = IteriertesFunktionssystem.w;
	static final int controlWindowOffsetY = 0;
	static final int controlWindowWidth = 200;
	static final int controlWindowHeight = 300;

	int id;

	//	GUI Controls for controlling the Rectangle
	JFrame controlWindow;
	JSlider sliderSize, sliderAngle;

	double x=0, y=0, w=IteriertesFunktionssystem.w, h=IteriertesFunktionssystem.h;
	double theta = 0.0;
	double zoom = 0.5;
	
	boolean print = true;
	
	
	public DoubleRectangle () {
		id = auto_increment++;

		controlWindow = new JFrame("Rectangle "+id);
		controlWindow.setLocation(controlWindowOffsetX + (id-1)*controlWindowWidth, controlWindowOffsetY);
		controlWindow.setSize(controlWindowWidth, controlWindowHeight);

		JPanel layout = new JPanel();

		sliderSize = new JSlider(JSlider.VERTICAL, 0, 100, 50);
		sliderAngle = new JSlider(JSlider.VERTICAL, 0, 360, 0);

		sliderSize.addChangeListener(new SizeChangeListener());
		sliderAngle.addChangeListener(new AngleChangeListener());

		layout.add(sliderSize);
		layout.add(sliderAngle);

		controlWindow.add(layout);

		controlWindow.setVisible(true);
	}

	public DoubleRectangle (boolean x) {
		super();
		print = x;
	}

	DoublePoint project (DoublePoint p) {
		DoublePoint r = new DoublePoint();

		r.x = x + p.x*Math.cos(theta)*zoom - p.y*Math.sin(theta)*zoom;
		r.y = y + p.y*Math.cos(theta)*zoom + p.x*Math.sin(theta)*zoom;

		return r;
	}
	
	DoublePoint projectBig (DoublePoint p) {
		DoublePoint r = new DoublePoint();

		r.x = x + p.x*w*Math.cos(theta)*zoom - p.y*h*Math.sin(theta)*zoom;
		r.y = y + p.y*h*Math.cos(theta)*zoom + p.x*w*Math.sin(theta)*zoom;

		return r;
	}

	DoubleRectangle project (DoubleRectangle p) {
		DoubleRectangle r = new DoubleRectangle(false);

		r.x = x + p.x*Math.cos(theta)*zoom - p.y*Math.sin(theta)*zoom;
		r.y = y + p.y*Math.cos(theta)*zoom + p.x*Math.sin(theta)*zoom;

		r.theta = theta + p.theta;
		r.zoom = zoom * p.zoom;

		return r;
	}

	boolean isInRect (Point p) {
		DoublePoint r = new DoublePoint();

		//		r.x = x + p.x*w*Math.cos(theta)*zoom - p.y*h*Math.sin(theta)*zoom;
		//		r.y = y + p.y*h*Math.cos(theta)*zoom + p.x*w*Math.sin(theta)*zoom;

		p.x -= x;
		p.y -= y;

		r.x = Math.cos(theta) / (Math.pow(Math.cos(theta), 0.2e1) + Math.pow(Math.sin(theta), 0.2e1)) * p.x + Math.sin(theta) / (Math.pow(Math.cos(theta), 0.2e1) + Math.pow(Math.sin(theta), 0.2e1)) * p.y;
		r.y = -Math.sin(theta) / (Math.pow(Math.cos(theta), 0.2e1) + Math.pow(Math.sin(theta), 0.2e1)) * p.x + Math.cos(theta) / (Math.pow(Math.cos(theta), 0.2e1) + Math.pow(Math.sin(theta), 0.2e1)) * p.y;

		//		System.out.println(r.x+" "+r.y);

		return r.x >= 0 && r.y >= 0 && r.x <= w*zoom && r.y <= h*zoom;
	}

	void paint (Graphics2D g) {
		if (print)
			g.fillOval((int)projectBig(DoublePoint.P00).x-2, (int)projectBig(DoublePoint.P00).y-2, 5, 5);
		g.drawLine((int)projectBig(DoublePoint.P00).x, (int)projectBig(DoublePoint.P00).y, (int)projectBig(DoublePoint.P01).x, (int)projectBig(DoublePoint.P01).y);
		g.drawLine((int)projectBig(DoublePoint.P01).x, (int)projectBig(DoublePoint.P01).y, (int)projectBig(DoublePoint.P11).x, (int)projectBig(DoublePoint.P11).y);
		g.drawLine((int)projectBig(DoublePoint.P11).x, (int)projectBig(DoublePoint.P11).y, (int)projectBig(DoublePoint.P10).x, (int)projectBig(DoublePoint.P10).y);
		g.drawLine((int)projectBig(DoublePoint.P00).x, (int)projectBig(DoublePoint.P00).y, (int)projectBig(DoublePoint.P10).x, (int)projectBig(DoublePoint.P10).y);
		if (print)
			g.drawString(String.valueOf(id), (int)projectBig(DoublePoint.PM).x, (int)projectBig(DoublePoint.PM).y);
	}


	class SizeChangeListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			zoom = ((JSlider)e.getSource()).getValue() / 100.0;

			//			System.out.println("Rectangle "+id+"\tZoom="+zoom);
			IteriertesFunktionssystem.repaint();
		}

	}

	class AngleChangeListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			theta = Math.toRadians(((JSlider)e.getSource()).getValue());
			//			System.out.println("Rectangle "+id+"\tAngle="+theta);
			IteriertesFunktionssystem.repaint();

		}

	}
}

