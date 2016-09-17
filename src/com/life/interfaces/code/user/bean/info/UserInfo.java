/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.bean.info.UserInfo
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月12日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.user.bean.info;

/**
 * 用户信息
 * @className:com.life.interfaces.code.user.bean.info.UserInfo
 * @version:v1.0.0 
 * @date:2016年6月12日 上午10:06:27
 * @author:Chaos
 */
public class UserInfo 
{
	//用户 UUID
	private String user_id = "";
	
	//昵称
	private String nickname = "";
	
	//真实姓名
	private String username = "";
	
	//手机号（账号）
	private String telephone = "";
	
	//密码
	private String password = "";
	
	//盐值
	private String salt = "";
	
	//邮箱
	private String email = "";
	
	//性别(0女，1男)
	private String gender = "";
	
	//学历
	private String education = "";
	
	//年龄
	private String age = "";
	
	//毕业院校
	private String collage = "";
	
	//头像
	private String avatar = "";
	
	//积分
	private String bonus_point = "";
	
	//等级ID
	private String grade_id = "";
	
	//地址
	private String address = "";
	
	//身份证号码
	private String idcard = "";
	
	//身份证正面
	private String img_a = "";
	
	//身份证反面
	private String img_b = "";
	
	//状态 0有效，1无效
	private String status = "";
	
	//审核状态(0已审核，1未审核，2审核不通过)
	private String verified = "";
	
	//添加时间
	private String add_time = "";
	
	//最后登录时间
	private String last_time = "";
	
	private String grade_Name = "";
	
	private String grade_Color = "";
	
	private String comment_Num = "";
	
	private String reply_Num = "";
	
	//邀请码
	private String lnvite_code = "";
	
	//呗访问者
	private String user_pid = "";

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public String getBonus_point()
	{
		return bonus_point;
	}

	public void setBonus_point(String bonus_point)
	{
		this.bonus_point = bonus_point;
	}

	public String getGrade_id()
	{
		return grade_id;
	}

	public void setGrade_id(String grade_id)
	{
		this.grade_id = grade_id;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getIdcard()
	{
		return idcard;
	}

	public void setIdcard(String idcard)
	{
		this.idcard = idcard;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getAdd_time()
	{
		return add_time;
	}

	public void setAdd_time(String add_time)
	{
		this.add_time = add_time;
	}

	public String getLast_time()
	{
		return last_time;
	}

	public void setLast_time(String last_time)
	{
		this.last_time = last_time;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getCollage()
	{
		return collage;
	}

	public void setCollage(String collage)
	{
		this.collage = collage;
	}

	public String getImg_a()
	{
		return img_a;
	}

	public void setImg_a(String img_a)
	{
		this.img_a = img_a;
	}

	public String getImg_b()
	{
		return img_b;
	}

	public void setImg_b(String img_b)
	{
		this.img_b = img_b;
	}

	public String getVerified()
	{
		return verified;
	}

	public void setVerified(String verified)
	{
		this.verified = verified;
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

	public String getComment_Num()
	{
		return comment_Num;
	}

	public void setComment_Num(String comment_Num)
	{
		this.comment_Num = comment_Num;
	}

	public String getReply_Num()
	{
		return reply_Num;
	}

	public void setReply_Num(String reply_Num)
	{
		this.reply_Num = reply_Num;
	}

	public String getLnvite_code()
	{
		return lnvite_code;
	}

	public void setLnvite_code(String lnvite_code)
	{
		this.lnvite_code = lnvite_code;
	}

	public String getUser_pid()
	{
		return user_pid;
	}

	public void setUser_pid(String user_pid)
	{
		this.user_pid = user_pid;
	}
	
}
