package br.com.boletos.dominio.boleto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IPagador {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome = "";
    private String documento = "";
    
    @OneToOne(cascade = CascadeType.ALL)
    private IEndereco endereco;
    
	public IPagador(String nome, String documento, IEndereco endereco) {
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
	}
	
	@SuppressWarnings("unused")
	private IPagador(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public IEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(IEndereco endereco) {
		this.endereco = endereco;
	}

}
