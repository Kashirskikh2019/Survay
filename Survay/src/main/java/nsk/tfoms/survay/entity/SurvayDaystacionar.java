package nsk.tfoms.survay.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SURVAY_DAYSTACIONAR database table.
 * 
 */
@Entity
@Table(name="SURVAY_DAYSTACIONAR")
@NamedQuery(name="SurvayDaystacionar.findAll", query="SELECT s FROM SurvayDaystacionar s")
public class SurvayDaystacionar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="AGE_DAYSTAC")
	private String ageDaystac;

	@Column(name="AMBULANCE_DAYSTAC")
	private String ambulanceDaystac;

	@Column(name="COMFORT_DAYSTAC")
	private String comfortDaystac;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INPUT_DAYSTAC")
	private Date dataInputDaystac;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RESP_DAYSTAC")
	private Date dataRespDaystac;

	@Column(name="EQUIPMENT_DAYSTAC")
	private String equipmentDaystac;

	@Column(name="LABORATORY_DAYSTAC")
	private String laboratoryDaystac;

	@Column(name="MEDICINE_DAYSTAC")
	private String medicineDaystac;

	@Column(name="QUALITY_AMBULANCE_DAYSTAC")
	private String qualityAmbulanceDaystac;

	@Column(name="QUALITY_DAYSTAC")
	private String qualityDaystac;

	@Column(name="RAPAIRS_DAYSTAC")
	private String rapairsDaystac;

	@Column(name="SERVICES_DAYSTAC")
	private String servicesDaystac;

	@Column(name="SEX_DAYSTAC")
	private String sexDaystac;

	@Column(name="THERAPIST_DAYSTAC")
	private String therapistDaystac;

	public SurvayDaystacionar() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAgeDaystac() {
		return this.ageDaystac;
	}

	public void setAgeDaystac(String ageDaystac) {
		this.ageDaystac = ageDaystac;
	}

	public String getAmbulanceDaystac() {
		return this.ambulanceDaystac;
	}

	public void setAmbulanceDaystac(String ambulanceDaystac) {
		this.ambulanceDaystac = ambulanceDaystac;
	}

	public String getComfortDaystac() {
		return this.comfortDaystac;
	}

	public void setComfortDaystac(String comfortDaystac) {
		this.comfortDaystac = comfortDaystac;
	}

	public Date getDataInputDaystac() {
		return this.dataInputDaystac;
	}

	public void setDataInputDaystac(Date dataInputDaystac) {
		this.dataInputDaystac = dataInputDaystac;
	}

	public Date getDataRespDaystac() {
		return this.dataRespDaystac;
	}

	public void setDataRespDaystac(Date dataRespDaystac) {
		this.dataRespDaystac = dataRespDaystac;
	}

	public String getEquipmentDaystac() {
		return this.equipmentDaystac;
	}

	public void setEquipmentDaystac(String equipmentDaystac) {
		this.equipmentDaystac = equipmentDaystac;
	}

	public String getLaboratoryDaystac() {
		return this.laboratoryDaystac;
	}

	public void setLaboratoryDaystac(String laboratoryDaystac) {
		this.laboratoryDaystac = laboratoryDaystac;
	}

	public String getMedicineDaystac() {
		return this.medicineDaystac;
	}

	public void setMedicineDaystac(String medicineDaystac) {
		this.medicineDaystac = medicineDaystac;
	}

	public String getQualityAmbulanceDaystac() {
		return this.qualityAmbulanceDaystac;
	}

	public void setQualityAmbulanceDaystac(String qualityAmbulanceDaystac) {
		this.qualityAmbulanceDaystac = qualityAmbulanceDaystac;
	}

	public String getQualityDaystac() {
		return this.qualityDaystac;
	}

	public void setQualityDaystac(String qualityDaystac) {
		this.qualityDaystac = qualityDaystac;
	}

	public String getRapairsDaystac() {
		return this.rapairsDaystac;
	}

	public void setRapairsDaystac(String rapairsDaystac) {
		this.rapairsDaystac = rapairsDaystac;
	}

	public String getServicesDaystac() {
		return this.servicesDaystac;
	}

	public void setServicesDaystac(String servicesDaystac) {
		this.servicesDaystac = servicesDaystac;
	}

	public String getSexDaystac() {
		return this.sexDaystac;
	}

	public void setSexDaystac(String sexDaystac) {
		this.sexDaystac = sexDaystac;
	}

	public String getTherapistDaystac() {
		return this.therapistDaystac;
	}

	public void setTherapistDaystac(String therapistDaystac) {
		this.therapistDaystac = therapistDaystac;
	}

}