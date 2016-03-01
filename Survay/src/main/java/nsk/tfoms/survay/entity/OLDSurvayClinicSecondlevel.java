package nsk.tfoms.survay.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the SURVAY_CLINIC_SECONDLEVEL database table.
 * 
 *
@Entity
@Table(name="SURVAY_CLINIC_SECONDLEVEL")
@NamedQuery(name="SurvayClinicSecondlevel.findAll", query="SELECT s FROM SurvayClinicSecondlevel s")
public class OLDSurvayClinicSecondlevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigDecimal id;

	@Column(name="AGE_SECONDLEVEL")
	private BigDecimal ageSecondlevel;

	@Column(name="DATA_INPUT_SECONDLEVEL")
	private String dataInputSecondlevel = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

	@Column(name="DATA_RESP_SECONDLEVEL")
	private String dataRespSecondlevel;

	@Column(name="MO_SECONDLEVEL")
	private String moSecondlevel;

	@Column(name="POLZOVATEL_SECONDLEVEL")
	private String polzovatelSecondlevel;

	@Column(name="REPLACEMENT_CLINIC_SECONDLEVEL")
	private String replacementClinicSecondlevel;

	@Column(name="SEX_SECONDLEVEL")
	private String sexSecondlevel;

	@Column(name="VISIT_CLINIC_SECONDLEVEL")
	private String visitClinicSecondlevel;

	@Column(name="VISIT_OPTION_SECONDLEVEL")
	private String visitOptionSecondlevel;

	public OLDSurvayClinicSecondlevel() {
	}



	public BigDecimal getAgeSecondlevel() {
		return this.ageSecondlevel;
	}

	public void setAgeSecondlevel(BigDecimal ageSecondlevel) {
		this.ageSecondlevel = ageSecondlevel;
	}

	
	public String getMoSecondlevel() {
		return this.moSecondlevel;
	}

	public void setMoSecondlevel(String moSecondlevel) {
		this.moSecondlevel = moSecondlevel;
	}

	public String getPolzovatelSecondlevel() {
		return this.polzovatelSecondlevel;
	}

	public void setPolzovatelSecondlevel(String polzovatelSecondlevel) {
		this.polzovatelSecondlevel = polzovatelSecondlevel;
	}

	public String getReplacementClinicSecondlevel() {
		return this.replacementClinicSecondlevel;
	}

	public void setReplacementClinicSecondlevel(String replacementClinicSecondlevel) {
		this.replacementClinicSecondlevel = replacementClinicSecondlevel;
	}

	public String getSexSecondlevel() {
		return this.sexSecondlevel;
	}

	public void setSexSecondlevel(String sexSecondlevel) {
		this.sexSecondlevel = sexSecondlevel;
	}

	public String getVisitClinicSecondlevel() {
		return this.visitClinicSecondlevel;
	}

	public void setVisitClinicSecondlevel(String visitClinicSecondlevel) {
		this.visitClinicSecondlevel = visitClinicSecondlevel;
	}

	public String getVisitOptionSecondlevel() {
		return this.visitOptionSecondlevel;
	}

	public void setVisitOptionSecondlevel(String visitOptionSecondlevel) {
		this.visitOptionSecondlevel = visitOptionSecondlevel;
	}

	public String getDataInputSecondlevel() {
		return dataInputSecondlevel;
	}

	public void setDataInputSecondlevel(String dataInputSecondlevel) {
		this.dataInputSecondlevel = dataInputSecondlevel;
	}

	public String getDataRespSecondlevel() {
		return dataRespSecondlevel;
	}

	public void setDataRespSecondlevel(String dataRespSecondlevel) {
		this.dataRespSecondlevel = dataRespSecondlevel;
	}



	public BigDecimal getId() {
		return id;
	}



	public void setId(BigDecimal id) {
		this.id = id;
	}

}*/