/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.dao.CommentDAO
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
package com.life.interfaces.code.comment.dao;

import java.sql.SQLException;
import java.util.List;

import com.life.interfaces.code.comment.bean.info.BrandCommentInfo;
import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;

/**
 * @className:com.life.interfaces.code.comment.dao.CommentDAO
 * @version:v1.0.0 
 * @date:2016年6月16日 上午8:59:19
 * @author:Chaos
 */
public interface CommentDAO
{
	/**
	 * 添加品牌评论
	 * @Description:
	 * @param reqInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 上午9:34:55
	 */
	public void addBrandComment(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询品牌评论列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 上午10:50:35
	 */
	public List<BrandCommentInfo> queryBrandCommetList(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询品牌评论列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 上午10:50:35
	 */
	public String queryBrandCommetCou(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询我评论的列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 下午2:40:19
	 */
	public List<BrandCommentInfo> queryMyBraCommentList(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询我评论的列表
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年6月16日 下午2:40:19
	 */
	public String queryMyBraCommentCou(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询最新的X条评论
	 * @Description:
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月12日 下午10:00:13
	 */
	public List<BrandCommentInfo> queryLastBraCommentList(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询今天评论次数
	 * @Description:
	 * @param userKey
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月20日 下午5:45:22
	 */
	public Integer queryCommentNumByToday(String userKey) throws SQLException;
	
	/**
	 * 查询今天评论次数
	 * @Description:
	 * @param userKey
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月20日 下午5:45:22
	 */
	public Integer queryCommentNumByTodays(String userKey) throws SQLException;
	
	
	/**
	 *  计算等级
	 * @Description:
	 * @param fen
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月21日 下午1:07:59
	 */
	public String queryUserGrade(String userId) throws SQLException;
	
	
	/**
	 * 查询我的品牌评论
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public List<BrandCommentInfo> queryMyCommentByBrand(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询我的品牌评论
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public String queryMyCommentByBrandCou(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 回复我的评论列表
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public List<BrandCommentInfo> queryReplyMyComment(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 回复我的数目
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public String queryReplyMyCommentCou(ReqCommentInfo reqInfo) throws SQLException;

	/**
	 * 我的回复评论列表
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public List<BrandCommentInfo> queryMyReplyComment(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 我的回复数目
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public String queryMyReplyCommentCou(ReqCommentInfo reqInfo) throws SQLException;
	
	/**
	 * 更新分数
	 * @Description:
	 * @param brand_id
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @date:2016年7月25日 下午10:33:02
	 */
	public void uptBrandScore(String brand_id) throws SQLException;
	
	
	/**
	 * 查询评论
	 * @Description:
	 * @param comment_id
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 */
	public BrandCommentInfo queryCommentInfo(String comment_id) throws SQLException;


	/**
	 * @Title: increasecommentzan
	 * @Description: 点赞
	 * @return: String
	 * @author: knight
	 * @date: 2016年7月29日 下午2:32:13
	 */
	public void increasecommentzan(BrandCommentInfo reqInfo);
}
