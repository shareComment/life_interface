/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.sys.SysInfo
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
 * @className:com.life.interfaces.code.sys.bean.sys.SysInfo
 * @version:v1.0.0 
 * @date:2016年7月7日 下午4:08:03
 * @author:Chaos
 */
public class SysInfo
{
	private String sms_id = "";
	
	private String title = "";
	
	private String content = "";
	
	private String send_time = "";
	
	private String status = "";

	public String getSms_id()
	{
		return sms_id;
	}

	public void setSms_id(String sms_id)
	{
		this.sms_id = sms_id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getSend_time()
	{
		return send_time;
	}

	public void setSend_time(String send_time)
	{
		this.send_time = send_time;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
}
