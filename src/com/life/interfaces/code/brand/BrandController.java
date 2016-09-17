/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.brand.BrandController
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
package com.life.interfaces.code.brand;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.life.interfaces.code.brand.bean.info.BrandInfo;
import com.life.interfaces.code.brand.bean.info.Category;
import com.life.interfaces.code.brand.bean.info.ReqBrandInfo;
import com.life.interfaces.code.brand.bean.info.RspBrandBean;
import com.life.interfaces.code.brand.bean.info.RspBrandListBean;
import com.life.interfaces.code.brand.bean.info.RspCategoryBean;
import com.life.interfaces.code.brand.bean.info.RspTagBean;
import com.life.interfaces.code.brand.bean.info.TagInfo;
import com.life.interfaces.code.brand.service.BrandService;
import com.life.interfaces.util.RequestUtil;
import com.life.interfaces.util.StringTools;

/**
 * 品牌
 * @className:com.life.interfaces.code.brand.BrandController
 * @version:v1.0.0 
 * @date:2016年6月14日 下午6:46:30
 * @author:Chaos
 */
@Controller
@RequestMapping(value = "/brandcontro")
public class BrandController
{
	/**
	 * 引入Gson
	 */
	private Gson gson = new Gson();
			
	/**
	 * 错误日志
	 */
	private static final Logger logger = Logger.getLogger(BrandController.class);
	
