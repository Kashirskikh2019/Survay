package nsk.tfoms.survay.util.report;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

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
    
    private void loadToExcelResalt( List<ArrayList<String>> resaltQuery, String absolutePath) throws FileNotFoundException, IOException
    {
    	POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(absolutePath));
		HSSFWorkbook wb = new HSSFWorkbook(fs);	
		HSSFSheet sheet = wb.getSheetAt(1);	
		
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
    }
	
}
