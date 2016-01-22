package nsk.tfoms.survay.util.report;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayDaystacionar;
import nsk.tfoms.survay.entity.SurvayStacionar;

public class Reports {

	
	
	 /*
     * Выргужаем фаил и удаляем с сервака
     * 
     */
    
    private void downloadExcel(HttpServletResponse response, String absolutePath) throws IOException 
    {
		System.out.println("pach....."+absolutePath);
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		try{
			stream = response.getOutputStream();
			File doc = new File(absolutePath);
			response.setCharacterEncoding("application/msexcel");
			response.addHeader("Content-Disposition", "attachment; filename=" + absolutePath);
			response.setContentLength((int)doc.length());
			FileInputStream input = new FileInputStream(doc);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			while((readBytes = buf.read()) != -1) { stream.write(readBytes); }
		} finally {
			if(stream != null) { stream.close(); }
			if(buf != null) { buf.close(); }
			
			File file =new File(absolutePath);
			System.out.println(file.delete());
		}
    }
    
    @SuppressWarnings("deprecation")
	public void loadToExcelResalt(List<List<SurvayClinic>> forOneOrgClinic,List<List<SurvayDaystacionar>> forOneOrgDayStac,List<List<SurvayStacionar>> forOneOrgStac, HttpServletRequest request) throws FileNotFoundException, IOException
    {
    	
    	 String applicationPath = request.getServletContext().getRealPath("");
         String FilePath = applicationPath + File.separator+"downloads";
         System.out.println(FilePath);
         File fileSaveDir = new File(FilePath);
         if (!fileSaveDir.exists()) { fileSaveDir.mkdirs(); }

         
         HSSFWorkbook wb = new HSSFWorkbook();
         HSSFSheet sheet = wb.createSheet(forOneOrgClinic.get(0).get(0).getPolzovatel());
         HSSFRow excelRow = null;
         HSSFCell excelCell = null;
         
         CellStyle styleonerow = wb.createCellStyle();         
         styleonerow.setWrapText(true);
         CellStyle style = wb.createCellStyle();
         style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
         style.setFillPattern(CellStyle.SOLID_FOREGROUND);
         style.setAlignment(CellStyle.ALIGN_CENTER);
         
         excelRow = sheet.createRow(2);
         excelRow = sheet.getRow(2);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Индикатор доступности и качества медицинской помощи");
         sheet.addMergedRegion(new CellRangeAddress(2,2,0,3));
         
         excelRow = sheet.createRow(3);
         excelRow = sheet.getRow(3);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Вид помощи");
         excelCell.setCellStyle(styleonerow);
         
         excelRow = sheet.getRow(3);			
         excelCell = excelRow.createCell(1);
         excelCell = excelRow.getCell(1);
         excelCell.setCellValue("Количество респондентов которых требуется опросить за N кварталов ( или за N-ый квартал)");
         excelCell.setCellStyle(styleonerow);
         
         excelRow = sheet.getRow(3);			
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue("Общее количество опрошенных респондентов");
         excelCell.setCellStyle(styleonerow);
         
         excelRow = sheet.getRow(3);			
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         excelCell.setCellValue("Доля опрошенных респондентов, в %");
         excelCell.setCellStyle(styleonerow);
         
         excelRow = sheet.createRow(4);
         excelRow = sheet.getRow(4);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Амбулаторно-поликлиническая помощь");
         excelCell.setCellStyle(style);
         sheet.addMergedRegion(new CellRangeAddress(4,4,0,3));
         
         excelRow = sheet.createRow(5);
         excelRow = sheet.getRow(5);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(6);
         excelRow = sheet.getRow(6);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(7);
         excelRow = sheet.getRow(7);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(8);
         excelRow = sheet.getRow(8);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(9);
         excelRow = sheet.getRow(9);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Итого");
         
         excelRow = sheet.createRow(10);
         excelRow = sheet.getRow(10);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Дневной стационар");   
         sheet.addMergedRegion(new CellRangeAddress(10,10,0,3));
         excelCell.setCellStyle(style);
         
/***********************************************************************************************************************************************************/
         
         excelRow = sheet.createRow(11);
         excelRow = sheet.getRow(11);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(12);
         excelRow = sheet.getRow(12);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(13);
         excelRow = sheet.getRow(13);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(14);
         excelRow = sheet.getRow(14);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(15);
         excelRow = sheet.getRow(15);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Итого");  
         
         excelRow = sheet.createRow(16);
         excelRow = sheet.getRow(16);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Стационарная помощь");   
         sheet.addMergedRegion(new CellRangeAddress(16,16,0,3));
         excelCell.setCellStyle(style);
         
/***********************************************************************************************************************************************************/
         
         excelRow = sheet.createRow(17);
         excelRow = sheet.getRow(17);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(18);
         excelRow = sheet.getRow(18);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(19);
         excelRow = sheet.getRow(19);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(20);
         excelRow = sheet.getRow(20);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(21);
         excelRow = sheet.getRow(21);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Итого"); 
         
         excelRow = sheet.createRow(22);
         excelRow = sheet.getRow(22);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Скорая помощь");   
         sheet.addMergedRegion(new CellRangeAddress(22,22,0,3));
         excelCell.setCellStyle(style);
         
/***********************************************************************************************************************************************************/
         
         excelRow = sheet.createRow(23);
         excelRow = sheet.getRow(23);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(24);
         excelRow = sheet.getRow(24);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(25);
         excelRow = sheet.getRow(25);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(26);
         excelRow = sheet.getRow(26);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(27);
         excelRow = sheet.getRow(27);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Итого");
         
         excelRow = sheet.createRow(28);
         excelRow = sheet.getRow(28);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Общий итог:");
         
         
         try {
        	    FileOutputStream out = new FileOutputStream(new File(FilePath+File.separator+"test.xls"));
        	    wb.write(out);
        	    wb.close();
        	    out.close();
        	    System.out.println("Excel written successfully.");
        	     
        	} catch (FileNotFoundException e) {
        	    e.printStackTrace();
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}
         
        
/*         HSSFSheet sheet = wb.getSheetAt(1);	

		
		
		HSSFRow excelRow = null;
		HSSFCell excelCell = null;
		
		//wb.getSheetAt(1).shiftRows(0, 0, 1);
		
		//зачищаем лист
				int rows = sheet.getPhysicalNumberOfRows();
				for(int i = 0; i < rows ; i++)
				{
					excelRow = sheet.createRow(i + 1);
					sheet.removeRow(excelRow);
				}		
		
		excelRow = sheet.createRow(0);
		excelRow = sheet.getRow(0);			
		excelCell = excelRow.createCell(0);
		excelCell = excelRow.getCell(0);
		excelCell.setCellValue("Фамилия");
		
		//excelRow = sheet.createRow(0);
		excelRow = sheet.getRow(0);			
		excelCell = excelRow.createCell(1);
		excelCell = excelRow.getCell(1);
		excelCell.setCellValue("Имя");
		
		//excelRow = sheet.createRow(0);
		excelRow = sheet.getRow(0);			
		excelCell = excelRow.createCell(2);
		excelCell = excelRow.getCell(2);
		excelCell.setCellValue("Отчество");
		
		//excelRow = sheet.createRow(0);
		excelRow = sheet.getRow(0);			
		excelCell = excelRow.createCell(3);
		excelCell = excelRow.getCell(3);
		excelCell.setCellValue("Дата рождения");
		
		//excelRow = sheet.createRow(0);
		excelRow = sheet.getRow(0);			
		excelCell = excelRow.createCell(4);
		excelCell = excelRow.getCell(4);
		excelCell.setCellValue("ЕНП вн");
		
		
		
		// определяем количество строк в нашей коллекции
		rows = resaltQuery.size();
		System.out.println("Количество исходящих строк" + rows);
		
		 // Style the cell with borders all around.
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
   

		
		for(int i = 1; i <= rows ; i++)
		{
			excelRow = sheet.createRow(i);
			excelRow = sheet.getRow(i);			
			excelCell = excelRow.createCell(0);
			excelCell = excelRow.getCell(0);
			excelCell.setCellValue(resaltQuery.get(i-1).get(0));
			excelCell.setCellStyle(style);
			
			excelCell = excelRow.createCell(1);
			excelCell = excelRow.getCell(1);
			excelCell.setCellValue(resaltQuery.get(i-1).get(1));
			excelCell.setCellStyle(style);
			
			excelCell = excelRow.createCell(2);
			excelCell = excelRow.getCell(2);
			excelCell.setCellValue(resaltQuery.get(i-1).get(2));
			excelCell.setCellStyle(style);
			
			excelCell = excelRow.createCell(3);
			excelCell = excelRow.getCell(3);
			excelCell.setCellValue(resaltQuery.get(i-1).get(3));
			excelCell.setCellStyle(style);
			
			excelCell = excelRow.createCell(4);
			excelCell = excelRow.getCell(4);
			excelCell.setCellValue(resaltQuery.get(i-1).get(4));
			excelCell.setCellStyle(style);
		}	
		
		HSSFRow row = wb.getSheetAt(1).getRow(0);
		for(int colNum = 0; colNum< row.getLastCellNum();colNum++)    wb.getSheetAt(1).autoSizeColumn(colNum);
	
		wb.setSheetName(0, "Исходные данные");
		wb.setSheetName(1, "Результат");
		
		FileOutputStream fileOut = new FileOutputStream(absolutePath);
		wb.write(fileOut);
		fileOut.close();
		
		*/
    }
	
}
