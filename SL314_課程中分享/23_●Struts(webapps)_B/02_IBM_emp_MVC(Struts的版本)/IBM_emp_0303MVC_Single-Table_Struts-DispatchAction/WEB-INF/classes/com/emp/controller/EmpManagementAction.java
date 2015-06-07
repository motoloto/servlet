package com.emp.controller;

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

import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.emp.view.EmpForm;
import com.emp.view.EmpnoForm;

public class EmpManagementAction extends DispatchAction {

	public ActionForward getOne_For_Display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm myForm = (EmpnoForm) form;
			Integer empno = new Integer(myForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(empno);
			if (empVO == null) {
				throw new RuntimeException("查無資料");
			}
			// Store the empVO in the request-scope
			request.setAttribute("empForm", empVO);

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
	
	public ActionForward getOne_For_Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm myForm = (EmpnoForm) form;
			Integer empno = new Integer(myForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(empno);
			if (empVO == null) {
				throw new RuntimeException("查無資料");
			}
			// Store the empVO in the request-scope
			request.setAttribute("empForm", empVO);
	
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

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			EmpForm myForm = (EmpForm) form;
			EmpVO empVO = new EmpVO();
			BeanUtils.copyProperties(empVO, myForm);
			// Perform business logic
			EmpService empSvc = new EmpService();
			empVO = empSvc.updateEmp(empVO.getEmpno(), empVO.getEname(), empVO.getJob(),
					empVO.getHiredate(), empVO.getSal(), empVO.getComm(),
					empVO.getDeptno());
			// Store the new empVO in the request-scope
			request.setAttribute("empVO", empVO);
			
			// Send the Success view
			return mapping.findForward("success");
	
			// Handle any unusual exceptions
		} catch (Exception e) {
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

	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			EmpForm myForm = (EmpForm) form;
			EmpVO empVO = new EmpVO();
			BeanUtils.copyProperties(empVO, myForm);
			// Perform business logic
			EmpService empSvc = new EmpService();
			empVO = empSvc.addEmp(empVO.getEname(), empVO.getJob(),
					empVO.getHiredate(), empVO.getSal(), empVO.getComm(),
					empVO.getDeptno());
			// Store the new empVO in the request-scope
			request.setAttribute("empVO", empVO);
			// Send the Success view
			return mapping.findForward("success");
	
			// Handle any unusual exceptions
		} catch (Exception e) {
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

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm myForm = (EmpnoForm) form;
			Integer empno = new Integer(myForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			empSvc.deleteEmp(empno);
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
