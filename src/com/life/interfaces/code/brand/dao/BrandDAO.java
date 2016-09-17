/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.dao.BrandDAO
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

import com.life.interfaces.code.brand.bean.info.BrandInfo;
import com.life.interfaces.code.brand.bean.info.Category;
import com.life.interfaces.code.brand.bean.info.ReqBrandInfo;
import com.life.interfaces.code.brand.bean.info.TagInfo;

/**
 * @className:com.life.interfaces.code.brand.dao.BrandDAO
 * @version:v1.0.0 
 * @date:2016年6月14日 下午6:46:51
 * @author:Chaos
 */
public interface BrandDAO
{
	/**
	 * 查询一级分类
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午8:03:36
	 */
	public List<Category> queryTopCategory() throws SQLException;
	
	
	/**
	 * 查询二级分类
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午8:55:03
	 */
	public List<Category> querySecondCtegory(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询标签列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午9:33:05
	 */
	public List<TagInfo> queryTageList(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询品牌详情
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午10:33:19
	 */
	public BrandInfo queryBrandInfo(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 搜索品牌列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午2:31:42
	 */
	public List<BrandInfo> searchBrand(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 搜索品牌列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午2:31:42
	 */
	public String searchBrandCou(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 按类别查询品牌列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午3:46:04
	 */
	public List<BrandInfo> queryBrandList(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 按类别查询品牌列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午3:46:04
	 */
	public String queryBrandListCou(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询首页品牌列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月12日 下午7:31:07
	 */
	public List<BrandInfo> queryHomeBrandList(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询首页品牌列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月12日 下午7:31:07
	 */
	public String queryHomeBrandListCou(ReqBrandInfo reqInfo) throws SQLException;
	
	
	/**
	 * 根据品牌ID 查询标签列表
	 * @Description:
	 * @param brand_id
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 */
	public List<TagInfo> queryTagInfoByBrandId(String brand_id) throws SQLException;
}
