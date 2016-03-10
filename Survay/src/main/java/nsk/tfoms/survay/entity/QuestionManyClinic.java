package nsk.tfoms.survay.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the SURVAY_CLINIC_SEC_1 database table.
 * 
 */
@Entity
@Table(name="Question_many_clinic")
public class QuestionManyClinic implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ID_question_many_clinic")
	private Integer idQuestionManyClinic;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SURVAY_CLINIC_SECONDLEVEL_ID", referencedColumnName="GENERAL_ID")
    @JsonIgnore
	private SurvayClinicSecondlevel survayClinicSecondlevel;
	
	@Column(name="question12_clinic",length=100)
	private String question12_clinic;
	
	

	public QuestionManyClinic() {
	}



	
	public SurvayClinicSecondlevel getSurvayClinicSecondlevel() {
		return this.survayClinicSecondlevel;
	}

	public void setSurvayClinicSecondlevel(SurvayClinicSecondlevel survayClinicSecondlevel) {
		this.survayClinicSecondlevel = survayClinicSecondlevel;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionManyClinic [idQuestionManyClinic=");
		builder.append(idQuestionManyClinic);
		//builder.append(", survayClinicSecondlevel=");
		//builder.append(survayClinicSecondlevel);
		builder.append(", question12_clinic=");
		builder.append(question12_clinic);
		builder.append("]");
		return builder.toString();
	}



	public Integer getIdQuestionManyClinic() {
		return idQuestionManyClinic;
	}



	public void setIdQuestionManyClinic(Integer idQuestionManyClinic) {
		this.idQuestionManyClinic = idQuestionManyClinic;
	}



	public String getQuestion12_clinic() {
		return question12_clinic;
	}



	public void setQuestion12_clinic(String question12_clinic) {
		this.question12_clinic = question12_clinic;
	}

	
	
}