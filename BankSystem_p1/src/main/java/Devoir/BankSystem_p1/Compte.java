package Devoir.BankSystem_p1;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import lombok.Data;


@Data
@AllArgsConstructor

public class Compte {
	
	private String nomCompte;
	private String dateCreation;
	private String dateUpdate;
	private String devise;
	//Un compte peut etre l'obj d'un seul client
	private Client owner;
	//le compte peut etre associer a une seule banque
	private Banque bank ;
	//Un compte peut Effectuer plusieurs Transactions
	private ArrayList<Transaction> transOperations;
	
	public Compte() {
		transOperations = new ArrayList<Transaction>();
	}
	
	@JsonIgnore
	public String getBankId() {
		return bank.getId();
	}
	
	public String toString() {
		return "\n"
				+ "num Client  :"+this.nomCompte+"\n"
				+ "nom         :" + this.dateCreation+"\n"
				+ "prenom      :" +this.dateUpdate+"\n"
				+ "adresse     :" + this.devise+"\n";	
	}
	
}

//------Notes
/*
 * Utilisation de @JsonIgnore Pour ne pas ajouter 
 * bankId au Json de compte lors de la convertion
 * du compte Obj
*/
 