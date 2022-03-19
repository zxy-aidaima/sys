package vms.dao;

import java.util.Map;

import vms.entity.RegisterTrack;
import vms.entity.UserLogin;

/**
 * @ClassName: UserDao
 * @Description: UserDao接口
 * @author: Mervyn
 * @Time: 2015年11月18日 下午5:27:55
 */
public interface IUserDao extends IBaseDao<UserLogin, Integer>{
	public UserLogin loginUser(UserLogin userLogin);

	public Boolean userRePassword(UserLogin userLogin);
	
	public Map<String, Object> findRegisterResult(RegisterTrack registerTrack);
	
}
