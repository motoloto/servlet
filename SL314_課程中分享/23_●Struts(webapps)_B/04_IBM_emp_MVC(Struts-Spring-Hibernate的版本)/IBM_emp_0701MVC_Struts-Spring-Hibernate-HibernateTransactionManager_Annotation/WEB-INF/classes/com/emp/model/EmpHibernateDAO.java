package com.emp.model;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Transactional(readOnly = true)
public class EmpHibernateDAO implements EmpDAO_interface {

	private static final String GET_ALL_STMT = "from EmpVO order by empno";

	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insert(EmpVO empVO) {
		hibernateTemplate.saveOrUpdate(empVO);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(EmpVO empVO) {
		hibernateTemplate.update(empVO);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Integer empno) {
		//EmpVO empVO = (EmpVO) hibernateTemplate.get(EmpVO.class, empno);
		EmpVO empVO = new EmpVO(); //�������h�����p���Y��A�A�R��
		empVO.setEmpno(empno);
		hibernateTemplate.delete(empVO);
	}

	@Override
	public EmpVO findByPrimaryKey(Integer empno) {
		EmpVO empVO = (EmpVO) hibernateTemplate.get(EmpVO.class, empno);
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = null;
		list = hibernateTemplate.find(GET_ALL_STMT);//�i�ʸˬd�߱���,�����ϥ�find��k.
		return list;
	}

	public static void main(String[] args) {

		//EmpHibernateDAO dao = new EmpHibernateDAO();
		//����K�@�����ε{��main�誺����,�ҥH���U��model-config1-DriverManagerDataSource.xml����dataSource�]�w�O�ĥ�org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
        
        // �إ�DAO����
		EmpDAO_interface dao =(EmpDAO_interface) context.getBean("empDAO");

		//�� �s�W
		com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // ����POJO
		deptVO.setDeptno(10);

//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("�d�ç�1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptVO(deptVO);
//		dao.insert(empVO1);



		//�� �ק�
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("�d�ç�2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptVO(deptVO);
//		dao.update(empVO2);



		//�� �R��(�p��cascade - �h��emp2.hbm.xml�p�G�]�� cascade="all"��
		// cascade="delete"�N�|�R���Ҧ��������-�]�A���ݳ����P�P�������䥦���u�N�|�@�ֳQ�R��)
//		dao.delete(7014);



		//�� �d��-findByPrimaryKey (�h��emp2.hbm.xml�����]��lazy="false")(�u!)
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		// �`�N�H�U�T�檺�g�k (�u!)
//		System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//		System.out.print(empVO3.getDeptVO().getDname() + ",");
//		System.out.print(empVO3.getDeptVO().getLoc());
//		System.out.println("\n---------------------");



		//�� �d��-getAll (�h��emp2.hbm.xml�����]��lazy="false")(�u!)
		List<EmpVO> list = dao.getAll();
		for (EmpVO aEmp : list) {
			System.out.print(aEmp.getEmpno() + ",");
			System.out.print(aEmp.getEname() + ",");
			System.out.print(aEmp.getJob() + ",");
			System.out.print(aEmp.getHiredate() + ",");
			System.out.print(aEmp.getSal() + ",");
			System.out.print(aEmp.getComm() + ",");
			// �`�N�H�U�T�檺�g�k (�u!)
			System.out.print(aEmp.getDeptVO().getDeptno() + ",");
			System.out.print(aEmp.getDeptVO().getDname() + ",");
			System.out.print(aEmp.getDeptVO().getLoc());
			System.out.println();
		}
	}
}
