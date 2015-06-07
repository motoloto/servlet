package com.emp.view;

//Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
//Servlet imports
import javax.servlet.http.HttpServletRequest;

public class EmpnoForm extends ActionForm {

	private String empno;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
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

		if ((empno == null) || (empno.length() == 0)) {
			errors.add("empno", new ActionMessage("error.empno.required","EMPNO-"));
		} else {
			try {
				new Integer(empno);
			} catch (NumberFormatException e) {
				errors.add("empno", new ActionMessage("error.empno.type","EMPNO-"));
			}
		}
		return errors;
	}
}
