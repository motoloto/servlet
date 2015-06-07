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
			// 這裡應寫入實際需要的例外處理
		}
		super.reset(mapping, request);

	}

	// 資料格式與完整性的檢查
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		//目前省略之
		
		return errors;
	}
}
