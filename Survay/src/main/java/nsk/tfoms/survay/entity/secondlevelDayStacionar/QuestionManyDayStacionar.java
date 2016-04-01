package nsk.tfoms.survay.entity.secondlevelDayStacionar;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the SURVAY_CLINIC_SEC_1 database table.
 * 
 */
@Entity
@Table(name="Question_many_daysstacionar")
public class QuestionManyDayStacionar implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ID_question_many_daystacionar")
	private Integer idQuestionManydaystacionar;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_SURVAY_CLINIC_DSSL", referencedColumnName="GENERAL_ID_DSSL")
    //@JsonIgnore
	private DayStacionarSecondlevel daystacionarsecondlevel;
	
	
	@Column(name="QuestionDS14",length=500)
	private String QuestionDS14many;
	
	@Column(name="QuestionDS16",length=500)
	private String QuestionDS16many;
	
	@Column(name="QuestionDS18",length=500)
	private String QuestionDS18many;
	
	@Column(name="QuestionDS19",length=500)
	private String QuestionDS19many;
	
	@Column(name="QuestionDS21",length=500)
	private String QuestionDS21many;
	
	@Column(name="QuestionDS22",length=500)
	private String QuestionDS22many;
	
	@Column(name="QuestionDS24",length=500)
	private String QuestionDS24many;

	public Integer getIdQuestionManydaystacionar() {
		return idQuestionManydaystacionar;
	}

	public void setIdQuestionManydaystacionar(Integer idQuestionManydaystacionar) {
		this.idQuestionManydaystacionar = idQuestionManydaystacionar;
	}

	public DayStacionarSecondlevel getDaystacionarsecondlevel() {
		return daystacionarsecondlevel;
	}

	public void setDaystacionarsecondlevel(DayStacionarSecondlevel daystacionarsecondlevel) {
		this.daystacionarsecondlevel = daystacionarsecondlevel;
	}

	public String getQuestionDS14many() {
		return QuestionDS14many;
	}

	public void setQuestionDS14many(String questionDS14many) {
		QuestionDS14many = questionDS14many;
	}

	public String getQuestionDS16many() {
		return QuestionDS16many;
	}

	public void setQuestionDS16many(String questionDS16many) {
		QuestionDS16many = questionDS16many;
	}

	public String getQuestionDS18many() {
		return QuestionDS18many;
	}

	public void setQuestionDS18many(String questionDS18many) {
		QuestionDS18many = questionDS18many;
	}

	public String getQuestionDS19many() {
		return QuestionDS19many;
	}

	public void setQuestionDS19many(String questionDS19many) {
		QuestionDS19many = questionDS19many;
	}

	public String getQuestionDS21many() {
		return QuestionDS21many;
	}

	public void setQuestionDS21many(String questionDS21many) {
		QuestionDS21many = questionDS21many;
	}

	public String getQuestionDS22many() {
		return QuestionDS22many;
	}

	public void setQuestionDS22many(String questionDS22many) {
		QuestionDS22many = questionDS22many;
	}

	public String getQuestionDS24many() {
		return QuestionDS24many;
	}

	public void setQuestionDS24many(String questionDS24many) {
		QuestionDS24many = questionDS24many;
	}



	
	
}