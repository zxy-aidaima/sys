package vms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vms.dao.ICodeConfDao;
import vms.entity.CodeConf;
import vms.service.ICodeConfService;

@Service("codeConfService")
public class CodeConfService implements ICodeConfService{
	@Autowired(required=true)
	@Qualifier("codeConfDao")
	private ICodeConfDao codeConfDao;
	
	@Override
	@Transactional  //使用声明式事物
	public String findByname(CodeConf codeConf) {
		return codeConfDao.findCode(codeConf);
	}
}
