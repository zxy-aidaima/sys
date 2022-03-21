package vms.service;

import java.util.Map;

import vms.entity.RegisterTrack;
import vms.entity.UserLogin;

/**
 * @ClassName: IUserService
 * @Description: 对UserService封装的接口，这里仅写一个save方法的接口，作为演示。项目中可添加实际的接口。
 * @author: Mervyn
 * @Time: 2015年11月20日 下午2:23:20
 */
public interface IUserService {
	/**
	 * @Title: save
	 * @Description: 保存用户
	 * @param: @param user
	 * @return: void
	 * @throws:
	 */
	void save(UserLogin userLogin);
	/**
	 * 根据用户查询用户登录信息
	 * 2020年12月25日
	 */
	UserLogin findUserLogin(UserLogin userLogin);
	
	Boolean rePassword(UserLogin userLogin);
	
	Map<String, Object> searchRegisterResult(RegisterTrack registerTrack);

}
