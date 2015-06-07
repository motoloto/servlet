package com.dept.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Struts classes
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.dept.model.DeptService;
import com.dept.model.DeptVO;
//import com.dept.view.DeptForm;
import com.dept.view.DeptnoForm;
import com.emp.model.EmpVO;

public class DeptManagementAction extends DispatchAction {
	
	// 來自select_page.jsp的請求
	public ActionForward listEmps_ByDeptno_A(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			DeptnoForm deptnoForm = (DeptnoForm) form;
			Integer deptno = new Integer(deptnoForm.getDeptno());
			// Perform business logic
			DeptService deptSvc = new DeptService();
			Set<EmpVO> set = deptSvc.getEmpsByDeptno(deptno);
			if (set == null) {
				throw new RuntimeException("查無資料");
			}
			// Store the empVO in the request-scope
			request.setAttribute("listEmps_ByDeptno", set);

			// Send the Success view
			return mapping.findForward("success");

			// Handle any unusual exceptions
		} catch (Exception e) {
			// 其它錯誤(或者企業邏輯處理)的錯誤
			// Log stack trace
			e.printStackTrace(System.err);
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpectedError", e.getMessage()));
			saveMessages(request, messages);
			// and forward to the error handling page (the form itself)
			return mapping.findForward("error");

		}
	}
	
	
	// 來自/dept/listAllDept.jsp的請求
	public ActionForward listEmps_ByDeptno_B(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			DeptnoForm deptnoForm = (DeptnoForm) form;
			Integer deptno = new Integer(deptnoForm.getDeptno());
			// Perform business logic
			DeptService deptSvc = new DeptService();
			Set<EmpVO> set = deptSvc.getEmpsByDeptno(deptno);
			if (set == null) {
				throw new RuntimeException("查無資料");
			}
			// Store the empVO in the request-scope
			request.setAttribute("listEmps_ByDeptno", set);

			// Send the Success view
			return mapping.findForward("success");

			// Handle any unusual exceptions
		} catch (Exception e) {
			// 其它錯誤(或者企業邏輯處理)的錯誤
			// Log stack trace
			e.printStackTrace(System.err);
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpectedError", e.getMessage()));
			saveMessages(request, messages);
			// and forward to the error handling page (the form itself)
			return mapping.findForward("error");

		}
	}
	
	
	//來自/dept/listAllDept.jsp的請求
	public ActionForward delete_Dept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			DeptnoForm deptnoForm = (DeptnoForm) form;
			Integer deptno = new Integer(deptnoForm.getDeptno());
			// Perform business logic
			DeptService deptSvc = new DeptService();
			deptSvc.deleteDept(deptno);
			// Send the Success view
			return mapping.findForward("success");
	
			// Handle any unusual exceptions
		} catch (RuntimeException e) {
			//其它錯誤(或者企業邏輯處理)的錯誤
			// Log stack trace
			e.printStackTrace(System.err);
	
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpectedError", e.getMessage()));
			saveMessages(request, messages);
			// and forward to the error handling page (the form itself)
			return mapping.findForward("error");
	
		} 
	}

}
