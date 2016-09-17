/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.RspTagBean
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
 * @className:com.life.interfaces.code.brand.bean.info.RspTagBean
 * @version:v1.0.0 
 * @date:2016年6月14日 下午9:53:21
 * @author:Chaos
 */
public class RspTagBean extends RspBean
{
	List<TagInfo> infoList = null;

	public List<TagInfo> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<TagInfo> infoList)
	{
		this.infoList = infoList;
	}
	
}
