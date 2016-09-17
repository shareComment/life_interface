/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.info.RspContentBean
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
package com.life.interfaces.code.sys.bean.info;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.sys.bean.info.RspContentBean
 * @version:v1.0.0 
 * @date:2016年6月22日 下午3:43:42
 * @author:Chaos
 */
public class RspContentBean extends RspBean
{
	private ContentInfo rspInfo = null;

	public ContentInfo getRspInfo()
	{
		return rspInfo;
	}

	public void setRspInfo(ContentInfo rspInfo)
	{
		this.rspInfo = rspInfo;
	}
	
}
