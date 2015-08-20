package br.com.boletos.dominio.boleto;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.boletos.dominio.beneficiario.IBeneficiario;

@Entity
public class IBoleto {

	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private IBoletoId boletoId;
	
	private BigDecimal valorBoleto = BigDecimal.ZERO;
	private BigDecimal quantidadeMoeda = BigDecimal.ZERO;
	private BigDecimal valorMoeda = BigDecimal.ZERO;
	private BigDecimal valorDescontos = BigDecimal.ZERO;
	private BigDecimal valorDeducoes = BigDecimal.ZERO;
	private BigDecimal valorMulta = BigDecimal.ZERO;
	private BigDecimal valorAcrescimos = BigDecimal.ZERO;

	private String especieMoeda;
	private int codigoEspecieMoeda;
	private String especieDocumento;
	private String numeroDocumento;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IDatas datas;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IPagador pagador;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IBeneficiario beneficiario;
	private String instrucao1;
	private String instrucao2;
	private String instrucao3;
	private String instrucao4;
	private String instrucao5;
	private String localPagamento1;
	private String localPagamento2;
	
	public IBoleto(IBoletoId boletoId, BigDecimal valorBoleto, BigDecimal quantidadeMoeda,
			BigDecimal valorMoeda, BigDecimal valorDescontos,
			BigDecimal valorDeducoes, BigDecimal valorMulta,
			BigDecimal valorAcrescimos, String especieMoeda,
			int codigoEspecieMoeda, String especieDocumento,
			String numeroDocumento, IDatas datas,
			IPagador pagador, IBeneficiario beneficiario, String instrucao1,
			String instrucao2, String instrucao3, String instrucao4,
			String instrucao5, String localPagamento1, String localPagamento2) {

		this.boletoId = boletoId;
		this.valorBoleto = valorBoleto;
		this.quantidadeMoeda = quantidadeMoeda;
		this.valorMoeda = valorMoeda;
		this.valorDescontos = valorDescontos;
		this.valorDeducoes = valorDeducoes;
		this.valorMulta = valorMulta;
		this.valorAcrescimos = valorAcrescimos;
		this.especieMoeda = especieMoeda;
		this.codigoEspecieMoeda = codigoEspecieMoeda;
		this.especieDocumento = especieDocumento;
		this.numeroDocumento = numeroDocumento;
		this.datas = datas;
		this.pagador = pagador;
		this.beneficiario = beneficiario;
		this.instrucao1 = instrucao1;
		this.instrucao2 = instrucao2;
		this.instrucao3 = instrucao3;
		this.instrucao4 = instrucao4;
		this.instrucao5 = instrucao5;
		this.localPagamento1 = localPagamento1;
		this.localPagamento2 = localPagamento2;
	}
	
	@SuppressWarnings("unused")
	private IBoleto(){}
	
	public IBoletoId getBoletoId() {
		return boletoId;
	}

	public void setBoletoId(IBoletoId boletoId) {
		this.boletoId = boletoId;
	}

	public BigDecimal getValorBoleto() {
		return valorBoleto;
	}
	public void setValorBoleto(BigDecimal valorBoleto) {
		this.valorBoleto = valorBoleto;
	}
	public BigDecimal getQuantidadeMoeda() {
		return quantidadeMoeda;
	}
	public void setQuantidadeMoeda(BigDecimal quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
	}
	public BigDecimal getValorMoeda() {
		return valorMoeda;
	}
	public void setValorMoeda(BigDecimal valorMoeda) {
		this.valorMoeda = valorMoeda;
	}
	public BigDecimal getValorDescontos() {
		return valorDescontos;
	}
	public void setValorDescontos(BigDecimal valorDescontos) {
		this.valorDescontos = valorDescontos;
	}
	public BigDecimal getValorDeducoes() {
		return valorDeducoes;
	}
	public void setValorDeducoes(BigDecimal valorDeducoes) {
		this.valorDeducoes = valorDeducoes;
	}
	public BigDecimal getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}
	public BigDecimal getValorAcrescimos() {
		return valorAcrescimos;
	}
	public void setValorAcrescimos(BigDecimal valorAcrescimos) {
		this.valorAcrescimos = valorAcrescimos;
	}
	public String getEspecieMoeda() {
		return especieMoeda;
	}
	public void setEspecieMoeda(String especieMoeda) {
		this.especieMoeda = especieMoeda;
	}
	public int getCodigoEspecieMoeda() {
		return codigoEspecieMoeda;
	}
	public void setCodigoEspecieMoeda(int codigoEspecieMoeda) {
		this.codigoEspecieMoeda = codigoEspecieMoeda;
	}
	public String getEspecieDocumento() {
		return especieDocumento;
	}
	public void setEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public IDatas getDatas() {
		return datas;
	}
	public void setDatas(IDatas datas) {
		this.datas = datas;
	}
	public IPagador getPagador() {
		return pagador;
	}
	public void setPagador(IPagador pagador) {
		this.pagador = pagador;
	}
	public IBeneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(IBeneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getInstrucao1() {
		return instrucao1;
	}
	public void setInstrucao1(String instrucao1) {
		this.instrucao1 = instrucao1;
	}
	public String getInstrucao2() {
		return instrucao2;
	}
	public void setInstrucao2(String instrucao2) {
		this.instrucao2 = instrucao2;
	}
	public String getInstrucao3() {
		return instrucao3;
	}
	public void setInstrucao3(String instrucao3) {
		this.instrucao3 = instrucao3;
	}
	public String getInstrucao4() {
		return instrucao4;
	}
	public void setInstrucao4(String instrucao4) {
		this.instrucao4 = instrucao4;
	}
	public String getInstrucao5() {
		return instrucao5;
	}
	public void setInstrucao5(String instrucao5) {
		this.instrucao5 = instrucao5;
	}
	public String getLocalPagamento1() {
		return localPagamento1;
	}
	public void setLocalPagamento1(String localPagamento1) {
		this.localPagamento1 = localPagamento1;
	}
	public String getLocalPagamento2() {
		return localPagamento2;
	}
	public void setLocalPagamento2(String localPagamento2) {
		this.localPagamento2 = localPagamento2;
	}
	

}
