
package model;

public class Lutador {
    private String nome, categoria;
	private double peso, altura;
	private int id; 
	
	public Lutador() {
		
	}
	public Lutador(int id) {
		this.id = id;
	}
	public Lutador(String nome, String categoria,
			double peso, double altura,int id) {
		this.nome = nome;
		this.categoria = categoria;
		this.peso = peso;
		this.altura = altura;
		this.id = id;
	}
	public Lutador(String nome, String categoria,
			double peso, double altura) {
		this.nome = nome;
		this.categoria = categoria;
		this.peso = peso;
		this.altura = altura;
		
	}
	
	public String getNome() {
		return nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public double getPeso() {
		return peso;
	}
	public double getAltura() {
		return altura;
	}
	public int getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setPeso(double peso) {
		this.peso = peso; 
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setId(int id) {
		this.id = id; 
	}
	@Override
	public String toString() {
		return "Lutador [nome=" + nome + ", categoria=" + categoria + ", peso=" + peso + ", altura=" + altura + ", id="
				+ id + "]";
	}
}
