package com.dept.model;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emp.model.EmpVO;

public class DeptService {

	private DeptDAO_interface dao;

	public DeptService() {
		//dao = new DeptHibernateDAO();
		//��1: ���Mmodel-config1-DriverManagerDataSource.xml�]�i�H��
		//��2: �����F�ϥγs�u��,�H�����į�,�ҥH���U��model-config2-JndiObjectFactoryBean.xml����dataSource�]�w�O�ĥ�org.springframework.jndi.JndiObjectFactoryBean
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		dao =(DeptDAO_interface) context.getBean("deptDAO");
	}

	public List<DeptVO> getAll() {
		return dao.getAll();
	}

	public DeptVO getOneDept(Integer deptno) {
		return dao.findByPrimaryKey(deptno);
	}

	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
		return dao.getEmpsByDeptno(deptno);
	}

	public void deleteDept(Integer deptno) {
		dao.delete(deptno);
	}
	
	public DeptVO addDept(String dname, String loc) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDname(dname);
		deptVO.setLoc(loc);
		dao.insert(deptVO);
		return deptVO;
	}

	public DeptVO updateEmp(Integer deptno, String dname, String loc) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptno(deptno);
		deptVO.setDname(dname);
		deptVO.setLoc(loc);
		dao.update(deptVO);
		return deptVO;
	}
}
