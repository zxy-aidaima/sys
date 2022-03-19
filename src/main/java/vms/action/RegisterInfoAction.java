package vms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import vms.entity.CodeConf;
import vms.entity.RegisterInfo;
import vms.entity.RegisterTrack;
import vms.service.ICodeConfService;
import vms.service.IRegisterInfoService;
import vms.service.IRegisterService;
import vms.tool.RandomAccount;
import vms.util.TimeAndDate;

@Controller("registerInfoAction")
@Scope(value="prototype")
public class RegisterInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String message; 
//	private String messageReturn;
//	private Map<String, Object> session;
//	private Map<String, Object> resultRegister;
	private RegisterInfo registerInfoResult;
	private RegisterInfo registerInfo;
	private String registerid;
	private String roletype;
	
	public String getRegisterid() {
		return registerid;
	}
	public void setRegisterid(String registerid) {
		this.registerid = registerid;
	}
	public String getRoletype() {
		return roletype;
	}
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	public RegisterInfo getRegisterInfo() {
		return registerInfo;
	}
	public void setRegisterInfo(RegisterInfo registerInfo) {
		this.registerInfo = registerInfo;
	}
	public String getMessage() { 
	    return message; 
	} 
	public void setMessage(String message) { 
	    this.message = message; 
	}	
	public RegisterInfo getRegisterInfoResult() {
		return registerInfoResult;
	}
	public void setRegisterInfoResult(RegisterInfo registerInfoResult) {
		this.registerInfoResult = registerInfoResult;
	}

	@Autowired(required=true)
	@Qualifier("registerService")
	private IRegisterService registerService; 
	
	@Autowired(required=true)
	@Qualifier("codeConfService")
	private ICodeConfService codeConfService;
	
	@Autowired(required=true)
	@Qualifier("registerInfoService")
	private IRegisterInfoService registerInfoService;

	@SuppressWarnings("null")
	public String saveRegisterInfo(RegisterTrack registerTrack) {
		RegisterInfo reRegisterInfo = null;
		RegisterInfo returnRegisterInfo = null;
		Boolean reflag = false;
		String reCode = "";
		String provinceCode = "";
		String generatID = "";
		CodeConf codeConf = null;
		RegisterTrack reRegisterTrack = registerService.find(registerTrack);
		if(null == reRegisterTrack) {
			message = "";
			return "Error";
		}else {
			codeConf.setDescribe(reRegisterTrack.getRegisterprovince());
			reCode = codeConfService.findByname(codeConf);
			if("".equals(reCode)) {
				message = "";
				return "Error";
			}else {
				provinceCode = reCode.substring(0,2);
				if(null != provinceCode || !"".equals(provinceCode)) {
					do{
						generatID = RandomAccount.getGeneratID("A", provinceCode);
						returnRegisterInfo = registerInfoService.find(generatID,reRegisterTrack.getRoletype());
					}while(null != returnRegisterInfo);
				}
			}
			reRegisterInfo.setRegisterid(generatID);
			reRegisterInfo.setPhonenumber(reRegisterTrack.getPhonenumber());
			reRegisterInfo.setUname(reRegisterTrack.getUname());
			reRegisterInfo.setSex(reRegisterTrack.getSex());
			reRegisterInfo.setIdentifynumber(reRegisterTrack.getIdentifynumber());
			reRegisterInfo.setAge(reRegisterTrack.getAge());
			reRegisterInfo.setLiveprovince(reRegisterTrack.getLiveprovince());
			reRegisterInfo.setLivecity(reRegisterTrack.getLivecity());
			reRegisterInfo.setLivecounty(reRegisterTrack.getLivecounty());
			reRegisterInfo.setLivetownvillage(reRegisterTrack.getLivetownvillage());
			reRegisterInfo.setRegisterprovince(reRegisterTrack.getRegisterprovince());
			reRegisterInfo.setRegistercity(reRegisterTrack.getRegistercity());
			reRegisterInfo.setRegistecounty(reRegisterTrack.getRegistecounty());
			reRegisterInfo.setRegistertownvillage(reRegisterTrack.getRegistertownvillage());
			reRegisterInfo.setApprovename(reRegisterTrack.getApprovename());
			reRegisterInfo.setRegisterdate(TimeAndDate.getNowTimeDate());
			reRegisterInfo.setTypeflag("2");
			reRegisterInfo.setRoleType(reRegisterTrack.getRoletype());
			
			reflag = registerInfoService.save(reRegisterInfo);
			if(reflag) {
				message = "";
				return "Success";
			}else {
				message = "";
				return "Error";
			}
		}		
	}
	
	public String findRegisterInfoResult() {
		//System.out.println(registerInfo.getRegisterid());
		//if(null == registerInfo.getRegisterid()) {
		//	message = "登录过期请重新登录！";
		//	return "login";
		//}
		System.out.println("registerId:"+ registerid +"::::::::::roleType:" + roletype);
		RegisterInfo registerInfoRes = registerInfoService.find(registerid ,roletype); 
		if(null != registerInfoRes) {
			registerInfoResult = registerInfoRes;
			//message = "查询成功";
			return "registerInfoResult";
		}else {
			message = "查询失败";
			return "registerInfoResult";
		}
	}
	
	public String updateRegisterInfo() {
		boolean reflag = false;
		RegisterInfo registerInfoRes = registerInfoService.findByPK(registerInfo.getRegisterid()); 
		if(null != registerInfoRes) {
			registerInfoRes.setPhonenumber(registerInfo.getPhonenumber());
			registerInfoRes.setUname(registerInfo.getUname());
			registerInfoRes.setIdentifynumber(registerInfo.getIdentifynumber());
			registerInfoRes.setAge(registerInfo.getAge());
			reflag = registerInfoService.update(registerInfoRes);
		}
		if(reflag) {
			registerInfoResult = registerInfoRes;
			// message = "查询成功";
			return "registerInfoResult";
		}else {
			// message = "查询失败";
			return "registerInfoResult";
		}
	}
	
}
