/**
 * Copyright (C) 2016 Chaos
 *
 *
 * @className:com.life.interfaces.util.SmsUtils
 * 
 * @version:v1.0.0 
 * @author:Chaos
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016年7月11日     Chaos       v1.0.0        create
 *
 *
 */
package com.life.interfaces.util;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * @className:com.life.interfaces.util.SmsUtils
 * @version:v1.0.0 
 * @date:2016年7月11日 下午9:51:52
 * @author:Chaos
 */
public class SmsUtils
{
	public static String sendSms(String phone,String smsCode,String sign,String code) throws ApiException
	{
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23410931", "d3fa847a60136b07e93bbce398249bc3");
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		//req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName(sign);
		req.setSmsParamString("{\"code\":\""+code+"\",\"product\":\""+"无锡自由生活"+"\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode(smsCode);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
	
	
}
