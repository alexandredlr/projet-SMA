package projet_2_agents.Agents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jade.core.Agent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import projet_2_agents.utils.Dessin;
import projet_2_agents.utils.Main;


public class View_Agent extends Agent{
	
	
	
	Dessin d;
			
	public void setup() {
		Object[] args=getArguments();
		System.out.println("View créée");
		d=new Dessin();
		//addBehaviour(new View_management());
		
		String[] args1={};
		Main.main(args1);

	}
		
	public Dessin getView() {
		return d;
	}
	
}



