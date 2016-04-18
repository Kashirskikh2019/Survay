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
	@Column(name="GENERAL_ID_DSSL")
	private Integer id;
	//@OneToMany(mappedBy="daystacionarsecondlevel", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JsonIgnore
	//private Set<QuestionManyDayStacionar> manyDSSL;

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

	
	
	
	


	//bi-directional one-to-one association to SurvayClinicSec1
//	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
//	private SurvayClinicDayStacionarSec1 survayclinicdaystacionarSec1;

//	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
//	private SCDSSLSec2 scdsslsec2;
	
//	@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	//private SCDSSLSec15 scdsslsec15;
	
	//@OneToOne(mappedBy="daystacionarsecondlevel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonIgnore
	//private SCDSSLSec25 scdsslsec25;

	
	
	
	

}