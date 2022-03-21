package vms.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import vms.dao.IUserDao;
import vms.entity.RegisterInfo;
import vms.entity.RegisterTrack;
import vms.entity.UserLogin;
import vms.util.Md5;

@Repository("userDao")
public class UserDao extends BaseDao<UserLogin, Integer> implements IUserDao {

	private SessionFactory sessionFactory;
	HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		if (hibernateTemplate == null) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
		return hibernateTemplate;
	}

	public boolean contains2(UserLogin userLogin) {
		// User不是数据库的表名是实体类的类名
		String hql = "from UserLogin where registerid = ? and upassword = ? and validflag= '1' ";
		System.out.println(hql);
		Object[] params = { userLogin.getRegisterid(), userLogin.getUpassword() };
		@SuppressWarnings("unchecked")
		List<UserLogin> userList = (List<UserLogin>) getHibernateTemplate().find(hql, params);
		if (!userList.isEmpty() && userList.size() == 1) {
			logger.info("登录用户[账号-用户名]：[" + userList.get(0).getRegisterid() + "-" + userList.get(0).getUname() + "]");
			return true;
		} else {
			return false;
		}
	}

	public UserLogin loginUser(UserLogin userLogin) {
		// User不是数据库的表名是实体类的类名
		String hql = "from UserLogin where registerid =:registerid and upassword =:upassword and validflag= '1' ";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("registerid", userLogin.getRegisterid());
		query.setParameter("upassword", Md5.string2MD5(userLogin.getUpassword()));
		@SuppressWarnings("unchecked")
		List<UserLogin> ruserLogin = (List<UserLogin>) query.list();
		if (!ruserLogin.isEmpty() && ruserLogin.size() == 1) {
			logger.info(
					"登录用户[账号-用户名]：[" + ruserLogin.get(0).getRegisterid() + "-" + ruserLogin.get(0).getUname() + "]");
			return ruserLogin.get(0);
		} else {
			logger.info("登录用户[账号-用户名]：[无该用户]");
			return null;
		}
	}

	@Override
	public Boolean userRePassword(UserLogin userLogin) {
		
//		String hql = "update UserLogin set upassword =:upassword where registerid =:registerid and phonenumber =:phonenumber and validflag= '1' ";
//		System.out.println(hql);
//		try {
//			Query query = getSession().createQuery(hql);
//			query.setParameter("registerid", userLogin.getRegisterid());
//			query.setString("upassword", Md5.string2MD5(userLogin.getUpassword()));
//			query.setString("phonenumber", userLogin.getPhonenumber());
//			int i = query.executeUpdate();
//			//int s = 9/0;
//			if (i == 1) {
//				transaction.commit();
//				logger.info("用户修改密码成功[账号-手机号]-[" + userLogin.getRegisterid() + "-" + userLogin.getPhonenumber() + "]:[影响行数]-[" + i + "]");
//				return true;
//			} else {
//				transaction.rollback();
//				logger.info("用户修改密码[手机号-账名]：[" + userLogin.getPhonenumber() + "]-[无该用户]:[" + userLogin.getRegisterid() + "]");
//				return false;
//			}
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//				logger.error("用户修改密码失败[账号-手机号]：[" + userLogin.getRegisterid() + "-" + userLogin.getPhonenumber() + "]", new RuntimeException(e.getMessage()));
//				//throw new RuntimeException(e.getMessage());
//				return false;
//			}
//			
//		} finally {
//			if (session != null && session.isOpen()) {
//				session.close();
//				
//			}
//		}
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from UserLogin where registerid =:registerid and phonenumber =:phonenumber and validflag= '1' ";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		query.setParameter("registerid", userLogin.getRegisterid());
		query.setParameter("phonenumber", userLogin.getPhonenumber());
		@SuppressWarnings("unchecked")
		List<UserLogin> ruserLogin = (List<UserLogin>) query.list();
		UserLogin reUserLogin = null;
		if (!ruserLogin.isEmpty() && ruserLogin.size() == 1) {
			try {
				reUserLogin = (UserLogin) session.load(UserLogin.class, ruserLogin.get(0).getRegisterid());// select语句
				reUserLogin.setUpassword(Md5.string2MD5(userLogin.getUpassword()));// update
				transaction.commit();
				logger.info("用户修改密码成功[账号-手机号]-[" + reUserLogin.getRegisterid() + "-" + reUserLogin.getPhonenumber() + "]:[影响行数]-[1]");
				return true;
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
					logger.error("用户修改密码失败[账号-手机号]：[" + reUserLogin.getRegisterid() + "-" + reUserLogin.getPhonenumber() + "]", new RuntimeException(e.getMessage()));
					return false;
				}				
				
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		} else {
			logger.error("用户修改密码[手机号-账名]：[" + userLogin.getPhonenumber() + "-" + userLogin.getRegisterid() + "]-[无该用户]");
			return false;
		}
		return false;
	}

