package entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LerJson {
	
	//Retornar o numero de casas a serem subtraidas a partir da chave "numero_casas"
	public static final String GetN() throws FileNotFoundException, IOException, ParseException {		
	    JSONParser jsonParser = new JSONParser();	    
	    try (FileReader reader = new FileReader("answer.json"))
	    {	    	
	    	Object obj = jsonParser.parse(reader);	    	
	    	JSONObject jsonObject = (JSONObject) obj;	    		    	
	    	return jsonObject.get("numero_casas").toString();   	
	    }
	}
	
	//Retornar a cifra a partir da chave "cifrado"
	public static final String GetCypher() throws FileNotFoundException, IOException, ParseException {		
	    JSONParser jsonParser = new JSONParser();	    
	    try (FileReader reader = new FileReader("answer.json"))
	    {	    	
	    	Object obj = jsonParser.parse(reader);	    	
	    	JSONObject jsonObject = (JSONObject) obj;
	    	
	    	return jsonObject.get("cifrado").toString();   	
	    }
	}
	
	//Atualizar a chave "decifrado" com a traducao da cifra
	@SuppressWarnings("unchecked")
	public static final void SetTranslation(String traducao) throws FileNotFoundException, IOException, ParseException{
		JSONParser jsonParser = new JSONParser();	    
	    try (FileReader reader = new FileReader("answer.json"))
	    {	    	
	    	Object obj = jsonParser.parse(reader);	    	
	    	JSONObject jsonObject = (JSONObject) obj;
	    	System.out.println(jsonObject);
	    	jsonObject.put("decifrado", traducao);      				
			FileWriter file = new FileWriter("answer.json");
			file.write(jsonObject.toString());
			file.close();
	    }
	}
	
	//Atualizar a chave "resumo_criptografico" com a criptografia Sha1
	@SuppressWarnings("unchecked")
	public static final void SetSha1(String criptografado) throws FileNotFoundException, IOException, ParseException{
		JSONParser jsonParser = new JSONParser();	    
	    try (FileReader reader = new FileReader("answer.json"))
	    {	    	
	    	Object obj = jsonParser.parse(reader);	    	
	    	JSONObject jsonObject = (JSONObject) obj;
	    	System.out.println(jsonObject);
	    	jsonObject.put("resumo_criptografico", criptografado);      				
			FileWriter file = new FileWriter("answer.json");
			file.write(jsonObject.toString());
			file.close();
	    }
	}
	
}
