/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.bean.info.RspBrandComBean
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月16日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.comment.bean.info;

import java.util.List;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.comment.bean.info.RspBrandComBean
 * @version:v1.0.0 
 * @date:2016年6月16日 上午10:45:59
 * @author:Chaos
 */
public class RspBrandComBean extends RspBean
{
	private List<BrandCommentInfo> infoList = null;
	
	private String count = "0";
	
	public List<BrandCommentInfo> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<BrandCommentInfo> infoList)
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
