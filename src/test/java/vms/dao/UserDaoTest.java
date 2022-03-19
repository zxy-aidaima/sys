package vms.dao;


import org.junit.Test;

import vms.util.BaseTransactionalTest;


/**
 * @ClassName: UserDaoTest
 * @Description: 测试IUserDao的实现类UserDao
 * @author: Mervyn
 * @Time: 2015年11月20日 下午3:22:21
 */
public class UserDaoTest extends BaseTransactionalTest{

//	@Test
//	public void testSave(){
//		UserLogin user = new UserLogin();
//		user.setUsername("admin");
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		userDao.save(user);
//		logger.debug("UserDao的void save(UserLogin entity)方法正确。");
//	}
	
//	@Test
//	public void testFindById(){
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		UserLogin user = userDao.findById(3);
//		Assert.notNull(user, "UserDao的findById()错误！");
//		logger.debug("UserDao的User findById(Integer id)方法正确。");
//	}
	
//	@Test
//	public void testUpdate(){
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		UserLogin user = userDao.findById(3);
//		user.setUsername("test");
//		userDao.update(user);
//		logger.debug("UserDao的void update(UserLogin entity)方法正确。");
//	}
	
//	@Test
//	public void testDelete(){
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		UserLogin user = userDao.findById(3);
//		userDao.delete(user);
//		logger.debug("UserDao的void delete(UserLogin entity)方法正确。");
//	}
//	
//	@Test
//	public void testDeleteById(){
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		userDao.deleteById(3);
//		logger.debug("UserDao的delete(Integer id)方法正确。");
//	}
//	
//	@Test
//	public void testDeleteAll(){
//		String hqlString = "FROM UserLogin user";
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		List<UserLogin> userList = userDao.findListByHQL(hqlString);
//		
//		userDao.deleteAll(userList);
//		logger.debug("UserDao的void deleteAll(Collection<UserLogin> entities)方法正确。");
//		
//	}
//	
//	@Test
//	public void testConstains(){
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		UserLogin user = userDao.findById(3);
//		Boolean result = userDao.contains(user);
//		Assert.isTrue(result, "该user不存在！");
//		logger.debug("UserDao的Boolean contains(UserLogin entity)方法正确。");
//	}
//	
	@Test
	public void testFindByHQL(){
		String hqlString = "FROM UserLogin user WHERE user.id = ?";
		IUserDao userDao = (IUserDao) this.getBean("userDao");
		userDao.findByHQL(hqlString, 3);
		logger.debug("UserDao的User findByHQL(String hqlString,Object... values)方法正确。");
	}
//	
//	@Test
//	public void testFindListByHQL(){
//		String hqlString = "FROM UserLogin user";
//		IUserDao userDao = (IUserDao) this.getBean("userDao");
//		userDao.findListByHQL(hqlString);
//		logger.debug("UserDao的List<UserLogin> findListByHQL(String hqlString,Object...values)方法正确。");
//	}
//	
}
