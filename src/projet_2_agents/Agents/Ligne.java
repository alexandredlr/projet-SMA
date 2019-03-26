package projet_2_agents.Agents;

import java.util.ArrayList;
import java.util.Random;

import jade.core.Agent;
import projet_2_agents.comp.Comp_ligne_transmission_sortie;
import projet_2_agents.comp.Envoi_message_entree;
import projet_2_agents.comp.Comp_ligne_recevoir_message_entree;

public class Ligne extends Agent{
		
	private int capacity;
	private int nb_produits;
	public String entree;
	public String sortie;
	public ArrayList<String> produits; 
	public int transmission_time;
	public int type;
	
	
	
	public void setup() {
		Object[] args=getArguments();
		capacity=(int)args[0];
		System.out.println("Ligne avec capacité: " + this.capacity );
		produits = new ArrayList<String>();
		this.transmission_time=(int)args[1];
		entree=(String)args[2];
		sortie=(String)args[3];
		type=(int)args[4];
		addBehaviour(new Envoi_message_entree());
		addBehaviour(new Comp_ligne_transmission_sortie());	
		addBehaviour(new Comp_ligne_recevoir_message_entree());
	}
	
	public String getSortie() {
		return this.sortie;
	}
	
	public int getType() {
		return this.type;
	}
	
	public int getTransTime() {
		return this.transmission_time;
	}
	
	public String getEntree() {
		return this.entree;
	}
	
	public boolean getProducts() {
		return (this.nb_produits>0);
	}
	
	public String getNextProduct() {
		return produits.get(0);
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void addProduct(String product_aid) {
		this.nb_produits++;
		produits.add(product_aid);
		System.out.println("produit créé, nbre de produits dans la ligne : " + this.nb_produits);
	}
	
	public void removeProduct() {
		this.nb_produits--;
		produits.remove(0);
		System.out.println("produit supprimé, nbre de produits dans la ligne : " + this.nb_produits);

		
	}
	
	public boolean getDispo() {
		return (this.nb_produits<this.capacity);
		
	}
	
}