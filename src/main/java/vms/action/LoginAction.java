package vms.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import redis.clients.jedis.ShardedJedis;
import vms.entity.RegisterTrack;
import vms.entity.UserLogin;
import vms.service.IRegisterService;
import vms.service.IUserService;
import vms.util.RedisUtil;
import vms.util.TimeAndDate;

/**
 * @ClassName: LoginAction
 * @Description: LoginAction,主要用来接收用户的请求，调用service的相应处理函数，然后返回相应的页面
 * @author: 
 * @Time: 2020年12月25日
 */
@Controller("userAction")
@Scope(value="prototype")
public class LoginAction extends ActionSupport implements SessionAware {
	/**
	 * @Filed serialVersionUID : 
	 */
	private static final long serialVersionUID = 1L;

	//定义一个成员变量 
	private String message; 
	private String messageReturn;
	private Map<String, Object> session;
	private Map<String, Object> resultRegister;

	public String getMessage() { 
	    return message; 
	} 
	public void setMessage(String message) { 
	    this.message = message; 
	}	
	public String getMessageReturn() {
		return messageReturn;
	}
	public void setMessageReturn(String messageReturn) {
		this.messageReturn = messageReturn;
	}
	public Map<String, Object> getResultRegister() {
		return resultRegister;
	}
	public void setResultRegister(Map<String, Object> resultRegister) {
		this.resultRegister = resultRegister;
	}
	public void setSession(Map<String, Object> session) {
        this.session = session;
    }
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
	
	@Autowired(required=true)
	@Qualifier("registerService")
	private IRegisterService registerService;	
	
	private RegisterTrack registerTrack;
	
	public RegisterTrack getRegister() {
		return registerTrack;
	}
	public void setRegister(RegisterTrack registerTrack) {
		this.registerTrack = registerTrack;
	}
	
	public String findUserLogin(){
		System.out.println(userLogin.getRegisterid() + "---" + userLogin.getUpassword() + "---" + userLogin.getRoletype());
		String code = (String)session.get("randomCode");// 生成的验证码
		String validateCode = userLogin.getValidateCode(); // 用户输入的验证码	
		String role = userLogin.getRoletype();
		UserLogin user = userService.findUserLogin(userLogin);
		
		System.out.println("生成的验证码 :"+code);
		System.out.println("用户输入的验证码 :"+validateCode);
		
		if(validateCode.equals(code)) {
			message = "验证码错";
			return "login";
		}else {
			if(null != user) {
				if(user.getRoletype().equals(role)) {
					if("0".equals(role)) {
						message = "登陆成功";
						session.put("typeuser", role);
						session.put("registerid", userLogin.getRegisterid());
						return "admin";
					}else if("1".equals(role)) {
						message = "登陆成功";
						session.put("typeuser", role);
						session.put("registerid", userLogin.getRegisterid());
						return "volunteer";
					}else if("2".equals(role)){
						message = "登陆成功";
						session.put("typeuser", role);
						session.put("registerid", userLogin.getRegisterid());
						return "uuser";
					}else {
						message = "角色不存在";
						return "login";
					}
					
				}else {
					message = "角色不存在";
					return "login";
				}
			}else {
				message = "用户名或密码错";
				return "login";
			}
		}
	}
	
	public String rePassword() {
		System.out.println(userLogin.getPhonenumber() + "---" + userLogin.getUpassword());
		RedisUtil redisUtil = new RedisUtil();
		ShardedJedis shardedJedis = redisUtil.getPool();
		String value = shardedJedis.get(userLogin.getPhonenumber());
		if(value == null) {
			message = "验证码过期";
			return "repassword";
		}else if(!value.equals(userLogin.getValidateCode())){
			message = "验证码不正确";
			return "repassword";
		}
		Boolean reflag = userService.rePassword(userLogin); // 更改密码
		if(reflag) {
			return "login";
		}else {
			message = "更改密码失败";
			return "repassword";
		}
		
	}
	
	public String findRegisterResult() {
		System.out.println(registerTrack.toString());
        RedisUtil redisUtil = new RedisUtil();
        ShardedJedis shardedJedis = redisUtil.getPool();
        String value = shardedJedis.get(registerTrack.getPhonenumber());
        if(value == null) {
            message = "验证码过期";
            return "register";
        }else if(!value.equals(registerTrack.getValidateCode())){
            message = "验证码不正确";
            return "register";
        }
		Map<String, Object> registerMap = userService.searchRegisterResult(registerTrack);
		if(!registerMap.isEmpty()) {
			resultRegister = registerMap;
			messageReturn = "申请注册查询结果轨迹";
        }else {
			message = "申请注册查询出错";
        }
        return "resultregister";

    }
	
	public String toRegister() {
		return "register";
	}
	public String toRepassword() {
		return "repassword";
	}
	public String resultRegister() {
		return "resultregister";
	}
}
