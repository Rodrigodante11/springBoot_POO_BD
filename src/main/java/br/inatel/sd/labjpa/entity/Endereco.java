package br.inatel.sd.labjpa.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable // papel dele eh ser imputido nas outras classes
public class Endereco {
	
	private String enderecoRua;
	private String enderecoNumero;
	private String enderecoComplemento;
	private String enderecoBairro;
	private String enderecoCidade;
	private String enderecoUF;
	public String getEnderecoRua() {
		return enderecoRua;
	}
	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}
	public String getEnderecoNumero() {
		return enderecoNumero;
	}
	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}
	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}
	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}
	public String getEnderecoBairro() {
		return enderecoBairro;
	}
	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}
	public String getEnderecoCidade() {
		return enderecoCidade;
	}
	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}
	public String getEnderecoUF() {
		return enderecoUF;
	}
	public void setEnderecoUF(String enderecoUF) {
		this.enderecoUF = enderecoUF;
	}
	@Override
	public String toString() {
		return "Endereco [enderecoRua=" + enderecoRua + ", enderecoNumero=" + enderecoNumero + ", enderecoComplemento="
				+ enderecoComplemento + ", enderecoBairro=" + enderecoBairro + ", enderecoCidade=" + enderecoCidade
				+ ", enderecoUF=" + enderecoUF + "]";
	}
	
	

}
