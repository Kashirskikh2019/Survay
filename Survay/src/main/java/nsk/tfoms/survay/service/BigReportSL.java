package nsk.tfoms.survay.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired private ServletContext servletContext;
	
	public void BigReportClinic(ParamTwoPart paramtwopart,File otch1, File file_for_ontch) throws ClassNotFoundException, SQLException, JRException, IOException  {
		
		Connection conn = connectForJasper();
		Map<String,Object> mapReport = mapForJasper(paramtwopart);
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
		
		System.out.println("############################ "+properties.getProperty("jdbc.databaseurl") +" --------- "+properties.getProperty("jdbc.username"));
			conn = DriverManager.getConnection(
					properties.getProperty("jdbc.databaseurl"), 
					properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
		
		return conn;
		}
	
	
	private void disconnectForJasper(Connection conn) throws SQLException {
		conn.close();
	}

	private Map<String, Object> mapForJasper(ParamTwoPart paramtwopart) throws IOException {
		Map<String,Object> mapReport = new HashMap<String,Object>();
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
		String lpu_header = "";
		if(lpuList.contains("Все")){
			File file = new File( servletContext.getRealPath("/WEB-INF/mo.txt"));
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String vr="";
			while ((vr = br.readLine()) != null)   {
					//lpu = lpu + vr.substring(vr.indexOf("=", 0), vr.indexOf(" ", 4));
					vr = new String(vr.getBytes("Cp1251"),"UTF-8").concat(" ");
					lpu = lpu + vr.substring(vr.indexOf("=", 0), vr.indexOf(" ", 4));
					lpu_header = lpu_header + vr.substring(2);
					
				}
			mapReport.put("lpu_header", "Все");
			mapReport.put("lpu", lpu);
			
		}else{
			for(int y = 0;y < lpuList.size(); y++){
			//	if(lpuList.get(y).substring(lpuList.get(y).indexOf("=", 0)+1, lpuList.get(y).indexOf(" ", 4)).equals("")){
					
			//	}
				lpu = lpu + lpuList.get(y);
			}
			mapReport.put("lpu", lpu);
			mapReport.put("lpu_header", lpu);
		}
		
		System.out.println("!!!!!!!!! "+mapReport);
		
		return mapReport;
	}
}
