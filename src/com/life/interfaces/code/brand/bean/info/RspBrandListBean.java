/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.RspBrandListBean
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月15日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.brand.bean.info;

import java.util.List;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.brand.bean.info.RspBrandListBean
 * @version:v1.0.0 
 * @date:2016年6月15日 下午2:28:50
 * @author:Chaos
 */
public class RspBrandListBean extends RspBean
{
	List<BrandInfo> infoList = null;
	
	String count = "";

	public List<BrandInfo> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<BrandInfo> infoList)
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
