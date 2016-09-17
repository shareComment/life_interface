/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.SysController
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
package com.life.interfaces.code.sys;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.life.interfaces.code.sys.bean.feed.FeedInfo;
import com.life.interfaces.code.sys.bean.image.ImagesBean;
import com.life.interfaces.code.sys.bean.info.ContentInfo;
import com.life.interfaces.code.sys.bean.info.RspContentBean;
import com.life.interfaces.code.sys.bean.param.ParamInfo;
import com.life.interfaces.code.sys.bean.param.RspParamBean;
import com.life.interfaces.code.sys.bean.param.RspParamListBean;
import com.life.interfaces.code.sys.bean.sys.ReqSmsCodeInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSysInfo;
import com.life.interfaces.code.sys.bean.sys.RspSysBean;
import com.life.interfaces.code.sys.bean.sys.RspSysInfoBean;
import com.life.interfaces.code.sys.bean.sys.SysInfo;
import com.life.interfaces.code.sys.service.SysService;
import com.life.interfaces.util.DateUtils;
import com.life.interfaces.util.RequestUtil;
import com.life.interfaces.util.RspBean;
import com.life.interfaces.util.StringTools;

/**
 * 系统参数controller
 * @className:com.life.interfaces.code.sys.SysController
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:09:44
 * @author:Chaos
 */
@Controller
@RequestMapping(value = "/syscontro")
public class SysController
{
	/**
	 * 引入Gson
	 */
	private Gson gson = new Gson();
			
	/**
	 * 错误日志
	 */
	private static final Logger logger = Logger.getLogger(SysController.class);
	
