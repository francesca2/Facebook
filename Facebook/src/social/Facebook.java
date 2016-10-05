package social;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Facebook {
	
/*
 *  classe contenente i metodi per gestire gli utenti e le liste di amici,
 *  1 metodo per registrare l'utente (void), 
 *  2 metodo per aggiungere gli amici (void), 
 *  3 metodo per restituire gli amici di un utente(ritorna una lista e ha in input nome e cognome),
 *  4 metodo per vedere (get) gli amici di amici,
 *  5 metodo per creare un gruppo
 */
		
	private List<Utente> ListaUtenti = new ArrayList<Utente>();
	private Map<String, List<Utente>> mappaGruppi = new TreeMap<String,List<Utente>>();

	public Facebook() {

}
	
	public Facebook(List<Utente> listaUtenti) {
	ListaUtenti = listaUtenti;
}

	public List<Utente> getListaUtenti() {
		return ListaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		ListaUtenti = listaUtenti;
	}
	
	public Map<String, List<Utente>> getMappaGruppi() {
		return mappaGruppi;
	}

	public void setMappaGruppi(Map<String, List<Utente>> mappaGruppi) {
		this.mappaGruppi = mappaGruppi;
	}

	public String toString(Utente v)
	{
		String 	str3= v.getNome() + " " + v.getCognome();
		
		return str3;
	}
	
	//registra l'utente
	
	public void registraUtente(String nome, String cognome, int eta, char sesso, String email)
	{
		Utente v = new Utente (nome, cognome, eta, sesso, email);
		
		if(email.contains("@"))
		{
		ListaUtenti.add(v);
		}

	}

	//aggiunge gli amici
	
	public void aggiungiAmici(String u1,String u2)
	{
		String str="";
		String str2="";
		
		for(Utente u : ListaUtenti)
		{
			str=u.getNome() + " " + u.getNome();
			
			for (Utente v : ListaUtenti)
			{
				
				str2= v.getNome() + " " + v.getCognome();
				
				if(str.equals(u1) && str2.equals(u2))
				{
					u.inserisciAmici(v);
					v.inserisciAmici(u);
				}
	
			}

		}
	}
	
	//restituire gli amici
	
	public String getAmiciDiUnUtente(String nome, String cognome)
	{
		String str="";
		
		Utente v=trovaUtente(nome,cognome);
		
				for(Utente u: v.getAmici())
				{
					str+= u.getNome() + " " + u.getCognome() + "\n";
				}
		
	return str;

	}
	
	//amici di amici
	
	public String getAmiciDiAmici(String nome, String cognome)
	{	
				String str="";
				List<Utente> ListaAmiciDiAmici = new ArrayList<Utente>();
		
				Utente v=trovaUtente(nome,cognome);	
				
				for(Utente u: v.getAmici())
				{
					for(Utente a: u.getAmici())
					{
						if(!a.getNome().equals(nome) &&!a.getCognome().equals(cognome)|| !v.getAmici().contains(a)|| !ListaAmiciDiAmici.contains(a) )
						{
						
						
//							str= str + a.getNome()+ " " + a.getCognome() + " \n";
							ListaAmiciDiAmici.add(a);
						}
					}
				}
					
		if(ListaAmiciDiAmici.isEmpty())
		{
			str= "Non ci sono amici di amici che non conosci";
		}
		else{
		for(Utente u : ListaAmiciDiAmici)
		{
			str= str+ u.getNome() + " " + u.getCognome() + "\n";
		}
		}		
		
		return str;
	}
	
	//Amici in comune
	
	public String getAmiciComuni(String utente1, String utente2)
	{
		String str="";
		String str1="";
		String str2="";
		List<Utente> AmiciComuni = new ArrayList<Utente>();
		
		for(Utente u: ListaUtenti)
		{
			str1= u.getNome() + " " + u.getCognome();
			
			for(Utente v: ListaUtenti)
			{
				str2= v.getNome() + " " + v.getCognome();
				
				if(str1.equals(utente1) && str2.equals(utente2))
				{
					for(Utente t: v.getAmici())
					{
						for(Utente s: u.getAmici())
						{
							if(v.getAmici().contains(s)&& !AmiciComuni.contains(s))
							{
								AmiciComuni.add(s);
							}
						}

					}
				break;
				}

			}
				
		}
		
		if(AmiciComuni.isEmpty())
		{
			str= "Non ci sono amici di amici comuni";
		}
		else{
		for(Utente u : AmiciComuni)
		{
			str= str+ u.getNome() + " " + u.getCognome() + "\n";
		}
		}
		
		return str;
	}
	
	//Crea gruppo
	public boolean creaGruppo(String nomeGruppo, Utente u) throws NomeGruppoEsistente
	{
		boolean b=false;
		if(!mappaGruppi.containsKey(nomeGruppo))
		{
		List<Utente> listaGruppo = new ArrayList<Utente>();
		listaGruppo.add(u);
		this.mappaGruppi.put(nomeGruppo,listaGruppo);
		b=true;
		}
		else
		{
			throw new NomeGruppoEsistente("Il gruppo " + nomeGruppo + " è già stato creato. Scegli un nuovo nome oppure registrati al gruppo");
		}
		return b;
	}
	
	//Aggiungi utente a gruppo
	public void aggiungiUtenteAGruppo(String nomeGruppo, Utente u)
	{
		mappaGruppi.get(nomeGruppo).add(u);
	}
	
	//Cerca utente
	private Utente trovaUtente(String nome, String cognome)
	{
		Utente v= new Utente();
		
		for(Utente u: ListaUtenti)
		{
			if(u.getNome()==nome && u.getCognome()==cognome)
			{
				v=u;
				break;
			}
			else
			{
				continue;
			}
		}
		return v;
	}
}