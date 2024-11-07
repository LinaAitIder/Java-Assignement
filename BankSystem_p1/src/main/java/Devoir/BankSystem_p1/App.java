package Devoir.BankSystem_p1;


import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
    	
    	Client firstClient = new Client(1,"Lina","AitIder","Agadir","linaitider@gmail.com","0655------", new ArrayList<Compte>());

    	ArrayList<Compte> CompteFirstClient = new ArrayList<Compte>();
    	Banque banque = new Banque();
    	CompteFirstClient.add(new Compte("LinaAitIder","06.11.2023","07.11.2024","D1238N00",firstClient,banque,new ArrayList<Transaction>()));
    	
    	firstClient.setLesComptes(CompteFirstClient);
    	
    	System.out.println("----- le premier Client ------" +firstClient);
    	
    }
}

//---Notes 
/* Si on fait appel au client sans avoir la fonction 
 * toString définie dans notre classe, Java va créer une fonction toString par défaut 
 * qui affichera aussi la liste des comptes des clients. Cela peut conduire à une boucle infinie 
 * car, dans ce cas, pour chaque compte, il réalise la fonction toString des comptes, 
 * les comptes ayant un objet client. La fonction toString sera alors implémentée pour le client 
 * de ce compte et on aura une boucle infinie. */
