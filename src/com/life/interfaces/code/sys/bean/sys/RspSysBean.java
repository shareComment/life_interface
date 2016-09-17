/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.sys.RspSysBean
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年7月11日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.sys.bean.sys;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.sys.bean.sys.RspSysBean
 * @version:v1.0.0 
 * @date:2016年7月11日 下午10:54:00
 * @author:Chaos
 */
public class RspSysBean extends RspBean
{
	private SysInfo rspInfo = null;

	public SysInfo getRspInfo()
	{
		return rspInfo;
	}

	public void setRspInfo(SysInfo rspInfo)
	{
		this.rspInfo = rspInfo;
	}
	
}
