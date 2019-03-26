package projet_2_agents.comp;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import projet_2_agents.Agents.Ligne;




public class Comp_ligne_recevoir_message_entree extends Behaviour {
	public boolean done=false;
	
	public void action() {
		
		MessageTemplate mt = 
			       MessageTemplate.and( 
			    	   MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
			           MessageTemplate.MatchSender(new AID(((Ligne)myAgent).getEntree(), AID.ISLOCALNAME)));
		
		
		ACLMessage m = myAgent.receive(mt);
		if (m==null) {
			block(10000);}
		else {
			((Ligne)myAgent).addProduct(m.getContent());
			System.out.println("Reception du message d'entrée vers la ligne avec content : " + m.getContent());
			
			block(10000);
		}
	}
	
	public boolean done() {
		return done;
	}
}
