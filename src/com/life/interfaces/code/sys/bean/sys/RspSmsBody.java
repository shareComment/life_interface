package com.life.interfaces.code.sys.bean.sys;

public class RspSmsBody
{
	private RspSmsInfo result;
	
	private String request_id = "";

	public RspSmsInfo getResult()
	{
		return result;
	}

	public void setResult(RspSmsInfo result)
	{
		this.result = result;
	}

	public String getRequest_id()
	{
		return request_id;
	}

	public void setRequest_id(String request_id)
	{
		this.request_id = request_id;
	}
	
}
