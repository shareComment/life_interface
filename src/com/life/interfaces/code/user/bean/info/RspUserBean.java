/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.bean.info.RspUserBean
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月12日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.user.bean.info;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.user.bean.info.RspUserBean
 * @version:v1.0.0 
 * @date:2016年6月12日 下午2:43:18
 * @author:Chaos
 */
public class RspUserBean extends RspBean
{
	private UserInfo rspInfo = null;

	public UserInfo getRspInfo()
	{
		return rspInfo;
	}

	public void setRspInfo(UserInfo rspInfo)
	{
		this.rspInfo = rspInfo;
	}
	
}
