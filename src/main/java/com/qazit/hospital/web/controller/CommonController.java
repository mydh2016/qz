package com.qazit.hospital.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共视图控制器
 * 
 * @author AI_NSG
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController {
    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request,HttpServletResponse response) {
    	 response.setContentType("text/html");
         //servlet页面默认是不缓存的
         //本页面允许在浏览器端或缓存服务器中缓存，时限为20秒。
         //20秒之内重新进入该页面的话不会进入该servlet的
//         java.util.Date date = new java.util.Date();    
//         response.setDateHeader("Last-Modified",date.getTime()); //Last-Modified:页面的最后生成时间 
//         response.setDateHeader("Expires",0); //Expires:过时期限值 
//         response.setHeader("Cache-Control", "private"); //Cache-Control来控制页面的缓存与否,public:浏览器和缓存服务器都可以缓存页面信息；
//         response.setHeader("Pragma", "no-cache"); //Pragma:设置页面是否缓存，为Pragma则缓存，no-cache则不缓存
//         response.setHeader("Cache-Control", "max-age=60"); 
//         response.addHeader( "Cache-Control", "no-cache" );
    	 
         //max-age
         //不允许浏览器端或缓存服务器缓存当前页面信息。
         response.setHeader( "Pragma", "no-cache" );   
         response.setDateHeader("Expires", 0);   
         response.addHeader( "Cache-Control", "no-cache" );//浏览器和缓存服务器都不应该缓存页面信息
         response.addHeader( "Cache-Control", "no-store" );//请求和响应的信息都不应该被存储在对方的磁盘系统中；    
         response.addHeader( "Cache-Control", "must-revalidate" );//于客户机的每次请求，代理服务器必须想服务器验证缓存是否过时；

         System.out.println("进入了servlet");
        return "index";
    }

}