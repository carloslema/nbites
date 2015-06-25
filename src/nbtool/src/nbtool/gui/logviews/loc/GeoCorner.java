package nbtool.gui.logviews.loc;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class GeoCorner {
	float x,y;
	int id;

	public GeoCorner() {
		x = 0;
		y = 0;
		id = -1;
	}

	public GeoCorner(float cx, float cy, int c_id) {
		x = cx;
		y = cy;
		id = c_id;
	}

	public void draw(Graphics2D g2, boolean shouldFlip) {
		Font font = new Font("Sans_Serif", Font.PLAIN, 30);
		g2.setColor(Color.black);
    	g2.setFont(font);

		switch(id) {
			case 0: g2.drawString("C",x,y);
					break;
			case 1: g2.drawString("V",x,y);
					break;
			case 2: g2.drawString("T",x,y);
		}

	}
}