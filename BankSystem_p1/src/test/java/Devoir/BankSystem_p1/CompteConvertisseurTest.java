package Devoir.BankSystem_p1;

import java.util.ArrayList;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class CompteConvertisseurTest {
	public static String compte2JsonTest(){
		ArrayList<Transaction> transactList = new ArrayList<Transaction>();
		ArrayList<Compte> compteList = new ArrayList<Compte>();
		ArrayList<Compte> bankCompteList = new ArrayList<Compte>();
		Banque banque = new Banque("12234","Maroc", bankCompteList);
		Client client = new Client(12234 ,"Lina","Ait Ider","Marrakech","linaitider@gmail.com","06558784--", compteList);
		Compte account2Json = new Compte("LinaAitIder","21/02/2023","14/04/2024","D94848", client, banque, transactList);
		String json = CompteConvertisseur.comptetoJson(account2Json);
		return json;
	}
	public static Compte Json2compteTest() {
		    String json2Account = "{"
	    	        + "\"nomCompte\":\"JohnDoe\","
	    	        + "\"dateCreation\":\"21.02.2000\","
	    	        + "\"dateUpdate\":\"14/04/2024\","
	    	        + "\"devise\":\"1234Jd343\","
	    	        + "\"owner\":{"
	    	        +     "\"numClient\":123456,"
	    	        +     "\"nom\":\"John\","
	    	        +     "\"prenom\":\"Doe\","
	    	        +     "\"adresse\":\"France\","
	    	        +     "\"email\":\"JohnDoe@gmail.com\","
	    	        +     "\"phone\":\"0603993983--\","
	    	        +     "\"lesComptes\":[]"
	    	        + "},"
	    	        + "\"bank\":{},"
	    	        + "\"transOperations\":[]"
	    	        + "}";

		Compte compte = CompteConvertisseur.Jsontocompte(json2Account);
		return compte;
	}
}
