package projet_2_agents.utils;

import java.awt.Dimension;

import javax.swing.JFrame;



public class Main {

		public static void main(String[] args) {
			JFrame f = new JFrame("ma fenetre");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dessin p = new Dessin();
			p.setPreferredSize(new Dimension(800,600));
			f.add(p);
			(new Thread() {
				public void run() {
				System.out.println("hello");
				p.setX();
				for(int i=0;i<100;i++) {
				try { Thread.sleep(100); }
				catch (InterruptedException e) { }
				
				p.setX();
				}
				}
				}).start();
			f.pack();
			f.setVisible(true);
		}

	}
 
