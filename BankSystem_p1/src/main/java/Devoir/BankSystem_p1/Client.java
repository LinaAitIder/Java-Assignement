package Devoir.BankSystem_p1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor

public class Client {
	private int numClient;
	private String nom;
	private String prenom;
	private String adresse; 
	private String email;
	private String phone;
	// Un Client possede plusieurs Comptes
	private ArrayList<Compte> LesComptes;
	
	@JsonCreator
	public Client(
			    @JsonProperty("numClient") int numClient,
		        @JsonProperty("nom") String nom,
		        @JsonProperty("prenom") String prenom,
		        @JsonProperty("adresse") String adresse,
		        @JsonProperty("email") String email,
		        @JsonProperty("phone") String phone
		){
		this.numClient= numClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email= email;
		this.phone= phone;
		LesComptes = new ArrayList<Compte>();
		}

	
	public String toString(){
		return "\n"
				+ "num Client  :"+this.numClient+"\n"
				+ "nom         :" + this.nom+"\n"
				+ "prenom      :" +this.prenom+"\n"
				+ "adresse     :" + this.adresse+"\n"
				+ "email       :" + this.email+"\n"
				+ "tel         :" +this.phone+"\n" ;
		
	}
}

//----Notes----

/*
 Sans @JSONCreator et @JSONProprety je rencontre des problemes 
 lors de la convertion vers json ou json en Objets
 */