	/**
	 * 引入service
	 */
	@Resource(name = "sysService")
	private SysService sysService;	
	
	
	/**
	 * 查询系统参数
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午1:16:02
	 */
	@RequestMapping(value = "/querysysparamInfo/{key}",method = RequestMethod.GET)
	public void querySysParamInfo(@PathVariable("key") String key,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspParamBean rspBean = new RspParamBean();
		ParamInfo rspInfo = new ParamInfo();
		
		//返回值
		String result = "";
		try
		{
			rspInfo = sysService.querySysParamInfo(key);
			
			if(StringTools.isNullOrEmpty(rspInfo)
				|| StringTools.isNullOrEmpty(rspInfo.getParam_value()))
			{
				rspBean.setResult("300001");
				rspBean.setErrorInfo("系统参数不存在");
			}
			else
			{
				rspBean.setResult("0");
				rspBean.setRspInfo(rspInfo);
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统参数不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统参数不存在");
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
	 * 添加反馈
	 * @Description:
	 * @param key
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午2:55:30
	 */
	@RequestMapping(value = "/addfeedinfo",method = RequestMethod.POST)
	public void addFeedInfo(HttpServletRequest request,HttpServletResponse response)
	{
		//设置请求Bean
		FeedInfo reqInfo = new FeedInfo();
		
		//设置返回Bean
		RspBean rspBean = new RspBean();
		
		//返回值
		String result = "";
		try
		{
			//获取Json
			String jsonBean = RequestUtil.request2String(request);
			
			//转换Bean
			reqInfo = gson.fromJson(jsonBean, FeedInfo.class);
			
			//判断非空
			if (!StringTools.isNullOrEmpty(reqInfo)
				&& !StringTools.isNullOrEmpty(reqInfo.getFeed_con()))
			{
				sysService.addFeedInfo(reqInfo);
			}
			else
			{
				rspBean.setResult("300002");
				rspBean.setErrorInfo("请输入反馈内容");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("请输入反馈内容");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("请输入反馈内容");
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
	 * 查询网站公告&关于我们
	 * @Description:
	 * @param key
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午3:49:06
	 */
	@RequestMapping(value = "/querycontentinfo/{class_id}",method = RequestMethod.GET)
	public void queryContentInfo(@PathVariable("class_id") String class_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspContentBean rspBean = new RspContentBean();
		ContentInfo rspInfo = new ContentInfo();
		
		//返回值
		String result = "";
		try
		{
			rspInfo = sysService.queryContentInfo(class_id);
			
			if(StringTools.isNullOrEmpty(rspInfo)
				|| StringTools.isNullOrEmpty(rspInfo.getContent()))
			{
				rspBean.setResult("300002");
				rspBean.setErrorInfo("系统参数不存在");
			}
			else
			{
				rspBean.setResult("0");
				rspBean.setRspInfo(rspInfo);
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统参数不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统参数不存在");
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
	 * 查询系统消息列表
	 * @Description:
	 * @param key
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午3:49:06
	 */
	@RequestMapping(value = "/querysysinfolist/{user_id}/{page}",method = RequestMethod.GET)
	public void querySysInfoList(@PathVariable("user_id") String user_id,
			@PathVariable("page") Integer page,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspSysInfoBean rspBean = new RspSysInfoBean();
		List<SysInfo> infoList = null;
		ReqSysInfo reqInfo = new ReqSysInfo();
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setUser_id(user_id);
			reqInfo.setPage(page);
			infoList = sysService.querySysInfoList(reqInfo);
			rspBean.setCount(sysService.querySysInfoListCou(reqInfo));
			rspBean.setResult("0");
			rspBean.setInfoList(infoList);
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统消息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统消息不存在");
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
	 * 查询系统消息
	 * @Description:
	 * @param key
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午3:49:06
	 */
	@RequestMapping(value = "/querysysinfo/{user_id}/{sms_id}",method = RequestMethod.GET)
	public void querySysInfoList(@PathVariable("user_id") String user_id,
			@PathVariable("sms_id") String sms_id,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspSysBean rspBean = new RspSysBean();
		ReqSysInfo reqInfo = new ReqSysInfo();
		SysInfo rspInfo = new SysInfo();
		
		//返回值
		String result = "";
		try
		{
			reqInfo.setUser_id(user_id);
			reqInfo.setSms_id(sms_id);
			
			rspInfo = sysService.querySysInfo(reqInfo);
			
			if (StringTools.isNullOrEmpty(rspInfo))
			{
				rspBean.setResult("000003");
				rspBean.setErrorInfo("系统消息不存在");
			}
			else
			{
				rspBean.setResult("0");
				rspBean.setRspInfo(rspInfo);
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统消息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统消息不存在");
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
	 * 查询轮播
	 * @Description:
	 * @param key
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午3:49:06
	 */
	@RequestMapping(value = "/queryparamlist",method = RequestMethod.GET)
	public void queryParamList(HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspParamListBean rspBean = new RspParamListBean();
		List<ParamInfo> rspInfo = new ArrayList<ParamInfo>();
		
		//返回值
		String result = "";
		try
		{
			rspInfo = sysService.queryParamList("CAROUSEL");
			
			if (StringTools.isNullOrEmpty(rspInfo))
			{
				rspBean.setResult("000003");
				rspBean.setErrorInfo("系统消息不存在");
			}
			else
			{
				rspBean.setResult("0");
				rspBean.setInfoList(rspInfo);
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统消息不存在");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("系统消息不存在");
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
	 * 发送验证码
	 * @Description:
	 * @param key
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午3:49:06
	 */
	@RequestMapping(value = "/sendcode/{phone}/{type}",method = RequestMethod.GET)
	public void sendCode(@PathVariable("type") String type,@PathVariable("phone") String phone,
			HttpServletRequest request,HttpServletResponse response)
	{
		//设置返回Bean
		RspBean rspBean = new RspBean();
		
		//返回值
		String result = "";
		try
		{
			ReqSmsCodeInfo reqInfo = new ReqSmsCodeInfo();
			reqInfo.setType(type);
			reqInfo.setPhone(phone);
			
			String r = sysService.addSmsCode(reqInfo);
			
			if(!"0".equals(r))
			{
				rspBean.setResult("000007");
				rspBean.setErrorInfo("短信发送失败，请重新发送");
			}
			else
			{
				rspBean.setResult("0");
			}
		}
		catch (SQLException e)
		{
			logger.error("数据库异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("短信发送失败，请重新发送");
		}
		catch (Exception e)
		{
			logger.error("处理器异常",e);
			rspBean.setResult("000003");
			rspBean.setErrorInfo("短信发送失败，请重新发送");
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
	
	
	
	// 要上传的文件类型
    private String imgContentType;
	
    /**
     * 指定的上传类型zip和图片格式的文件
     */
    private static final String[] types =
    { "application/x-zip-compressed", "image/pjpeg", "image/x-jpg", "image/jpeg", "image/jpg" }; // "application/octet-stream; charset=utf-8",
    
	/**
	 * 上传图片
	* @Title: upLoad
	* @Description: 上传图片
	* @param @param reqest
	* @param @param response    设定文件
	* @return void    返回类型
	* @throws
	* @author:刘强
	* @date:2015年7月27日 下午11:48:40
	 */
	@RequestMapping(value = "/upload/{fn}",method = RequestMethod.POST)
	public void upLoad(@RequestParam(value = "file", required = false) MultipartFile file,
			@PathVariable("fn") String fn,
			HttpServletRequest reqest,HttpServletResponse response)
	{
		String result = "";
		InputStream in = null;
		String info = "";
		int size_b = 1;
        int size_m = 1;
        int size_s = 1;
		//获取文件名XXX.XXX
		//String fileName = file.getOriginalFilename();
        
        
		/**
		 * 设置目录
		 * 1：品牌
		 * 2：评论
		 */
		String otherName = "";
		if("1".equals(fn))
		{
			otherName = "pingpai";
		}
		else if("2".equals(fn))
		{
			otherName = "pinglun";
		}
		
		//随机生成文件夹名
		String destName = StringTools.getUUID();
		
		/**
		 * 创建目录
		 */
        // 读取properties文件
		Properties props = new Properties();
        in = FileUpload.class.getResourceAsStream("/com/life/interfaces/cfg/file.properties");
        try
		{
			props.load(in);
			info = props.getProperty("info").toString();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
        
        
        String filep = File.separator + otherName + File.separator + DateUtils.getSeqWeek();
		String filePath =  info + filep;
		File traFile = new File(filePath);
		if(!traFile.exists())
		{
			traFile.mkdirs();
		}
		
		
        //创建一个通用的多部分解析器   1
		//  CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(reqest.getSession().getServletContext());  
        
        //转换成多部分request     2
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)reqest; 
        
        //取得request中的所有文件名 3  
        Iterator<String> iter = multiRequest.getFileNames();  
        
        while(iter.hasNext())
        {
        	//取得上传文件 4
        	MultipartFile files1 = multiRequest.getFile(iter.next());
        	if(files1 != null)
        	{
        		try
        		{
        			//保存到文件夹下
        			traFile = new File(filePath, destName + ".jpg");
        			//file.transferTo(traFile);
        			files1.transferTo(traFile);
        			
        			//设置文件存放的路径
        			result = filePath;
        			
        			//图片的的路径
        			String imgPath = filePath + File.separator + destName + ".jpg";
        			
        			 // 强制转型图片的大小为INT
        			ImagesBean image = new ImagesBean();
                    long imgSize = image.getPicSize(imgPath) / 1024;
                    
                    // 读入文件
                    File _file = new File(imgPath);
                    Image src = null;
                    src = javax.imageio.ImageIO.read(_file);
                    
                    // 构造Image对象
                    int wideth = src.getWidth(null); // 得到源图宽
                    int height = src.getHeight(null); // 得到源图长

            
                    // 获取key对应的value
                    size_b = Integer.valueOf(props.getProperty("b").trim());
                    size_m = Integer.valueOf(props.getProperty("m").trim());
                    size_s = Integer.valueOf(props.getProperty("s").trim());
                    
                    //设置图片最大长宽
                    int maxWidtSize = 2000;
                    
                    
                    // 只有图片大小超过100KB的时候才进行相关的图片比例压缩
                    if(imgSize > 1)
                    {
                    	//限制长宽最大值
                    	if((wideth > maxWidtSize) || (height > maxWidtSize))
                    	{
                    		// 大图
        					image.compressPic(filePath, filePath, destName + ".jpg", destName + "_b.jpg", maxWidtSize, maxWidtSize, true);
        					// 中图
        					image.compressPic(filePath, filePath, destName + ".jpg", destName + "_m.jpg", size_m, size_m, true);
        					// 小图
        					image.compressPic(filePath, filePath, destName + ".jpg", destName + "_s.jpg", size_s, size_s, true);
                    	}
                    	else
                    	{
                    		// 判断逻辑：有些小图 （如：宽高233*212 硬性规定 压缩长宽 压缩后会放大导致效果很差
                    		// 以下代码---只有 长宽同时 超过规定值（size_m ,size_b）才强制压缩长宽否则使用原长宽（这样做的同时导致 某些 b,m 图压缩后一样）
                    		// 压缩大图
                    		if ((wideth > size_b) && (height > size_b))
        					{
                    			image.compressPic(filePath, filePath, destName + ".jpg", destName + "_b.jpg", size_b, size_b, true);
        					}
        					else
        					{
        						image.compressPic(filePath, filePath, destName + ".jpg", destName + "_b.jpg", wideth, height, true);
        					}
        					
                    		// 压缩中图
        					if ((wideth > size_m) && (height > size_m))
        					{
        						image.compressPic(filePath, filePath, destName + ".jpg", destName + "_m.jpg", size_m, size_m, true);
        					}
        					else
        					{
        						image.compressPic(filePath, filePath, destName + ".jpg", destName + "_m.jpg", wideth, height, true);
        					}
        					
        					// 压缩小图
        					image.compressPic(filePath, filePath, destName + ".jpg", destName + "_s.jpg", size_s, size_s, true);
                    	}
                    }
                    else
                    {
                    	// 大图
                        image.compressPic(filePath, filePath, destName + ".jpg", destName + "_b.jpg", wideth, height, true);
                        // ImageUtil.pressText2("我是大图", filePath + "/" +
                        // fileName + "_b1.jpg", filePath + "/" +
                        // fileName + "_b.jpg", "黑体", 36,
                        // Color.white, 80, 0, 0, 0.5f);
                        // 中图
                        image.compressPic(filePath, filePath, destName + ".jpg", destName + "_m.jpg", wideth, height, true);
                        // ImageUtil.pressText2("我是中图", filePath + "/" +
                        // fileName + "_m1.jpg", filePath + "/" +
                        // fileName + "_m.jpg", "黑体", 36,
                        // Color.white, 80, 0, 0, 0.5f);
                        // 小图
                        image.compressPic(filePath, filePath, destName + ".jpg", destName + "_s.jpg", wideth, height, true);
                        // ImageUtil.pressText2("我是小图", filePath + "/" +
                        // fileName + "_s1.jpg", filePath + "/" +
                        // fileName + "_s.jpg", "黑体", 36,
                        // Color.white, 40, 0, 0, 0.9f);
                    }
        		} 
        		catch (IllegalStateException e)
        		{
        			e.printStackTrace();
        		} 
        		catch (IOException e)
        		{
        			e.printStackTrace();
        		}
        		finally 
        		{
        			result = filep + File.separator +destName + ".jpg";
        			response.setContentType("application/json;charset=UTF-8");
        			try
        			{
        				response.getOutputStream().write(result.getBytes("UTF-8"));
        			} catch (UnsupportedEncodingException e)
        			{
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (IOException e)
        			{
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
        	}
        }

	}
	
	
	
	/**
	 * 判断文件类型
	 * @Description: TODO
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author 刘强
	 * @date 2015年8月1日下午11:09:05
	 */
	public boolean filterType()
    {
        boolean isFileType = false;
        String fileType = getImgContentType();
        for (String type : types)
        {
            if (type.equals(fileType))
            {
                isFileType = true;
                break;
            }
        }
        return isFileType;
    }
	
	public String getImgContentType()
	{
		return imgContentType;
	}

	public void setImgContentType(String imgContentType)
	{
		this.imgContentType = imgContentType;
	}
}
