/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.param.Fen
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年7月11日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.sys.bean.param;

/**
 * @className:com.life.interfaces.code.sys.bean.param.Fen
 * @version:v1.0.0 
 * @date:2016年7月11日 下午11:16:27
 * @author:Chaos
 */
public class Fen
{
	private String user_id = "";
	
	private String fen = "";

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getFen()
	{
		return fen;
	}

	public void setFen(String fen)
	{
		this.fen = fen;
	}
	
}
