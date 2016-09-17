/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.param.RspParamBean
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
package com.life.interfaces.code.sys.bean.param;

import java.util.List;

import com.life.interfaces.util.RspBean;

/**
 * @className:com.life.interfaces.code.sys.bean.param.RspParamBean
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:41:30
 * @author:Chaos
 */
public class RspParamListBean extends RspBean
{
	private List<ParamInfo> infoList = null;

	public List<ParamInfo> getInfoList()
	{
		return infoList;
	}

	public void setInfoList(List<ParamInfo> infoList)
	{
		this.infoList = infoList;
	}
	
}
