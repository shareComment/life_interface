/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.dao.BrandDAOImpl
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年6月14日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.code.brand.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.life.interfaces.code.brand.bean.info.BrandInfo;
import com.life.interfaces.code.brand.bean.info.Category;
import com.life.interfaces.code.brand.bean.info.ReqBrandInfo;
import com.life.interfaces.code.brand.bean.info.TagInfo;

/**
 * @className:com.life.interfaces.code.brand.dao.BrandDAOImpl
 * @version:v1.0.0 
 * @date:2016年6月14日 下午6:47:06
 * @author:Chaos
 */
@Repository("brandDao")
public class BrandDAOImpl extends SqlMapClientDaoSupport implements BrandDAO
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryTopCategory() throws SQLException
	{
		return sqlMapClient.queryForList("brand.queryTopCategory");
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> querySecondCtegory(ReqBrandInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("brand.querySecondCtegory", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<TagInfo> queryTageList(ReqBrandInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("brand.queryTageList", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public BrandInfo queryBrandInfo(ReqBrandInfo reqInfo) throws SQLException
	{
		return (BrandInfo) sqlMapClient.queryForObject("brand.queryBrandInfo", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandInfo> searchBrand(ReqBrandInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("brand.searchBrand", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandInfo> queryBrandList(ReqBrandInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("brand.queryBrandList",reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandInfo> queryHomeBrandList(ReqBrandInfo reqInfo) throws SQLException
	{
		return sqlMapClient.queryForList("brand.queryHomeBrandList", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String searchBrandCou(ReqBrandInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("brand.searchBrandCou", reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryHomeBrandListCou(ReqBrandInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("brand.queryHomeBrandListCou", reqInfo);
	}


	@Override
	public String queryBrandListCou(ReqBrandInfo reqInfo) throws SQLException
	{
		return (String) sqlMapClient.queryForObject("brand.queryBrandListCou", reqInfo);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<TagInfo> queryTagInfoByBrandId(String brand_id) throws SQLException
	{
		return sqlMapClient.queryForList("brand.queryTagInfoByBrandId", brand_id);
	}
}
