package Devoir.BankSystem_p1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// This importation what does it mean ?
public class CompteConvertisseur {
	public static String comptetoJson(Compte compte) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(compte);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
		
	}
	public static Compte Jsontocompte(String json) {
		Compte convertedJsonAccount = null;
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			 convertedJsonAccount = mapper.readValue(json,Compte.class);
		} catch (JsonMappingException e) {
			e.printStackTrace(); //printStackTrace() use?
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 
		return convertedJsonAccount;
		
	}
}

	