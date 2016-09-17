/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.bean.info.ReqCommentInfo
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

/**
 * 评论请求基类
 * @className:com.life.interfaces.code.comment.bean.info.ReqCommentInfo
 * @version:v1.0.0 
 * @date:2016年6月16日 上午8:48:40
 * @author:Chaos
 */
public class ReqCommentInfo
{
	//评论ID
	private String comment_id = "";
	
	//品牌ID
	private String brand_id = "";
	
	//用户ID
	private String user_id = "";
	
	//评论父ID
	private String comment_pid = "";
	
	//评论内容
	private String comment = "";
	
	//评论图片
	private String comment_img = "";
	
	//评论时间
	private String add_time = "";
	
	//分页数量
	private Integer pageNum = 0;
	
	//起始页面
	private Integer page = 0;
	
	private Integer score = 0;


	public String getComment_id()
	{
		return comment_id;
	}

	public void setComment_id(String comment_id)
	{
		this.comment_id = comment_id;
	}

	public String getBrand_id()
	{
		return brand_id;
	}

	public void setBrand_id(String brand_id)
	{
		this.brand_id = brand_id;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getComment_pid()
	{
		return comment_pid;
	}

	public void setComment_pid(String comment_pid)
	{
		this.comment_pid = comment_pid;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getComment_img()
	{
		return comment_img;
	}

	public void setComment_img(String comment_img)
	{
		this.comment_img = comment_img;
	}

	public String getAdd_time()
	{
		return add_time;
	}

	public void setAdd_time(String add_time)
	{
		this.add_time = add_time;
	}

	public Integer getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public Integer getScore()
	{
		return score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}
	
	
}
