package entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

public class Decrypt {
	
	public static final String decrypt(String frase) throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		
		List<Character> list = new ArrayList<>();
		
		for (char l : alfabeto.toCharArray()) {
			list.add(l);
		}
		
		StringBuilder traducao = new StringBuilder("");
		
		Integer casas = Integer.parseInt(LerJson.GetN());
		
		for (char l : frase.toLowerCase().toCharArray()) {
	
			if (list.contains(l)) {
				int cifrado = list.indexOf(l);
				int original = cifrado - casas;
				if (original < 0) {
					original = list.size() + original;
					traducao.append(list.get(original));
				}
				else {
					traducao.append(list.get(original));
				}		
			}
			else {
				traducao.append(l);
			}
			
		}		
		
		return traducao.toString();
		
	}

}
