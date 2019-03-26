package projet_2_agents.comp;

import java.io.IOException;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import projet_2_agents.Agents.Ligne;
import projet_2_agents.utils.Message;

public class Comp_ligne_transmission_sortie extends Behaviour {
	public void action() {
		if (((Ligne)myAgent).getProducts()) {
			block(((Ligne)myAgent).getTransTime());
			ACLMessage m = new ACLMessage(ACLMessage.INFORM);
			int type =((Ligne)myAgent).getType();
			Message mes=new Message();
			mes.product_type=type;
			mes.product_name=(((Ligne)myAgent).getNextProduct());
			try {
				m.setContentObject(mes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.addReceiver(new AID((((Ligne)myAgent).getSortie()),AID.ISLOCALNAME));
			//System.out.println(((Ligne)myAgent).getLocalName());
			myAgent.send(m);
			((Ligne)myAgent).removeProduct();
			block(10000);
		}
		else {
			block(1000);
		}
	}
	
	
	
	public boolean done() {
		return false;
	}
}

