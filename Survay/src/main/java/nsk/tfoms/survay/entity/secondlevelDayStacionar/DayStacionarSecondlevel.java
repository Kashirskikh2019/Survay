package nsk.tfoms.survay.entity.secondlevelDayStacionar;

import java.io.Serializable;
import javax.persistence.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the SURVAY_CLINIC_SECONDLEVEL database table.
 * 
 */
@Entity
@Table(name="SURVAY_CLINIC_DAYSTACIONAR_TWO")
public class DayStacionarSecondlevel implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GENERAL_ID_DSSL")
	private Integer id;
	@OneToMany(mappedBy="daystacionarsecondlevel", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JsonIgnore
	private Set<QuestionManyDayStacionar> manyDSSL;

	@Column(name="AGE_daystacionar_two")
	private int ageSecondleveldaystacionar;

	@Column(name="DATA_INPUT_daystacionar_two")
	private String dataInputSecondlevel = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

	@Column(name="DATA_RESP_daystacionar_two")
	private String dataRespSecondleveldaystacionar;

	@Column(name="MO_daystacionar_two",length=200)
	private String moSecondleveldaystacionar;

	@Column(name="POLZOVATEL_daystacionar_two",length=15)
	private String polzSecondleveldaystacionar;

	@Column(name="SEX_daystacionar_two",length=15)
	private String sexSecondleveldaystacionar;

	@Column(name="VISIT_CLINIC_daystacionar_two",length=50)
	private String visitClinicSecondleveldaystacionar;
	
	@Column(name="QuestionDS1",length=500)
	private String questionDS1;
	
	@Column(name="QuestionDS2",length=500)
	private String QuestionDS2;
	
	@Column(name="QuestionDS3",length=500)
	private String QuestionDS3;
	
	@Column(name="QuestionDS4",length=500)
	private String QuestionDS4;
	
	@Column(name="QuestionDS5",length=500)
	private String QuestionDS5;
	
	@Column(name="QuestionDS6",length=500)
	private String QuestionDS6;
	
	@Column(name="QuestionDS9",length=500)
	private String QuestionDS9;
	
	@Column(name="QuestionDS17",length=500)
	private String QuestionDS17;
	
	@Column(name="QuestionDS20",length=500)
	private String QuestionDS20;
	
	@Column(name="QuestionDS23",length=500)
	private String QuestionDS23;
	
	@Column(name="QuestionDS26",length=500)
	private String QuestionDS26;
	
	@Column(name="QuestionDS27",length=500)
	private String QuestionDS27;
	
	@Column(name="QuestionDS28",length=500)
	private String QuestionDS28;
	
	@Column(name="QuestionDS31",length=500)
	private String QuestionDS31;
	
	@Column(name="QuestionDS32",length=500)
	private String QuestionDS32;
	
	@Column(name="QuestionDS33",length=500)
	private String QuestionDS33;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAgeSecondleveldaystacionar() {
		return ageSecondleveldaystacionar;
	}

	public void setAgeSecondleveldaystacionar(int ageSecondleveldaystacionar) {
		this.ageSecondleveldaystacionar = ageSecondleveldaystacionar;
	}

	public String getDataInputSecondlevel() {
		return dataInputSecondlevel;
	}

	public void setDataInputSecondlevel(String dataInputSecondlevel) {
		this.dataInputSecondlevel = dataInputSecondlevel;
	}

	public String getDataRespSecondleveldaystacionar() {
		return dataRespSecondleveldaystacionar;
	}

	public void setDataRespSecondleveldaystacionar(String dataRespSecondleveldaystacionar) {
		this.dataRespSecondleveldaystacionar = dataRespSecondleveldaystacionar;
	}

	public String getMoSecondleveldaystacionar() {
		return moSecondleveldaystacionar;
	}

	public void setMoSecondleveldaystacionar(String moSecondleveldaystacionar) {
		this.moSecondleveldaystacionar = moSecondleveldaystacionar;
	}

	public String getPolzSecondleveldaystacionar() {
		return polzSecondleveldaystacionar;
	}

	public void setPolzSecondleveldaystacionar(String polzSecondleveldaystacionar) {
		this.polzSecondleveldaystacionar = polzSecondleveldaystacionar;
	}

	public String getSexSecondleveldaystacionar() {
		return sexSecondleveldaystacionar;
	}

	public void setSexSecondleveldaystacionar(String sexSecondleveldaystacionar) {
		this.sexSecondleveldaystacionar = sexSecondleveldaystacionar;
	}

	public String getVisitClinicSecondleveldaystacionar() {
		return visitClinicSecondleveldaystacionar;
	}

	public void setVisitClinicSecondleveldaystacionar(String visitClinicSecondleveldaystacionar) {
		this.visitClinicSecondleveldaystacionar = visitClinicSecondleveldaystacionar;
	}

	public Set<QuestionManyDayStacionar> getManyDSSL() {
		return manyDSSL;
	}

	public void setManyDSSL(Set<QuestionManyDayStacionar> manyDSSL) {
		this.manyDSSL = manyDSSL;
	}

	public String getQuestionDS1() {
		return questionDS1;
	}

	public void setQuestionDS1(String questionDS1) {
		this.questionDS1 = questionDS1;
	}

	public String getQuestionDS2() {
		return QuestionDS2;
	}

	public void setQuestionDS2(String questionDS2) {
		QuestionDS2 = questionDS2;
	}

	public String getQuestionDS3() {
		return QuestionDS3;
	}

	public void setQuestionDS3(String questionDS3) {
		QuestionDS3 = questionDS3;
	}

	public String getQuestionDS4() {
		return QuestionDS4;
	}

	public void setQuestionDS4(String questionDS4) {
		QuestionDS4 = questionDS4;
	}

	public String getQuestionDS5() {
		return QuestionDS5;
	}

	public void setQuestionDS5(String questionDS5) {
		QuestionDS5 = questionDS5;
	}

	public String getQuestionDS6() {
		return QuestionDS6;
	}

	public void setQuestionDS6(String questionDS6) {
		QuestionDS6 = questionDS6;
	}

	public String getQuestionDS9() {
		return QuestionDS9;
	}

	public void setQuestionDS9(String questionDS9) {
		QuestionDS9 = questionDS9;
	}

	public String getQuestionDS17() {
		return QuestionDS17;
	}

	public void setQuestionDS17(String questionDS17) {
		QuestionDS17 = questionDS17;
	}

	public String getQuestionDS20() {
		return QuestionDS20;
	}

	public void setQuestionDS20(String questionDS20) {
		QuestionDS20 = questionDS20;
	}

	public String getQuestionDS23() {
		return QuestionDS23;
	}

	public void setQuestionDS23(String questionDS23) {
		QuestionDS23 = questionDS23;
	}

	public String getQuestionDS26() {
		return QuestionDS26;
	}

	public void setQuestionDS26(String questionDS26) {
		QuestionDS26 = questionDS26;
	}

	public String getQuestionDS27() {
		return QuestionDS27;
	}

	public void setQuestionDS27(String questionDS27) {
		QuestionDS27 = questionDS27;
	}

	public String getQuestionDS28() {
		return QuestionDS28;
	}

	public void setQuestionDS28(String questionDS28) {
		QuestionDS28 = questionDS28;
	}

	public String getQuestionDS31() {
		return QuestionDS31;
	}

	public void setQuestionDS31(String questionDS31) {
		QuestionDS31 = questionDS31;
	}

	public String getQuestionDS32() {
		return QuestionDS32;
	}

	public void setQuestionDS32(String questionDS32) {
		QuestionDS32 = questionDS32;
	}

	public String getQuestionDS33() {
		return QuestionDS33;
	}

	public void setQuestionDS33(String questionDS33) {
		QuestionDS33 = questionDS33;
	}


	//bi-directional one-to-one association to SurvayClinicSec1
	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SurvayClinicDayStacionarSec1 survayclinicdaystacionarSec1;

	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SCDSSLSec2 scdsslsec2;
	
	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SCDSSLSec15 scdsslsec15;
	
	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SCDSSLSec25 scdsslsec25;

	
	public SurvayClinicDayStacionarSec1 getSurvayclinicdaystacionarSec1() {
		return survayclinicdaystacionarSec1;
	}

	public void setSurvayclinicdaystacionarSec1(SurvayClinicDayStacionarSec1 survayclinicdaystacionarSec1) {
		this.survayclinicdaystacionarSec1 = survayclinicdaystacionarSec1;
	}

	public SCDSSLSec2 getScdsslsec2() {
		return scdsslsec2;
	}

	public void setScdsslsec2(SCDSSLSec2 scdsslsec2) {
		this.scdsslsec2 = scdsslsec2;
	}

	public SCDSSLSec15 getScdsslsec15() {
		return scdsslsec15;
	}

	public void setScdsslsec15(SCDSSLSec15 scdsslsec15) {
		this.scdsslsec15 = scdsslsec15;
	}

	public SCDSSLSec25 getScdsslsec25() {
		return scdsslsec25;
	}

	public void setScdsslsec25(SCDSSLSec25 scdsslsec25) {
		this.scdsslsec25 = scdsslsec25;
	}
	
	
	

}