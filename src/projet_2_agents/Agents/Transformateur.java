package projet_2_agents.Agents;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import jade.core.Agent;
import projet_2_agents.utils.Pair;
import projet_2_agents.comp.Comp_transfo_reception_produits;

public class Transformateur extends Agent{
		
	private ArrayList<Pair> required;
	private int time;
	private int prob;
	private int output_type;
	private Hashtable<Integer,Integer> stocks;
	private ArrayList<String> lignes_entree;
	private String ligne_sortie;
	
	
	
	
	
	
	public void setup() {
		Object[] args=getArguments();
		required=(ArrayList<Pair>)args[0];
		time=(int)args[1];
		prob=(int)args[2];
		output_type=(int)args[3];
		stocks=new Hashtable<Integer,Integer>();
		lignes_entree=(ArrayList<String>)args[4];
		ligne_sortie=(String)args[5];
		System.out.println("Tranfsormateur créé");
		addBehaviour(new Comp_transfo_reception_produits());
	}
	
	public int getTime() {
		return time;
	}
	
	public int getProb(){
		return prob;
	}
	
	public ArrayList<Pair> getRequired(){
		return required;
	}
	
	
	public boolean readyToProduct() {
		boolean ready=true;
		for (int i = 0; i < required.size(); i++) {
			if (required.get(i).getRight()>stocks.get(required.get(i).getLeft())) {
				ready=false;
			}
		}
		return ready;
	}
	
	
	
	
	
	public int getOutput(){
		return output_type;
	}
}