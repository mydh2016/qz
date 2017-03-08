package com.qazit.hospital.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("download")
public class Download {
	@RequestMapping("download")
	public void download(Integer dl,HttpServletResponse response,HttpServletRequest request){
		String path=request.getSession().getServletContext().getRealPath("/");
		if(dl==1){
			path=path+"/muBan.xlsx";
		}else if(dl==2){
			path=path+"/huanZheMuBan.xlsx";
		}else if(dl==3){
			path=path+"/miandarao.xlsx";
		}
		try {
			File file = new File(path);// path是根据日志路径和文件名拼接出来的
		    String filename = file.getName();// 获取日志文件名称
		    InputStream fis = new BufferedInputStream(new FileInputStream(path));
		    byte[] buffer = new byte[fis.available()];
		    fis.read(buffer);
		    fis.close();
		    response.reset();
		    // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
		    response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
		    response.addHeader("Content-Length", "" + file.length());
		    OutputStream os = new BufferedOutputStream(response.getOutputStream());
		    response.setContentType("application/octet-stream");
		    os.write(buffer);// 输出文件
		    os.flush();
		    os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
