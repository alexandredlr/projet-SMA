package projet_2_agents.Agents;

import java.util.Random;

import jade.core.Agent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import projet_2_agents.comp.Message_entree;


public class Entree extends Agent{
		
	private int type;	
	static int nb_produits_crees;
	
	
	public void setup() {
		Object[] args=getArguments();
		type=(int)args[0];
		System.out.println("Entrée de type : " + this.type);
		
		addBehaviour(new Message_entree());
	}
	
	public int getType() {
		return type;
	}	
	
	public String createProduct() {
		this.nb_produits_crees++;
		String name = "Produit_" + String.valueOf(this.nb_produits_crees) ;
        AgentContainer c = getContainerController();
        try {
            AgentController a = c.createNewAgent( name , "projet_2_agents.Agents.Produit", new Object[] {type,true} );
            a.start();
        }
        catch (Exception e){}
        
        return name;
	}
}