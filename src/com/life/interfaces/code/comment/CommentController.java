/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.CommentController
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
package com.life.interfaces.code.comment;

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
import com.life.interfaces.code.comment.bean.info.BrandCommentInfo;
import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;
import com.life.interfaces.code.comment.bean.info.RspBrandComBean;
import com.life.interfaces.code.comment.bean.info.RspBrandComm;
import com.life.interfaces.code.comment.service.CommentService;
import com.life.interfaces.util.RequestUtil;
import com.life.interfaces.util.RspBean;
import com.life.interfaces.util.StringTools;

/**
 * @className:com.life.interfaces.code.comment.CommentController
 * @version:v1.0.0 
 * @date:2016年6月16日 上午9:06:44
 * @author:Chaos
 */
@Controller
@RequestMapping(value = "/commentContro")
public class CommentController
{
	/**
	 * 引入Gson
	 */
	private Gson gson = new Gson();
			
	/**
	 * 错误日志
	 */
	private static final Logger logger = Logger.getLogger(CommentController.class);
	
	/**
	 * 引入service
	 */
	@Resource(name = "commentService")
	private CommentService commentService;
	
	
	/**
	 * 添加评论&回复评论
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 上午9:44:55
	 */
	@RequestMapping(value = "/addbrandcomment",method = RequestMethod.POST)
	public void addBrandComment(HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		//设置返回Bean
		RspBean rspBean = new RspBean();
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqInfo = gson.fromJson(jsonBean, ReqCommentInfo.class);
			
			if(!StringTools.isNullOrEmpty(reqInfo)
				&&!StringTools.isNullOrEmpty(reqInfo.getBrand_id())
				&&!StringTools.isNullOrEmpty(reqInfo.getComment())
				&&!StringTools.isNullOrEmpty(reqInfo.getUser_id()))
			{
				commentService.addBrandComment(reqInfo);
				rspBean.setResult("0");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("评论失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("评论失败");
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
	 * 查询评论列表
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 下午12:42:34
	 */
	@RequestMapping(value = "/querybrandcommetlist/{brand_id}/{comment_id}/{page}",method = RequestMethod.GET)
	public void queryBrandCommetList(@PathVariable("brand_id") String brand_id,
			@PathVariable("comment_id") String comment_id,@PathVariable("page") Integer page,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		
		//设置返回Bean
		RspBrandComBean rspBean = new RspBrandComBean();
		List<BrandCommentInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setBrand_id(brand_id);
			reqInfo.setComment_id(comment_id);
			reqInfo.setPage(page);
			
			if("0".equals(comment_id))
			{
				reqInfo.setComment_id("");
			}
			
			infoList = commentService.queryBrandCommetList(reqInfo);
			rspBean.setCount(commentService.queryBrandCommetCou(reqInfo));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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
	 * 查询我的评论列表
	 * @Description:
	 * @param brand_id
	 * @param comment_id
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 下午2:41:34
	 */
	@RequestMapping(value = "/querymybracommentlist/{user_id}/{page}",method = RequestMethod.GET)
	public void queryMyBraCommentList(@PathVariable("user_id") String user_id,@PathVariable("page") Integer page,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		//设置返回Bean
		RspBrandComBean rspBean = new RspBrandComBean();
		List<BrandCommentInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setUser_id(user_id);
			reqInfo.setPage(page);
			
			infoList = commentService.queryMyBraCommentList(reqInfo);
			rspBean.setCount(commentService.queryMyBraCommentCou(reqInfo));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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
	 * 查最新的评论列表
	 * @Description:
	 * @param brand_id
	 * @param comment_id
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 下午2:41:34
	 */
	@RequestMapping(value = "/querylastbracommentlist",method = RequestMethod.GET)
	public void querylastbracommentlist(HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		//设置返回Bean
		RspBrandComBean rspBean = new RspBrandComBean();
		List<BrandCommentInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			infoList = commentService.queryLastBraCommentList(reqInfo);
			rspBean.setCount(String.valueOf(infoList.size()));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/querymycommentbybrand/{brand_id}/{user_id}/{page}",method = RequestMethod.GET)
	public void queryMyCommentByBrand(@PathVariable("brand_id") String brand_id,
			@PathVariable("page") String page,
			@PathVariable("user_id") String user_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		//设置返回Bean
		RspBrandComBean rspBean = new RspBrandComBean();
		List<BrandCommentInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setBrand_id(brand_id);
			reqInfo.setUser_id(user_id);
			reqInfo.setPage(Integer.valueOf(page));
			infoList = commentService.queryMyBraCommentList(reqInfo);
			rspBean.setCount(commentService.queryMyBraCommentCou(reqInfo));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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

	@RequestMapping(value = "/querymyreplycomment/{user_id}/{page}",method = RequestMethod.GET)
	public void queryMyReplyComment(@PathVariable("page") String page,
			@PathVariable("user_id") String user_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		//设置返回Bean
		RspBrandComBean rspBean = new RspBrandComBean();
		List<BrandCommentInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setUser_id(user_id);
			reqInfo.setPage(Integer.valueOf(page));
			infoList = commentService.queryMyReplyComment(reqInfo);
			rspBean.setCount(commentService.queryMyReplyCommentCou(reqInfo));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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
	
	@RequestMapping(value = "/queryreplymycomment/{user_id}/{page}",method = RequestMethod.GET)
	public void queryReplyMyComment(@PathVariable("page") String page,
			@PathVariable("user_id") String user_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		ReqCommentInfo reqInfo = new ReqCommentInfo();
		
		//设置返回Bean
		RspBrandComBean rspBean = new RspBrandComBean();
		List<BrandCommentInfo> infoList = null;
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setUser_id(user_id);
			reqInfo.setPage(Integer.valueOf(page));
			infoList = commentService.queryReplyMyComment(reqInfo);
			rspBean.setCount(commentService.queryReplyMyCommentCou(reqInfo));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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
	
	
	@RequestMapping(value = "/querycommentinfo/{commentId}",method = RequestMethod.GET)
	public void queryCommentInfo(@PathVariable("commentId") String commentId,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求bean 
		
		//设置返回Bean
		RspBrandComm rspBean = new RspBrandComm();
		
		//返回值
		String result = "";
		try
		{
			BrandCommentInfo com = commentService.queryCommentInfo(commentId);
			rspBean.setInfo(com);
			rspBean.setResult("0");
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("加载评论列表失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("加载评论列表失败");
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
	 * 
	 * @Title: increasecommentzan
	 * @Description: 点赞
	 * @return: void
	 * @author: knight
	 * @date: 2016年7月29日 下午2:25:55
	 */
	@RequestMapping(value = "/increasecommentzan/{comment_id}",method = RequestMethod.GET)
	public void increasecommentzan(@PathVariable("comment_id") String comment_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		RspBean rspBean = new RspBean();
		//返回值
		String result = "";
		try
		{
			String resCode = commentService.increasecommentzan(comment_id);
			if("0".equals(resCode)){
				rspBean.setResult("0");
			}else
			{
				rspBean.setResult("000001");
				rspBean.setErrorInfo("点赞失败，稍后再试");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000002");
			rspBean.setErrorInfo("评论点赞失败");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("评论点赞失败");
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
