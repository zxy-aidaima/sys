package vms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import vms.dao.ICodeConfDao;
import vms.entity.CodeConf;

@Repository("codeConfDao")
public class CodeConfDao extends BaseDao<CodeConf, Integer> implements ICodeConfDao {

	@Override
	public String findCode(CodeConf codeConf) {
		String hql = "from CodeConf where describe =:describe and state= '1' ";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		query.setParameter("registerid", codeConf.getDescribe());
		@SuppressWarnings("unchecked")
		List<CodeConf> reCodeConf = (List<CodeConf>) query.list();
		if (!reCodeConf.isEmpty() && reCodeConf.size() == 1) {
			logger.info("查询[名称-编码值]：[" + codeConf.getDescribe() + "-" + reCodeConf.get(0).getCode() + "]");
			return reCodeConf.get(0).getCode();
		} else {
			logger.info("查询[名称-编码值]：[无对应码值，或码值无效]");
			return "";
		}
	}

}
