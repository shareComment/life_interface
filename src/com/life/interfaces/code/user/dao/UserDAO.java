/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.dao.UserDAO
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
package com.life.interfaces.code.user.dao;

import java.sql.SQLException;

import com.life.interfaces.code.user.bean.info.UserInfo;
import com.life.interfaces.code.user.bean.info.UserPwd;

/**
 * @className:com.life.interfaces.code.user.dao.UserDAO
 * @version:v1.0.0 
 * @date:2016年6月12日 上午10:16:01
 * @author:Chaos
 */
public interface UserDAO
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
	 * 查询账户是否存在
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月12日 下午3:51:10
	 */
	public Integer queryUserPhone(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询盐值
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月12日 下午3:53:56
	 */
	public String querySalt(UserInfo reqInfo) throws SQLException;
	
	
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
	public void register(UserInfo reqInfo) throws SQLException;
	
	
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
	 * 查询用户信息
	 * @Description:
	 * @param reqInfp
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午6:37:58
	 */
	public UserInfo queryUserInfo(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询密码
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午6:43:11
	 */
	public String queryUserPwd(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 修改密码
	 * @Description:
	 * @param reqInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午7:01:38
	 */
	public void updatePwd(UserPwd reqInfo) throws SQLException;
	
	
	/**
	 * 根据手机号 查询用户ID
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月19日 上午12:04:18
	 */
	public String queryUserByPhone(UserInfo reqInfo) throws SQLException;
	
	
	/**
	 * 校验验证码
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月19日 上午12:09:48
	 */
	public String queryCode(UserInfo reqInfo) throws SQLException;
	
	
	
}
