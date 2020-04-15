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
		
		URL url = new URL(site); 
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		
		String method = "GET";
				
		conn.setRequestMethod(method);
		
		conn.connect();
		
		int responsecode = conn.getResponseCode();
		
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
		
		JSONObject jsonObject = new JSONObject(responseContent.toString());
		
		FileWriter file = new FileWriter("answer.json");
		file.write(jsonObject.toString());
		file.close();  
	    
	}
	


}
