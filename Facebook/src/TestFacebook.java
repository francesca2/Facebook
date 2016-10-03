import java.util.Map;

import social.*;

public class TestFacebook {


	public static void main(String[] args) {
		Facebook f=new Facebook();
			
		Utente u1 = new Utente("aaaa","aaaa",18,'M',"aaaa@alfa.com");
		
		Utente u2 = new Utente("bbbb","bbbb",18,'M',"bbbb@alfa.com");
		
		Utente u3= new Utente("cccc","cccc",28,'f',"cccc@alfa.com");
		
		Utente u4=new Utente("dddd","dddd",28,'F',"dddd@alfa.com");
		
		Utente u5=new Utente("eeeee","eeee",28,'F',"eeeee@alfa.com");
		
		
		f.registraUtente("aaaa","aaaa",18,'M',"aaaa@alfa.com");
		f.registraUtente("bbbb","bbbb",18,'M',"bbbb@alfa.com");
		f.registraUtente("cccc","cccc",28,'f',"cccc@alfa.com");
		f.registraUtente("dddd","dddd",28,'F',"dddd@alfa.com");
		f.registraUtente("eeeee","eeee",28,'F',"eeeee@alfa.com");
		
		
		
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u2.getNome() + " " + u2.getCognome());
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u3.getNome() + " " + u3.getCognome());
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u4.getNome() + " " + u4.getCognome());
		f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u5.getNome() + " " + u5.getCognome());
		f.aggiungiAmici(u2.getNome() + " " + u2.getCognome(), u3.getNome() + " " + u3.getCognome());
		f.aggiungiAmici(u2.getNome() + " " + u2.getCognome(), u4.getNome() + " " + u4.getCognome());
		
//		for(Utente v : f.getListaUtenti())
//		{
//			System.out.println(f.toString(v));
//		}
		
		System.out.println("Amici di cccc: \n" + f.getAmiciDiUnUtente("cccc","cccc"));
		
		
		System.out.println("Amici di amici di cccc: \n" + f.getAmiciDiAmici("cccc","cccc"));

		System.out.println("Amici comuni: \n" + f.getAmiciComuni(u1.getNome() + " " + u1.getCognome(), u2.getNome() + " " + u2.getCognome()));
		
		try {
			f.creaGruppo("Gruppo1", u1);
		} catch (NomeGruppoEsistente e) {
	System.out.println(e.getMessage());
		}
		
		try {
			f.creaGruppo("Gruppo1", u1);
		} catch (NomeGruppoEsistente e) {
	System.out.println(e.getMessage());
		}
		
		f.aggiungiUtenteAGruppo("Gruppo1", u2);
		
		System.out.println("Gruppi creati: \n");
		
		for(Map.Entry m : f.getMappaGruppi().entrySet())
		{
			System.out.println(m.getKey() + ":");
			for(Utente u : f.getMappaGruppi().get(m.getKey()))
			{
				System.out.println(u.getNome()+ " " + u.getCognome());
			}
		}
		
	}


}
