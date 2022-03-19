package vms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import vms.dao.IRegisterDao;
import vms.entity.RegisterTrack;

@Repository("registerDao")
public class RegisterDao extends BaseDao<RegisterTrack, Integer> implements IRegisterDao {
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

	@Override
	public Boolean saveRegister(RegisterTrack registerTrack) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		registerTrack.setTypeflag("0");
		try {
			session.save(registerTrack);
			transaction.commit();
			logger.info("用户注册申请成功[姓名-手机号]：[" + registerTrack.getUname() + "-" + registerTrack.getPhonenumber() + "]:[影响行数]-[1]");
			return true;
		}catch(Exception e) {
			transaction.rollback();
			logger.error("用户注册申请失败[姓名-手机号]：[" + registerTrack.getUname() + "-" + registerTrack.getPhonenumber() + "]", new RuntimeException(e.getMessage()));
			return false;
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public RegisterTrack findRegister(RegisterTrack registerTrack) {
		String hql = "from RegisterTrack where id =:id and typeflag= '0' ";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("id", registerTrack.getId());
		@SuppressWarnings("unchecked")
		List<RegisterTrack> reRegisterTrack = (List<RegisterTrack>) query.list();
		if (!reRegisterTrack.isEmpty() && reRegisterTrack.size() == 1) {
			logger.info("查询[ID-手机号]：[" + registerTrack.getId() + "-" + reRegisterTrack.get(0).getPhonenumber() + "]");
			return reRegisterTrack.get(0);
		} else {
			logger.info("查询[ID-手机号]：[" + registerTrack.getId() + "-无对应ID和手机号]");
			return null;
		}
	}

	@Override
	public Boolean updateRegister(RegisterTrack registerTrack) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		RegisterTrack reRegisterTrack = null;
		try {
			reRegisterTrack = (RegisterTrack) session.load(RegisterTrack.class, registerTrack.getId());// select语句
			reRegisterTrack.setTypeflag(registerTrack.getTypeflag());// update
			transaction.commit();
			logger.info("更新成功[ID-手机号]-[" + reRegisterTrack.getId() + "-" + reRegisterTrack.getPhonenumber() + "]:[影响行数]-[1]");
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				logger.error("更新失败[ID-手机号]：[" + registerTrack.getId() + "-" + registerTrack.getPhonenumber() + "]", new RuntimeException(e.getMessage()));
				return false;
			}				
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		logger.error("用户修改密码[ID]：[" + registerTrack.getId() +  "]-[无该ID信息]");
		return false;
	}


}
