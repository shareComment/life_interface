/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.bean.info.ReqUserBean
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

/**
 * @className:com.life.interfaces.code.user.bean.info.ReqUserBean
 * @version:v1.0.0 
 * @date:2016年6月12日 下午2:39:36
 * @author:Chaos
 */
public class ReqUserBean
{
	private UserInfo reqInfo = null;

	public UserInfo getReqInfo()
	{
		return reqInfo;
	}

	public void setReqInfo(UserInfo reqInfo)
	{
		this.reqInfo = reqInfo;
	}
	
}
