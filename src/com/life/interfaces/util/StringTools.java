package com.life.interfaces.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.fileupload.FileUpload;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.google.gson.Gson;
import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;

/**
 * 
* @ClassName: StringTools
* @Description: String工具类
* @author 刘强
* @date 2015年7月5日 下午6:35:50
 */
public class StringTools
{
	
	/**
	 * 
	* @Title: removeSpace
	* @Description:  字符串去首尾空格
	* @param @param str
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public static String removeSpace(String str)
	{
		if (StringTools.isNullOrEmpty(str))
		{
			return "";
		}
		return str.trim();
	}

	/**
	 * 
	* @Title: isNullOrEmpty
	* @Description: 判断字符串非空
	* @param @param str
	* @param @return    设定文件
	* @return boolean    返回类型
	* @throws
	 */
	public static boolean isNullOrEmpty(String str)
	{
		if (null == str || "".equals(str) || "null".equals(str))
		{
			return true;
		}
		return false;
	}

	/**
	 * 
	* @Title: isNullOrEmpty
	* @Description: 判断对象是否为空
	* @param @param obj
	* @param @return    设定文件
	* @return boolean    返回类型
	* @throws
	 */
	public static boolean isNullOrEmpty(Object obj)
	{
		if (null == obj || "".equals(obj))
		{
			return true;
		}
		return false;
	}

	/**
	 * 
	* @Title: parseStr2Int
	* @Description: 将字符串转换成Integer
	* @param @param str
	* @param @return    设定文件
	* @return int    返回类型
	* @throws
	 */
	public static int parseStr2Int(String str)
	{
		int num = 0;
		try
		{
			if (StringTools.isNullOrEmpty(str))
			{
				return 0;
			}
			num = Integer.parseInt(StringTools.removeSpace(str));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
		return num;
	}

	/**
	 * 
	* @Title: cutOutString
	* @Description: 按规定的长度截取字符串，过长部分用“...”表示
	* @param @param str
	* @param @param length
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public static String cutOutString(String str, int length)
	{
		str = StringTools.removeSpace(str);
		String newStr = str;
		if (StringTools.isNullOrEmpty(str))
		{
			return "";
		}

		if (str.length() > length)
		{
			newStr = str.substring(0, length) + "...";
		}
		return newStr;
	}
	
	/**
	 * 
	* @Title: getKeyByTypeCode
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	* @author:刘强
	* @date:2015年7月8日 下午11:53:18
	 */
	public static String getKeyByTypeCode(String typeCode)
	{
		Random jjj = new Random();
        Date currentTime = new Date();

        String key = "";
        String randomNum = "";

        // 获取当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateString = formatter.format(currentTime);

        // 取四位随机数
        for (int k = 0; k < 4; k++)
        {
            randomNum = randomNum + jjj.nextInt(9);
        }

        key = typeCode + dateString + randomNum;
        return key;
	}
	
	
	public static String getDateFileName()
	{
		Date now = new Date();
		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMM");
        String d1 = f1.format(now);
        SimpleDateFormat f2 = new SimpleDateFormat("dd");
        String d2 = f2.format(now);
		return d1+"/"+d2;
	}
		
	/**
	 * 返回UUID
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月5日下午9:03:31
	 */
	public static String getUUID()
	{
		String s = UUID.randomUUID().toString();
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}
	
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 将Unix时间戳转换成指定格式日期 
	 * @param @param timestampString
	 * @param @param formats
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author 刘强
	 * @date 2015年9月29日上午12:31:05
	 */
	public static String TimeStamp2Date(String timestampString,String strDate)
	{
		 Long timestamp = Long.parseLong(timestampString)*1000;    
		 String date = new java.text.SimpleDateFormat(strDate).format(new java.util.Date(timestamp));    
		 return date;
	}
	
	
	/**
	 * 字符串转成map
	 * @param @param xmlStr
	 * @param @return
	 * @param @throws DocumentException   
	 * @return Map<String,String>  
	 * @throws
	 * @author 刘强
	 * @date 2015年10月6日下午10:59:39
	 */
	public static Map<String, String>	str2Map(String xmlStr) throws DocumentException
	{
		Map<String, String> map = new HashMap<String,String>();
		//将xml格式的字符串转换成Document对象  
		Document doc = DocumentHelper.parseText(xmlStr);
		//获取根节点
		Element root = doc.getRootElement();
		//获取根节点下面所有元素
		@SuppressWarnings("rawtypes")
		List childeren = root.elements();
		//循环所有子元素
		if(childeren != null && childeren.size() > 0)
		{
			for (Object object : childeren)
			{
				Element child = (Element) object;
				map.put(child.getName(), child.getTextTrim());
			}
		}
		return map;
	}
	
	
	public static String levelName(String num)
	{
		Integer num1 = Integer.valueOf(num);
		
		if(num1 > 100)
		{
			return "一品";
		}
		else
		{
			return "九品";
		}
		
	}
	
	public static String getImgUrl(String key) throws IOException
	{
		String url = null;
		InputStream in = null;
		Properties props = new Properties();
		in = FileUpload.class.getResourceAsStream("/com/life/interfaces/cfg/file.properties");
		props.load(in);
		switch (key)
		{
		case "1":
	        url = props.getProperty("infos");//本地图片
			return url;
		default:
			url = props.getProperty("infos");
			return url;
		}
	}
	
	public static void main(String[] args)
	{
		System.err.println(Math.ceil(3.3));
	}
	
	
}
