package Devoir.BankSystem_p1;
import java.util.ArrayList;

public class ClientConvertisseurTest {
	public static String client2JsonTest(){
		Client client2json = new Client(12234 ,"Lina","Ait Ider","Marrakech","linaitider@gmail.com","0655878499", new ArrayList<Compte>());
		String json = ClientConvertisseur.clientoJson(client2json);
		return json;
	}
	public static Client Json2clientTest() {
        String json2Client = "{\"numClient\":123456,\"nom\":\"Doe\",\"prenom\":\"John\",\"adresse\":\"Marrakech\",\"email\":\"john.doe@example.com\",\"phone\":\"1234567890\",\"lesComptes\":[]}}";
		Client client = ClientConvertisseur.stringtoClient(json2Client);
		return client;
	}
}
