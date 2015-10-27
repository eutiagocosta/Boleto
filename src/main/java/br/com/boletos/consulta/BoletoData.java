package br.com.boletos.consulta;

import java.math.BigDecimal;
import java.util.Calendar;

public class BoletoData {

	private String boletoId;
	private String beneficiarioId;
	private String pagadorId;
	/*private BigDecimal quantidadeMoeda;
	private BigDecimal valorMoeda;
	private BigDecimal valorDescontos;
	private BigDecimal valorDeducoes;
	private BigDecimal valorMulta;
	private BigDecimal valorAcrescimos;
	private String especieMoeda;
	private int codigoEspecieMoeda;
	private String especieDocumento;*/
	private Calendar emissao;
	private Calendar processamento;
	private Calendar vencimento;
	private BigDecimal valor;
	private String numeroDocumento;
	private String instrucao1;
	private String instrucao2;
	private String instrucao3;
	private String instrucao4;
	private String instrucao5;
	private String localPagamento1;
	private String localPagamento2;
	private String banco;
	
	public BoletoData(){}
	
	public BoletoData(String boletoId, String beneficiarioId, String pagadorId, Calendar emissao,
			Calendar processamento, Calendar vencimento, BigDecimal valor, String instrucao1,
			String instrucao2, String instrucao3, String instrucao4, String instrucao5, String localPagamento1,
			String localPagamento2, String banco) {

		this.boletoId = boletoId;
		this.beneficiarioId = beneficiarioId;
		this.pagadorId = pagadorId;
		this.emissao = emissao;
		this.processamento = processamento;
		this.vencimento = vencimento;
		this.valor = valor;
		this.instrucao1 = instrucao1;
		this.instrucao2 = instrucao2;
		this.instrucao3 = instrucao3;
		this.instrucao4 = instrucao4;
		this.instrucao5 = instrucao5;
		this.localPagamento1 = localPagamento1;
		this.localPagamento2 = localPagamento2;
		this.banco = banco;
	}
	
	/*public BoletoData(String boletoId, String beneficiarioId, String pagadorId, BigDecimal quantidadeMoeda,
			BigDecimal valorMoeda, BigDecimal valorDescontos, BigDecimal valorDeducoes, BigDecimal valorMulta,
			BigDecimal valorAcrescimos, String especieMoeda, int codigoEspecieMoeda, String especieDocumento,
			Calendar emissao, Calendar processamento, Calendar vencimento, BigDecimal valor, String numeroDocumento,
			String instrucao1, String instrucao2, String instrucao3, String instrucao4, String instrucao5,
			String localPagamento1, String localPagamento2, String banco) {

		this.boletoId = boletoId;
		this.beneficiarioId = beneficiarioId;
		this.pagadorId = pagadorId;
		this.quantidadeMoeda = quantidadeMoeda;
		this.valorMoeda = valorMoeda;
		this.valorDescontos = valorDescontos;
		this.valorDeducoes = valorDeducoes;
		this.valorMulta = valorMulta;
		this.valorAcrescimos = valorAcrescimos;
		this.especieMoeda = especieMoeda;
		this.codigoEspecieMoeda = codigoEspecieMoeda;
		this.especieDocumento = especieDocumento;
		this.emissao = emissao;
		this.processamento = processamento;
		this.vencimento = vencimento;
		this.valor = valor;
		//this.numeroDocumento = numeroDocumento;
		this.instrucao1 = instrucao1;
		this.instrucao2 = instrucao2;
		this.instrucao3 = instrucao3;
		this.instrucao4 = instrucao4;
		this.instrucao5 = instrucao5;
		this.localPagamento1 = localPagamento1;
		this.localPagamento2 = localPagamento2;
		this.banco = banco;
	}*/

	public String getBoletoId() {
		return boletoId;
	}

	public void setBoletoId(String boletoId) {
		this.boletoId = boletoId;
	}

	public String getBeneficiarioId() {
		return beneficiarioId;
	}

	public void setBeneficiarioId(String beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}

	public String getPagadorId() {
		return pagadorId;
	}

	public void setPagadorId(String pagadorId) {
		this.pagadorId = pagadorId;
	}

	public Calendar getEmissao() {
		return emissao;
	}

	public void setEmissao(Calendar emissao) {
		this.emissao = emissao;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
