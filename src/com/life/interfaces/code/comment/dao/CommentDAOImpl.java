/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.dao.CommentDAOImpl
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
package com.life.interfaces.code.comment.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.life.interfaces.code.comment.bean.info.BrandCommentInfo;
import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;

/**
 * @className:com.life.interfaces.code.comment.dao.CommentDAOImpl
 * @version:v1.0.0 
 * @date:2016年6月16日 上午8:59:34
 * @author:Chaos
 */
@Repository("commentDao")
public class CommentDAOImpl extends SqlMapClientDaoSupport  implements CommentDAO
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
	public void addBrandComment(ReqCommentInfo reqInfo) throws SQLException
	{
		sqlMapClient.insert("comment.addBrandComment", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandCommentInfo> queryBrandCommetList(ReqCommentInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("comment.queryBrandCommetList", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandCommentInfo> queryMyBraCommentList(ReqCommentInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("comment.queryMyBraCommentList", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryBrandCommetCou(ReqCommentInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("comment.queryBrandCommetCou", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryMyBraCommentCou(ReqCommentInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("comment.queryMyBraCommentCou", reqInfo);
	}

	
	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandCommentInfo> queryLastBraCommentList(ReqCommentInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("comment.queryLastBraCommentList", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public Integer queryCommentNumByToday(String userKey) throws SQLException
	{
		return (Integer) sqlMapClient.queryForObject("comment.queryCommentNumByToday", userKey);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public Integer queryCommentNumByTodays(String userKey) throws SQLException
	{
		return (Integer) sqlMapClient.queryForObject("comment.queryCommentNumByTodays", userKey);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryUserGrade(String userId) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("comment.queryUserGrade", userId);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandCommentInfo> queryMyCommentByBrand(ReqCommentInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("comment.queryMyCommentByBrand", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryMyCommentByBrandCou(ReqCommentInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("comment.queryMyCommentByBrandCou", reqInfo);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<BrandCommentInfo> queryReplyMyComment(ReqCommentInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("comment.queryReplyMyComment", reqInfo);
	}


	@Override
	public String queryReplyMyCommentCou(ReqCommentInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("comment.queryReplyMyCommentCou", reqInfo);
	}


	@Override
	public void uptBrandScore(String brand_id) throws SQLException
	{
		sqlMapClient.update("comment.uptBrandScore", brand_id);
	}


	@Override
	public BrandCommentInfo queryCommentInfo(String comment_id) throws SQLException
	{
		return (BrandCommentInfo) sqlMapClient.queryForObject("comment.queryCommentInfo", comment_id);
	}


	@Override
	public void increasecommentzan(BrandCommentInfo reqInfo) {
		sqlMapClient.update("comment.increasecommentzan", reqInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandCommentInfo> queryMyReplyComment(ReqCommentInfo reqInfo)
			throws SQLException {
		return sqlMapClient.queryForList("comment.queryMyReplyComment", reqInfo);
	}

	@Override
	public String queryMyReplyCommentCou(ReqCommentInfo reqInfo)
			throws SQLException {
		return (String) sqlMapClient.queryForObject("comment.queryMyReplyCommentCou", reqInfo);
	}
}
