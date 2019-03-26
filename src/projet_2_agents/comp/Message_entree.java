package projet_2_agents.comp;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import projet_2_agents.Agents.Entree;


//comportement d'entrée qui lorsqu'elle est contacté par une ligne créé un produit et prévient la ligne
// qu'elle y a injecté un produit (avec le nom du produit)

public class Message_entree extends Behaviour {
	public boolean done=false;
	
	public void action() {
		ACLMessage m = myAgent.receive();
		//m.setContent("je suis l'agent" + ((Producteur)myAgent).getNUm());
		if (m==null) {
			block(1000);}
		else {
			String product_name=((Entree)myAgent).createProduct();
			
			//réponse d'un produit créé à la ligne
			
			ACLMessage info_ligne = new ACLMessage(ACLMessage.INFORM);
			info_ligne.setContent(product_name);
			info_ligne.addReceiver(m.getSender());
			
			myAgent.send(info_ligne);
			System.out.println("création d'un produit et réponse de l'entrée ");
			
			//envoie de l'info à la view
			
			//ACLMessage info_view = new ACLMessage(ACLMessage.INFORM);
			//info_view.setContent(m.getContent());
			//info_view.addReceiver(new AID("View", AID.ISLOCALNAME));
			//System.out.println("message reçu : " + m.getContent());
			//myAgent.send(info_view);
			block(10000);
		}
	}
	
	public boolean done() {
		return done;
	}
}
