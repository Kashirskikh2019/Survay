package nsk.tfoms.survay.pojo;



public class ParamOnePart {
	
	private String onefirstkv;
	private String onesecondkv;
	private String onetreekv;
	private String onefourkv;
	
	private String onefoms;
	private String onesimaz;
	private String oneingos;
	private String onerosno;
	
	
	public String getOnefirstkv() {
		return onefirstkv;
	}
	public void setOnefirstkv(String onefirstkv) {
		this.onefirstkv = onefirstkv;
	}
	public String getOnesecondkv() {
		return onesecondkv;
	}
	public void setOnesecondkv(String onesecondkv) {
		this.onesecondkv = onesecondkv;
	}
	public String getOnetreekv() {
		return onetreekv;
	}
	public void setOnetreekv(String onetreekv) {
		this.onetreekv = onetreekv;
	}
	public String getOnefourkv() {
		return onefourkv;
	}
	public void setOnefourkv(String onefourkv) {
		this.onefourkv = onefourkv;
	}
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
	public void setOnerosno(String onerosno) {
		this.onerosno = onerosno;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamOnePart [onefirstkv=");
		builder.append(onefirstkv);
		builder.append(", onesecondkv=");
		builder.append(onesecondkv);
		builder.append(", onetreekv=");
		builder.append(onetreekv);
		builder.append(", onefourkv=");
		builder.append(onefourkv);
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
