package br.com.boletos.dominio.beneficiario;

import javax.persistence.Embeddable;

@Embeddable
public class IBeneficiarioId {
	
	private String beneficiarioId;
	
	public IBeneficiarioId(String beneficiarioId){
		this.beneficiarioId = beneficiarioId;
	}
	
	@SuppressWarnings("unused")
	private IBeneficiarioId(){}
	
	public String beneficiarioId(){
		return beneficiarioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficiarioId == null) ? 0 : beneficiarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IBeneficiarioId other = (IBeneficiarioId) obj;
		if (beneficiarioId == null) {
			if (other.beneficiarioId != null)
				return false;
		} else if (!beneficiarioId.equals(other.beneficiarioId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IBeneficiarioId [beneficiarioId=" + beneficiarioId + "]";
	}
	


}
