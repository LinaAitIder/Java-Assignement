package Devoir.BankSystem_p1;


import lombok.AllArgsConstructor;
import java.util.ArrayList;
import lombok.Data;


@Data
@AllArgsConstructor

public class Banque {
	
	private String id;
	private String pays;
    //Une banque retient plusieurs Comptes
	private ArrayList<Compte> comptes;

	public Banque(){
		comptes = new ArrayList<Compte>();
	}
	
}
