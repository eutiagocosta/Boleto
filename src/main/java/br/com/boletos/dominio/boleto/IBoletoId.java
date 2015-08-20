package br.com.boletos.dominio.boleto;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class IBoletoId {
	
private String boletoId;
	
	public IBoletoId(String BoletoId) {
		this.boletoId = BoletoId;
	}

	@SuppressWarnings("unused")
	private IBoletoId(){}
	
	public String id(){
		return boletoId;
	}
	
	@Override
	public boolean equals(Object objeto) {
		boolean objetosIguais = false;

		if (objeto != null && this.getClass() == objeto.getClass()) {
			IBoletoId objetoTipado = (IBoletoId) objeto;
			objetosIguais = new EqualsBuilder()
				.append(id(),objetoTipado.id())
				.isEquals();
		}

		return objetosIguais;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(337,417)
			.append(id())
			.toHashCode();
	}

	@Override
	public String toString() {
		return "BoletoId [boletoId=" + boletoId + "]";
	}

}
