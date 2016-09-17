/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.user.service.UserServiceImpl
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
package com.life.interfaces.code.user.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;
import com.life.interfaces.code.comment.dao.CommentDAO;
import com.life.interfaces.code.sys.bean.param.Fen;
import com.life.interfaces.code.sys.dao.SysDAO;
import com.life.interfaces.code.user.bean.info.UserInfo;
import com.life.interfaces.code.user.bean.info.UserPwd;
import com.life.interfaces.code.user.dao.UserDAO;
import com.life.interfaces.util.MD5Util;
import com.life.interfaces.util.StringTools;

/**
 * @className:com.life.interfaces.code.user.service.UserServiceImpl
 * @version:v1.0.0 
 * @date:2016年6月12日 下午2:28:49
 * @author:Chaos
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
	/**
	 * 引入Dao
	 */
	@Resource(name = "userDao")
	private UserDAO userDao;
	
	/**
	 * 引入Dao
	 */
	@Resource(name = "commentDao")
	private CommentDAO commentDao;
	
	/**
	 * 引入Dao
	 */
	@Resource(name = "sysDao")
	private SysDAO sysDao;
	
	/**
     * {@inheritDoc}
     */
	@Override
	public UserInfo login(UserInfo reqInfo) throws SQLException
	{
		Integer cou = 0;
		String salt = "";
		UserInfo rspInfo = new UserInfo();
		//查询账户是否存在
		cou = userDao.queryUserPhone(reqInfo);
		if(cou > 0)
		{
			//查询盐值
			salt = userDao.querySalt(reqInfo);
			reqInfo.setPassword(MD5Util.getMD5String(reqInfo.getPassword()+salt));
			rspInfo = userDao.login(reqInfo);
			if(StringTools.isNullOrEmpty(reqInfo))
			{
				rspInfo.setStatus("-2");
			}
		}
		else
		{
			rspInfo.setStatus("-1");
		}
		return rspInfo;
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public Integer register(UserInfo reqInfo) throws SQLException
	{
		Integer result = 0;
		Integer cou = 0;
		String c = "";
		//账号是否存在
		cou = userDao.queryUserPhone(reqInfo);
		
		if(cou == 0)
		{
			//验证码是否正确
			c = userDao.queryCode(reqInfo);
			
			if("1".equals(c))
			{
				Random r = new Random();
				reqInfo.setSalt(Integer.toString(r.nextInt(10000)));
				reqInfo.setPassword(MD5Util.getMD5String(reqInfo.getPassword() + reqInfo.getSalt()));
				reqInfo.setUser_id(StringTools.getUUID());
				reqInfo.setNickname(reqInfo.getTelephone());
				userDao.register(reqInfo);
				
				if(!StringTools.isNullOrEmpty(reqInfo.getLnvite_code()))
				{
					String uId = userDao.queryUserByPhone(reqInfo);
					if(!StringTools.isNullOrEmpty(uId))
					{
						Fen fen = new Fen();
						fen.setFen("20");
						fen.setUser_id(uId);
						
						sysDao.updateFen(fen);
					}
				}
			}
			else
			{
				result = -2;//验证码失效
			}
		}
		else
		{
			result = -1;//用户存在
		}
		return result;
	}

	
	/**
     * {@inheritDoc}
     */
	@Override
	public void uptUser(UserInfo reqInfo) throws SQLException
	{
		userDao.uptUser(reqInfo);
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String uptPwd(UserPwd reqInfo) throws SQLException
	{
		String result = "-1";//默认修改失败
		UserInfo reqUserInfo = new UserInfo();
		//忘记密码
		if(reqInfo.getUser_id().equals("0") && !StringTools.isNullOrEmpty(reqInfo.getCode()))
		{
			//校验验证码
			reqUserInfo.setUser_id(reqInfo.getUser_id());
			
			String codeRes = userDao.queryCode(reqUserInfo);
			
			if( StringTools.isNullOrEmpty(codeRes) || !"1".equals(codeRes))
			{
				return "-50";//验证码有错
			}
			
			//根据手机号查询userid
			String uId = userDao.queryUserByPhone(reqUserInfo);
			if(!StringTools.isNullOrEmpty(uId))
			{
				reqInfo.setUser_id(uId);
			}
			else
			{
				return "-90";//用户不存在
			}
			//修改密码
			reqUserInfo = new UserInfo();
			reqUserInfo.setUser_id(reqInfo.getUser_id());
			//查询原密码，盐值等信息
			String salt = userDao.querySalt(reqUserInfo);
			if(!StringTools.isNullOrEmpty(salt))
			{
				reqInfo.setNewPwd(MD5Util.getMD5String(reqInfo.getNewPwd() + salt));
				userDao.updatePwd(reqInfo);
				result = "0";
			}
			return result;
		}
		
		//修改密码
		reqUserInfo = new UserInfo();
		reqUserInfo.setUser_id(reqInfo.getUser_id());
		//查询原密码，盐值等信息
		String pwd = userDao.queryUserPwd(reqUserInfo);
		String salt = userDao.querySalt(reqUserInfo);
		if(!StringTools.isNullOrEmpty(pwd) && !StringTools.isNullOrEmpty(salt))
		{
			reqInfo.setOldPwd(MD5Util.getMD5String(reqInfo.getOldPwd() + salt));
//System.out.println("原密码:"+pwd);
//System.out.println("旧密码:"+reqInfo.getOldPwd());
//System.out.println("新密码:"+MD5Util.getMD5String(reqInfo.getNewPwd() + salt));
			//原密码正确
			if(reqInfo.getOldPwd().equals(pwd))
			{
				reqInfo.setNewPwd(MD5Util.getMD5String(reqInfo.getNewPwd() + salt));
				userDao.updatePwd(reqInfo);
				result = "0";
			}
		}
		return result;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public UserInfo queryUserInfo(UserInfo reqInfo) throws SQLException, IOException
	{
		ReqCommentInfo reqInfos = new ReqCommentInfo();
		UserInfo userInfo = userDao.queryUserInfo(reqInfo);
		
		reqInfos.setUser_id(userInfo.getUser_id());
		userInfo.setComment_Num(commentDao.queryMyBraCommentCou(reqInfos));
		userInfo.setReply_Num(commentDao.queryReplyMyCommentCou(reqInfos));
		if(!StringUtils.isEmpty(userInfo.getImg_a())){
			userInfo.setImg_a(StringTools.getImgUrl("1") + userInfo.getImg_a());
		}
		if(!StringUtils.isEmpty(userInfo.getImg_b())){
			userInfo.setImg_b(StringTools.getImgUrl("1") + userInfo.getImg_b());
		}
		userInfo.setAvatar(StringTools.getImgUrl("1") + userInfo.getAvatar());
		return userInfo;
	}

}
