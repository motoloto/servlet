package com.dept.model;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emp.model.EmpVO;

@Transactional(readOnly = true)
public class DeptHibernateDAO implements DeptDAO_interface {
	
	private static final String GET_ALL_STMT = "from DeptVO order by deptno";
	
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insert(DeptVO deptVO) {
		hibernateTemplate.saveOrUpdate(deptVO);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(DeptVO deptVO) {
		hibernateTemplate.update(deptVO);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Integer deptno) {
		DeptVO deptVO = (DeptVO) hibernateTemplate.get(DeptVO.class, deptno);
		hibernateTemplate.delete(deptVO);
	}

	@Override
	public DeptVO findByPrimaryKey(Integer deptno) {
		DeptVO deptVO = (DeptVO) hibernateTemplate.get(DeptVO.class, deptno);
		return deptVO;
	}

	@Override
	public List<DeptVO> getAll() {
		List<DeptVO> list = null;
		list = hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	@Override
	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {		
		Set<EmpVO>	set = findByPrimaryKey(deptno).getEmps();
		return set;
	}

	public static void main(String[] args) {

		//DeptHibernateDAO dao = new DeptHibernateDAO();
		//����K�@�����ε{��main�誺����,�ҥH���U��model-config1-DriverManagerDataSource.xml����dataSource�]�w�O�ĥ�org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		
		// �إ�DAO����
		DeptDAO_interface dao =(DeptDAO_interface) context.getBean("deptDAO");

		//�� �s�W-1(�@��dept2.hbm.xml������cascade="save-update" ��cascade="all"���]�w)(���M�j�j,���L��ȤW�ä��`��)(��,�i�Φb�q��D�ɻP�����ɤ@���s�W���\)
//		DeptVO deptVO = new DeptVO(); // ����POJO
//		Set<EmpVO> set = new HashSet<EmpVO>();// �ǳƸm�J���u�ƤH,�H�Kcascade="save-update"������
//
//		EmpVO empXX = new EmpVO();   // ���uPOJO1
//		empXX.setEname("�d15");
//		empXX.setJob("MANAGER15");
//		empXX.setHiredate(java.sql.Date.valueOf("2001-01-15"));
//		empXX.setSal(new Double(15000));
//		empXX.setComm(new Double(150));
//		empXX.setDeptVO(deptVO);
//
//		EmpVO empYY = new EmpVO();   // ���uPOJO2
//		empYY.setEname("�d16");
//		empYY.setJob("MANAGER16");
//		empYY.setHiredate(java.sql.Date.valueOf("2001-01-16"));
//		empYY.setSal(new Double(16000));
//		empYY.setComm(new Double(160));
//		empYY.setDeptVO(deptVO);
//
//		set.add(empXX);
//		set.add(empYY);
//
//		deptVO.setDname("�s�y��");
//		deptVO.setLoc("���ꦿ��");
//		deptVO.setEmps(set);
//		dao.insert(deptVO);



		//�� �ק�-1(�@��dept2.hbm.xml������cascade="save-update" �� cascade="all"���]�w)(���M�j�j,���L��ȤW�ä��`��)(��,�i�����p�ϥΤ�)
//		DeptVO deptVO = new DeptVO(); // ����POJO
//		Set<EmpVO> set = new HashSet<EmpVO>(); // �ǳƸm�J���u�ƤH,�H�Kcascade="save-update"������
//
//		EmpVO empXX = new EmpVO(); // ���uPOJO1
//		empXX.setEmpno(7015); // �i�p�G�W�[ empXX.setEmpno(7015); �h�ܦ�update�j
//		empXX.setEname("�d��15");
//		empXX.setJob("MANAGER15");
//		empXX.setHiredate(java.sql.Date.valueOf("2001-01-15"));
//		empXX.setSal(new Double(15555));
//		empXX.setComm(new Double(155));
//		empXX.setDeptVO(deptVO);
//
//		EmpVO empYY = new EmpVO(); // ���uPOJO2
//		empYY.setEmpno(7016); // �i�p�G�W�[ empXX.setEmpno(7016); �h�ܦ�update�j
//		empYY.setEname("�d��16");
//		empYY.setJob("MANAGER16");
//		empYY.setHiredate(java.sql.Date.valueOf("2001-01-16"));
//		empYY.setSal(new Double(16666));
//		empYY.setComm(new Double(166));
//		empYY.setDeptVO(deptVO);
//
//		set.add(empXX);
//		set.add(empYY);
//
//		deptVO.setDeptno(50); // �i�p�G�W�[deptVO.setDeptno(50); �h�ܦ�update�j
//		deptVO.setDname("�s�y��1");
//		deptVO.setLoc("���ꦿ��1");
//		deptVO.setEmps(set);
//		dao.update(deptVO);



		//�� �ק�-2(���ݳ]�wcascade="save-update" �� cascade="all")(�o�O�g�`�n�Ψ쪺�@��ק�)
//		DeptVO deptVO2 = new DeptVO(); // ����POJO
//		deptVO2.setDeptno(50); // �i�p�G�W�[deptVO.setDeptno(50); �h�ܦ�update�j
//		deptVO2.setDname("�s�y��2");
//		deptVO2.setLoc("���ꦿ��2");
//		dao.update(deptVO2);



		//���R�� (�W�űj�j!�p�ߨϥ�!)(�@��dept2.hbm.xml������cascade="delete" �� cascade="all"���]�w, �A�[�Winverse="true"�]�w)
//		dao.delete(50);



		//�� �s�W-2(���ݭncascade="save-update" �� cascade="all"���]�w)(�o�O�g�`�n�Ψ쪺�@��s�W)
//		DeptVO deptVO = new DeptVO(); // ����POJO
//		deptVO.setDname("�s�y��s");
//		deptVO.setLoc("���ꦿ��s");
//		dao.insert(deptVO);



		//�� �d��-findByPrimaryKey (�u�q!) (�@��dept2.hbm.xml�����]��lazy="false")
//		DeptVO deptVO3 = dao.findByPrimaryKey(30);
//		System.out.print(deptVO3.getDeptno() + ",");
//		System.out.print(deptVO3.getDname() + ",");
//		System.out.print(deptVO3.getLoc());
//		System.out.println("\n-----------------");
//		Set<EmpVO> set3 = deptVO3.getEmps();
//		for (EmpVO aEmp : set3) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//			System.out.print(aEmp.getDeptVO().getDname() + ",");
//			System.out.print(aEmp.getDeptVO().getLoc());
//			System.out.println();
//		}



		//�� �d��-getAll-1 (�@��dept2.hbm.xml���γ]��lazy="false",�]���S�Ψ�h�誺����)
//		List<DeptVO> list1 = dao.getAll();
//		for (DeptVO aDept : list1) {
//			System.out.print(aDept.getDeptno() + ",");
//			System.out.print(aDept.getDname() + ",");
//			System.out.print(aDept.getLoc());
//			System.out.println();
//		}



		//�� �d��-getAll-2 (�u�q!!!) (�@��dept2.hbm.xml�����]��lazy="false")
		List<DeptVO> list2 = dao.getAll();
		for (DeptVO aDept : list2) {
			System.out.print(aDept.getDeptno() + ",");
			System.out.print(aDept.getDname() + ",");
			System.out.print(aDept.getLoc());
			System.out.println("\n-----------------");
			Set<EmpVO> set2 = aDept.getEmps();
			for (EmpVO aEmp : set2) {
				System.out.print(aEmp.getEmpno() + ",");
				System.out.print(aEmp.getEname() + ",");
				System.out.print(aEmp.getJob() + ",");
				System.out.print(aEmp.getHiredate() + ",");
				System.out.print(aEmp.getSal() + ",");
				System.out.print(aEmp.getComm() + ",");
				System.out.print(aEmp.getDeptVO().getDeptno() + ",");
				System.out.print(aEmp.getDeptVO().getDname() + ",");
				System.out.print(aEmp.getDeptVO().getLoc());
				System.out.println();
			}
			System.out.println();
		}

	}
}
