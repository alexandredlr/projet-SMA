package projet_2_agents.comp;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class Comp_transfo_reception_produits extends Behaviour {
	
public boolean done=false;
	
	public void action() {
				
		ACLMessage m = myAgent.receive();
		//m.setContent("je suis l'agent" + ((Producteur)myAgent).getNUm());
		if (m==null) {
			block(1000);}
		else {
			
			try {
				System.out.println("produit reçu par transfo : " + m.getContentObject().product_name);
				block(10000);
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	public boolean done() {
		return done;
	}

}
