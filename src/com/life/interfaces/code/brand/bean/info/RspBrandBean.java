/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.RspBrandBean
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月14日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.brand.bean.info;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.brand.bean.info.RspBrandBean
 * @version:v1.0.0 
 * @date:2016年6月14日 下午11:12:07
 * @author:Chaos
 */
public class RspBrandBean extends RspBean
{
	private BrandInfo rspInfo = null;

	public BrandInfo getRspInfo()
	{
		return rspInfo;
	}

	public void setRspInfo(BrandInfo rspInfo)
	{
		this.rspInfo = rspInfo;
	}
	
}
