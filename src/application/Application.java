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
		
		//Token Individual
		String token = "";
		
		String site = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + token;
		
		//Acessar o site e gerar um arquivo .json
		HttpRequest.Request_Get(site);
		
		//Ler o Json e criar uma String com a cifra
		String cripto = LerJson.GetCypher();
		
		//Criar uma String com a traducao da cifra
		String traducao = Decrypt.decrypt(cripto);
		
		//Atualizar o Json com a traducao
		LerJson.SetTranslation(traducao);
		
		//Gerar a Criptografia Sha1
		String traducao_sha1 = Sha1.sha1(traducao);
		
		//Atualizar o Json com a Sha1
		LerJson.SetSha1(traducao_sha1);

	}

}
