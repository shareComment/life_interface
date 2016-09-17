/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.sys.dao.SysDAO
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
package com.life.interfaces.code.sys.dao;

import java.sql.SQLException;
import java.util.List;

import com.life.interfaces.code.sys.bean.feed.FeedInfo;
import com.life.interfaces.code.sys.bean.info.ContentInfo;
import com.life.interfaces.code.sys.bean.param.Fen;
import com.life.interfaces.code.sys.bean.param.ParamInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSmsCodeInfo;
import com.life.interfaces.code.sys.bean.sys.ReqSysInfo;
import com.life.interfaces.code.sys.bean.sys.SysInfo;

/**
 * @className:com.life.interfaces.code.sys.dao.SysDAO
 * @version:v1.0.0 
 * @date:2016年6月22日 上午10:31:46
 * @author:Chaos
 */
public interface SysDAO
{
	/**
	 * 查询系统参数
	 * @Description:
	 * @param key
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 上午10:43:20
	 */
	public ParamInfo querySysParamInfo(String key) throws SQLException;
	
	
	/**
	 * 添加反馈
	 * @Description:
	 * @param reqInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午2:54:33
	 */
	public void addFeedInfo(FeedInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询网站公告&关于我们
	 * @Description:
	 * @param class_id
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月22日 下午3:47:47
	 */
	public ContentInfo queryContentInfo(String class_id) throws SQLException;
	
	
	/**
	 * 查询系统消息列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月7日 下午4:12:30
	 */
	public List<SysInfo> querySysInfoList(ReqSysInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询系统消息
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月11日 下午10:44:26
	 */
	public SysInfo querySysInfo(ReqSysInfo reqInfo) throws SQLException;
	
	
	/**
	 * 修改消息状态
	 * @Description:
	 * @param reqInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月11日 下午10:49:52
	 */
	public void updateSysInfo(ReqSysInfo reqInfo) throws SQLException;
	
	
	/**
	 * 添加减少积分
	 * @Description:
	 * @param reqInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月11日 下午11:23:11
	 */
	public void updateFen(Fen reqInfo) throws SQLException;
	
	
	/**
	 * 查询轮播列表
	 * @Description:
	 * @param key
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月12日 下午10:14:36
	 */
	public List<ParamInfo> queryParamList(String key) throws SQLException;
	
	
	/**
	 * 发送短信
	 * @Description:
	 * @param reqInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月18日 下午5:37:15
	 */
	public void addSmsCode(ReqSmsCodeInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询系统条数
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月21日 下午6:30:43
	 */
	public String querySysInfoListCou(ReqSysInfo reqInfo) throws SQLException;
}
