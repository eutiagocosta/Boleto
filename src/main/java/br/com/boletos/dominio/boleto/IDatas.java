package br.com.boletos.dominio.boleto;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "IDATAS")
public class IDatas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Calendar documento;
	private Calendar processamento;
	private Calendar vencimento;
	
	public IDatas(Calendar documento, Calendar processamento, Calendar vencimento) {
		this.documento = documento;
		this.processamento = processamento;
		this.vencimento = vencimento;
	}
	
	@SuppressWarnings("unused")
	private IDatas(){}

	public Calendar getDocumento() {
		return documento;
	}

	public void setDocumento(Calendar documento) {
		this.documento = documento;
	}

	public Calendar getProcessamento() {
		return processamento;
	}

	public void setProcessamento(Calendar processamento) {
		this.processamento = processamento;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

}
