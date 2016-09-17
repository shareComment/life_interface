/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.sys.RspSysInfoBean
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

import java.util.List;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.sys.bean.sys.RspSysInfoBean
 * @version:v1.0.0 
 * @date:2016年7月11日 下午10:27:20
 * @author:Chaos
 */
public class RspSysInfoBean extends RspBean
{
	List<SysInfo> infoList = null;
	
	String count = "";

	public List<SysInfo> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<SysInfo> infoList)
	{
		this.infoList = infoList;
	}

	public String getCount()
	{
		return count;
	}

	public void setCount(String count)
	{
		this.count = count;
	}
	
}
