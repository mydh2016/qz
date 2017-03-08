package com.qazit.hospital.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
public class ExportExcel {
	public HSSFWorkbook export(List<String>list,List<?>dataList,List<Integer>methodList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("sheet1");  
        // 第三步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();
        HSSFRow row = sheet.createRow(0);
        row.setHeight((short) 400);
//        row.setRowStyle(style);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        HSSFCell cell = null;
        for (int i = 0; i < list.size(); i++) {
        	cell=row.createCell(i);
        	 cell.setCellValue(list.get(i));  
             cell.setCellStyle(style);  
		}
        int c=0;
        HSSFCellStyle rowstyle = wb.createCellStyle();
    	rowstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
        for (int i = 0; i < dataList.size(); i++) { 
        	c++;
        	HSSFRow rownum = sheet.createRow(c);
             Object t=dataList.get(i);
            Field[] fields=t.getClass().getDeclaredFields();
             // 第5步，创建单元格，并设置值  
            for (int j = 0; j < methodList.size(); j++) {
            	Field field = fields[methodList.get(j)];
            	String fieldName = field.getName();
            	String getMethodName = "get"
            	+ fieldName.substring(0, 1).toUpperCase()
            	+ fieldName.substring(1);
            	Class<? extends Object> tCls = t.getClass();
            	Method getMethod = tCls.getMethod(getMethodName,
            	new Class[] {});
            	Object value = getMethod.invoke(t, new Object[] {});
            	HSSFCell rowcell=rownum.createCell(j);
            	if(value==null){
            		rowcell.setCellValue("");
            		rowcell.setCellStyle(rowstyle);
            	}else{
            		if("sex".equals(fieldName)&& "1".equals(value.toString())){
            			rowcell.setCellValue("男");
            		}else if("sex".equals(fieldName)&& "2".equals(value.toString())){
            			rowcell.setCellValue("女");
            		}else if("status".equals(fieldName)&& "1".equals(value.toString())){
            			rowcell.setCellValue("院内");
            		}else if("status".equals(fieldName)&& "2".equals(value.toString())){
            			rowcell.setCellValue("院外");
            		}else{
            			rowcell.setCellValue(value.toString());
            		}
            		rowcell.setCellStyle(rowstyle);
            	}
			}
        } 
//		creatExcellHead(wb, sheet, style,list);
//		writeData(sheet, dataList);
//		saveFile(wb,request,response);
		return wb;
	}
//	public HSSFSheet creatExcellHead(HSSFWorkbook wb,HSSFSheet sheet,HSSFCellStyle style,List<String>list){
//        // 第四步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
//        HSSFRow row = sheet.createRow((int) 0);  
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
//        HSSFCell cell = null;
//        for (int i = 0; i < list.size(); i++) {
//        	cell=row.createCell(i);
//        	 cell.setCellValue(list.get(i));  
//             cell.setCellStyle(style);  
//		}
//        return sheet;
//	}
//	public void writeData(HSSFSheet sheet,List<?>dataList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//        for (int i = 0; i < dataList.size(); i++) {  
//        	HSSFRow row = sheet.createRow((int) i + 1);
//             Object t=dataList.get(i);
//            Field[] fields=t.getClass().getDeclaredFields();
//             // 第5步，创建单元格，并设置值  
//            for (int j = 0; j < fields.length; j++) {
//            	Field field = fields[i];
//            	String fieldName = field.getName();
//            	String getMethodName = "get"
//            	+ fieldName.substring(0, 1).toUpperCase()
//            	+ fieldName.substring(1);
//            	Class<? extends Object> tCls = t.getClass();
//            	Method getMethod = tCls.getMethod(getMethodName,
//            	new Class[] {});
//            	Object value = getMethod.invoke(t, new Object[] {});
//            	row.createCell(j).setCellValue(value.toString());
//			}
//        }  
//	}
//	public void saveFile(HSSFWorkbook wb,HttpServletRequest request,HttpServletResponse response){
//		// 第六步，将文件存到指定位置  
//        try {  
//        	response.setContentType("application/vnd.ms-excel");  
//            response.setHeader("Content-disposition", "attachment;filename=student.xls");
//            request.getSession().getServletContext().getRealPath("/WEB-INF/upload");   
//            OutputStream ouputStream = response.getOutputStream();    
//             wb.write(ouputStream);  
//             ouputStream.flush();  
//             ouputStream.close();  
//        } catch (Exception e) {  
//             e.printStackTrace();  
//        }  
//	}
}
