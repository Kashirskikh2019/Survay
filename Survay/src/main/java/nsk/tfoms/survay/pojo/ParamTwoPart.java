package nsk.tfoms.survay.pojo;

import java.util.ArrayList;
import java.util.List;


public class ParamTwoPart {
	
	
	private String datebeginslcbreport;
	private String dateendslcbreport;
	private List<String> org;
	private List<String> ans;
	public String getDatebeginslcbreport() {
		return datebeginslcbreport;
	}
	public void setDatebeginslcbreport(String datebeginslcbreport) {
		this.datebeginslcbreport = datebeginslcbreport;
	}
	public String getDateendslcbreport() {
		return dateendslcbreport;
	}
	public void setDateendslcbreport(String dateendslcbreport) {
		this.dateendslcbreport = dateendslcbreport;
	}
	public List<String> getOrg() {
		return org;
	}
	public void setOrg(List<String> org) {
		this.org = org;
	}
	public List<String> getAns() {
		return ans;
	}
	public void setAns(List<String> ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamTwoPart [datebeginslcbreport=");
		builder.append(datebeginslcbreport);
		builder.append(", dateendslcbreport=");
		builder.append(dateendslcbreport);
		builder.append(", org=");
		builder.append(org);
		builder.append(", ans=");
		builder.append(ans);
		builder.append("]");
		return builder.toString();
	}
	
	
	
		
	
}
