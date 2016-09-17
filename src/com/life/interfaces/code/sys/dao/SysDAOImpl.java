/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.dao.SysDAOImpl
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
package com.life.interfaces.code.sys.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.life.interfaces.code.sys.bean.feed.FeedInfo;
import com.life.interfaces.code.sys.bean.info.ContentInfo;
import com.life.interfaces.code.sys.bean.param.Fen;
import com.life.interfaces.code.sys.bean.param.ParamInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSmsCodeInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSysInfo;
import com.life.interfaces.code.sys.bean.sys.SysInfo;

/**
 * @className:com.life.interfaces.code.sys.dao.SysDAOImpl
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:31:56
 * @author:Chaos
 */
@Repository("sysDao")
public class SysDAOImpl extends SqlMapClientDaoSupport implements SysDAO
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
	public ParamInfo querySysParamInfo(String key) throws SQLException
	{
		return (ParamInfo) sqlMapClient.queryForObject("sys.querySysParamInfo", key);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void addFeedInfo(FeedInfo reqInfo) throws SQLException
	{
		sqlMapClient.insert("sys.addFeedInfo", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public ContentInfo queryContentInfo(String class_id) throws SQLException
	{
		return (ContentInfo) sqlMapClient.queryForObject("sys.queryContentInfo", class_id);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysInfo> querySysInfoList(ReqSysInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("sys.querySysInfoList", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public SysInfo querySysInfo(ReqSysInfo reqInfo) throws SQLException
	{
		return (SysInfo) sqlMapClient.queryForObject("sys.querySysInfo", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void updateSysInfo(ReqSysInfo reqInfo) throws SQLException
	{
		sqlMapClient.insert("sys.updateSysInfo", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void updateFen(Fen reqInfo) throws SQLException
	{
		sqlMapClient.update("sys.updateFen", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<ParamInfo> queryParamList(String key) throws SQLException
	{
		return sqlMapClient.queryForList("sys.queryParamList", key);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void addSmsCode(ReqSmsCodeInfo reqInfo) throws SQLException
	{
		sqlMapClient.insert("sys.addSmsCode", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String querySysInfoListCou(ReqSysInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("sys.querySysInfoListCou", reqInfo);
	}
	
}