//	@SuppressWarnings("unchecked")
//	public List<UserLogin> findByName(String phonenumber) {
//		return (List<UserLogin>)getHibernateTemplate().execute(new HibernateCallback<UserLogin>() {
//			public UserLogin doInHibernate(Session session) throws HibernateException {
//				List<UserLogin> result = session.createCriteria(UserLogin.class).add(Restrictions.eq("phonenumber", phonenumber)).list();
//				return (UserLogin) result;
//			}
//		});
//	}
	public Map<String, Object> findRegisterResult(RegisterTrack registerTrack) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> noneApprove = new ArrayList<String>(); // 未审核
		List<String> noPass = new ArrayList<String>(); // 未通过
		List<String> pass = new ArrayList<String>(); // 已通过
		String hql = "from RegisterTrack where phonenumber =:phonenumber and typeflag <>'3' order by returndate desc";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("phonenumber", registerTrack.getPhonenumber());
		@SuppressWarnings("unchecked")
		List<RegisterTrack> registerTrackList = (List<RegisterTrack>) query.list();
		if (!registerTrackList.isEmpty() && registerTrackList.size() != 0) {
			Iterator<RegisterTrack> iter = registerTrackList.iterator();
			while(iter.hasNext()){
				RegisterTrack resultRegisterTrack = (RegisterTrack) iter.next();
				if("0".equals(resultRegisterTrack.getTypeflag())) {
					String text0 = "您的手机号码" + resultRegisterTrack.getPhonenumber() + "提交的申请尚未审核，请等待审核。";
					noneApprove.add(text0);
				}
				if("1".equals(resultRegisterTrack.getTypeflag())) {
					String text1 = "审核人" + resultRegisterTrack.getApprovename() + "在" + resultRegisterTrack.getReturndate() + "审核了您提交的申请。结果：未通过。原因：" + resultRegisterTrack.getReturnreason();
					noPass.add(text1);
				}
				if("2".equals(resultRegisterTrack.getTypeflag())) {
					String hqlinfo = "from RegisterInfo where phonenumber =:phonenumber and typeflag ='2' ";
					System.out.println(hqlinfo);
					Query queryInfo = getSession().createQuery(hqlinfo);
					queryInfo.setParameter("phonenumber", resultRegisterTrack.getPhonenumber());
					RegisterInfo registerTrackInfo =  (RegisterInfo) queryInfo.list().get(0);
					if(null != registerTrackInfo) {
						String text2 = "审核人" + registerTrackInfo.getApprovename() + "在" + registerTrackInfo.getRegisterdate() + "审核了您提交的申请。结果：通过。您的账号：" + registerTrackInfo.getRegisterid() + "默认密码：1234。请及时前往登陆页更改密码。";
						pass.add(text2);
					}else {
						logger.info("用户[手机号]：[" + registerTrackList.get(0).getPhonenumber() + "]:[不存在]");
					}
				}
			}
			
			resultMap.put("未审核", noneApprove);
			resultMap.put("未通过", noPass);
			resultMap.put("已通过", pass);
			return resultMap;
		} else {
			logger.info("登录用户[账号-用户名]：[无该用户]");
			return null;
		}
	}

}
