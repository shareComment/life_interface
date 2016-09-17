/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.RspCategoryBean
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

import java.util.List;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.brand.bean.info.RspCategoryBean
 * @version:v1.0.0 
 * @date:2016年6月14日 下午8:01:31
 * @author:Chaos
 */
public class RspCategoryBean extends RspBean
{
	List<Category> infoList = null;

	public List<Category> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<Category> infoList)
	{
		this.infoList = infoList;
	}
	
}
