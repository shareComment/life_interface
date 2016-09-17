/**  
* @Title: ReqUserPwdBean.java    
* @Package com.life.interfaces.code.user.bean.info    
* @Description: TODO(用一句话描述该文件做什么)    
* @author LiuQiang
* @date 2016年6月13日 下午6:23:32    
* @version V1.0  
*/
package com.life.interfaces.code.user.bean.info;

/** 
 * @ClassName:	ReqUserPwdBean 
 * @Description:TODO(这里用一句话描述这个类的作用) 
 * @author:	LiuQiang
 * @date:	2016年6月13日 下午6:23:32 
 *  
 */
public class ReqUserPwdBean
{
	private UserPwd reqInfo = null;

	public UserPwd getReqInfo()
	{
		return reqInfo;
	}

	public void setReqInfo(UserPwd reqInfo)
	{
		this.reqInfo = reqInfo;
	}
	
}
