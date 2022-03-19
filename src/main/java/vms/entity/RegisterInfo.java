package vms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "registerinfo")
public class RegisterInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String registerid; // 注册账号
	private String phonenumber; // 手机号码
	private String uname; // 用户姓名
	private String sex; // 性别
	private String identifynumber; // 身份证号
	private int age; // 年龄
	private String liveprovince; // 居住省
	private String livecity; // 居住市
	private String livecounty; // 居住县
	private String livetownvillage; // 居住详细地址
	private String registerprovince; // 注册省
	private String registercity; // 注册市
	private String registecounty; // 注册县
	private String registertownvillage; // 注册详细地址
	private String approvename; // 审核人
	private Date registerdate; // 注册时间
	private String typeflag; // 状态(未审核-0,审核不通过-1,审核通过-2,无效数据-3)
	private String roleType; // 角色类型(管理员-0,志愿者-1,用户-2)
	
	@Id
	@GenericGenerator(name = "registerinfoGenerator", strategy = "native")
	public String getRegisterid() {
		return registerid;
	}
	public void setRegisterid(String registerid) {
		this.registerid = registerid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLiveprovince() {
		return liveprovince;
	}
	public void setLiveprovince(String liveprovince) {
		this.liveprovince = liveprovince;
	}
	public String getLivecity() {
		return livecity;
	}
	public void setLivecity(String livecity) {
		this.livecity = livecity;
	}
	public String getLivecounty() {
		return livecounty;
	}
	public void setLivecounty(String livecounty) {
		this.livecounty = livecounty;
	}
	public String getLivetownvillage() {
		return livetownvillage;
	}
	public void setLivetownvillage(String livetownvillage) {
		this.livetownvillage = livetownvillage;
	}
	public String getRegisterprovince() {
		return registerprovince;
	}
	public void setRegisterprovince(String registerprovince) {
		this.registerprovince = registerprovince;
	}
	public String getRegistercity() {
		return registercity;
	}
	public void setRegistercity(String registercity) {
		this.registercity = registercity;
	}
	public String getRegistecounty() {
		return registecounty;
	}
	public void setRegistecounty(String registecounty) {
		this.registecounty = registecounty;
	}
	public String getRegistertownvillage() {
		return registertownvillage;
	}
	public void setRegistertownvillage(String registertownvillage) {
		this.registertownvillage = registertownvillage;
	}
	public String getApprovename() {
		return approvename;
	}
	public void setApprovename(String approvename) {
		this.approvename = approvename;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date date) {
		this.registerdate = date;
	}
	public String getTypeflag() {
		return typeflag;
	}
	public void setTypeflag(String typeflag) {
		this.typeflag = typeflag;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	@Override
	public String toString() {
		return "RegisterInfo [registerid=" + registerid + ", phonenumber=" + phonenumber + ", uname=" + uname + ", sex="
				+ sex + ", identifynumber=" + identifynumber + ", age=" + age + ", liveprovince=" + liveprovince
				+ ", livecity=" + livecity + ", livecounty=" + livecounty + ", livetownvillage=" + livetownvillage
				+ ", registerprovince=" + registerprovince + ", registercity=" + registercity + ", registecounty="
				+ registecounty + ", registertownvillage=" + registertownvillage + ", approvename=" + approvename
				+ ", registerdate=" + registerdate + ", typeflag=" + typeflag + ", roleType=" + roleType + "]";
	}
	
}
