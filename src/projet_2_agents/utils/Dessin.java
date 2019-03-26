package projet_2_agents.utils;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dessin extends JPanel {
	
	private int posx;


	public void setX() {
		System.out.println("hello 2");
		this.posx+=5;
		repaint();
	}
	
	@Override 
	public void paint(Graphics g) {
		g.clearRect(0, 0, 800, 600);
		g.setColor(Color.GRAY);
		g.fillRect(30, 30, 200, 100);
		g.fillRect(300, 30, 200, 100);
		g.fillRect(570, 30, 200, 100);
		g.setColor(Color.BLACK);
		g.drawLine(240, 90, 290, 90);
		g.drawRect(300, 30, 200, 100);
		g.drawRect(570, 30, 200, 100);
		g.drawRect(30, 30, 200, 100);
		g.setColor(Color.PINK);
		g.fillRect(this.posx, 15, 40, 30);
		g.drawLine(this.posx, 90, 290, 90);
	}
}