package entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LerJson {
	
	public static final String GetN() throws FileNotFoundException, IOException, ParseException {		
	    JSONParser jsonParser = new JSONParser();	    
	    try (FileReader reader = new FileReader("answer.json"))
	    {	    	
	    	Object obj = jsonParser.parse(reader);	    	
	    	JSONObject jsonObject = (JSONObject) obj;	    		    	
	    	return jsonObject.get("numero_casas").toString();   	
	    }
	}
	
	public static final String GetCypher() throws FileNotFoundException, IOException, ParseException {		
	    JSONParser jsonParser = new JSONParser();	    
	    try (FileReader reader = new FileReader("answer.json"))
	    {	    	
	    	Object obj = jsonParser.parse(reader);	    	
	    	JSONObject jsonObject = (JSONObject) obj;
	    	
	    	return jsonObject.get("cifrado").toString();   	
	    }
	}
	
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
