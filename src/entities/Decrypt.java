package entities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

public class Decrypt {
	
	public static final String decrypt(String frase) throws NumberFormatException, FileNotFoundException, IOException, ParseException {
		
		//Criar uma Lista com cada caracter do alfabeto
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		
		List<Character> list = new ArrayList<>();
		
		for (char l : alfabeto.toCharArray()) {
			list.add(l);
		}
		
		StringBuilder traducao = new StringBuilder("");
		
		//Pegar o numero de casas do arquivo Json
		Integer casas = Integer.parseInt(LerJson.GetN());
		
		//Dividir a frase a ser decifrada em caracteres individuais
		for (char l : frase.toLowerCase().toCharArray()) {
	
			//Se o caracter da frase existe no dicionario, adicionar a letra anterior na frase
			if (list.contains(l)) {
				int cifrado = list.indexOf(l);
				int original = cifrado - casas;
				// Tratar de excecoes do inicio do alfabeto 
				if (original < 0) {
					original = list.size() + original;
					traducao.append(list.get(original));
				}
				else {
					traducao.append(list.get(original));
				}		
			}
			//Caracteres especiais, como / e . devem continuar iguais
			else {
				traducao.append(l);
			}
			
		}		
		
		//Retornar uma String da cifra traduzida
		return traducao.toString();
		
	}

}
