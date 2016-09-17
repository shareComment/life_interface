/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.bean.info.RspBrandComm
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 *
 *
 */
package com.life.interfaces.code.comment.bean.info;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.comment.bean.info.RspBrandComm
 * @version:v1.0.0 
 * @author:Chaos
 */
public class RspBrandComm extends RspBean
{
	private BrandCommentInfo info = null;

	public BrandCommentInfo getInfo()
	{
		return info;
	}

	public void setInfo(BrandCommentInfo info)
	{
		this.info = info;
	}
	
}
