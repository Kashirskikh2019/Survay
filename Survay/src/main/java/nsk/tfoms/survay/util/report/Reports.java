package nsk.tfoms.survay.util.report;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

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
	public void loadToExcelResalt(List<List<SurvayClinic>> forOneOrgClinic,List<List<SurvayDaystacionar>> forOneOrgDayStac,List<List<SurvayStacionar>> forOneOrgStac, HttpServletRequest request,String user) throws FileNotFoundException, IOException
    {
    	
    	 String applicationPath = request.getServletContext().getRealPath("");
         String FilePath = applicationPath + File.separator+"downloads";
         System.out.println(FilePath);
         File fileSaveDir = new File(FilePath);
         if (!fileSaveDir.exists()) { fileSaveDir.mkdirs(); }

         
         HSSFWorkbook wb = new HSSFWorkbook();
         HSSFSheet sheet = wb.createSheet(user);
         
         HSSFRow excelRow = null;
         HSSFCell excelCell = null;
         
         Font fontstyle = wb.createFont();
         fontstyle.setFontHeightInPoints((short)10);
         fontstyle.setFontName("Courier New");
         fontstyle.setItalic(false);
         fontstyle.setStrikeout(false);
         fontstyle.setBold(true);
         CellStyle styleonerow = wb.createCellStyle();         
         styleonerow.setWrapText(true);
         styleonerow.setAlignment(CellStyle.ALIGN_CENTER);
         styleonerow.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
         styleonerow.setFillForegroundColor(IndexedColors.AQUA.getIndex());
         styleonerow.setFillPattern(CellStyle.SOLID_FOREGROUND);
         styleonerow.setFont(fontstyle);
         
         fontstyle = wb.createFont();
         fontstyle.setFontHeightInPoints((short)9);
         fontstyle.setFontName("Courier New");
         fontstyle.setItalic(false);
         fontstyle.setStrikeout(false);
         fontstyle.setBold(false);
         CellStyle style = wb.createCellStyle();
         style.setWrapText(true);
         style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
         style.setFillPattern(CellStyle.SOLID_FOREGROUND);
         style.setAlignment(CellStyle.ALIGN_CENTER);
         style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
         style.setFont(fontstyle);
         
         
         Font font = wb.createFont();
         font.setFontHeightInPoints((short)20);
         font.setFontName("Courier New");
         font.setItalic(false);
         font.setStrikeout(false);
         font.setBold(true);
         CellStyle styleheader = wb.createCellStyle();
         styleheader.setWrapText(true);
         styleheader.setAlignment(CellStyle.ALIGN_CENTER);
         styleheader.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
         styleheader.setFont(font);
         
         Font fontforother = wb.createFont();
         fontforother.setFontHeightInPoints((short)9);
         fontforother.setFontName("Courier New");
         fontforother.setItalic(false);
         fontforother.setStrikeout(false);
         fontforother.setBold(false);
         CellStyle forother = wb.createCellStyle();
         forother.setWrapText(true);
         forother.setFont(fontforother);
         
         
         
         
         excelRow = sheet.createRow(2);
         excelRow = sheet.getRow(2);		
         excelRow.setHeight((short) 800);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Индикатор доступности и качества медицинской помощи");
         sheet.addMergedRegion(new CellRangeAddress(2,2,0,4));
         excelCell.setCellStyle(styleheader);
         
         excelRow = sheet.createRow(3);
         excelRow = sheet.getRow(3);	
         excelRow.setHeight((short) 1000);
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
         
         
         excelRow = sheet.getRow(3);			
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         excelCell.setCellValue("Индикатор доступности и качества медицинской помощи в %");
         excelCell.setCellStyle(styleonerow);
         
         
         
         
         excelRow = sheet.createRow(4);
         excelRow = sheet.getRow(4);
         excelRow.setHeight((short) 400);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Амбулаторно-поликлиническая помощь");
         excelCell.setCellStyle(style);
         sheet.addMergedRegion(new CellRangeAddress(4,4,0,4));
         
         excelRow = sheet.createRow(5);
         excelRow = sheet.getRow(5);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(6);
         excelRow = sheet.getRow(6);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(7);
         excelRow = sheet.getRow(7);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(8);
         excelRow = sheet.getRow(8);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(9);
         excelRow = sheet.getRow(9);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Итого");
         
         excelRow = sheet.createRow(10);
         excelRow = sheet.getRow(10);
         excelRow.setHeight((short) 400);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Дневной стационар");   
         sheet.addMergedRegion(new CellRangeAddress(10,10,0,4));
         excelCell.setCellStyle(style);
         
         
         /***********************************************************************************************************************************************************/
         
         excelRow = sheet.createRow(11);
         excelRow = sheet.getRow(11);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(12);
         excelRow = sheet.getRow(12);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(13);
         excelRow = sheet.getRow(13);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(14);
         excelRow = sheet.getRow(14);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(15);
         excelRow = sheet.getRow(15);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Итого");  
         
         excelRow = sheet.createRow(16);
         excelRow = sheet.getRow(16);
         excelRow.setHeight((short) 400);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Стационарная помощь");   
         sheet.addMergedRegion(new CellRangeAddress(16,16,0,4));
         excelCell.setCellStyle(style);
         
         /***********************************************************************************************************************************************************/
         
         excelRow = sheet.createRow(17);
         excelRow = sheet.getRow(17);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(18);
         excelRow = sheet.getRow(18);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(19);
         excelRow = sheet.getRow(19);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(20);
         excelRow = sheet.getRow(20);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(21);
         excelRow = sheet.getRow(21);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Итого"); 
         
         excelRow = sheet.createRow(22);
         excelRow = sheet.getRow(22);	
         excelRow.setHeight((short) 400);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Скорая помощь");   
         sheet.addMergedRegion(new CellRangeAddress(22,22,0,4));
         excelCell.setCellStyle(style);
         
         /***********************************************************************************************************************************************************/
         
         excelRow = sheet.createRow(23);
         excelRow = sheet.getRow(23);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 18-59лет");
         
         excelRow = sheet.createRow(24);
         excelRow = sheet.getRow(24);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 18-54 лет");
         
         excelRow = sheet.createRow(25);
         excelRow = sheet.getRow(25);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов мужчин 60 лет и старше");
         
         excelRow = sheet.createRow(26);
         excelRow = sheet.getRow(26);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Количество респондентов женщин 55 лет и старше");
         
         excelRow = sheet.createRow(27);
         excelRow = sheet.getRow(27);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Итого");
         
         excelRow = sheet.createRow(28);
         excelRow = sheet.getRow(28);			
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellStyle(forother);
         excelCell.setCellValue("Общий итог:");
         
         /***********************************CLINIC*********************************/
         
         excelRow = sheet.getRow(5);
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue(forOneOrgClinic.get(0).size());

         excelRow = sheet.getRow(6);
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue(forOneOrgClinic.get(1).size());
         
         excelRow = sheet.getRow(7);
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue(forOneOrgClinic.get(2).size());
         
         excelRow = sheet.getRow(8);
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue(forOneOrgClinic.get(3).size());
         
         excelRow = sheet.getRow(9);
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue(forOneOrgClinic.get(3).size()+forOneOrgClinic.get(2).size()+forOneOrgClinic.get(1).size()+forOneOrgClinic.get(0).size());
         
         
         
         
         excelRow = sheet.getRow(5);
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         double x = ((double)forOneOrgClinic.get(0).size()/1000)*100.0;
         excelCell.setCellValue(x);

         excelRow = sheet.getRow(6);
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         double x2 = ((double)forOneOrgClinic.get(1).size()/1000)*100.0;
         excelCell.setCellValue(x2);
         
         excelRow = sheet.getRow(7);
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         double x3 = ((double)forOneOrgClinic.get(2).size()/1000)*100.0;
         excelCell.setCellValue(x3);
         
         excelRow = sheet.getRow(8);
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         double x4 = ((double)forOneOrgClinic.get(3).size()/1000)*100.0;
         excelCell.setCellValue(x4);
         
         excelRow = sheet.getRow(9);
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         excelCell.setCellValue(x+x2+x3+x4);
         
         
         
         /*
          * FOR CLINIC
          *  variable count is a counts assessments. Look method getcount() 
          *  
          *  variable countall is a counts all questions (see a quantity in anket for this help) 
          */
         double count = 0;
         double countAll =11.0 ;
         
         for(int i = 0; i<forOneOrgClinic.get(0).size(); i++)
         {
        	 count = count +forOneOrgClinic.get(0).get(i).getCount();
         }
         excelRow = sheet.getRow(5);
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         double xxx = ((double)count/((double)forOneOrgClinic.get(0).size()*countAll))*100.0;
         excelCell.setCellValue(xxx);
         
         //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         excelCell = excelRow.createCell(6);
         excelCell = excelRow.getCell(6);
         double xxxt = count;
         excelCell.setCellValue(xxxt);
         excelCell = excelRow.createCell(7);
         excelCell = excelRow.getCell(7);
         excelCell.setCellValue(forOneOrgClinic.get(0).size()*countAll);
         
         
         count = 0;
         for(int i = 0; i<forOneOrgClinic.get(1).size(); i++)
         {
        	 count = count +forOneOrgClinic.get(1).get(i).getCount();
         }
         excelRow = sheet.getRow(6);
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         double xxx2 = ((double)count/((double)forOneOrgClinic.get(1).size()*countAll))*100.0;
         excelCell.setCellValue(xxx2);

         //	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         excelCell = excelRow.createCell(6);
         excelCell = excelRow.getCell(6);
         double xxxt2 = count;
         excelCell.setCellValue(xxxt2);
         excelCell = excelRow.createCell(7);
         excelCell = excelRow.getCell(7);
         excelCell.setCellValue(forOneOrgClinic.get(1).size()*countAll);
         
         
         count = 0;
         for(int i = 0; i<forOneOrgClinic.get(2).size(); i++)
         {
        	 count = count +forOneOrgClinic.get(2).get(i).getCount();
         }
         excelRow = sheet.getRow(7);
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         double xxx3 = ((double)count/((double)forOneOrgClinic.get(2).size()*countAll))*100.0;
         excelCell.setCellValue(xxx3);
         
         //     	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         excelCell = excelRow.createCell(6);
         excelCell = excelRow.getCell(6);
         double xxxt3 = count;
         excelCell.setCellValue(xxxt3);
         excelCell = excelRow.createCell(7);
         excelCell = excelRow.getCell(7);
         excelCell.setCellValue(forOneOrgClinic.get(2).size()*countAll);
         
         
         count = 0;
         for(int i = 0; i<forOneOrgClinic.get(3).size(); i++)
         {
        	 count = count +forOneOrgClinic.get(3).get(i).getCount();
         }
         excelRow = sheet.getRow(8);
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         double xxx4 = ((double)count/((double)forOneOrgClinic.get(3).size()*countAll))*100.0;
         excelCell.setCellValue(xxx4);
         
         //      	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         excelCell = excelRow.createCell(6);
         excelCell = excelRow.getCell(6);
         double xxxt4 = count;
         excelCell.setCellValue(xxxt4);
         excelCell = excelRow.createCell(7);
         excelCell = excelRow.getCell(7);
         excelCell.setCellValue(forOneOrgClinic.get(3).size()*countAll);
         
         excelRow = sheet.getRow(9);
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         excelCell.setCellValue(xxx+xxx2+xxx3+xxx4);

        	
         /******************************************************************************************/			
  		
         
     /*    CellStyle border = wb.createCellStyle();
         border.setWrapText(false);
         border.setBorderBottom(CellStyle.BORDER_THIN);
         border.setBottomBorderColor(IndexedColors.BLACK.getIndex());
         border.setBorderLeft(CellStyle.BORDER_THIN);
         border.setLeftBorderColor(IndexedColors.BLACK.getIndex());
         border.setBorderRight(CellStyle.BORDER_THIN);
         border.setRightBorderColor(IndexedColors.BLACK.getIndex());
         border.setBorderTop(CellStyle.BORDER_THIN);
         border.setTopBorderColor(IndexedColors.BLACK.getIndex()); 
         
         for(int i = 3; i <=28  ; i++)
 		{
 			excelRow = sheet.getRow(i);	
 			for(int j = 0 ; j < 4; j++)
 			{
 				if(i != 2 ||i != 10 || i != 16 || i != 22){
 				excelCell = excelRow.getCell(j);
 	 			excelCell.setCellStyle(border);
 				}
 			}
 			
 		}	
         
     */    
         HSSFRow row = wb.getSheetAt(0).getRow(2);
 		for(int colNum = 0; colNum< row.getLastCellNum();colNum++)    wb.getSheetAt(0).autoSizeColumn(colNum);
 		wb.getSheetAt(0).setColumnWidth(1, 10000);
 		wb.getSheetAt(0).setColumnWidth(2, 8500);
 		wb.getSheetAt(0).setColumnWidth(3, 8500);
 		wb.getSheetAt(0).setColumnWidth(4, 9500);
 		
 		CellRangeAddress region =  CellRangeAddress.valueOf("A4:E29");
 		final short borderMediumDashed = CellStyle.BORDER_THICK;
 	   RegionUtil.setBorderBottom( borderMediumDashed, region, sheet, wb );
 	   RegionUtil.setBorderTop( borderMediumDashed,region, sheet, wb );
 	   RegionUtil.setBorderLeft( borderMediumDashed,region, sheet, wb );
 	   RegionUtil.setBorderRight( borderMediumDashed,region, sheet, wb );
 	   	region =  CellRangeAddress.valueOf("A4:E4");
 	   RegionUtil.setBorderBottom( borderMediumDashed, region, sheet, wb );
 	   RegionUtil.setBorderTop( borderMediumDashed,region, sheet, wb );
 	   RegionUtil.setBorderLeft( borderMediumDashed,region, sheet, wb );
 	   RegionUtil.setBorderRight( borderMediumDashed,region, sheet, wb );
 	   	region =  CellRangeAddress.valueOf("A5:E5");
	   RegionUtil.setBorderBottom( borderMediumDashed, region, sheet, wb );
	   RegionUtil.setBorderTop( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderLeft( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderRight( borderMediumDashed,region, sheet, wb );
	   	region =  CellRangeAddress.valueOf("A11:E11");
	   RegionUtil.setBorderBottom( borderMediumDashed, region, sheet, wb );
	   RegionUtil.setBorderTop( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderLeft( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderRight( borderMediumDashed,region, sheet, wb );
	   region =  CellRangeAddress.valueOf("A17:E17");
	   RegionUtil.setBorderBottom( borderMediumDashed, region, sheet, wb );
	   RegionUtil.setBorderTop( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderLeft( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderRight( borderMediumDashed,region, sheet, wb );
	   region =  CellRangeAddress.valueOf("A23:E23");
	   RegionUtil.setBorderBottom( borderMediumDashed, region, sheet, wb );
	   RegionUtil.setBorderTop( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderLeft( borderMediumDashed,region, sheet, wb );
	   RegionUtil.setBorderRight( borderMediumDashed,region, sheet, wb );

	   
	   
 	   
         try {
        	 
        	 String name = "Report "+String.valueOf(Math.random())+".xls";
        	 request.getSession().setAttribute("filename", name);
        	    FileOutputStream out = new FileOutputStream(new File(FilePath+File.separator+name));
        	    wb.write(out);
        	    wb.close();
        	    out.close();
        	    System.out.println("Excel written successfully.");
        	     
        	} catch (FileNotFoundException e) {
        	    e.printStackTrace();
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}
         
        

    }
	
}
