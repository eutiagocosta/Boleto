package br.com.boletos.consulta;

import java.math.BigDecimal;
import java.util.Calendar;

public class IBoletoData {

	private String iBoletoId;
	private BigDecimal valor;
	private BigDecimal quantidadeMoeda;
	private BigDecimal valorMoeda;
	private BigDecimal valorDescontos;
	private BigDecimal valorDeducoes;
	private BigDecimal valorMulta;
	private BigDecimal valorAcrescimos;
	private String especieMoeda;
	private int codigoEspecieMoeda;
	private String especieDocumento;
	private String numeroDocumento;
	private Calendar emissao;
	private Calendar processamento;
	private Calendar vencimento;
	private String nomePagador;
	private String cpfPagador;
	private String logradouroPagador;
	private String bairroPagador;
	private String cepPagador;
	private String cidadePagador;
	private String ufPagador;
	private String logradouroBeneficiario;
	private String bairroBeneficiario;
	private String cepBeneficiario;
	private String cpfBeneficiario;
	private String cidadeBeneficiario;
	private String ufBeneficiario;
	private String nomeBeneficiario;
	private String agenciaBeneficiario;
	private String digitoBeneficiario;
	private String codigoBeneficiario;
	private String digitoCodigoBeneficiario;
	private String convenioBeneficiario;
	private String carteiraBeneficiario;
	private String digitoNossoNumero;
	private String nossoNumero;
	private String instrucao1;
	private String instrucao2;
	private String instrucao3;
	private String instrucao4;
	private String instrucao5;
	private String localPagamento1;
	private String localPagamento2;
	
	public IBoletoData(){}
	
