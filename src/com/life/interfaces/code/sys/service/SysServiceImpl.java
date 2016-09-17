/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.service.SysServiceImpl
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
package com.life.interfaces.code.sys.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.life.interfaces.code.sys.bean.feed.FeedInfo;
import com.life.interfaces.code.sys.bean.info.ContentInfo;
import com.life.interfaces.code.sys.bean.param.ParamInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSmsCodeInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSysInfo;
import com.life.interfaces.code.sys.bean.sys.RspSmsBean;
import com.life.interfaces.code.sys.bean.sys.SysInfo;
import com.life.interfaces.code.sys.dao.SysDAO;
import com.life.interfaces.util.Constants;
import com.life.interfaces.util.SmsUtils;
import com.life.interfaces.util.StringTools;
import com.taobao.api.ApiException;

/**
 * @className:com.life.interfaces.code.sys.service.SysServiceImpl
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:32:21
 * @author:Chaos
 */
@Service("sysService")
public class SysServiceImpl implements SysService
{
	/**
	 * 引入Dao
	 */
	@Resource(name = "sysDao")
	private SysDAO sysDao;
	
	
	/**
     * {@inheritDoc}
     */
	@Override
	public ParamInfo querySysParamInfo(String key) throws SQLException
	{
		return sysDao.querySysParamInfo(key);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void addFeedInfo(FeedInfo reqInfo) throws SQLException
	{
		sysDao.addFeedInfo(reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public ContentInfo queryContentInfo(String class_id) throws SQLException
	{
		return sysDao.queryContentInfo(class_id);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public List<SysInfo> querySysInfoList(ReqSysInfo reqInfo) throws SQLException
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
			reqInfo.setPage((reqInfo.getPage()-1)*10);
			reqInfo.setPageNum(10);
		}
		
		List<SysInfo> infoList = sysDao.querySysInfoList(reqInfo);
		return infoList;
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public SysInfo querySysInfo(ReqSysInfo reqInfo) throws SQLException
	{
		SysInfo sysInfo = sysDao.querySysInfo(reqInfo);
		
		if(!StringTools.isNullOrEmpty(sysInfo))
		{
			if("1".equals(sysInfo.getStatus()))
			{
				//未看置为已看
				sysDao.updateSysInfo(reqInfo);
			}
		}
		
		return sysInfo;
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public void updateSysInfo(ReqSysInfo reqInfo) throws SQLException
	{
		
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<ParamInfo> queryParamList(String key) throws SQLException, IOException
	{
		List<ParamInfo> infoList = sysDao.queryParamList(key);
		
		for (ParamInfo paramInfo : infoList)
		{
			paramInfo.setParam_value(StringTools.getImgUrl("1") + paramInfo.getParam_value());
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
	 * @throws ApiException 
	 * @throws IOException 
     */
	@Override
	public String addSmsCode(ReqSmsCodeInfo reqInfo) throws SQLException, ApiException
	{
		String r = "-99";
		//判断是什么类
		if("0".equals(reqInfo.getType()))
		{
			reqInfo.setCode(Constants.registerCode);
			reqInfo.setSign(Constants.registerSign);
		}
		else
		{
			reqInfo.setCode(Constants.changeCode);
			reqInfo.setSign(Constants.changeSign);
		}
		String code = "";
		Random rs = new Random(System.currentTimeMillis());
		code = String.valueOf((rs.nextInt(9000) + 1000));

		
		//调用发送短信接口
		String result = SmsUtils.sendSms(reqInfo.getPhone(), reqInfo.getCode(), reqInfo.getSign(),code);
		Gson gson = new Gson();
		RspSmsBean rspSmsBean = gson.fromJson(result, RspSmsBean.class);
		if(!StringTools.isNullOrEmpty(result))
		{
			if("0".equals(rspSmsBean.getAlibaba_aliqin_fc_sms_num_send_response().getResult().getErr_code()))
			{
				reqInfo.setYzm(code);
				sysDao.addSmsCode(reqInfo);
				r="0";
			}
		}
		
		return r;
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String querySysInfoListCou(ReqSysInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(sysDao.querySysInfoListCou(reqInfo)) / Constants.commentPage;
		return String.valueOf((int)Math.ceil(cou));
	}

}
