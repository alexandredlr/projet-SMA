package projet_2_agents;

import jade.core.Runtime;

import java.util.ArrayList;
import java.util.Random;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import projet_2_agents.utils.Pair;
import projet_2_agents.Agents.*;

public class Lanceur {
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	private static final Random rand= new Random();

	public static void main(String[] args) throws StaleProxyException {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.instance();
		rt.setCloseVM(true);
		Profile pMain = new ProfileImpl("localhost", 8887, null);
		AgentContainer mc = rt.createMainContainer(pMain);
		
//		for (int i=0;i<2;i++) {
//			AgentController ac=mc.createNewAgent("toto_" + String.valueOf(i) , "projet_2_agents.Ligne", 
//				new Object[] {rand.nextInt(10),i });
//			ac.start();
//		}
		
		Pair requis=new Pair(10,1);
		ArrayList<Pair> requis_list=new ArrayList<Pair>();
		requis_list.add(requis);
		ArrayList<String> lignes_entrees=new ArrayList<String>();
		lignes_entrees.add("Ligne1");
		
		
		AgentController ac2=mc.createNewAgent("Entree", "projet_2_agents.Agents.Entree", 
				new Object[] {10});
		ac2.start();
		AgentController ac=mc.createNewAgent("Ligne1", "projet_2_agents.Agents.Ligne", 
				new Object[] {1,100,"Entree","Transformateur",10});;
		ac.start();
		AgentController ac5=mc.createNewAgent("Ligne2", "projet_2_agents.Agents.Ligne", 
				new Object[] {1,100,"Transformateur","Transformateur",10});
		ac5.start();
		//AgentController ac3=mc.createNewAgent("View", "projet_2_agents.Agents.View_Agent", 
			//	new Object[] {});;
		//ac3.start();
		AgentController ac4=mc.createNewAgent("Transformateur", "projet_2_agents.Agents.Transformateur", 
				new Object[] {requis_list, 100,1,2,lignes_entrees,"Ligne2"});;
		ac4.start();
		
	
		
		
	}

}
