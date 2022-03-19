package vms.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import vms.entity.UserLogin;
import vms.service.IUserService;
import vms.util.Captcha;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RandomAction extends ActionSupport implements SessionAware {
	private ByteArrayInputStream inputStream;
	private Map<String, Object> session;

	@Autowired(required=true)
	@Qualifier("userService")
	private IUserService userService;
	
	private UserLogin userLogin;
	
	public UserLogin getUser() { 
		return userLogin; 
	} 
	public void setUser(UserLogin userLogin) { 
		this.userLogin = userLogin; 
	}
	
	public String execute() throws Exception {
		Captcha rdnu = Captcha.Instance();
		this.setInputStream(rdnu.getImage());// 取得带有随机字符串的图片
		String str = rdnu.getString();
		session.put("randomCode", str);// 取得随机字符串放入HttpSession
		//logger.info("登录用户[验证码]：["  + str + "]");
		return SUCCESS;
	}
	
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
			this.session = session;	
		
	}

}