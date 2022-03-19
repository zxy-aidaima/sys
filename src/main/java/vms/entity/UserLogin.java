package vms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName: UserLogin
 * @Description: 测试实体类User
 * @author: Mervyn
 * @Time: 2015年11月18日 下午2:19:32
 */
@Entity // 将一个类声明为一个实体bean
@Table(name = "userlogin") // name -可选，表示表的名称，默认情况下，表名与实体名称一致，只有在不一致的情况下，需要指定表名
public class UserLogin extends Login implements Serializable {

	/**
	 * @Filed serialVersionUID : 用来标明当前class的版本号
	 */
	private static final long serialVersionUID = 1L;

	private String registerid;
	private String uname;
	private String phonenumber;
	private String upassword;
	private String loginflag;
	private String lasttime;
	private String roletype;
	private String validflag;

	@Id
	@GeneratedValue(generator = "userGenerator")
	@GenericGenerator(name = "userGenerator", strategy = "native")
	public String getRegisterid() {
		return registerid;
	}

	public void setRegisterid(String registerid) {
		this.registerid = registerid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getLoginflag() {
		return loginflag;
	}

	public void setLoginflag(String loginflag) {
		this.loginflag = loginflag;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public String getValidflag() {
		return validflag;
	}

	public void setValidflag(String validflag) {
		this.validflag = validflag;
	}
	
	@Override
	public String toString() {
		return "UserLogin [registerid=" + registerid + ", uname=" + uname + ", phonenumber=" + phonenumber + ", upassword="
				+ upassword + ", loginflag=" + loginflag + ", lasttime=" + lasttime + ", roletype=" + roletype
				+ ", validflag=" + validflag + "]";
	}

}
