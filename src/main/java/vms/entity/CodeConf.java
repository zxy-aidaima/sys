package vms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class CodeConf implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id; // 自增主键
	private String code; // 码值
	private String describe; // 描述
	private String codename; // 码名
	private String state; // 状态(0-无效,1-有效)
	private Date datetime; // 创建时间
	private String remark; // 备注
	@Id
	@GeneratedValue(generator = "codeConfGenerator") // 自增填充主键
	@GenericGenerator(name = "codeConfGenerator", strategy = "native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCodename() {
		return codename;
	}
	public void setCodename(String codename) {
		this.codename = codename;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "CodeConf [id=" + id + ", code=" + code + ", describe=" + describe + ", codename=" + codename
				+ ", state=" + state + ", datetime=" + datetime + ", remark=" + remark + "]";
	}
	
}
