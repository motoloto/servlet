package com.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Struts classes
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

// Model classes
import com.emp.model.*;
//View classes
import com.emp.view.EmpnoForm;

public class GetOneEmpAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

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

}
