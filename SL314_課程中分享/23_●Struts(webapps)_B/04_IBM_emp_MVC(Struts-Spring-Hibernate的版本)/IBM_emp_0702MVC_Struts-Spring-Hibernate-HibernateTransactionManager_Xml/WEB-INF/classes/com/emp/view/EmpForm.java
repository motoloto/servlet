package com.emp.view;

//Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
//Servlet imports
import javax.servlet.http.HttpServletRequest;

public class EmpForm extends ActionForm {
	private String empno;
	private String ename;
	private String job;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;

	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			// 這裡應寫入實際需要的例外處理
		}
		super.reset(mapping, request);

	}

	// 資料格式與完整性的檢查
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		try {
			java.sql.Date.valueOf(hiredate);
		} catch (IllegalArgumentException e) {
			errors.add("hiredate", new ActionMessage("error.hiredate.required", "Hiredate"));
		}

		try {
			Double.parseDouble(sal);
		} catch (NumberFormatException e) {
			errors.add("sal", new ActionMessage("error.sal.type", "Salary"));
		}

		try {
			Double.parseDouble(comm);
		} catch (NumberFormatException nfe) {
			errors.add("comm", new ActionMessage("error.comm.type",	"Commmision"));
		}

		return errors;
	}
}
