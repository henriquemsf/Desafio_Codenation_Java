package application;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.json.simple.parser.ParseException;
import entities.Decrypt;
import entities.HttpRequest;
import entities.LerJson;
import entities.Sha1;

public class Application {

	public static final void main(String[] args) throws IOException, ParseException, NoSuchAlgorithmException {
		
		String token = "";
		
		String site = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + token;
		
		HttpRequest.Request_Get(site);
		
		String cripto = LerJson.GetCypher();
		
		String traducao = Decrypt.decrypt(cripto);
		
		LerJson.SetTranslation(traducao);
		
		String traducao_sha1 = Sha1.sha1(traducao);
		
		LerJson.SetSha1(traducao_sha1);

	}

}
