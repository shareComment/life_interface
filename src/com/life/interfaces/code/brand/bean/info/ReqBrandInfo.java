/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.bean.info.ReqBrandInfo
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
package com.life.interfaces.code.brand.bean.info;

/**
 * 品牌请求基类
 * @className:com.life.interfaces.code.brand.bean.info.ReqBrandInfo
 * @version:v1.0.0 
 * @date:2016年6月14日 下午9:45:35
 * @author:Chaos
 */
public class ReqBrandInfo
{
	//品牌ID
	private String brand_id = "";
	
	//品牌名称
	private String brand_name = "";
	
	//类目id
	private String cate_id = "";
	
	//PC图片
	private String pc_img = "";
	
	//wap图片
	private String wap_img = "";
	
	//所属企业
	private String co_name = "";
	
	//经营范围
	private String biz_scope = "";
	
	//评分
	private String score = "";
	
	//品牌描述
	private String brand_info = "";
	
	//类别父ID
	private String cate_pid = "";
	
	//类别名
	private String cate_name = "";
	
	//标签ID
	private String tag_id = "";
	
	//标签名
	private String tag_name = "";
	
	//分页数量
	private Integer pageNum = 0;
	
	//起始页面
	private Integer page = 0;
	
	private String desc = "";

	public String getBrand_id()
	{
		return brand_id;
	}

	public void setBrand_id(String brand_id)
	{
		this.brand_id = brand_id;
	}

	public String getBrand_name()
	{
		return brand_name;
	}

	public void setBrand_name(String brand_name)
	{
		this.brand_name = brand_name;
	}

	public String getCate_id()
	{
		return cate_id;
	}

	public void setCate_id(String cate_id)
	{
		this.cate_id = cate_id;
	}

	public String getPc_img()
	{
		return pc_img;
	}

	public void setPc_img(String pc_img)
	{
		this.pc_img = pc_img;
	}

	public String getWap_img()
	{
		return wap_img;
	}

	public void setWap_img(String wap_img)
	{
		this.wap_img = wap_img;
	}

	public String getCo_name()
	{
		return co_name;
	}

	public void setCo_name(String co_name)
	{
		this.co_name = co_name;
	}

	public String getBiz_scope()
	{
		return biz_scope;
	}

	public void setBiz_scope(String biz_scope)
	{
		this.biz_scope = biz_scope;
	}

	public String getScore()
	{
		return score;
	}

	public void setScore(String score)
	{
		this.score = score;
	}

	public String getBrand_info()
	{
		return brand_info;
	}

	public void setBrand_info(String brand_info)
	{
		this.brand_info = brand_info;
	}

	public String getCate_pid()
	{
		return cate_pid;
	}

	public void setCate_pid(String cate_pid)
	{
		this.cate_pid = cate_pid;
	}

	public String getCate_name()
	{
		return cate_name;
	}

	public void setCate_name(String cate_name)
	{
		this.cate_name = cate_name;
	}

	public String getTag_id()
	{
		return tag_id;
	}

	public void setTag_id(String tag_id)
	{
		this.tag_id = tag_id;
	}

	public String getTag_name()
	{
		return tag_name;
	}

	public void setTag_name(String tag_name)
	{
		this.tag_name = tag_name;
	}

	public Integer getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	
}
