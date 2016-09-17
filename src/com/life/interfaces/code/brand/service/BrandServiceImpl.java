/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.service.BrandServiceImpl
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
package com.life.interfaces.code.brand.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.life.interfaces.code.brand.bean.info.BrandInfo;
import com.life.interfaces.code.brand.bean.info.Category;
import com.life.interfaces.code.brand.bean.info.ReqBrandInfo;
import com.life.interfaces.code.brand.bean.info.TagInfo;
import com.life.interfaces.code.brand.dao.BrandDAO;
import com.life.interfaces.code.sys.bean.param.ParamInfo;
import com.life.interfaces.code.sys.dao.SysDAO;
import com.life.interfaces.util.Constants;
import com.life.interfaces.util.StringTools;

/**
 * @className:com.life.interfaces.code.brand.service.BrandServiceImpl
 * @version:v1.0.0 
 * @date:2016年6月14日 下午6:47:26
 * @author:Chaos
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService
{
	/**
	 * 引入Dao
	 */
	@Resource(name = "brandDao")
	private BrandDAO brandDao;
	
	/**
	 * 引入Dao
	 */
	@Resource(name = "sysDao")
	private SysDAO sysDao;

	
	/**
     * {@inheritDoc}
     */
	@Override
	public List<Category> queryTopCategory() throws SQLException
	{
		return brandDao.queryTopCategory();
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public List<Category> querySecondCtegory(ReqBrandInfo reqInfo) throws SQLException
	{
		return brandDao.querySecondCtegory(reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public List<TagInfo> queryTageList(ReqBrandInfo reqInfo) throws SQLException
	{
		return brandDao.queryTageList(reqInfo);
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public BrandInfo queryBrandInfo(ReqBrandInfo reqInfo) throws SQLException, IOException
	{
		BrandInfo rspInfo = brandDao.queryBrandInfo(reqInfo);
		rspInfo.setPc_img(StringTools.getImgUrl("1") +rspInfo.getPc_img());
		rspInfo.setWap_img(StringTools.getImgUrl("1")+rspInfo.getWap_img());
		return rspInfo;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandInfo> searchBrand(ReqBrandInfo reqInfo) throws SQLException, IOException
	{
		ParamInfo param = null;
		param = sysDao.querySysParamInfo("pageNum");
		if(!StringTools.isNullOrEmpty(param) && !StringTools.isNullOrEmpty(param.getParam_value()))
		{
			Integer pageNum = Integer.parseInt(param.getParam_value());
			reqInfo.setPageNum(pageNum);
			reqInfo.setPage((reqInfo.getPage()-1)*pageNum);
		}
		else
		{
			reqInfo.setPage((reqInfo.getPage()-1)* Constants.brangdPage);
			reqInfo.setPageNum(Constants.brangdPage);
		}
		List<BrandInfo> infoList = brandDao.searchBrand(reqInfo);
		
		for (int i = 0; i < infoList.size(); i++)
		{
			infoList.get(i).setPc_img(StringTools.getImgUrl("1") +infoList.get(i).getPc_img());
			infoList.get(i).setWap_img(StringTools.getImgUrl("1") +infoList.get(i).getWap_img());
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandInfo> queryBrandList(ReqBrandInfo reqInfo) throws SQLException, IOException
	{
		ParamInfo param = null;
		param = sysDao.querySysParamInfo("pageNum");
		if(!StringTools.isNullOrEmpty(param) && !StringTools.isNullOrEmpty(param.getParam_value()))
		{
			Integer pageNum = Integer.parseInt(param.getParam_value());
			reqInfo.setPageNum(pageNum);
			reqInfo.setPage((reqInfo.getPage()-1)*pageNum);
		}
		else
		{
			reqInfo.setPage((reqInfo.getPage()-1)*Constants.brangdPage);
			reqInfo.setPageNum(Constants.brangdPage);
		}
		
		List<BrandInfo> infoList = brandDao.queryBrandList(reqInfo);
		
		for (int i = 0; i < infoList.size(); i++)
		{
			infoList.get(i).setPc_img(StringTools.getImgUrl("1") +infoList.get(i).getPc_img());
			infoList.get(i).setWap_img(StringTools.getImgUrl("1") +infoList.get(i).getWap_img());
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandInfo> queryHomeBrandList(ReqBrandInfo reqInfo) throws SQLException, IOException
	{
		//查询首页条数
		String pageNum = sysDao.querySysParamInfo("INDEX_BRAND_NO").getParam_value();
		
		if(!reqInfo.equals("0"))
		{
			reqInfo.setPage(0);
			reqInfo.setPageNum(Integer.valueOf(pageNum));
		}
		
		List<BrandInfo> infoList = brandDao.queryHomeBrandList(reqInfo);
		
		for (int i = 0; i < infoList.size(); i++)
		{
			infoList.get(i).setPc_img(StringTools.getImgUrl("1") +infoList.get(i).getPc_img());
			infoList.get(i).setWap_img(StringTools.getImgUrl("1") +infoList.get(i).getWap_img());
		}
		
		return infoList;
	}


	@Override
	public String searchBrandCou(ReqBrandInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(brandDao.searchBrandCou(reqInfo)) / Constants.brangdPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	@Override
	public String queryHomeBrandListCou(ReqBrandInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(brandDao.queryHomeBrandListCou(reqInfo)) / Constants.brangdPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	@Override
	public String queryBrandListCou(ReqBrandInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(brandDao.queryBrandListCou(reqInfo)) / Constants.brangdPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	@Override
	public List<TagInfo> queryTagInfoByBrandId(String brand_id) throws SQLException
	{
		return brandDao.queryTagInfoByBrandId(brand_id);
	}
	
}