	/**
	 * 引入service
	 */
	@Resource(name = "brandService")
	private BrandService brandService;
	
	
	/**
	 * 查询一级类别
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午8:06:35
	 */
	@RequestMapping(value = "/querytopcategory",method = RequestMethod.GET)
	public void queryTopCategory(HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspCategoryBean rspBean = new RspCategoryBean();
		List<Category> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			infoList = brandService.queryTopCategory();
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setInfoList(infoList);
			}
			else
			{
				rspBean.setResult("200001");
				rspBean.setResult("类别信息不存在");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("用户名或密码不正确");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("用户名或密码不正确");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查询二级分类
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午9:05:32
	 */
	@RequestMapping(value = "/querysecondctegory/{cate_id}",method = RequestMethod.GET)
	public void querySecondCtegory(@PathVariable("cate_id") String cate_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqBrandInfo reqInfo = new ReqBrandInfo();
		reqInfo.setCate_id(cate_id);
		
		//设置返回Bean
		RspCategoryBean rspBean = new RspCategoryBean();
		List<Category> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			infoList = brandService.querySecondCtegory(reqInfo);
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setInfoList(infoList);
			}
			else
			{
				rspBean.setResult("200001");
				rspBean.setResult("类别信息不存在");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("用户名或密码不正确");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("用户名或密码不正确");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查询标签列表
	 * @Description:
	 * @param cate_id
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午9:52:40
	 */
	@RequestMapping(value = "/querytaglist/{cate_id}",method = RequestMethod.GET)
	public void queryTagList(@PathVariable("cate_id") String cate_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqBrandInfo reqInfo = new ReqBrandInfo();
		reqInfo.setCate_id(cate_id);
		
		//设置返回Bean
		RspTagBean rspBean = new RspTagBean();
		List<TagInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			infoList = brandService.queryTageList(reqInfo);
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setInfoList(infoList);
			}
			else
			{
				rspBean.setResult("200001");
				rspBean.setResult("类别信息不存在");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("类别信息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("类别信息不存在");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查询品牌详情
	 * @Description:
	 * @param cate_id
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 下午11:09:37
	 */
	@RequestMapping(value = "/querybrandinfo/{brand_id}",method = RequestMethod.GET)
	public void queryBrandInfo(@PathVariable("brand_id") String brand_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqBrandInfo reqInfo = new ReqBrandInfo();
		reqInfo.setBrand_id(brand_id);
		
		//设置返回Bean
		RspBrandBean rspBean = new RspBrandBean();
		BrandInfo rspInfo = new BrandInfo();
		
		//返回值
		String result = "";
		try
		{
			rspInfo = brandService.queryBrandInfo(reqInfo);
			if(!StringTools.isNullOrEmpty(rspInfo))
			{
				rspBean.setResult("0");
				rspBean.setRspInfo(rspInfo);
			}
			else
			{
				rspBean.setResult("200002");
				rspBean.setResult("品牌信息不存在");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 搜索品牌
	 * @Description:
	 * @param brand_id
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午2:25:35
	 */
	@RequestMapping(value = "/searchbrandinfo/{page}",method = RequestMethod.POST)
	public void searchBrandInfo(@PathVariable("page") Integer page,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqBrandInfo reqInfo = new ReqBrandInfo();
		
		//设置返回Bean
		RspBrandListBean rspBean = new RspBrandListBean();
		List<BrandInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqInfo = gson.fromJson(jsonBean, ReqBrandInfo.class);
			reqInfo.setPage(page);
			
			if(!StringTools.isNullOrEmpty(reqInfo)
				&&!StringTools.isNullOrEmpty(reqInfo.getBrand_name()))
			{
				infoList = brandService.searchBrand(reqInfo);
				rspBean.setCount(brandService.searchBrandCou(reqInfo));
			}
			
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setInfoList(infoList);
			}
			else
			{
				rspBean.setResult("200002");
				rspBean.setResult("品牌信息不存在");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查询品牌列表
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午3:47:29
	 */
	@RequestMapping(value = "/querybrandlist/{cate_id}/{page}",method = RequestMethod.GET)
	public void queryBrandList(@PathVariable("cate_id") String cate_id,@PathVariable("page") Integer page,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqBrandInfo reqInfo = new ReqBrandInfo();
		reqInfo.setCate_id(cate_id);
		reqInfo.setPage(page);
		
		//设置返回Bean
		RspBrandListBean rspBean = new RspBrandListBean();
		List<BrandInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{ 
			infoList = brandService.queryBrandList(reqInfo);
			String count = brandService.queryBrandListCou(reqInfo);
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setCount(count);
				rspBean.setInfoList(infoList);
			}
			else
			{
				rspBean.setResult("200002");
				rspBean.setResult("品牌信息不存在");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 查询首页品牌列表
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月15日 下午3:47:29
	 */
	@RequestMapping(value = "/queryHomebrandlist/{desc}/{page}",method = RequestMethod.GET)
	public void queryBrandList(@PathVariable("desc") String desc,@PathVariable("page") String page,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqBrandInfo reqInfo = new ReqBrandInfo();
		
		//设置返回Bean
		RspBrandListBean rspBean = new RspBrandListBean();
		List<BrandInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{ 
			reqInfo.setDesc(desc);
			reqInfo.setPage(Integer.valueOf(page)); 
			infoList = brandService.queryHomeBrandList(reqInfo);
			String count = brandService.queryHomeBrandListCou(reqInfo);
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setCount(count);
				rspBean.setInfoList(infoList);
			}
			else
			{
				/*rspBean.setResult("200002");
				rspBean.setResult("品牌信息不存在");*/
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	@RequestMapping(value = "/querytaginfobybrandid/{brand_id}",method = RequestMethod.GET)
	public void queryTagInfoByBrandId(@PathVariable("brand_id") String brand_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		
		//设置返回Bean
		RspTagBean rspBean = new RspTagBean();
		List<TagInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{ 
			infoList = brandService.queryTagInfoByBrandId(brand_id);
			if(infoList != null && infoList.size() > 0)
			{
				rspBean.setResult("0");
				rspBean.setInfoList(infoList);
			}
			else
			{
				/*rspBean.setResult("200002");
				rspBean.setResult("品牌信息不存在");*/
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("品牌信息不存在");
		}
		finally 
		{
            try
			{
            	result = gson.toJson(rspBean);
            	response.setContentType("application/json;charset=UTF-8");
				response.getOutputStream().write(result.getBytes("UTF-8"));
			} 
            catch (UnsupportedEncodingException e)
			{
				e.printStackTrace();
			} 
            catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
