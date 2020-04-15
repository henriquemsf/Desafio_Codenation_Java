package entities;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class HttpRequest {
	
	public static final void Request_Get(String site) throws IOException {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		//Realizar uma conexao com o site e obter o codigo de resposta do mesmo
		URL url = new URL(site); 
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		String method = "GET";		
		conn.setRequestMethod(method);
		conn.connect();
		int responsecode = conn.getResponseCode();
		
		//Ler a mensagem ou erro do site
		if (responsecode != 200) {
			reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			while((line = reader.readLine()) != null){
				responseContent.append(line);
			}
		}
		else {
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((line = reader.readLine()) != null){
				responseContent.append(line);
			}
			conn.disconnect();	    
		}
		
		//Criar um objeto Json com a resposta do site
		JSONObject jsonObject = new JSONObject(responseContent.toString());
		
		//Criar um arquivo .json
		FileWriter file = new FileWriter("answer.json");
		file.write(jsonObject.toString());
		file.close();  
	    
	}
	


}
