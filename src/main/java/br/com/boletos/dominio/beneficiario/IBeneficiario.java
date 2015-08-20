package br.com.boletos.dominio.beneficiario;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.boletos.dominio.boleto.IEndereco;

@Entity
public class IBeneficiario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private IBeneficiarioId beneficiarioId;
	
	private String agencia;
	private String digitoAgencia;
	private String codigoBeneficiario;
	private String digitoCodigoBeneficiario;
	private String carteira;
	private String nossoNumero;
	private String digitoNossoNumero;
	private String nomeBeneficiario;
	private String documento;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IEndereco endereco;
	
	private String numeroConvenio;
	
	public IBeneficiario(String agencia, String digitoAgencia,
			String codigoBeneficiario, String digitoCodigoBeneficiario,
			String carteira, String nossoNumero, String digitoNossoNumero,
			String nomeBeneficiario, String documento, IEndereco endereco,
			String numeroConvenio) {

		this.agencia = agencia;
		this.digitoAgencia = digitoAgencia;
		this.codigoBeneficiario = codigoBeneficiario;
		this.digitoCodigoBeneficiario = digitoCodigoBeneficiario;
		this.carteira = carteira;
		this.nossoNumero = nossoNumero;
		this.digitoNossoNumero = digitoNossoNumero;
		this.nomeBeneficiario = nomeBeneficiario;
		this.documento = documento;
		this.endereco = endereco;
		this.numeroConvenio = numeroConvenio;
	}
	
	@SuppressWarnings("unused")
	private IBeneficiario(){}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getDigitoAgencia() {
		return digitoAgencia;
	}
	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}
	public String getCodigoBeneficiario() {
		return codigoBeneficiario;
	}
	public void setCodigoBeneficiario(String codigoBeneficiario) {
		this.codigoBeneficiario = codigoBeneficiario;
	}
	public String getDigitoCodigoBeneficiario() {
		return digitoCodigoBeneficiario;
	}
	public void setDigitoCodigoBeneficiario(String digitoCodigoBeneficiario) {
		this.digitoCodigoBeneficiario = digitoCodigoBeneficiario;
	}
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public String getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}
	public void setDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
	}
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}
	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
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
	public String getNumeroConvenio() {
		return numeroConvenio;
	}
	public void setNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	} 
	
}
