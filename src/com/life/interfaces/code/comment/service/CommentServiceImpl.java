/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.code.comment.service.CommentServiceImpl
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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.life.interfaces.code.comment.bean.info.BrandCommentInfo;
import com.life.interfaces.code.comment.bean.info.ReqCommentInfo;
import com.life.interfaces.code.comment.dao.CommentDAO;
import com.life.interfaces.code.sys.bean.param.Fen;
import com.life.interfaces.code.sys.bean.param.ParamInfo;
import com.life.interfaces.code.sys.dao.SysDAO;
import com.life.interfaces.code.user.bean.info.UserInfo;
import com.life.interfaces.code.user.dao.UserDAO;
import com.life.interfaces.util.Constants;
import com.life.interfaces.util.StringTools;

/**
 * @className:com.life.interfaces.code.comment.service.CommentServiceImpl
 * @version:v1.0.0 
 * @date:2016年6月16日 上午9:06:10
 * @author:Chaos
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService
{
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
	 * 引入Dao
	 */
	@Resource(name = "userDao")
	private UserDAO userDao;
	
	/**
     * {@inheritDoc}
     */
	@Override
	public void addBrandComment(ReqCommentInfo reqInfo) throws SQLException
	{
		ParamInfo paramInfo = new ParamInfo();
		//查询评论积分上限
		paramInfo = sysDao.querySysParamInfo(Constants.MAX_POINT);
		Integer maxNum = Integer.valueOf(paramInfo.getParam_value());
		
		//查询今天评论次数
		Integer comNumToday = commentDao.queryCommentNumByToday(reqInfo.getUser_id());//有图
		Integer comNumTodays = commentDao.queryCommentNumByTodays(reqInfo.getUser_id());//无图
		
		paramInfo = sysDao.querySysParamInfo(Constants.COMMENT_NO_PIC);//无图积分
		Integer noPicNum = Integer.valueOf(paramInfo.getParam_value());
		paramInfo = sysDao.querySysParamInfo(Constants.COMMENT_PIC);//有图积分
		Integer picNUm = Integer.valueOf(paramInfo.getParam_value());
		
		commentDao.addBrandComment(reqInfo);
		
		//计算是否超过上限
		if((noPicNum * comNumTodays + picNUm * comNumToday) >= maxNum)
		{
			return;
		}
		
		//增加积分
		Fen fen = new Fen();
		fen.setUser_id(reqInfo.getUser_id());
		if(StringTools.isNullOrEmpty(reqInfo.getComment_img()))
		{
			fen.setFen(String.valueOf(noPicNum));
		}
		else
		{
			fen.setFen(String.valueOf(picNUm));
		}
		sysDao.updateFen(fen);
		
		//计算等级
		String grade = commentDao.queryUserGrade(reqInfo.getUser_id());
		UserInfo userInfo = new UserInfo();
		userInfo.setUser_id(reqInfo.getUser_id());
		userInfo.setGrade_id(grade);
		userDao.uptUser(userInfo);
		
		if(reqInfo.getComment_pid().equals("0"))
		{
			commentDao.uptBrandScore(reqInfo.getBrand_id());
		}
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandCommentInfo> queryBrandCommetList(ReqCommentInfo reqInfo) throws SQLException, IOException
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
			reqInfo.setPage((reqInfo.getPage()-1)*Constants.commentPage);
			reqInfo.setPageNum(Constants.commentPage);
		}
		
		List<BrandCommentInfo> infoList = commentDao.queryBrandCommetList(reqInfo);
		
		for (BrandCommentInfo info : infoList)
		{
			if(!StringTools.isNullOrEmpty(info.getComment_img()))
			{
				String[] imgs = info.getComment_img().split(",");
				String prefix = StringTools.getImgUrl("1");
				String new_imgs = "";
				for(String img : imgs){
					new_imgs += ","+prefix + img;
				}
				info.setComment_img(new_imgs.substring(1));
			}
			info.setAvatar(StringTools.getImgUrl("1") + info.getAvatar());
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandCommentInfo> queryMyBraCommentList(ReqCommentInfo reqInfo) throws SQLException, IOException
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
			reqInfo.setPage((reqInfo.getPage()-1)*Constants.commentPage);
			reqInfo.setPageNum(Constants.commentPage);
		}
		
		List<BrandCommentInfo> infoList = commentDao.queryMyBraCommentList(reqInfo);
		
		for (BrandCommentInfo info : infoList)
		{
			if(!StringTools.isNullOrEmpty(info.getComment_img()))
			{
				info.setComment_img(StringTools.getImgUrl("1") + info.getComment_img());
			}
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryBrandCommetCou(ReqCommentInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(commentDao.queryBrandCommetCou(reqInfo)) / Constants.commentPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryMyBraCommentCou(ReqCommentInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(commentDao.queryMyBraCommentCou(reqInfo)) / Constants.commentPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandCommentInfo> queryLastBraCommentList(ReqCommentInfo reqInfo) throws SQLException, IOException
	{
		reqInfo.setPage(0);
		reqInfo.setPageNum(Integer.valueOf(sysDao.querySysParamInfo("RECENT_COMMENT_NUM").getParam_value()));
		List<BrandCommentInfo> infoList = commentDao.queryLastBraCommentList(reqInfo);
		
		for (BrandCommentInfo info : infoList)
		{
			if(!StringTools.isNullOrEmpty(info.getComment_img()))
			{
				info.setComment_img(StringTools.getImgUrl("1") + info.getComment_img());
			}
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandCommentInfo> queryMyCommentByBrand(ReqCommentInfo reqInfo) throws SQLException, IOException
	{
		List<BrandCommentInfo> infoList = commentDao.queryMyCommentByBrand(reqInfo);
		
		for (BrandCommentInfo info : infoList)
		{
			if(!StringTools.isNullOrEmpty(info.getComment_img()))
			{
				info.setComment_img(StringTools.getImgUrl("1") + info.getComment_img());
			}
		}
		
		return infoList;
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public String queryMyCommentByBrandCou(ReqCommentInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(commentDao.queryMyBraCommentCou(reqInfo)) / Constants.commentPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	/**
     * {@inheritDoc}
	 * @throws IOException 
     */
	@Override
	public List<BrandCommentInfo> queryReplyMyComment(ReqCommentInfo reqInfo) throws SQLException, IOException
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
			reqInfo.setPage((reqInfo.getPage()-1)*Constants.commentPage);
			reqInfo.setPageNum(Constants.commentPage);
		}
		List<BrandCommentInfo> infoList = commentDao.queryReplyMyComment(reqInfo);
		
		for (BrandCommentInfo info : infoList)
		{
			if(!StringTools.isNullOrEmpty(info.getComment_img()))
			{
				info.setComment_img(StringTools.getImgUrl("1") + info.getComment_img());
			}
		}
		return infoList;
	}


	/**
     * {@inheritDoc}
     */
	@Override
	public String queryReplyMyCommentCou(ReqCommentInfo reqInfo) throws SQLException
	{
		Double cou = Double.valueOf(commentDao.queryReplyMyCommentCou(reqInfo)) / Constants.commentPage;
		return String.valueOf((int)Math.ceil(cou));
	}


	@Override
	public BrandCommentInfo queryCommentInfo(String comment_id) throws SQLException, IOException
	{
		BrandCommentInfo comment = commentDao.queryCommentInfo(comment_id);
		
		if(!StringTools.isNullOrEmpty(comment))
		{
			comment.setComment_img(StringTools.getImgUrl("1") + comment.getComment_img());
		}
		
		return comment;
	}

	@Override
	public String increasecommentzan(String comment_id) throws SQLException {
		BrandCommentInfo comment = commentDao.queryCommentInfo(comment_id);
		comment.setZan(comment.getZan()+1);
		try{
			commentDao.increasecommentzan(comment);
		}
		catch(Exception e){
			return "1";
		}
		return "0";
	}

	@Override
	public List<BrandCommentInfo> queryMyReplyComment(ReqCommentInfo reqInfo) throws SQLException, IOException {
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
			reqInfo.setPage((reqInfo.getPage()-1)*Constants.commentPage);
			reqInfo.setPageNum(Constants.commentPage);
		}
		List<BrandCommentInfo> infoList = commentDao.queryMyReplyComment(reqInfo);
		
		for (BrandCommentInfo info : infoList)
		{
			if(!StringTools.isNullOrEmpty(info.getComment_img()))
			{
				info.setComment_img(StringTools.getImgUrl("1") + info.getComment_img());
			}
		}
		return infoList;
	}

	@Override
	public String queryMyReplyCommentCou(ReqCommentInfo reqInfo) throws SQLException {
		Double cou = Double.valueOf(commentDao.queryMyReplyCommentCou(reqInfo)) / Constants.commentPage;
		return String.valueOf((int)Math.ceil(cou));
	}
}
