package com.life.interfaces.util;

/**
 * 
 * @ClassName: RspBean
 * @Description: 返回 基类
 * @author 刘强
 * @date 2015年7月5日 上午12:03:42
 */
public class RspBean
{
	/**
	 * 结果
	 */
	private String result = "";
	
	/**
	 * 错误信息
	 */
	private String errorInfo = "";

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public String getErrorInfo()
	{
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo)
	{
		this.errorInfo = errorInfo;
	}

	@Override
	public String toString()
	{
		return "RspBean [result=" + result + ", errorInfo=" + errorInfo + "]";
	}

}
