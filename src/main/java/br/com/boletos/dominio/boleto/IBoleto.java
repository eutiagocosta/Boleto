package br.com.boletos.dominio.boleto;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.boletos.dominio.publico.PublicoId;

@Entity(name = "IBOLETO")
public class IBoleto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Embedded
	private IBoletoId boletoId;

	@Embedded
    @AttributeOverride(name="publicoId", column=@Column(name="BENEFICIARIO_ID"))
	private PublicoId beneficiarioId;
	
	@Embedded
	@AttributeOverride(name="publicoId", column=@Column(name="PAGADOR_ID"))
	private PublicoId pagadorId;
	
	private BigDecimal valorBoleto = BigDecimal.ZERO;
	/*private BigDecimal quantidadeMoeda = BigDecimal.ZERO;
	private BigDecimal valorMoeda = BigDecimal.ZERO;
	private BigDecimal valorDescontos = BigDecimal.ZERO;
	private BigDecimal valorDeducoes = BigDecimal.ZERO;
	private BigDecimal valorMulta = BigDecimal.ZERO;
	private BigDecimal valorAcrescimos = BigDecimal.ZERO;

	private String especieMoeda;
	private int codigoEspecieMoeda;
	private String especieDocumento;
	private String numeroDocumento;*/
	
	@OneToOne(cascade = CascadeType.ALL)
	private IDatas datas;
	
	private String instrucao1;
	private String instrucao2;
	private String instrucao3;
	private String instrucao4;
	private String instrucao5;
	private String localPagamento1;
	private String localPagamento2;
	private String banco;
	
	@SuppressWarnings("unused")
	private IBoleto(){}
	
	public IBoleto(IBoletoId boletoId, PublicoId beneficiarioId, PublicoId pagadorId, BigDecimal valorBoleto,
			IDatas datas, String instrucao1, String instrucao2, String instrucao3, String instrucao4, String instrucao5,
			String localPagamento1, String localPagamento2, String banco) {
		super();
		this.boletoId = boletoId;
		this.beneficiarioId = beneficiarioId;
		this.pagadorId = pagadorId;
		this.valorBoleto = valorBoleto;
		this.datas = datas;
		this.instrucao1 = instrucao1;
		this.instrucao2 = instrucao2;
		this.instrucao3 = instrucao3;
		this.instrucao4 = instrucao4;
		this.instrucao5 = instrucao5;
		this.localPagamento1 = localPagamento1;
		this.localPagamento2 = localPagamento2;
		this.banco = banco;
	}
	
	/*public IBoleto(IBoletoId boletoId, PublicoId beneficiarioId, PublicoId pagadorId, BigDecimal valorBoleto,
			BigDecimal quantidadeMoeda, BigDecimal valorMoeda, BigDecimal valorDescontos, BigDecimal valorDeducoes,
			BigDecimal valorMulta, BigDecimal valorAcrescimos, String especieMoeda, int codigoEspecieMoeda,
			String especieDocumento, String numeroDocumento, IDatas datas, String instrucao1, String instrucao2,
			String instrucao3, String instrucao4, String instrucao5, 
			String localPagamento1, String localPagamento2, String banco) {
		
		this.boletoId = boletoId;
		this.beneficiarioId = beneficiarioId;
		this.pagadorId = pagadorId;
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
		this.instrucao1 = instrucao1;
		this.instrucao2 = instrucao2;
		this.instrucao3 = instrucao3;
		this.instrucao4 = instrucao4;
		this.instrucao5 = instrucao5;
		this.localPagamento1 = localPagamento1;
		this.localPagamento2 = localPagamento2;
		this.banco = banco;
	}*/
	
	public IBoletoId getBoletoId() {
		return boletoId;
	}
	public void setBoletoId(IBoletoId boletoId) {
		this.boletoId = boletoId;
	}
	public PublicoId getBeneficiarioId() {
		return beneficiarioId;
	}
	public void setBeneficiarioId(PublicoId beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}
	public PublicoId getPagadorId() {
		return pagadorId;
	}
	public void setPagadorId(PublicoId pagadorId) {
		this.pagadorId = pagadorId;
	}
	public BigDecimal getValorBoleto() {
		return valorBoleto;
	}
	public void setValorBoleto(BigDecimal valorBoleto) {
		this.valorBoleto = valorBoleto;
	}

	public IDatas getDatas() {
		return datas;
	}
	public void setDatas(IDatas datas) {
		this.datas = datas;
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
