package projet_2_agents.Agents;

import java.util.Random;

import jade.core.Agent;

public class Verificateur extends Agent{
		
	private int type;
	private int time;
	
	
	public void setup() {
		Object[] args=getArguments();
		type=(int)args[0];
		time=(int)args[1];
		System.out.println("Produit en entrée : " + this.type + " // durée de traitement : " + this.time);
		
		//addBehaviour(new Production());
	}
	
	public int getType() {
		return type;
	}
	
	public int getTime(){
		return this.time;
	}
}