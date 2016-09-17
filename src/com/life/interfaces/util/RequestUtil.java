package com.life.interfaces.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

/**
 * 
* @ClassName: RequestUtil
* @Description: 请求工具类
* @author 刘强
* @date 2015年7月5日 下午3:07:22
 */
public class RequestUtil
{
	/**
	 * @throws IOException 
	 * 
	* @Title: request2String
	* @Description: 返回请求报文
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public static String request2String(HttpServletRequest request) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null)
		{
			sb.append(line);
		}
		
		return sb.toString();
	}
}
