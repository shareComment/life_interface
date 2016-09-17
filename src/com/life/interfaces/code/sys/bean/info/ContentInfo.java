/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.info.ContentInfo
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月22日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.sys.bean.info;

/**
 * @className:com.life.interfaces.code.sys.bean.info.ContentInfo
 * @version:v1.0.0 
 * @date:2016年6月22日 下午3:43:06
 * @author:Chaos
 */
public class ContentInfo
{
	private String class_id = "";
	
	private String content = "";

	public String getClass_id()
	{
		return class_id;
	}

	public void setClass_id(String class_id)
	{
		this.class_id = class_id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
	
}
