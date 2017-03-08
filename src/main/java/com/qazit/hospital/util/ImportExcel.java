package com.qazit.hospital.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcel {
	@SuppressWarnings("resource")
	public List<List<Object>> readExcel(String path) throws FileNotFoundException, IOException{
		boolean is2007=false;
		if(path.endsWith("xlsx")){
			is2007=true;
		}
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		Workbook wb  = null;
		File fl=new File(path);
		InputStream file=new FileInputStream(fl);
		if(is2007){
			wb=new XSSFWorkbook(file);
		}else{
			wb= new HSSFWorkbook(file);
		}
		Sheet sheet=wb.getSheetAt(0);
		Iterator<Row>rows=sheet.rowIterator();
		List<List<Object>>dataList=new ArrayList<List<Object>>();
		int i=0;
		while (rows.hasNext()) {
			Row row=rows.next();
			if(i==0){
				i++;
			}else{
				i++;
				List<Object>list=new ArrayList<Object>();
				Iterator<Cell>cells=row.cellIterator();
				String cellValue=null;
				while (cells.hasNext()) {
					Cell cell=cells.next();
						switch(cell.getCellType()) {  
		                    case Cell.CELL_TYPE_STRING: //文本  
		                        cellValue = cell.getStringCellValue();  
		                        break;  
		                    case Cell.CELL_TYPE_NUMERIC: //数字、日期  
		                        if(DateUtil.isCellDateFormatted(cell)) {  
		                            cellValue = fmt.format(cell.getDateCellValue()); //日期型  
		                        }  
		                        else {
		                        	DecimalFormat format = new DecimalFormat("#");  
		                        	double value = cell.getNumericCellValue();  
		                        	String phone = format.format(value); 
		                        	cellValue=phone;
		                        }  
		                        break;  
		                    case Cell.CELL_TYPE_BOOLEAN: //布尔型  
		                        cellValue = String.valueOf(cell.getBooleanCellValue());  
		                        break;  
		                    case Cell.CELL_TYPE_BLANK: //空白  
		                        break;  
		                    case Cell.CELL_TYPE_ERROR: //错误  
		                        break;  
		                    case Cell.CELL_TYPE_FORMULA: //公式  
		                        break;  
		                    default:  
		                }  
					
					list.add(cellValue);
				}
				if(!list.isEmpty()&& list.size()>0){
					dataList.add(list);
				}
			}
			
		}
		if(fl.exists())
			fl.delete();
//		 @SuppressWarnings("resource")
//		HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(new File(path)));
//		 HSSFSheet sheet=null;
//		 List<List<Object>>dataList=new ArrayList<>();
//	        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
//	             sheet=workbook.getSheetAt(i);
//	             for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {//获取每行
//	                HSSFRow row=sheet.getRow(j);
//	                List<Object>list=new ArrayList<Object>();
//	                for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {//获取每个单元格
//	                    System.out.print(row.getCell(k)+"\t");
//	                    list.add(row.getCell(k));
//	                }
//	                dataList.add(list);
//	                System.out.println("---Sheet表"+i+"处理完毕---");
//	            }
//	        }
	        return dataList;
	}
}
