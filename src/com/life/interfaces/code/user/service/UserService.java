/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.service.UserService
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
package com.life.interfaces.code.user.service;

import java.io.IOException;
import java.sql.SQLException;

import com.life.interfaces.code.user.bean.info.UserInfo;
import com.life.interfaces.code.user.bean.info.UserPwd;

/**
 * @className:com.life.interfaces.code.user.service.UserService
 * @version:v1.0.0 
 * @date:2016年6月12日 下午2:28:40
 * @author:Chaos
 */
public interface UserService
{
	/**
	 * 登录
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月12日 下午2:06:03
	 */
	public UserInfo login(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 注册用户
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午1:23:05
	 */
	public Integer register(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 修改个人信息
	 * @Description:
	 * @param req
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午3:44:13
	 */
	public void uptUser(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 修改密码
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午6:32:42
	 */
	public String uptPwd(UserPwd reqInfo) throws SQLException;
	
	
	/**
	 * 查询用户信息
	 * @Description:
	 * @param reqInfp
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @throws IOException 
	 * @date:2016年6月13日 下午6:37:58
	 */
	public UserInfo queryUserInfo(UserInfo reqInfo) throws SQLException, IOException;
}
