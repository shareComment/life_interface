/**  
* @Title: UserPwd.java    
* @Package com.life.interfaces.code.user.bean.info    
* @Description: TODO(用一句话描述该文件做什么)    
* @author LiuQiang
* @date 2016年6月13日 下午6:22:02    
* @version V1.0  
*/
package com.life.interfaces.code.user.bean.info;

/**
 * 
 * @className:com.life.interfaces.code.user.bean.info.UserPwd
 * @version:v1.0.0 
 * @date:2016年6月13日 下午6:27:40
 * @author:Chaos
 */
public class UserPwd
{
	private String oldPwd = "";
	
	private String newPwd = "";

	private String user_id = "";
	
	private String code = "";
	
	public String getOldPwd()
	{
		return oldPwd;
	}

	public void setOldPwd(String oldPwd)
	{
		this.oldPwd = oldPwd;
	}

	public String getNewPwd()
	{
		return newPwd;
	}

	public void setNewPwd(String newPwd)
	{
		this.newPwd = newPwd;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
	
}
