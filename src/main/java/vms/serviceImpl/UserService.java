package vms.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vms.dao.IUserDao;
import vms.entity.RegisterTrack;
import vms.entity.UserLogin;
import vms.service.IUserService;

/**
 * @ClassName: UserService
 * @Description: IUserService的具体的实现类，该类仅做一个简单的演示，实际中service中应该是业务逻辑的核心（复杂）
 * @author: Mervyn
 * @Time: 2015年11月20日 下午2:27:02
 */
@Service("userService")
public class UserService implements IUserService {
	/**
	 * @Filed userDao : 自动注入IUserDao接口的实现类
	 */
	@Autowired(required=true)
	@Qualifier("userDao")
	private IUserDao userDao;

	/*
	 *(非 Javadoc) 
	 * <p>Title: save</p> 
	 * <p>Description: 保存User类的对象</p> 
	 * @param user 
	 * @see vms.service.IUserService#save(vms.entity.UserLogin) 
	 */
	@Override
	@Transactional  //使用声明式事物
	public void save(UserLogin userLogin) {
		userDao.save(userLogin);
	}
	
	@Override
	@Transactional 
	public UserLogin findUserLogin(UserLogin userLogin) {
		return userDao.loginUser(userLogin);
	}
	
	@Override
	@Transactional 
	public Boolean rePassword(UserLogin userLogin) {
		return userDao.userRePassword(userLogin);
	}

	@Override
	@Transactional
	public Map<String, Object> searchRegisterResult(RegisterTrack registerTrack) {
		return userDao.findRegisterResult(registerTrack);
	}
	

}
