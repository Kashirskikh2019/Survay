package nsk.tfoms.survay.pojo;

import java.util.ArrayList;
import java.util.List;


public class ParamTwoPart {
	
	
	private String datestart;
	private String dateend;
	
	private String lpu;
	
	private String onefoms;
	private String onesimaz;
	private String oneingos;
	private String onerosno;
	
	
	
	private List<String> mas;
	
	
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
	
	public String getLpu() {
		return lpu;
	}
	public void setLpu(String lpu) {
		this.lpu = lpu;
	}
	
	public List<String> getMas() {
		mas = new ArrayList<String>();
		
		return mas;
	}
	public void setMas(List<String> mas) {
		this.mas = mas;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamTwoPart [datestart=");
		builder.append(datestart);
		builder.append(", dateend=");
		builder.append(dateend);
		builder.append(", lpu=");
		builder.append(lpu);
		builder.append(", onefoms=");
		builder.append(onefoms);
		builder.append(", onesimaz=");
		builder.append(onesimaz);
		builder.append(", oneingos=");
		builder.append(oneingos);
		builder.append(", onerosno=");
		builder.append(onerosno);
		builder.append(", mas=");
		builder.append(mas);
		builder.append("]");
		return builder.toString();
	}
	
	
}
