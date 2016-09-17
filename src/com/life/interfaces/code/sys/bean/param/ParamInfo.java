/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.param.ParamInfo
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
package com.life.interfaces.code.sys.bean.param;

/**
 * @className:com.life.interfaces.code.sys.bean.param.ParamInfo
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:34:59
 * @author:Chaos
 */
public class ParamInfo
{
	private String param_key = "";
	
	private String param_value = "";

	public String getParam_key()
	{
		return param_key;
	}

	public void setParam_key(String param_key)
	{
		this.param_key = param_key;
	}

	public String getParam_value()
	{
		return param_value;
	}

	public void setParam_value(String param_value)
	{
		this.param_value = param_value;
	}
	
}
