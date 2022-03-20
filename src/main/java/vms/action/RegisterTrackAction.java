package vms.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import redis.clients.jedis.ShardedJedis;
import vms.entity.RegisterTrack;
import vms.service.IRegisterService;
import vms.util.RedisUtil;
import vms.util.TimeAndDate;

@Controller("registerAction")
@Scope(value="prototype")
public class RegisterTrackAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//定义一个成员变量 
	private String message; 
	public String getMessage() { 
	    return message; 
	} 
	public void setMessage(String message) { 
	    this.message = message; 
	}
	
	public void setSession(Map<String, Object> session) {
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
	
	public String applyRegister() {
		System.out.println(registerTrack.toString());
		RedisUtil redisUtil = new RedisUtil();
		ShardedJedis shardedJedis = redisUtil.getPool();
		String value = shardedJedis.get(registerTrack.getPhonenumber());
		if(value == null) {
			message = "验证码过期";
			return "register";
		}
		Boolean reflag = registerService.save(registerTrack); // 注册
		if(reflag) {
			return "login";
		}else {
			message = "申请注册失败";
			return "register";
		}
	
	}
}
