package vms.dao;

import vms.entity.RegisterInfo;

public interface IRegisterInfoDao {
	public Boolean saveRegisterInfo(RegisterInfo registerInfo);
	public RegisterInfo findById(String registerId, String roleType);
	public RegisterInfo findByPK(String registerId);
	public Boolean updateRegisterInfo(RegisterInfo registerInfo);
}