	public IBoletoData(String iBoletoId, BigDecimal valor, BigDecimal quantidadeMoeda, BigDecimal valorMoeda,
			BigDecimal valorDescontos, BigDecimal valorDeducoes, BigDecimal valorMulta, BigDecimal valorAcrescimos,
			String especieMoeda, int codigoEspecieMoeda, String especieDocumento, String numeroDocumento,
			Calendar emissao, Calendar processamento, Calendar vencimento, String nomePagador, String cpfPagador,
			String logradouroPagador, String bairroPagador, String cepPagador, String cidadePagador, String ufPagador,
			String logradouroBeneficiario, String bairroBeneficiario, String cepBeneficiario, String cpfBeneficiario,
			String cidadeBeneficiario, String ufBeneficiario, String nomeBeneficiario, String agenciaBeneficiario,
			String digitoBeneficiario, String codigoBeneficiario, String digitoCodigoBeneficiario,
			String convenioBeneficiario, String carteiraBeneficiario, String digitoNossoNumero, String nossoNumero,
			String instrucao1, String instrucao2, String instrucao3, String instrucao4, String instrucao5,
			String localPagamento1, String localPagamento2) {
		super();
		this.iBoletoId = iBoletoId;
		this.valor = valor;
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
		this.emissao = emissao;
		this.processamento = processamento;
		this.vencimento = vencimento;
		this.nomePagador = nomePagador;
		this.cpfPagador = cpfPagador;
		this.logradouroPagador = logradouroPagador;
		this.bairroPagador = bairroPagador;
		this.cepPagador = cepPagador;
		this.cidadePagador = cidadePagador;
		this.ufPagador = ufPagador;
		this.logradouroBeneficiario = logradouroBeneficiario;
		this.bairroBeneficiario = bairroBeneficiario;
		this.cepBeneficiario = cepBeneficiario;
		this.cpfBeneficiario = cpfBeneficiario;
		this.cidadeBeneficiario = cidadeBeneficiario;
		this.ufBeneficiario = ufBeneficiario;
		this.nomeBeneficiario = nomeBeneficiario;
		this.agenciaBeneficiario = agenciaBeneficiario;
		this.digitoBeneficiario = digitoBeneficiario;
		this.codigoBeneficiario = codigoBeneficiario;
		this.digitoCodigoBeneficiario = digitoCodigoBeneficiario;
		this.convenioBeneficiario = convenioBeneficiario;
		this.carteiraBeneficiario = carteiraBeneficiario;
		this.digitoNossoNumero = digitoNossoNumero;
		this.nossoNumero = nossoNumero;
		this.instrucao1 = instrucao1;
		this.instrucao2 = instrucao2;
		this.instrucao3 = instrucao3;
		this.instrucao4 = instrucao4;
		this.instrucao5 = instrucao5;
		this.localPagamento1 = localPagamento1;
		this.localPagamento2 = localPagamento2;
	}



	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}

	public void setCpfBeneficiario(String cpfBeneficiario) {
		this.cpfBeneficiario = cpfBeneficiario;
	}

	public String getIBoletoId() {
		return iBoletoId;
	}

	public void setIBoletoId(String iBoletoId) {
		this.iBoletoId = iBoletoId;
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

	public String getLogradouroBeneficiario() {
		return logradouroBeneficiario;
	}

	public void setLogradouroBeneficiario(String logradouroBeneficiario) {
		this.logradouroBeneficiario = logradouroBeneficiario;
	}

	public String getBairroBeneficiario() {
		return bairroBeneficiario;
	}

	public void setBairroBeneficiario(String bairroBeneficiario) {
		this.bairroBeneficiario = bairroBeneficiario;
	}

	public String getCepBeneficiario() {
		return cepBeneficiario;
	}

	public void setCepBeneficiario(String cepBeneficiario) {
		this.cepBeneficiario = cepBeneficiario;
	}

	public String getCidadeBeneficiario() {
		return cidadeBeneficiario;
	}

	public void setCidadeBeneficiario(String cidadeBeneficiario) {
		this.cidadeBeneficiario = cidadeBeneficiario;
	}

	public String getUfBeneficiario() {
		return ufBeneficiario;
	}

	public void setUfBeneficiario(String ufBeneficiario) {
		this.ufBeneficiario = ufBeneficiario;
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public String getAgenciaBeneficiario() {
		return agenciaBeneficiario;
	}

	public void setAgenciaBeneficiario(String agenciaBeneficiario) {
		this.agenciaBeneficiario = agenciaBeneficiario;
	}

	public String getDigitoBeneficiario() {
		return digitoBeneficiario;
	}

	public void setDigitoBeneficiario(String digitoBeneficiario) {
		this.digitoBeneficiario = digitoBeneficiario;
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

	public String getConvenioBeneficiario() {
		return convenioBeneficiario;
	}

	public void setConvenioBeneficiario(String convenioBeneficiario) {
		this.convenioBeneficiario = convenioBeneficiario;
	}

	public String getCarteiraBeneficiario() {
		return carteiraBeneficiario;
	}

	public void setCarteiraBeneficiario(String carteiraBeneficiario) {
		this.carteiraBeneficiario = carteiraBeneficiario;
	}

	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	public void setDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getLogradouroPagador() {
		return logradouroPagador;
	}

	public void setLogradouroPagador(String logradouroPagador) {
		this.logradouroPagador = logradouroPagador;
	}

	public String getBairroPagador() {
		return bairroPagador;
	}

	public void setBairroPagador(String bairroPagador) {
		this.bairroPagador = bairroPagador;
	}

	public String getCepPagador() {
		return cepPagador;
	}

	public void setCepPagador(String cepPagador) {
		this.cepPagador = cepPagador;
	}

	public String getCidadePagador() {
		return cidadePagador;
	}

	public void setCidadePagador(String cidadePagador) {
		this.cidadePagador = cidadePagador;
	}

	public String getUfPagador() {
		return ufPagador;
	}

	public void setUfPagador(String ufPagador) {
		this.ufPagador = ufPagador;
	}

	public String getNomePagador() {
		return nomePagador;
	}

	public void setNomePagador(String nomePagador) {
		this.nomePagador = nomePagador;
	}

	public String getCpfPagador() {
		return cpfPagador;
	}

	public void setCpfPagador(String cpfPagador) {
		this.cpfPagador = cpfPagador;
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
	
}
