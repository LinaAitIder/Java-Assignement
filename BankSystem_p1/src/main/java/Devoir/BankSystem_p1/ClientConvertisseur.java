package Devoir.BankSystem_p1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ClientConvertisseur {
	
	//Meth.Qui converti le client objet en Json
	public static String clientoJson(Client client) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(client);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	//Meth.Qui converti le client json en un obj Client
	public static Client stringtoClient(String json) {
		Client jsonCnvrtToClient = null;
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			 jsonCnvrtToClient  = mapper.readValue(json,Client.class);
		} catch (JsonMappingException e) {
			e.printStackTrace(); 
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 
		return jsonCnvrtToClient ;
	}

}
