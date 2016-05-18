package nsk.tfoms.survay.entity.secondlevel.Stacionar;

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
@Table(name="SURVAY_SL_STACIONAR")
public class StacionarSecondlevel implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GENERAL_ID_SLS")
	private Integer id;
	@OneToMany(mappedBy="stacionarsecondlevel", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JsonIgnore
	private Set<QuestionManyStacionar> manySSL;

	@Column(name="AGE_SLS")
	private int ageSls;

	@Column(name="DATA_INPUT_SLS")
	private String dataInputSls = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

	@Column(name="DATA_RESP_SLS")
	private String dataRespSls;

	@Column(name="MO_SLS")
	private String moSLS;

	@Column(name="POLZOVATEL_SLS")
	private String polzSecondlSls;

	@Column(name="SEX_SLS")
	private String sexSls;

	@Column(name="questionS1")
	private String questionS1;
	
	@Column(name="questionS2")
	private String questionS2;
	
	@Column(name="questionS3")
	private String questionS3;
	
	@Column(name="questionS4")
	private String questionS4;
	
	@Column(name="questionS6")
	private String questionS6;
	
	@Column(name="questionS7")
	private String questionS7;
	
	@Column(name="questionS8")
	private String questionS8;
	
	@Column(name="questionS10")
	private String questionS10;
	
	@Column(name="questionS12")
	private String questionS12;
	
	@Column(name="questionS16")
	private String questionS16;
	
	@Column(name="questionS19")
	private String questionS19;
	
	@Column(name="questionS22")
	private String questionS22;
	
	@Column(name="questionS25")
	private String questionS25;
	
	@Column(name="questionS26")
	private String questionS26;
	
	@Column(name="questionS27")
	private String questionS27;
	
	@Column(name="questionS30")
	private String questionS30;
	
	@Column(name="questionS31")
	private String questionS31;
	
	@Column(name="questionS32")
	private String questionS32;
	
	
	


	//bi-directional one-to-one association to SurvayClinicSec1
	@OneToOne(mappedBy="stacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SCSSLSec1 scsslsec1;

	@OneToOne(mappedBy="stacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SCSSLSec2 scsslsec2;
	
	@OneToOne(mappedBy="stacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	private SCSSLSec3 scsslsec3;
	
	

}