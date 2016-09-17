/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.Category
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
 * 类别
 * @className:com.life.interfaces.code.brand.bean.info.Category
 * @version:v1.0.0 
 * @date:2016年6月14日 下午7:52:24
 * @author:Chaos
 */
public class Category
{
	//类别ID
	private String cate_id = "";
	
	//类别父ID
	private String cate_pid = "";
	
	//类别名
	private String cate_name = "";

	public String getCate_id()
	{
		return cate_id;
	}

	public void setCate_id(String cate_id)
	{
		this.cate_id = cate_id;
	}

	public String getCate_pid()
	{
		return cate_pid;
	}

	public void setCate_pid(String cate_pid)
	{
		this.cate_pid = cate_pid;
	}

	public String getCate_name()
	{
		return cate_name;
	}

	public void setCate_name(String cate_name)
	{
		this.cate_name = cate_name;
	}
	
}
