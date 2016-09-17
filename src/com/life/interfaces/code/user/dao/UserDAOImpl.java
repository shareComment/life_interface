/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.dao.UserDAOImpl
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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.life.interfaces.code.user.bean.info.UserInfo;
import com.life.interfaces.code.user.bean.info.UserPwd;

/**
 * @className:com.life.interfaces.code.user.dao.UserDAOImpl
 * @version:v1.0.0 
 * @date:2016年6月12日 上午10:16:16
 * @author:Chaos
 */
@Repository("userDao")
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO
{
	@Resource(name = "sqlMapClient")
	private SqlMapClientTemplate sqlMapClient;

	@PostConstruct
	public void initSqlMapClient()
	{
		super.setSqlMapClientTemplate(sqlMapClient);
	}
	
	
	/**
     * {@inheritDoc}
     */
	@Override
	public UserInfo login(UserInfo reqInfo) throws SQLException
	{
		return (UserInfo) sqlMapClient.queryForObject("user.login", reqInfo);
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public Integer queryUserPhone(UserInfo reqInfo) throws SQLException
	{
		return (Integer) sqlMapClient.queryForObject("user.queryUserPhone", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String querySalt(UserInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("user.querySalt", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void register(UserInfo reqInfo) throws SQLException
	{
		sqlMapClient.insert("user.register", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void uptUser(UserInfo reqInfo) throws SQLException
	{
		sqlMapClient.update("user.uptUser", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public UserInfo queryUserInfo(UserInfo reqInfo) throws SQLException
	{
		return (UserInfo) sqlMapClient.queryForObject("user.queryUserInfo", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryUserPwd(UserInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("user.queryUserPwd", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void updatePwd(UserPwd reqInfo) throws SQLException
	{
		sqlMapClient.update("user.uptPwd", reqInfo);
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public String queryUserByPhone(UserInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("user.queryUserByPhone", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryCode(UserInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("user.queryCode", reqInfo);
	}

}
