/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.TagInfo
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月14日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.brand.bean.info;

/**
 * 标签信息
 * @className:com.life.interfaces.code.brand.bean.info.TagInfo
 * @version:v1.0.0 
 * @date:2016年6月14日 下午9:31:11
 * @author:Chaos
 */
public class TagInfo
{
	//标签ID
	private String tag_id = "";
	
	//标签名
	private String tag_name = "";

	public String getTag_id()
	{
		return tag_id;
	}

	public void setTag_id(String tag_id)
	{
		this.tag_id = tag_id;
	}

	public String getTag_name()
	{
		return tag_name;
	}

	public void setTag_name(String tag_name)
	{
		this.tag_name = tag_name;
	}
	
}
