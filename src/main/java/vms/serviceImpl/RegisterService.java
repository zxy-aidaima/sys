package vms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vms.dao.IRegisterDao;
import vms.entity.RegisterTrack;
import vms.service.IRegisterService;

@Service("registerService")
public class RegisterService implements IRegisterService {

	@Autowired(required=true)
	@Qualifier("registerDao")
	private IRegisterDao registerDao;
	
	@Override
	@Transactional  //使用声明式事物
	public Boolean save(RegisterTrack registerTrack) {
		return registerDao.saveRegister(registerTrack);
	}
	
	@Override
	@Transactional  //使用声明式事物
	public RegisterTrack find(RegisterTrack registerTrack) {
		return registerDao.findRegister(registerTrack);
	}

	@Override
	public Boolean update(RegisterTrack registerTrack) {
		return registerDao.updateRegister(registerTrack);
	}
	
}
