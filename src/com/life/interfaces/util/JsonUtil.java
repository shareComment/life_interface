package com.life.interfaces.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
* @ClassName: JsonUtil
* @Description: 解析json的工具类
* @author 刘强
* @date 2015年7月5日 下午10:51:40
 */
public class JsonUtil
{
	/**
	 * 
	* @Title: getValue
	* @Description: 返回json字符串中的value
	* @param @param json
	* @param @param key
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	public static String getValue(String json,String key)
	{
		String value = "";
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
		value = jsonObject.get(key).getAsString();
		return value;
	}
	
	
}
