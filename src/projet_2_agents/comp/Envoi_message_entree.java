package projet_2_agents.comp;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import projet_2_agents.Agents.Ligne;


//comportement de ligne qui envoie un message à son entrée si elle peut transporter des produits

public class Envoi_message_entree extends Behaviour {
	public void action() {
		if (((Ligne)myAgent).getDispo()) {
			System.out.println("Message de dispo envoyé par ligne" + ((Ligne)myAgent).getLocalName() );
			ACLMessage m = new ACLMessage(ACLMessage.INFORM);
			m.setContent(((Ligne)myAgent).getLocalName());
			m.addReceiver(new AID(((Ligne)myAgent).getEntree(), AID.ISLOCALNAME));
			//System.out.println(((Ligne)myAgent).getLocalName());
			myAgent.send(m);
			block(10000);
		}
		else {
			block(10000);
		}
	}
	
	
	
	public boolean done() {
		return false;
	}
}
