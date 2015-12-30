package nsk.tfoms.survay.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SURVAY_STACIONAR database table.
 * 
 */
@Entity
@Table(name="SURVAY_STACIONAR")
@NamedQuery(name="SurvayStacionar.findAll", query="SELECT s FROM SurvayStacionar s")
public class SurvayStacionar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="AGE_STAC")
	private String ageStac;

	@Column(name="AMBULANCE_STAC")
	private String ambulanceStac;

	@Column(name="COMFORT_STAC")
	private String comfortStac;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INPUT_STAC")
	private Date dataInputStac;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RESP_STAC")
	private Date dataRespStac;

	@Column(name="EQUIPMENT_STAC")
	private String equipmentStac;

	@Column(name="FOOD_STAC")
	private String foodStac;

	@Column(name="LABORATORY_STAC")
	private String laboratoryStac;

	@Column(name="MEDICINE_STAC")
	private String medicineStac;

	@Column(name="QUALITY_AMBULANCE_STAC")
	private String qualityAmbulanceStac;

	@Column(name="QUALITY_STAC")
	private String qualityStac;

	@Column(name="RAPAIRS_STAC")
	private String rapairsStac;

	@Column(name="SEX_STAC")
	private String sexStac;

	@Column(name="TERMS_STAC")
	private String termsStac;

	@Column(name="THERAPIST_STAC")
	private String therapistStac;

	public SurvayStacionar() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAgeStac() {
		return this.ageStac;
	}

	public void setAgeStac(String ageStac) {
		this.ageStac = ageStac;
	}

	public String getAmbulanceStac() {
		return this.ambulanceStac;
	}

	public void setAmbulanceStac(String ambulanceStac) {
		this.ambulanceStac = ambulanceStac;
	}

	public String getComfortStac() {
		return this.comfortStac;
	}

	public void setComfortStac(String comfortStac) {
		this.comfortStac = comfortStac;
	}

	public Date getDataInputStac() {
		return this.dataInputStac;
	}

	public void setDataInputStac(Date dataInputStac) {
		this.dataInputStac = dataInputStac;
	}

	public Date getDataRespStac() {
		return this.dataRespStac;
	}

	public void setDataRespStac(Date dataRespStac) {
		this.dataRespStac = dataRespStac;
	}

	public String getEquipmentStac() {
		return this.equipmentStac;
	}

	public void setEquipmentStac(String equipmentStac) {
		this.equipmentStac = equipmentStac;
	}

	public String getFoodStac() {
		return this.foodStac;
	}

	public void setFoodStac(String foodStac) {
		this.foodStac = foodStac;
	}

	public String getLaboratoryStac() {
		return this.laboratoryStac;
	}

	public void setLaboratoryStac(String laboratoryStac) {
		this.laboratoryStac = laboratoryStac;
	}

	public String getMedicineStac() {
		return this.medicineStac;
	}

	public void setMedicineStac(String medicineStac) {
		this.medicineStac = medicineStac;
	}

	public String getQualityAmbulanceStac() {
		return this.qualityAmbulanceStac;
	}

	public void setQualityAmbulanceStac(String qualityAmbulanceStac) {
		this.qualityAmbulanceStac = qualityAmbulanceStac;
	}

	public String getQualityStac() {
		return this.qualityStac;
	}

	public void setQualityStac(String qualityStac) {
		this.qualityStac = qualityStac;
	}

	public String getRapairsStac() {
		return this.rapairsStac;
	}

	public void setRapairsStac(String rapairsStac) {
		this.rapairsStac = rapairsStac;
	}

	public String getSexStac() {
		return this.sexStac;
	}

	public void setSexStac(String sexStac) {
		this.sexStac = sexStac;
	}

	public String getTermsStac() {
		return this.termsStac;
	}

	public void setTermsStac(String termsStac) {
		this.termsStac = termsStac;
	}

	public String getTherapistStac() {
		return this.therapistStac;
	}

	public void setTherapistStac(String therapistStac) {
		this.therapistStac = therapistStac;
	}

}