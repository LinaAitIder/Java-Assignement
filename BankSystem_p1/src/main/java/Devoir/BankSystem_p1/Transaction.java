package Devoir.BankSystem_p1;

import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import lombok.Value;


@Value

public class Transaction {
	
	final private LocalDateTime timeStamp ; 
	final private String reference ;
	final private type transactionType;
	final private double montant;
	final private int nombreRecepteur;
	final private String paysOrigin;
	final private String paysDestination;
	final private List<Compte> comptes ;
	
	
	 public Transaction(double montant, LocalDateTime date, String paysOrigin,String paysDestination, int nombreRecepteur , List<Compte> comptes) {
		this.montant = montant;
		this.timeStamp = date;
		this.paysOrigin = paysOrigin;
		this.paysDestination = paysDestination;
		this.nombreRecepteur = nombreRecepteur;
        this.comptes = Collections.unmodifiableList(comptes); 
		this.transactionType = calculateTransactionType();
		/* Normallement la ref doit representee un mixte de nombres et 
		 * caracteres et doit etre unique mais oublie 
		 */
	    this.reference = String.valueOf(Math.random()*1000);  
	  }
	
	  
	  final public type calculateTransactionType() {
		  //Un seul Recipient ou plusieurs?
		  if(nombreRecepteur > 1) {
			  return type.VIRMULTA; 
		  }
		  //si un  Recipient , la meme banque ou different banque	  
		  else {
			  if(paysOrigin.equals(paysDestination)){
				  	if(areFromSameBank()) {
					 return type.VIREST;
				  	} else {
				  		return type.VIRINI;
				  	}
					 //meme pays ==banques
					 //return type.VIRINI;
				  } else if(!paysOrigin.equals(paysDestination)){
					  return type.VIRCHA; 
				  }
		  }
	     return null;  	  
	  }
	  
	  
	  private boolean areFromSameBank() {
		  //On recupere l'id de banque de premier Compte
		  String BankId = comptes.get(0).getBankId();
		  
		  for( Compte compte : comptes) {
			  //Si un des comptes n'a pas le meme banque id ,on return false
			  if(!compte.getBankId().equals(BankId)) {
				  return false;
			  }
		  }
		  //sinon on retourne true
		  return true;
		  
	  }
	 
	
}

enum type {
	VIRINI,
	VIREST,
	VIRCHA,
	VIRMULTA,
}

//----Notes
/* 
//@DATA this lombok expression conflicts with the immutable class concept
//so we need to use @Value since this expression was designed especially for immutable classes
//It provides getters for all fields , a constructor with all fields 
//and it also generates aprivate final field for each member variable
//Normally an immutable class shouldn't contain getters or setters so why does @Value provide getters ?
 * Reminder : An immutable class is designed to be unchanged meaning we cannot use setters but we can use getters
 * to get necessary informations
 * */
