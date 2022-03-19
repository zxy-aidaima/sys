package vms.action;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

import vms.entity.UserLogin;
import vms.util.SignMassage;
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
		// System.out.println("手机号：" + userLogin.getPhonenumber() + "密码：" +
		// userLogin.getUpassword() + "时间戳：" + userLogin.getSendTime());
		HttpServletRequest request = ServletActionContext.getRequest();
		String phonenumber = request.getParameter("phonenumber");
		String returnMessage = "";
		String code = "";
		code = getSendCodeMessage();
		Gson gson = new Gson();
		System.out.println("手机号：" + phonenumber + " 验证码：" + code);
		try {
			// returnMessage = "{\"RequestId\":\"D0D92A9F-CF9C-4502-BDA1-AF15FCE192D6\",\"Message\":\"OK\",\"BizId\":\"838609709855352827^0\",\"Code\":\"OK\"}";
			returnMessage = SignMassage.sendSms(SignMassage.createUrl(phonenumber, code));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(returnMessage);
		Type userListType = new TypeToken<HashMap<String, String>>(){}.getType();
		Map<String, String> messageMap = gson.fromJson(returnMessage, userListType);
		Map<String, Object> map = new HashMap<String, Object>();
		if ("OK".equals(messageMap.get("Message")) && "OK".equals(messageMap.get("Code"))) {
			Long startTimes = TimeAndDate.getTimestamp();
			map.put("codemessage", "发送成功");
			map.put("time", startTimes);
			map.put("code", code);
			result = gson.toJson(map);
		} else {
			map.put("codemessage", "发送失败请稍后重试");
			map.put("time", "");
			map.put("code", "");
			result = gson.toJson(map);
		}
		return SUCCESS;
	}

//	@Override
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//
//	}

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
