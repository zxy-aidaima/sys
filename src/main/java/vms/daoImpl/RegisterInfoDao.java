package vms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vms.dao.IRegisterInfoDao;
import vms.entity.RegisterInfo;


@Repository("registerInfoDao")
public class RegisterInfoDao extends BaseDao<RegisterInfo, Integer> implements IRegisterInfoDao{
	
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
	
	@Transactional(readOnly = true)
	@Override
	public Boolean saveRegisterInfo(RegisterInfo registerInfo) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(registerInfo);
			transaction.commit();
			logger.info("用户注册信息添加成功[姓名-手机号]：[" + registerInfo.getUname() + "-" + registerInfo.getPhonenumber() + "]:[影响行数]-[1]");
			return true;
		}catch(Exception e) {
			transaction.rollback();
			logger.error("用户注册信息添加失败[姓名-手机号]：[" + registerInfo.getUname() + "-" + registerInfo.getPhonenumber() + "]", new RuntimeException(e.getMessage()));
			return false;
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public RegisterInfo findById(String registerId, String roleType) {
		String hql = "from RegisterInfo where registerid =:registerid and roletype =:roletype and typeflag = '2' ";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("registerid", registerId);
		query.setParameter("roletype", roleType);
		@SuppressWarnings("unchecked")
		List<RegisterInfo> reRegisterInfoList = (List<RegisterInfo>) query.list();
		if (!reRegisterInfoList.isEmpty() && reRegisterInfoList.size() == 1) {
			logger.info("用户信息[账号-用户名]：[" + reRegisterInfoList.get(0).getRegisterid() + "-" + reRegisterInfoList.get(0).getUname() + "]");
			return reRegisterInfoList.get(0);
		} else {
			logger.info("用户信息[账号-用户名]：[无该用户]");
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public RegisterInfo findByPK(String registerId) {
		String hql = "from RegisterInfo where registerid =:registerid and typeflag = '2' ";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("registerid", registerId);
		@SuppressWarnings("unchecked")
		List<RegisterInfo> reRegisterInfoList = (List<RegisterInfo>) query.list();
		if (!reRegisterInfoList.isEmpty() && reRegisterInfoList.size() == 1) {
			logger.info("用户信息[账号-用户名]：[" + reRegisterInfoList.get(0).getRegisterid() + "-" + reRegisterInfoList.get(0).getUname() + "]");
			return reRegisterInfoList.get(0);
		} else {
			logger.info("用户信息[账号-用户名]：[无该用户]");
			return null;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Boolean updateRegisterInfo(RegisterInfo registerInfo) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(registerInfo);
			transaction.commit();
			logger.info("用户注册信息更新成功[姓名-手机号]：[" + registerInfo.getUname() + "-" + registerInfo.getPhonenumber() + "]:[影响行数]-[1]");
			return true;
		}catch(Exception e) {
			transaction.rollback();
			logger.error("用户注册信息更新失败[姓名-手机号]：[" + registerInfo.getUname() + "-" + registerInfo.getPhonenumber() + "]", new RuntimeException(e.getMessage()));
			return false;
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
}
