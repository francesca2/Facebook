package social;

import java.util.ArrayList;
import java.util.List;

public class Utente {
	
	private String nome;
	private String cognome;
	private int eta;
	private char sesso;
	private String email;
	private List<Utente> Amici= new ArrayList<Utente>();
	
	public Utente() {
	}

	public Utente(String nome, String cognome, int eta, char sesso,
			String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		if(email.contains("@"))
		{
		this.email = email;
		}
		else
		{
			System.out.println("Email non valida");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Utente> getAmici() {
		return Amici;
	}

	public void setAmici(List<Utente> amici) {
		Amici = amici;
	}

public void inserisciAmici(Utente v)
{
	Amici.add(v);
}
	
}
