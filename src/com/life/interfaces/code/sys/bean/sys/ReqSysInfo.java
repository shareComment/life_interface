/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.sys.ReqSysInfo
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年7月7日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.sys.bean.sys;

/**
 * @className:com.life.interfaces.code.sys.bean.sys.ReqSysInfo
 * @version:v1.0.0 
 * @date:2016年7月7日 下午2:45:14
 * @author:Chaos
 */
public class ReqSysInfo
{
	private String user_id = "";
	
	//分页数量
	private Integer pageNum = 0;
		
	//起始页面
	private Integer page = 0;
	
	//消息ID
	private String sms_id = "";

	public Integer getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getSms_id()
	{
		return sms_id;
	}

	public void setSms_id(String sms_id)
	{
		this.sms_id = sms_id;
	}
	
}
