//package com.bingfa;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class TomcatTestController{
//
//	@RequestMapping(value = "/tomcatTest")
//	@ResponseBody
//	public String tomcatTest(HttpServletRequest request,HttpServletResponse response) {
//
//		response.setHeader("Content-type", "text/html;charset=UTF-8");
//
//		try {
//
//			InputStream in = request.getInputStream();
//
//			byte[] bytes = new byte[1024];
//
//			in.read(bytes);
//			String result = "Tomcat 接收到信息：  "+ new String(bytes,"utf-8");
//			result = result.trim();
//			System.out.println(result);
//			in.close();
//
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			OutputStream out = response.getOutputStream();
//
//			out.write(result.getBytes("utf-8"));
//
//			out.flush();
//
//			out.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("over ... ");
//
//		return null;
//
//	}
//
//}
