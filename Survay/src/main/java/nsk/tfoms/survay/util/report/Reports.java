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
import nsk.tfoms.survay.pojo.ParamOnePart;

/* How it works
 * In method loadtoexcelresalt pass query from db...init excel...after pass full path name xls file:  request.getSession().setAttribute("filename", name);
 * and  redirect on client side to the method downloadexcel
 * 
 */

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
	public void loadToExcelResalt2(List<List<SurvayClinic>> forOneOrgClinic,List<List<SurvayDaystacionar>> forOneOrgDayStac,List<List<SurvayStacionar>> forOneOrgStac, HttpServletRequest request,String user,ParamOnePart paramonepart) throws FileNotFoundException, IOException
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
         
         /* 
          * Date
          */
         excelRow = sheet.createRow(0);
         excelRow = sheet.getRow(0);		
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Период отчета");
         excelCell = excelRow.createCell(1);
         excelCell = excelRow.getCell(1);
         excelCell.setCellValue(paramonepart.getDatestart());
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue(paramonepart.getDateend());
         /* 
          * MO
          */
         excelRow = sheet.createRow(1);
         excelRow = sheet.getRow(1);		
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Мед огранизация");
         excelCell = excelRow.createCell(1);
         excelCell = excelRow.getCell(1);
         excelCell.setCellValue(paramonepart.getLpu());
         /* 
          * Type questions
          */
         excelRow = sheet.createRow(2);
         excelRow = sheet.getRow(2);		
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Категории ответов");
         for(int i=0;i<paramonepart.getMas().size();i++)
         {
        	 excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(paramonepart.getMas().get(i));
         }
         /* 
          * Header
          */
         excelRow = sheet.createRow(5);
         excelRow = sheet.getRow(5);		
         excelRow.setHeight((short) 800);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Индикатор доступности и качества медицинской помощи");
         sheet.addMergedRegion(new CellRangeAddress(5,5,0,4));
         /* 
          * Header2
          */
         excelRow = sheet.createRow(6);
         excelRow = sheet.getRow(6);	
         excelRow.setHeight((short) 1000);
         excelCell = excelRow.createCell(0);
         excelCell = excelRow.getCell(0);
         excelCell.setCellValue("Вопросы");
         
         
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(1);
         excelCell = excelRow.getCell(1);
         excelCell.setCellValue("Категория респонденты мужчины 18-59лет");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(2);
         excelCell = excelRow.getCell(2);
         excelCell.setCellValue("Категория респонденты женщины 18-54 лет");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(3);
         excelCell = excelRow.getCell(3);
         excelCell.setCellValue("Категория респонденты мужчины 60 лет и старше");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(4);
         excelCell = excelRow.getCell(4);
         excelCell.setCellValue("Категория респонденты женщины 55 лет и старше");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(5);
         excelCell = excelRow.getCell(5);
         excelCell.setCellValue("Итого сумма");
         
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(6);
         excelCell = excelRow.getCell(6);
         excelCell.setCellValue("Категория респонденты мужчины 18-59лет");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(7);
         excelCell = excelRow.getCell(7);
         excelCell.setCellValue("Категория респонденты женщины 18-54 лет");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(8);
         excelCell = excelRow.getCell(8);
         excelCell.setCellValue("Категория респонденты мужчины 60 лет и старше");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(9);
         excelCell = excelRow.getCell(9);
         excelCell.setCellValue("Категория респонденты женщины 55 лет и старше");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue("Итого сумма");
         
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(11);
         excelCell = excelRow.getCell(11);
         excelCell.setCellValue("Категория респонденты мужчины 18-59лет");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(12);
         excelCell = excelRow.getCell(12);
         excelCell.setCellValue("Категория респонденты женщины 18-54 лет");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(13);
         excelCell = excelRow.getCell(13);
         excelCell.setCellValue("Категория респонденты мужчины 60 лет и старше");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(14);
         excelCell = excelRow.getCell(14);
         excelCell.setCellValue("Категория респонденты женщины 55 лет и старше");
         excelRow = sheet.getRow(6);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue("Итого сумма");


         /* 
          * Header3
          */
         excelRow = sheet.createRow(7);
         excelRow = sheet.getRow(7);
         excelRow.setHeight((short) 400);
         excelCell = excelRow.createCell(1);
         excelCell = excelRow.getCell(1);
         excelCell.setCellValue("Амбулаторно-поликлиническая помощь");
         sheet.addMergedRegion(new CellRangeAddress(7,7,1,5));
         
         excelRow = sheet.getRow(7);
         excelCell = excelRow.createCell(6);
         excelCell = excelRow.getCell(6);
         excelCell.setCellValue("Дневной стационар");
         sheet.addMergedRegion(new CellRangeAddress(7,7,6,10));
         
         excelRow = sheet.getRow(7);
         excelCell = excelRow.createCell(11);
         excelCell = excelRow.getCell(11);
         excelCell.setCellValue("Стационарная помощь");
         sheet.addMergedRegion(new CellRangeAddress(7,7,11,15));
         
         /* 
          * Questions
          */
         List<String> list = questions();
         for(int i=0;i<list.size();i++)
         {
        	 excelRow = sheet.createRow(i+8);
             excelRow = sheet.getRow(i+8);			
             excelCell = excelRow.createCell(0);
             excelCell = excelRow.getCell(0);
             excelCell.setCellValue(list.get(i));
         }
         
         /*
          * Data 
          */
         // ПОЛИКЛИНИКА
         
         // Организацией записи на прием к врачу
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(8);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic1(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         //  СУММА Организацией записи на прием к врачу
        	 excelRow = sheet.getRow(8);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic1summ(forOneOrgClinic,paramonepart.getMas()));
         
         
         // Временем ожидания приема врача
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(9);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic2(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Временем ожидания приема врача
        	 excelRow = sheet.getRow(9);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic2summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Сроками ожидания медицинских услуг после записи
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(10);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic3(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Сроками ожидания медицинских услуг после записи
        	 excelRow = sheet.getRow(10);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic3summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Доступностью необходимых лабораторных исследований/анализов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(11);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic4(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Доступностью необходимых лабораторных исследований/анализов
        	 excelRow = sheet.getRow(11);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic4summ(forOneOrgClinic,paramonepart.getMas()));

 	   
         // Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.)
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(12);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic5(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.)
        	 excelRow = sheet.getRow(12);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic5summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Доступностью мед.помощи терапевтов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(13);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic6(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Доступностью мед.помощи терапевтов
        	 excelRow = sheet.getRow(13);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic6summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Доступностью мед.помощи врачей-специалистов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(14);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic7(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Доступностью мед.помощи врачей-специалистов
        	 excelRow = sheet.getRow(14);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic7summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Работой врачей в поликлинике
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(15);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic8(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         //СУММА Работой врачей в поликлинике
        	 excelRow = sheet.getRow(15);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic8summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Насколько Вы удовлетворены качеством бесплатной медицинской помощи
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(16);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic9(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Насколько Вы удовлетворены качеством бесплатной медицинской помощи
        	 excelRow = sheet.getRow(16);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic9summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Техническим состоянием, ремонтом помещений, площадью помещений
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(17);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic10(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Техническим состоянием, ремонтом помещений, площадью помещений
        	 excelRow = sheet.getRow(17);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic10summ(forOneOrgClinic,paramonepart.getMas()));
         
         // Оснащенностью современным медицинским оборудованием
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(18);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(countonquestionClinic11(forOneOrgClinic.get(i),paramonepart.getMas()));
         }
         
         // СУММА Оснащенностью современным медицинским оборудованием
        	 excelRow = sheet.getRow(18);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic11summ(forOneOrgClinic,paramonepart.getMas()));
         
         // количество опрошенных респондентов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(19);	
             excelCell = excelRow.createCell(i+1);
             excelCell = excelRow.getCell(i+1);
             excelCell.setCellValue(forOneOrgClinic.get(i).size());
         }

         // СУММА количество опрошенных респондентов
        	 excelRow = sheet.getRow(19);	
             excelCell = excelRow.createCell(5);
             excelCell = excelRow.getCell(5);
             excelCell.setCellValue(countonquestionClinic12(forOneOrgClinic));
         
         /*
          * Дневной стационар
          */
             
         // Насколько Вы удовлетворены качеством бесплатной медицинской помощи
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(16);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC1(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Насколько Вы удовлетворены качеством бесплатной медицинской помощи
    	 excelRow = sheet.getRow(16);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC1summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Техническим состоянием, ремонтом помещений, площадью помещений
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(17);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC2(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Техническим состоянием, ремонтом помещений, площадью помещений
    	 excelRow = sheet.getRow(17);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC2summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Оснащенностью современным медицинским оборудованием
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(18);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC3(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Оснащенностью современным медицинским оборудованием
    	 excelRow = sheet.getRow(18);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC3summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Комфортностью больничной палаты и мест пребывания пациентов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(21);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC4(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Комфортностью больничной палаты и мест пребывания пациентов
    	 excelRow = sheet.getRow(21);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC4summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Комплексом предоставляемых медицинских услуг
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(22);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC5(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Комплексом предоставляемых медицинских услуг
    	 excelRow = sheet.getRow(22);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC5summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(23);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC6(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.
    	 excelRow = sheet.getRow(23);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC6summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Обеспеченностью медикаментами и расходными материалами
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(24);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC7(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Обеспеченностью медикаментами и расходными материалами
    	 excelRow = sheet.getRow(24);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC7summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // Работой лечащего врача
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(25);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(countonquestionDC8(forOneOrgDayStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Работой лечащего врача
    	 excelRow = sheet.getRow(25);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC8summ(forOneOrgDayStac,paramonepart.getMas()));
         
         // количество опрошенных респондентов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(26);	
             excelCell = excelRow.createCell(i+6);
             excelCell = excelRow.getCell(i+6);
             excelCell.setCellValue(forOneOrgDayStac.get(i).size());
         }
         
         // СУММА количество опрошенных респондентов
    	 excelRow = sheet.getRow(26);	
         excelCell = excelRow.createCell(10);
         excelCell = excelRow.getCell(10);
         excelCell.setCellValue(countonquestionDC9(forOneOrgDayStac));
         
         /*
          * Стационарная помощь
          */
             
         // Насколько Вы удовлетворены качеством бесплатной медицинской помощи
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(16);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac1(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Насколько Вы удовлетворены качеством бесплатной медицинской помощи
    	 excelRow = sheet.getRow(16);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac1summ(forOneOrgStac,paramonepart.getMas()));
         
         // Техническим состоянием, ремонтом помещений, площадью помещений
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(17);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac2(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Техническим состоянием, ремонтом помещений, площадью помещений
    	 excelRow = sheet.getRow(17);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac2summ(forOneOrgStac,paramonepart.getMas()));         
         
         // Оснащенностью современным медицинским оборудованием
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(18);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac3(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Оснащенностью современным медицинским оборудованием
    	 excelRow = sheet.getRow(18);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac3summ(forOneOrgStac,paramonepart.getMas()));
         
         // Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(23);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac4(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.
    	 excelRow = sheet.getRow(23);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac4summ(forOneOrgStac,paramonepart.getMas()));
         
         // Обеспеченностью медикаментами и расходными материалами
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(24);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac5(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Обеспеченностью медикаментами и расходными материалами
    	 excelRow = sheet.getRow(24);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac5summ(forOneOrgStac,paramonepart.getMas()));
         
         // Работой лечащего врача
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(25);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac6(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Работой лечащего врача
    	 excelRow = sheet.getRow(25);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac6summ(forOneOrgStac,paramonepart.getMas()));
         
         // Комфортностью больничной палаты и мест пребывания пациентов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(28);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac7(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Комфортностью больничной палаты и мест пребывания пациентов
    	 excelRow = sheet.getRow(28);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac7summ(forOneOrgStac,paramonepart.getMas()));
         
         // Питание
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(29);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac8(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Питание
    	 excelRow = sheet.getRow(29);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac8summ(forOneOrgStac,paramonepart.getMas()));
         
         //Сроками ожидания плановой госпитализации
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(30);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(countonquestionStac9(forOneOrgStac.get(i),paramonepart.getMas()));
         }
         
         // СУММА Сроками ожидания плановой госпитализации
    	 excelRow = sheet.getRow(30);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac9summ(forOneOrgStac,paramonepart.getMas()));
         
         // количество опрошенных респондентов
         for(int i=0; i<4;i++)
         {
        	 excelRow = sheet.getRow(31);	
             excelCell = excelRow.createCell(i+11);
             excelCell = excelRow.getCell(i+11);
             excelCell.setCellValue(forOneOrgStac.get(i).size());
         }
         
         // СУММА количество опрошенных респондентов
    	 excelRow = sheet.getRow(31);	
         excelCell = excelRow.createCell(15);
         excelCell = excelRow.getCell(15);
         excelCell.setCellValue(countonquestionStac10(forOneOrgStac));

         
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
    
    

    private List<String> questions()
    {
    	List<String> ls = new ArrayList<String>();
    	
    	ls.add("Организацией записи на прием к врачу");// п
    	ls.add("Временем ожидания приема врача");//п
    	ls.add("Сроками ожидания медицинских услуг после записи");// п
    	ls.add("Доступностью необходимых лабораторных исследований/анализов");//п
    	ls.add("Доступностью диагностических исследований (ЭКГ, УЗИ и т.д.)"); // п
    	ls.add("Доступностью мед.помощи терапевтов"); // п
    	ls.add("Доступностью мед.помощи врачей-специалистов");// п
    	ls.add("Работой врачей в поликлинике");// п
    	
    	ls.add("Насколько Вы удовлетворены качеством бесплатной медицинской помощи");
    	ls.add("Техническим состоянием, ремонтом помещений, площадью помещений");
    	ls.add("Оснащенностью современным медицинским оборудованием");
    	ls.add("Всего количество опрошенных респондентов амбл.-поликлин. помощи (кол чел)");// п
    	ls.add("Требуется опросить амбл.-поликлин. помощи (кол чел)");// п
    	
    	ls.add("Комфортностью больничной палаты и мест пребывания пациентов");// дс
    	ls.add("Комплексом предоставляемых медицинских услуг");// дс
    	
    	ls.add("Работой вспомогательных служб (лаборатория, рентген-кабинет, физиотерапевтический кабинет и т.д.)");// дс с
    	ls.add("Обеспеченностью медикаментами и расходными материалами");// дс с
    	ls.add("Работой лечащего врача");// дс с
    	ls.add("Всего количество опрошенных респондентов дневного стационара (кол чел)");// дс
    	ls.add("Требуется опросить респондентов из дневного стационара (кол чел)");// дс
    	
    	ls.add("Комфортностью больничной палаты и мест пребывания пациентов"); // c 
    	ls.add("Питание"); // c 
    	ls.add("Сроками ожидания плановой госпитализации"); // c
    	ls.add("Всего количество опрошенных респондентов стационарной помощи (кол чел)");// c
    	ls.add("Требуется опросить стационарной помощи (кол чел)");// c
    	
    	return ls;
    }

    private int countonquestionClinic1(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getSeeADoctor().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic1summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getSeeADoctor().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic2(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getWaitingTime().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic2summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getWaitingTime().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic3(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getWaitingTime2().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic3summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getWaitingTime2().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }

    private int countonquestionClinic4(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getLaboratoryResearch().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }

    private int countonquestionClinic4summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getLaboratoryResearch().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic5(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getDiagnosticTests().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic5summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getDiagnosticTests().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic6(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getTherapist().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic6summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getTherapist().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic7(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getMedicalSpecialists().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic7summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getMedicalSpecialists().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic8(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getClinicDoctor().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic8summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getClinicDoctor().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic9(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getFreeHelp().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }

    private int countonquestionClinic9summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getFreeHelp().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    
    private int countonquestionClinic10(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getRepairs().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic10summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getRepairs().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic11(List<SurvayClinic> forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
           	 if(forOneOrgClinic.get(i).getEquipment().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionClinic11summ(List<List<SurvayClinic>>  forOneOrgClinic,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgClinic.size();i++)
            {
    			for(int k=0;k<forOneOrgClinic.get(i).size();k++){
    		
    				if(forOneOrgClinic.get(i).get(k).getEquipment().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    
    private int countonquestionClinic12(List<List<SurvayClinic>> forOneOrgClinic)
    {
    	int p =0;
    	for(int i=0;i<forOneOrgClinic.size();i++)
    	{
    		p =p+ forOneOrgClinic.get(i).size();
    	}
    		
        return p;
    }

    private int countonquestionDC1(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getQualityDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC1summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getQualityDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    
    private int countonquestionDC2(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getRapairsDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC2summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getRapairsDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC3(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getEquipmentDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC3summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getEquipmentDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC4(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getComfortDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }

    private int countonquestionDC4summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getComfortDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    
    private int countonquestionDC5(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getServicesDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC5summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getServicesDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC6(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getLaboratoryDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC6summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getLaboratoryDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC7(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getMedicineDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC7summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getMedicineDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC8(List<SurvayDaystacionar> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
           	 if(forOneOrgDayStac.get(i).getTherapistDaystac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }

    private int countonquestionDC8summ(List<List<SurvayDaystacionar>> forOneOrgDayStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgDayStac.size();i++)
            {
    			for(int k=0;k<forOneOrgDayStac.get(i).size();k++){
    		
    				if(forOneOrgDayStac.get(i).get(k).getTherapistDaystac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionDC9(List<List<SurvayDaystacionar>> forOneOrgDayStac)
    {
    	int p =0;
    	for(int i=0;i<forOneOrgDayStac.size();i++)
    	{
    		p =p+ forOneOrgDayStac.get(i).size();
    	}
    		
        return p;
    }

    private int countonquestionStac1(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getQualityStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac1summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getQualityStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }

    
    private int countonquestionStac2(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getRapairsStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac2summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getRapairsStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac3(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getEquipmentStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac3summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getEquipmentStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac4(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getLaboratoryStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac4summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getLaboratoryStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac5(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getMedicineStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac5summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getMedicineStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac6(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getTherapistStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac6summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getTherapistStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac7(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getComfortStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac7summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getComfortStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac8(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getFoodStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac8summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getFoodStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac9(List<SurvayStacionar> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
           	 if(forOneOrgStac.get(i).getTermsStac().equals(var.get(j)))
    			{
    				p++;
    			}
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac9summ(List<List<SurvayStacionar>> forOneOrgStac,List<String> var)
    {
    	int p =0;
    	
    	for(int j=0; j<var.size();j++)
    	{
    		for(int i=0;i<forOneOrgStac.size();i++)
            {
    			for(int k=0;k<forOneOrgStac.get(i).size();k++){
    		
    				if(forOneOrgStac.get(i).get(k).getTermsStac().equals(var.get(j)))
        			{
        				p++;
        			}
    				
    			}
           	 
            }
    	}
        
        return p;
    }
    
    private int countonquestionStac10(List<List<SurvayStacionar>> forOneOrgStac)
    {
    	int p =0;
    	for(int i=0;i<forOneOrgStac.size();i++)
    	{
    		p =p+ forOneOrgStac.get(i).size();
    	}
    		
        return p;
    }
    
    }
