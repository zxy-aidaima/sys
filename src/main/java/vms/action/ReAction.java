package vms.action;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

import redis.clients.jedis.ShardedJedis;
import vms.entity.UserLogin;
import vms.util.RedisUtil;
import vms.util.SignMassage;
import vms.util.StringUtils;
import vms.util.TimeAndDate;

public class ReAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
//	private Map<String, Object> session;
	private UserLogin userLogin;
	private String timesOrMassage;
//	private HttpServletRequest request;
	private String result;

//	public void setServletRequest(HttpServletRequest arg0) {
//		this.request = arg0;
//	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UserLogin getUser() {
		return userLogin;
	}

	public void setUser(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getTimesOrMassage() {
		return timesOrMassage;
	}

	public void setTimesOrMassage(String timesOrMassage) {
		this.timesOrMassage = timesOrMassage;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String phonenumber = request.getParameter("phonenumber");
		String returnMessage = "";
		String code = "";
		boolean flag = false;
		code = getSendCodeMessage();
		Gson gson = new Gson();
		System.out.println("手机号：" + phonenumber + " 验证码：" + code);
		RedisUtil redisUtil = new RedisUtil();
		ShardedJedis shardedJedis = redisUtil.getPool();
		if (!shardedJedis.exists(phonenumber)) {
			String strTime = StringUtils.getPropertiesValue("redisCheckCodeLiveTime", "app-config.properties");
			String result = shardedJedis.set(phonenumber, code, "NX", "EX", Long.parseLong(strTime));
		} else {
			flag = true;
		}
		try {
			if(!flag){
				returnMessage = "{\"RequestId\":\"D0D92A9F-CF9C-4502-BDA1-AF15FCE192D6\",\"Message\":\"OK\",\"BizId\":\"838609709855352827^0\",\"Code\":\"OK\"}";
				// 使用短信发送验证码功能时放开注释
				// returnMessage = SignMassage.sendSms(SignMassage.createUrl(phonenumber, code));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(returnMessage);
		Type userListType = new TypeToken<HashMap<String, String>>(){}.getType();
		Map<String, String> messageMap = gson.fromJson(returnMessage, userListType);
		Map<String, Object> map = new HashMap<String, Object>();
		if (messageMap != null && "OK".equals(messageMap.get("Message")) && "OK".equals(messageMap.get("Code"))) {
			map.put("codemessage", "发送成功");
			map.put("code", code);
			result = gson.toJson(map);
		} else if (flag) {
			map.put("codemessage", "上次发送的验证码还没有失效");
			map.put("code", "");
			result = gson.toJson(map);
		} else {
			map.put("codemessage", "发送失败请稍后重试");
			map.put("code", "");
			result = gson.toJson(map);
		}
		return SUCCESS;
	}

	public String getSendCodeMessage() {
		int number = 0;
		int len = 4;
		String code = "";
		for (int i = 0; i < len; i++) {
			number = (int) Math.floor(Math.random() * 10);
			code = code + number;
		}
		return code;
	}

}
