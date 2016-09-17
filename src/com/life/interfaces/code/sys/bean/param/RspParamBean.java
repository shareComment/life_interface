/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.param.RspParamBean
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

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.sys.bean.param.RspParamBean
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:41:30
 * @author:Chaos
 */
public class RspParamBean extends RspBean
{
	private ParamInfo rspInfo = null;

	public ParamInfo getRspInfo()
	{
		return rspInfo;
	}

	public void setRspInfo(ParamInfo rspInfo)
	{
		this.rspInfo = rspInfo;
	}
	
}
