/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.service.CommentService
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
package com.life.interfaces.code.comment.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.life.interfaces.code.comment.bean.info.BrandCommentInfo;
import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;

/**
 * @className:com.life.interfaces.code.comment.service.CommentService
 * @version:v1.0.0 
 * @date:2016年6月16日 上午9:05:59
 * @author:Chaos
 */
public interface CommentService
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
	 * @throws IOException 
	 * @date:2016年6月16日 上午10:50:35
	 */
	public List<BrandCommentInfo> queryBrandCommetList(ReqCommentInfo reqInfo) throws SQLException, IOException;
	
	
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
	 * @throws IOException 
	 * @date:2016年6月16日 下午2:40:19
	 */
	public List<BrandCommentInfo> queryMyBraCommentList(ReqCommentInfo reqInfo) throws SQLException, IOException;
	
	
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
	 * @throws IOException 
	 * @date:2016年7月12日 下午10:00:13
	 */
	public List<BrandCommentInfo> queryLastBraCommentList(ReqCommentInfo reqInfo) throws SQLException, IOException;

	
	/**
	 * 查询我的品牌评论
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	public List<BrandCommentInfo> queryMyCommentByBrand(ReqCommentInfo reqInfo) throws SQLException, IOException;

	
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
	 * @throws IOException 
	 */
	public List<BrandCommentInfo> queryReplyMyComment(ReqCommentInfo reqInfo) throws SQLException, IOException;
	
	
	/**
	 * 回复我的数目
	 * @param reqInfo
	 * @return
	 * @throws SQLException
	 */
	public String queryReplyMyCommentCou(ReqCommentInfo reqInfo) throws SQLException;
	
	
	/**
	 * 查询评论
	 * @Description:
	 * @param comment_id
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Chaos
	 * @throws IOException 
	 */
	public BrandCommentInfo queryCommentInfo(String comment_id) throws SQLException, IOException;


	/**
	 * @Title: increasecommentzan
	 * @Description: 点赞
	 * @return: String
	 * @author: knight
	 * @throws SQLException 
	 * @date: 2016年7月29日 下午2:26:11
	 */
	public String increasecommentzan(String comment_id) throws SQLException;


	/**
	 * @Title: queryMyReplyComment
	 * @Description: 我的回复评论列表
	 * @return: List<BrandCommentInfo>
	 * @author: knight
	 * @date: 2016年7月29日 下午4:17:02
	 */
	public List<BrandCommentInfo> queryMyReplyComment(ReqCommentInfo reqInfo) throws SQLException, IOException;


	/**
	 * @Title: queryMyReplyCommentCou
	 * @Description: 我的回复数目
	 * @return: String
	 * @author: knight
	 * @date: 2016年7月29日 下午4:17:37
	 */
	public String queryMyReplyCommentCou(ReqCommentInfo reqInfo) throws SQLException;
}
