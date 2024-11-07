package Devoir.BankSystem_p1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.DeserializationFeature;

//Erreurs a cause de changement de la version initial de la classe Trasaction
// Des Problemes de convertition concernant localDateTime et autres
// Ne fonctionne pas correctement 

public class TransactionConvertisseur {
	public static String transactoJson(Transaction transaction) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(transaction);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
		
	}
	
	public static Transaction JsontoTransac(String json) {
        Transaction transaction = null;
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
        try {
            transaction = mapper.readValue(json, Transaction.class);
        } catch (Exception e) {
            e.printStackTrace();  
        }
        return transaction;
    }
}


