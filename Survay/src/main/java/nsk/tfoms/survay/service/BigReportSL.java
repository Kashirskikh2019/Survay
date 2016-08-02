package nsk.tfoms.survay.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRTextElement;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import nsk.tfoms.survay.pojo.ParamTwoPart;

@Service
public class BigReportSL {

	public void BigReportClinic(ParamTwoPart paramtwopart,File otch1, File file_for_ontch) throws ClassNotFoundException, SQLException, JRException  {
		
		Connection conn = connectForJasper();
		Map mapReport = mapForJasper(paramtwopart);
		JasperReport jasperReport = JasperCompileManager.compileReport(otch1.getAbsolutePath());
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file_for_ontch.getAbsolutePath()));
		exporter.exportReport();
		
		disconnectForJasper(conn);
		
	}
	
	private Connection connectForJasper() throws ClassNotFoundException,SQLException {
		Connection conn = null;

		Properties properties = new Properties();
		 InputStream is = BigReportSL.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//System.out.println("############################ "+properties.getProperty("jdbc.databaseurl") +" --------- "+properties.getProperty("jdbc.username"));
			conn = DriverManager.getConnection(
					properties.getProperty("jdbc.databaseurl"), 
					properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
		
		return conn;
		}
	
	
	private void disconnectForJasper(Connection conn) throws SQLException {
		conn.close();
	}

	private Map<String,String> mapForJasper(ParamTwoPart paramtwopart) {
		Map<String,String> mapReport = new HashMap<String,String>();
		mapReport.put("dateBegin", paramtwopart.getDatebeginslcbreport());
		mapReport.put("dateEnd", paramtwopart.getDateendslcbreport());
		
		List<String> orgList = paramtwopart.getOrg();
		String username = "";
		for(int i = 0;i<orgList.size(); i++){
			
			if(orgList.get(i).equals("twotfoms")){username = username.concat(orgList.get(i).replace("two", ""));}
			else{username = username.concat(orgList.get(i).replace("two", "smo_"));}
			
		}
		mapReport.put("username", username);
		
		List<String> lpuList = paramtwopart.getAns();
		String lpu = "";
		if(lpuList.contains("Все")){
			mapReport.put("lpu", "Все");
		}else{
			for(int y = 0;y < lpuList.size(); y++){
				lpu = lpu + lpuList.get(y);
			}
			mapReport.put("username", lpu);
		}
		
		System.out.println("!!!!!!!!! "+mapReport);
		
		return mapReport;
	}
}
