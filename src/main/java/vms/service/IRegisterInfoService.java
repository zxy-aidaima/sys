package vms.service;

import vms.entity.RegisterInfo;

public interface IRegisterInfoService {
	
	Boolean save(RegisterInfo registerInfo);
	Boolean update(RegisterInfo registerInfo);
	RegisterInfo find(String registerId, String roleType);
	RegisterInfo findByPK(String registerId);
	
}
