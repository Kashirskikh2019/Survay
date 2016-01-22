package nsk.tfoms.survay.pojo;

import javax.validation.constraints.Pattern;

public class ParamOnePart {
	
	
	@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}")
	private String datestart;
	@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}")
	private String dateend;
	
	private String onefoms;
	private String onesimaz;
	private String oneingos;
	private String onerosno;
	
	
	
	
	public String getOnefoms() {
		return onefoms;
	}
	public void setOnefoms(String onefoms) {
		this.onefoms = onefoms;
	}
	public String getOnesimaz() {
		return onesimaz;
	}
	public void setOnesimaz(String onesimaz) {
		this.onesimaz = onesimaz;
	}
	public String getOneingos() {
		return oneingos;
	}
	public void setOneingos(String oneingos) {
		this.oneingos = oneingos;
	}
	public String getOnerosno() {
		return onerosno;
	}
	
	public String getDatestart() {
		return datestart;
	}
	public void setDatestart(String datestart) {
		this.datestart = datestart;
	}
	public String getDateend() {
		return dateend;
	}
	public void setDateend(String dateend) {
		this.dateend = dateend;
	}
	public void setOnerosno(String onerosno) {
		this.onerosno = onerosno;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamOnePart [datestart=");
		builder.append(datestart);
		builder.append(", dateend=");
		builder.append(dateend);
		builder.append(", onefoms=");
		builder.append(onefoms);
		builder.append(", onesimaz=");
		builder.append(onesimaz);
		builder.append(", oneingos=");
		builder.append(oneingos);
		builder.append(", onerosno=");
		builder.append(onerosno);
		builder.append("]");
		return builder.toString();
	}
}
