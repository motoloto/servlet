package com.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Struts classes
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

// Model classes
import com.emp.model.EmpService;
import com.emp.model.EmpVO;

//View classes
import com.emp.view.EmpForm;

public class UpdateEmpAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	
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
			//�䥦���~(�Ϊ̥��~�޿�B�z)�����~
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
