package model;

public class Pessoa {
	
	
	private String nome;
	private int idade;
	private Double peso;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return " \nnome= " + nome + "\nidade= " + idade + "\npeso= " + peso;
	}
	
	

	
	
}
