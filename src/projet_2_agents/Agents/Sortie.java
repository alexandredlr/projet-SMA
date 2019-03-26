package projet_2_agents.Agents;

import java.util.Random;

import jade.core.Agent;

public class Sortie extends Agent{
		
	private int quantity;

	
	
	public void setup() {
		Object[] args=getArguments();
		quantity=(int)args[0];
		System.out.println("Sortie avec quantité : " + this.quantity);
		
		//addBehaviour(new Production());
	}
	
	public int getQuantity() {
		return quantity;
	}

}