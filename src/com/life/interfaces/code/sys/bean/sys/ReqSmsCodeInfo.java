/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.sys.ReqSmsCodeInfo
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年7月18日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.sys.bean.sys;

/**
 * @className:com.life.interfaces.code.sys.bean.sys.ReqSmsCodeInfo
 * @version:v1.0.0 
 * @date:2016年7月18日 下午5:31:06
 * @author:Chaos
 */
public class ReqSmsCodeInfo
{
	private String phone = "";//手机号
	
	private String type = "";//注册、忘记密码  0注册，1忘记密码
	
	private String code = "";//注册、忘记密码  0注册，1忘记密码
	
	private String sign = "";
	
	private String yzm = "";

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getSign()
	{
		return sign;
	}

	public void setSign(String sign)
	{
		this.sign = sign;
	}

	public String getYzm()
	{
		return yzm;
	}

	public void setYzm(String yzm)
	{
		this.yzm = yzm;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
}
