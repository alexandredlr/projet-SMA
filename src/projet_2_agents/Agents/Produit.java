package projet_2_agents.Agents;

import java.util.Random;

import jade.core.Agent;

public class Produit extends Agent{
		
	private int type;
	private boolean state;
	
	
	public void setup() {
		Object[] args=getArguments();
		type=(int)args[0];
		state=(boolean)args[1];
		//System.out.println(this.getLocalName() + " : " + this.state);
		
		//addBehaviour(new Production());
	}
	
	public int getType() {
		return type;
	}
	
	public int getState(){
		return state ? 1 : 0;
	}
}