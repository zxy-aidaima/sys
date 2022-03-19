package vms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vms.dao.IRegisterInfoDao;
import vms.entity.RegisterInfo;
import vms.service.IRegisterInfoService;

@Service("registerInfoService")
public class RegisterInfoService implements IRegisterInfoService{

	@Autowired(required=true)
	@Qualifier("registerInfoDao")
	private IRegisterInfoDao registerInfoDao;
	
	@Override
	public Boolean save(RegisterInfo registerInfo) {
		return registerInfoDao.saveRegisterInfo(registerInfo);
	}

	@Override
	public RegisterInfo find(String registerId, String roleType) {
		return registerInfoDao.findById(registerId, roleType);
	}

	@Override
	public RegisterInfo findByPK(String registerId) {
		return registerInfoDao.findByPK(registerId);
	}

	@Override
	public Boolean update(RegisterInfo registerInfo) {
		return registerInfoDao.updateRegisterInfo(registerInfo);
	}
	
}
