/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.UserController
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
package com.life.interfaces.code.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.life.interfaces.code.user.bean.info.ReqUserBean;
import com.life.interfaces.code.user.bean.info.ReqUserPwdBean;
import com.life.interfaces.code.user.bean.info.RspUserBean;
import com.life.interfaces.code.user.bean.info.UserInfo;
import com.life.interfaces.code.user.bean.info.UserPwd;
import com.life.interfaces.code.user.service.UserService;
import com.life.interfaces.util.RequestUtil;
import com.life.interfaces.util.RspBean;
import com.life.interfaces.util.StringTools;

/**
 * @className:com.life.interfaces.code.user.UserController
 * @version:v1.0.0 
 * @date:2016年6月12日 上午9:58:47
 * @author:Chaos
 */
@Controller
@RequestMapping(value = "/usercontro")
public class UserController 
{
	/**
	 * 引入Gson
	 */
	private Gson gson = new Gson();
			
	/**
	 * 错误日志
	 */
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	/**
	 * 引入service
	 */
	@Resource(name = "userService")
	private UserService userService;
	
	
	/**
	 * 登录
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午2:07:54
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求Bean
		ReqUserBean reqBean = new ReqUserBean();
		UserInfo reqInfo = new UserInfo();
		
		//设置返回Bean
		RspUserBean rspBean = new RspUserBean();
		UserInfo rspInfo = new UserInfo();
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqBean = gson.fromJson(jsonBean, ReqUserBean.class);
			reqInfo = reqBean.getReqInfo();
			
			//判断非空
			if(!StringTools.isNullOrEmpty(reqInfo.getTelephone())
				&&!StringTools.isNullOrEmpty(reqInfo.getPassword()))
			{
				//调用service 
				rspInfo = userService.login(reqInfo);
				if("0".equals(rspInfo.getStatus()))
				{
					rspBean.setResult("0");
					rspBean.setRspInfo(rspInfo);
				}
				else if("-1".equals(rspInfo.getStatus()))
				{
					rspBean.setResult("100002");
					rspBean.setErrorInfo("用户不存在");
				}
				else if("1".equals(rspInfo.getStatus()))
				{
					rspBean.setResult("100003");
					rspBean.setErrorInfo("用户被冻结");
				}
				else if("-2".equals(rspInfo.getStatus()))
				{
					rspBean.setResult("100005");
					rspBean.setErrorInfo("用户名或密码错误");
				}
			}
			else
			{
				rspBean.setResult("100001");
				rspBean.setErrorInfo("用户名或密码为空");
			}

		}
		catch (IOException e)
		{
			logger.error("IO异常",e);
			rspBean.setResult("000001");
			rspBean.setErrorInfo("服务器异常");
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
	 * 注册
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午2:08:04
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public void register(HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求Bean
		ReqUserBean reqBean = new ReqUserBean();
		UserInfo reqInfo = new UserInfo();
		
		//设置返回Bean
		RspBean rspBean = new RspBean();
		Integer sta = 0;
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqBean = gson.fromJson(jsonBean, ReqUserBean.class);
			reqInfo = reqBean.getReqInfo();
			
			//非空判断
			if(!StringTools.isNullOrEmpty(reqInfo)
				&&!StringTools.isNullOrEmpty(reqInfo.getTelephone())
				&&!StringTools.isNullOrEmpty(reqInfo.getPassword())
				&&!StringTools.isNullOrEmpty(reqInfo.getSalt()))
			{
				sta = userService.register(reqInfo);
				
				if(-1 == sta)
				{
					rspBean.setResult("100004");
					rspBean.setErrorInfo("该手机号已注册");
				}
				else if(-2 == sta)
				{
					rspBean.setResult("100004");
					rspBean.setErrorInfo("验证码失效");
				}
				else
				{
					rspBean.setResult("0");
				}
			}
			else
			{
				rspBean.setResult("100001");
				rspBean.setErrorInfo("用户名或密码为空");
			}
		}
		catch (IOException e)
		{
			logger.error("IO异常",e);
			rspBean.setResult("000001");
			rspBean.setErrorInfo("服务器异常");
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
	 * 修改个人信息
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午3:23:46
	 */
	@RequestMapping(value = "/uptuser",method = RequestMethod.POST)
	public void uptUser(HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求Bean
		ReqUserBean reqBean = new ReqUserBean();
		UserInfo reqInfo = new UserInfo();
		
		//设置返回Bean
		RspBean rspBean = new RspBean();
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqBean = gson.fromJson(jsonBean, ReqUserBean.class);
			reqInfo = reqBean.getReqInfo();
			
			//非空判断
			if(!StringTools.isNullOrEmpty(reqInfo)
				&&!StringTools.isNullOrEmpty(reqInfo.getUser_id()))
			{
				userService.uptUser(reqInfo);
				rspBean.setResult("0");
			}
			else
			{
				rspBean.setResult("000004");
				rspBean.setErrorInfo("必填参数未填");
			}
		}
		catch (IOException e)
		{
			logger.error("IO异常",e);
			rspBean.setResult("000001");
			rspBean.setErrorInfo("服务器异常");
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
	 * 修改密码
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月13日 下午4:24:42
	 */
	@RequestMapping(value = "/uptpwd/{code}",method = RequestMethod.POST)
	public void uptPwd(@PathVariable("code") String code,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求Bean
		ReqUserPwdBean reqBean = new ReqUserPwdBean();
		UserPwd reqInfo = new UserPwd();
		
		//设置返回Bean
		RspBean rspBean = new RspBean();
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqBean = gson.fromJson(jsonBean, ReqUserPwdBean.class);
			reqInfo = reqBean.getReqInfo();
			
			if(!"0".equals(code))
			{
				reqInfo.setCode(code);
				reqInfo.setOldPwd("123");
			}
			
			//非空判断
			if(!StringTools.isNullOrEmpty(reqInfo)
				&&!StringTools.isNullOrEmpty(reqInfo.getNewPwd())
				&&!StringTools.isNullOrEmpty(reqInfo.getOldPwd())
				&&!StringTools.isNullOrEmpty(reqInfo.getUser_id()))
			{
				String rsu = userService.uptPwd(reqInfo);
				if("0".equals(rsu))
				{
					rspBean.setResult("0");
				}
				else
				{
					rspBean.setResult("100006");
					rspBean.setErrorInfo("原密码错误");
				}
			}
			else
			{
				rspBean.setResult("000004");
				rspBean.setErrorInfo("必填参数未填");
			}
		}
		catch (IOException e)
		{
			logger.error("IO异常",e);
			rspBean.setResult("000001");
			rspBean.setErrorInfo("服务器异常");
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
	 * 查询用户信息
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月14日 上午8:54:25
	 */
	@RequestMapping(value = "/queryuserinfo/{user_id}",method = RequestMethod.GET)
	public void queryUserInfo(@PathVariable("user_id") String user_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求Bean
		ReqUserBean reqBean = new ReqUserBean();
		UserInfo reqInfo = new UserInfo();
		
		//设置返回Bean
		RspUserBean rspBean = new RspUserBean();
		UserInfo rspInfo = new UserInfo();
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setUser_id(user_id);
			reqBean.setReqInfo(reqInfo);
			
			if(!StringTools.isNullOrEmpty(reqInfo)
				&&!StringTools.isNullOrEmpty(reqInfo.getUser_id()))
			{
				rspInfo = userService.queryUserInfo(reqInfo);
				if(!StringTools.isNullOrEmpty(rspInfo))
				{
					rspBean.setResult("0");
					rspBean.setRspInfo(rspInfo);
				}
				else
				{
					rspBean.setResult("100002");
					rspBean.setErrorInfo("用户不存在");
				}
			}
			else
			{
				rspBean.setResult("000004");
				rspBean.setErrorInfo("必填参数未填");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
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
}
