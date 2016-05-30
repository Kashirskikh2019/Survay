package nsk.tfoms.survay.pojo;

import nsk.tfoms.survay.entity.secondlevel.Stacionar.SCSSLSec1;
import nsk.tfoms.survay.entity.secondlevel.Stacionar.SCSSLSec2;
import nsk.tfoms.survay.entity.secondlevel.Stacionar.StacionarSecondlevel;

public class SenderSSL {
	
	private StacionarSecondlevel survay1;
	private SCSSLSec1 survay2;
	private SCSSLSec2 survay3;
	private WrapManySSL survay5;
	
	

	public SCSSLSec1 getSurvay2() {
		return survay2;
	}
	public void setSurvay2(SCSSLSec1 survay2) {
		this.survay2 = survay2;
	}
	public WrapManySSL getSurvay5() {
		return survay5;
	}
	public void setSurvay5(WrapManySSL survay5) {
		this.survay5 = survay5;
	}
	public StacionarSecondlevel getSurvay1() {
		return survay1;
	}
	public void setSurvay1(StacionarSecondlevel survay1) {
		this.survay1 = survay1;
	}
	public SCSSLSec2 getSurvay3() {
		return survay3;
	}
	public void setSurvay3(SCSSLSec2 survay3) {
		this.survay3 = survay3;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SenderSSL [survay1=");
		builder.append(survay1);
		builder.append(", survay2=");
		builder.append(survay2);
		builder.append(", survay3=");
		builder.append(survay3);
		builder.append(", survay5=");
		builder.append(survay5);
		builder.append("]");
		return builder.toString();
	}
	
	
			

}
