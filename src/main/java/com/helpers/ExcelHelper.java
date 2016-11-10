package com.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import jxl.Workbook;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelHelper {
	public  String path;
	public  String reportName;
	public  String sheetName;
	public  int  possition;
	String strFormula= "AVERAGE(C:E)";
	
	
	
	public ExcelHelper(String path, String reportName, String sheetName, int possition) {
		super();
		this.path = path;
		this.reportName = reportName;
		this.sheetName = sheetName;
		this.possition = possition;
	}

	public WritableWorkbook createExcel(String path,String fileName,String sheetName,int possition) throws IOException{
		 WritableWorkbook workbook = Workbook.createWorkbook(new File(path+"/"+fileName+".xls"));
		 WritableSheet sheet = workbook.createSheet(sheetName, possition);
		 return workbook;
	}
	public void write() throws Exception{
		 FileOutputStream fileOut;
         fileOut = new FileOutputStream("file.xls");
         HSSFWorkbook workbook = new HSSFWorkbook();
         HSSFSheet worksheet = workbook.createSheet("Sheet 0");
         worksheet.addMergedRegion(new CellRangeAddress(0,0,2,5));
         worksheet.addMergedRegion(new CellRangeAddress(0,0,6,9));
         worksheet.addMergedRegion(new CellRangeAddress(0,0,10,13));
         worksheet.addMergedRegion(new CellRangeAddress(0,0,14,17));
        
         worksheet.addMergedRegion(new CellRangeAddress(1,3,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(4,5,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(6,7,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(8,9,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(10,11,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(12,13,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(14,15,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(16,17,0,0));
         worksheet.addMergedRegion(new CellRangeAddress(18,19,0,0));
    
         Row row1 = worksheet.createRow((short)0);
         row1.createCell(0).setCellValue("Time Stamp");
         row1.createCell(1).setCellValue("Plan");
         row1.createCell(2).setCellValue("Public Site");
         row1.createCell(6).setCellValue("Public site to Login page");
         row1.createCell(10).setCellValue("Login page to VO Dashboard");
         row1.createCell(14).setCellValue("VO Dashboard to Product Page");
         Row row2 = worksheet.createRow((short)1);
         row2.createCell(1).setCellValue("Plan");
         row2.createCell(2).setCellValue("1st");
         row2.createCell(3).setCellValue("2nd"); 
         row2.createCell(4).setCellValue("3rd");
         row2.createCell(5).setCellValue("Avg");
         
        
         row2.createCell(6).setCellValue("1st");
         row2.createCell(7).setCellValue("2nd"); 
         row2.createCell(8).setCellValue("3rd");
         row2.createCell(9).setCellValue("Avg");
         
        
         row2.createCell(10).setCellValue("1st");
         row2.createCell(11).setCellValue("2nd"); 
         row2.createCell(12).setCellValue("3rd");
         row2.createCell(13).setCellValue("Avg");
         
         
         row2.createCell(14).setCellValue("1st");
         row2.createCell(15).setCellValue("2nd"); 
         row2.createCell(16).setCellValue("3rd");
         row2.createCell(17).setCellValue("Avg");
      
         //ResultSet resultSets = DB.result("SELECT * FROM time WHERE plan='Vihan' AND round='1'");
         Row row;
         
        // workbook.write(fileOut);
       
        Map<Integer,Map> data = new HashMap<Integer,Map>();
        Map<Integer,String> line1 = new HashMap<Integer,String>();
        Map<Integer,String> line2 = new HashMap<Integer,String>();
        Map<Integer,String> line3 = new HashMap<Integer,String>();
        data = Mapper.map();
     int x;
     int a = 2;
        for (int i = 1; i < data.size(); i++) {
        	
        	line1 = data.get(i);
        	line2 = data.get(x=i+1);
        	line3 = data.get(x=i+2);
        	System.out.println("-----------------------------------------------------------------------");
        	System.out.println(line1);
        	System.out.println("-----------------------------------------------------------------------");
        	System.out.println(line2);
        	System.out.println("-----------------------------------------------------------------------");
        	System.out.println(line3);
        	System.out.println("-----------------------------------------------------------------------");
        	
        	if(line1.get(0).equals("Vihan")){
        		System.out.println("Printing Line no V"+a);
        		 int y = a+1;
        	row = worksheet.createRow((short)a);
        	row.createCell(1).setCellValue(line1.get(0));
        	row.createCell(2).setCellValue(Double.parseDouble(line1.get(2)));
        	row.createCell(3).setCellValue(Double.parseDouble(line2.get(3)));
        	row.createCell(4).setCellValue(Double.parseDouble(line3.get(4)));
        	row.createCell(6).setCellValue(Double.parseDouble(line1.get(6)));
        	row.createCell(7).setCellValue(Double.parseDouble(line2.get(7)));
        	row.createCell(8).setCellValue(Double.parseDouble(line3.get(8)));
        	row.createCell(10).setCellValue(Double.parseDouble(line1.get(10)));
        	row.createCell(11).setCellValue(Double.parseDouble(line2.get(11)));
        	row.createCell(12).setCellValue(Double.parseDouble(line3.get(12)));
        	row.createCell(14).setCellValue(Double.parseDouble(line1.get(14)));
        	row.createCell(15).setCellValue(Double.parseDouble(line2.get(15)));
        	row.createCell(16).setCellValue(Double.parseDouble(line3.get(16)));
        
        	row.createCell(5).setCellFormula("AVERAGE(C"+y+":E"+y+")");
        	row.createCell(9).setCellFormula("AVERAGE(G"+y+":I"+y+")");
        	row.createCell(13).setCellFormula("AVERAGE(K"+y+":M"+y+")");
        	row.createCell(17).setCellFormula("AVERAGE(O"+y+":Q"+y+")");
        	}
		
        	else if(line1.get(0).equals("World Plan")){
        		System.out.println("Printing Line no WP"+a);
        		 int y = a+1;
        		row = worksheet.createRow((short)a);
            	row.createCell(1).setCellValue(line1.get(0));
            	row.createCell(2).setCellValue(Double.parseDouble(line1.get(2)));
            	row.createCell(3).setCellValue(Double.parseDouble(line2.get(3)));
            	row.createCell(4).setCellValue(Double.parseDouble(line3.get(4)));
            	row.createCell(6).setCellValue(Double.parseDouble(line1.get(6)));
            	row.createCell(7).setCellValue(Double.parseDouble(line2.get(7)));
            	row.createCell(8).setCellValue(Double.parseDouble(line3.get(8)));
            	row.createCell(10).setCellValue(Double.parseDouble(line1.get(10)));
            	row.createCell(11).setCellValue(Double.parseDouble(line2.get(11)));
            	row.createCell(12).setCellValue(Double.parseDouble(line3.get(12)));
            	row.createCell(14).setCellValue(Double.parseDouble(line1.get(14)));
            	row.createCell(15).setCellValue(Double.parseDouble(line2.get(15)));
            	row.createCell(16).setCellValue(Double.parseDouble(line3.get(16)));
            
            	row.createCell(5).setCellFormula("AVERAGE(C"+y+":E"+y+")");
            	row.createCell(9).setCellFormula("AVERAGE(G"+y+":I"+y+")");
            	row.createCell(13).setCellFormula("AVERAGE(K"+y+":M"+y+")");
            	row.createCell(17).setCellFormula("AVERAGE(O"+y+":Q"+y+")");
	
	
   	}
        	i=x;
        	a++;
	}
       
      
               workbook.write(fileOut);
       
         fileOut.flush();
         fileOut.close();
	}
	
	/*public void write(WritableWorkbook book,int sheetNo,String txt,int c , int r) throws RowsExceededException, WriteException, IOException{
		WritableSheet sheet = book.getSheet(sheetNo);
		 Label testId = new Label(c, r, txt);
		sheet.addCell(testId);
		 book.write();
	     book.close();
		
	}*/
	//XSSFWorkbook myWorkBook;
	public void t() throws WriteException{ 
	
	 try {
        //create a new workbook to write
        WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
        //add a new sheet to the work book
        WritableSheet sheet = workbook.createSheet("TestCases", 0);
        //add test Id to col 0 row 0
        Label testId = new Label(0, 0, "TestId");
        //add test name to col 1 row 0
        Label testName = new Label(1, 0, "TestName");
        //add test module to col 2 row 0
        Label testModule = new Label(2, 0, "TestModule");
        //add test type to col 3 row 0
        Label testType = new Label(3, 0, "TestType");
        //add test steps to col 4 row 0
        Label testSteps = new Label(4, 0, "TestSteps");
        //add test actions to col 5 row 0
        Label testActions = new Label(5, 0, "Action");
        //add test result to col 6 row 0
        Label testResult = new Label(5, 0, "TestResult");
        //add test note to col 7 row 0
        Label testNote = new Label(6, 0, "Note");
        //add to the cells
        sheet.addCell(testId);
        sheet.addCell(testName);
        sheet.addCell(testModule);
        sheet.addCell(testType);
        sheet.addCell(testSteps);
        sheet.addCell(testActions);
        sheet.addCell(testResult);
        sheet.addCell(testNote);
        //define row 1 content
        Number testIdNumber = new Number(0, 1, 1234);
        Label testNameContent=new Label(1,1,"Login");
        Label testModuleContent=new Label(2,1,"Dashboard");
        Label testTypeContent=new Label(3,1,"Regression");
        Label testStepsContent=new Label(4,1,"1");
        Label testActionContent=new Label(5,1,"Open Browser");
        Label testResultContent=new Label(6,1,"");
        Label testNoteContent=new Label(7,1,"");
        //add row 1 content
        sheet.addCell(testIdNumber);
        sheet.addCell(testNameContent);
        sheet.addCell(testModuleContent);
        sheet.addCell(testTypeContent);
        sheet.addCell(testStepsContent);
        sheet.addCell(testActionContent);
        sheet.addCell(testResultContent);
        sheet.addCell(testNoteContent);
        // All sheets and cells added. Now write out the workbook
        workbook.write();
        workbook.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
