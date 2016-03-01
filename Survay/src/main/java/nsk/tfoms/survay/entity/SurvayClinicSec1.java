package nsk.tfoms.survay.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SURVAY_CLINIC_SEC_1 database table.
 * 
 */
@Entity
@Table(name="SURVAY_CLINIC_SEC_1")
@NamedQuery(name="SurvayClinicSec1.findAll", query="SELECT s FROM SurvayClinicSec1 s")
public class SurvayClinicSec1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SURVAY_CLINIC_SEC_1")
	private BigDecimal idsurvayclinicsec1;
	
	@Column(name="REPLACEMENT_CLINIC_SECONDLEVEL")
	private String replacementClinicSecondlevel;

	//bi-directional one-to-one association to SurvayClinicSecondlevel
	@OneToOne(mappedBy="survayClinicSec1")
	private SurvayClinicSecondlevel survayClinicSecondlevel;

	public SurvayClinicSec1() {
	}

	

	public String getReplacementClinicSecondlevel() {
		return this.replacementClinicSecondlevel;
	}

	public void setReplacementClinicSecondlevel(String replacementClinicSecondlevel) {
		this.replacementClinicSecondlevel = replacementClinicSecondlevel;
	}

	public SurvayClinicSecondlevel getSurvayClinicSecondlevel() {
		return this.survayClinicSecondlevel;
	}

	public void setSurvayClinicSecondlevel(SurvayClinicSecondlevel survayClinicSecondlevel) {
		this.survayClinicSecondlevel = survayClinicSecondlevel;
	}



	public BigDecimal getIdsurvayclinicsec1() {
		return idsurvayclinicsec1;
	}



	public void setIdsurvayclinicsec1(BigDecimal idsurvayclinicsec1) {
		this.idsurvayclinicsec1 = idsurvayclinicsec1;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SurvayClinicSec1 [idsurvayclinicsec1=");
		builder.append(idsurvayclinicsec1);
		builder.append(", replacementClinicSecondlevel=");
		builder.append(replacementClinicSecondlevel);
		//builder.append(", survayClinicSecondlevel=");
		//builder.append(survayClinicSecondlevel);
		builder.append("]");
		return builder.toString();
	}





}