package com.dept.view;

//Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
//Servlet imports
import javax.servlet.http.HttpServletRequest;

public class DeptnoForm extends ActionForm {

	private String deptno;	

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			// �o�����g�J��ڻݭn���ҥ~�B�z
		}
		super.reset(mapping, request);

	}

	// ��Ʈ榡�P����ʪ��ˬd
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		//�ثe�ٲ���
		
		return errors;
	}
}
