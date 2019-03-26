package projet_2_agents.comp;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import projet_2_agents.Agents.Entree;

public class View_management extends Behaviour {
	public void action() {
		ACLMessage m = myAgent.receive();
		//m.setContent("je suis l'agent" + ((Producteur)myAgent).getNUm());
		if (m==null) {
			block(100);}
		else {
			((Entree)myAgent).setX();
		}
	}
	
	
	
	public boolean done() {
		return false;
	}
}
