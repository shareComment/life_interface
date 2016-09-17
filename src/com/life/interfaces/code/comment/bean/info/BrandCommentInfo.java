/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.bean.info.BrandCommentInfo
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
 * @className:com.life.interfaces.code.comment.bean.info.BrandCommentInfo
 * @version:v1.0.0 
 * @date:2016年6月16日 上午10:30:02
 * @author:Chaos
 */
public class BrandCommentInfo
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
	
	//昵称
	private String nickname = "";
	
	//是否有2级，0没有 ，有几就是有几条
	private String isComment = "";
	
	//头像
	private String avatar = "";
	
	private String grade_Name = "";
	
	private String grade_Color = "";
	
	//品牌名称
	private String brand_name = "";
	
	private Integer score = 0;

	private Integer zan = 0;
	
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

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getIsComment()
	{
		return isComment;
	}

	public void setIsComment(String isComment)
	{
		this.isComment = isComment;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public String getGrade_Name()
	{
		return grade_Name;
	}

	public void setGrade_Name(String grade_Name)
	{
		this.grade_Name = grade_Name;
	}

	public String getGrade_Color()
	{
		return grade_Color;
	}

	public void setGrade_Color(String grade_Color)
	{
		this.grade_Color = grade_Color;
	}

	public String getBrand_name()
	{
		return brand_name;
	}

	public void setBrand_name(String brand_name)
	{
		this.brand_name = brand_name;
	}

	public Integer getScore()
	{
		return score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}

	/**
	 * @return the zan
	 */
	public Integer getZan() {
		return zan;
	}

	/**
	 * @param zan the zan to set
	 */
	public void setZan(Integer zan) {
		this.zan = zan;
	}
	
}
