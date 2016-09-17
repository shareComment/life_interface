/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.bean.feed.FeedInfo
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
package com.life.interfaces.code.sys.bean.feed;

/**
 * @className:com.life.interfaces.code.sys.bean.feed.FeedInfo
 * @version:v1.0.0 
 * @date:2016年6月22日 下午2:53:02
 * @author:Chaos
 */
public class FeedInfo
{
	private String user_id = "";
	
	private String feed_con = "";

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getFeed_con()
	{
		return feed_con;
	}

	public void setFeed_con(String feed_con)
	{
		this.feed_con = feed_con;
	}
	
}
