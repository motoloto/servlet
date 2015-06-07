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

import com.dept.model.DeptService;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.emp.view.EmpForm;
import com.emp.view.EmpnoForm;

public class EmpManagementAction extends DispatchAction {

	// �Ӧ�select_page.jsp���ШD
	public ActionForward getOne_For_Display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm empnoForm = (EmpnoForm) form;
			Integer empno = new Integer(empnoForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(empno);
			if (empVO == null) {
				throw new RuntimeException("�d�L���");
			}
			// Store the empVO in the request-scope
			request.setAttribute("empVO", empVO);

			// Send the Success view
			return mapping.findForward("success");

			// Handle any unusual exceptions
		} catch (Exception e) {
			// �䥦���~(�Ϊ̥��~�޿�B�z)�����~
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
	

	// �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp ���ШD
	public ActionForward getOne_For_Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String requestURL = request.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j
		
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm empnoForm = (EmpnoForm) form;
			Integer empno = new Integer(empnoForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(new Integer(empnoForm.getEmpno()));
			if (empVO == null) {
				throw new RuntimeException("�d�L���");
			}
			// �H�U4��{���X�]���n��/emp/update_emp_input.jsp����ϥ�Struts���j�j���~�B�z,�ҥH��o�۷�·�!!
			EmpForm empForm = new EmpForm();
			BeanUtils.copyProperties(empForm, empVO);
			empForm.setDeptno(String.valueOf(empVO.getDeptVO().getDeptno()));
			request.setAttribute("empForm", empForm);
	
			// Send the Success view
			return mapping.findForward("success");
	
			// Handle any unusual exceptions
		} catch (Exception e) {
			// �䥦���~(�Ϊ̥��~�޿�B�z)�����~
			// Log stack trace
			e.printStackTrace(System.err);
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpectedError", e.getMessage()));
			saveMessages(request, messages);
			// and forward to the error handling page (the form itself)
			if(requestURL.equals("/emp/listAllEmp.jsp"))
			    return mapping.findForward("error1");
		    else if(requestURL.equals("/dept/listEmps_ByDeptno.jsp"))
				return mapping.findForward("error2");		
		    else if(requestURL.equals("/dept/listAllDept.jsp"))
		    	return mapping.findForward("error3");
		    else return null;
	
		}
	}

	
	// �Ӧ�update_emp_input.jsp���ШD
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String requestURL = request.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j
		
		try {
			// Cast the form to the application-specific action-form class
			EmpForm empForm = (EmpForm) form;
			EmpVO empVO = new EmpVO();
			BeanUtils.copyProperties(empVO, empForm);
			// Perform business logic
			EmpService empSvc = new EmpService();
			empVO = empSvc.updateEmp(empVO.getEmpno(), empVO.getEname(), empVO.getJob(),
					empVO.getHiredate(), empVO.getSal(), empVO.getComm(),
					new Integer(empForm.getDeptno()));
			// Store the new empVO in the request-scope
			request.setAttribute("empVO", empVO);
			
			// Send the Success view
			if(requestURL.equals("/emp/listAllEmp.jsp"))
				return mapping.findForward("success1");
			else if(requestURL.equals("/dept/listEmps_ByDeptno.jsp")){
				DeptService deptSvc = new DeptService();
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(new Integer(empForm.getDeptno()))); // ��Ʈw���X��Set����,�s�Jrequest
				return mapping.findForward("success2");
			}else if(requestURL.equals("/dept/listAllDept.jsp")){
				DeptService deptSvc = new DeptService();
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(new Integer(empForm.getDeptno()))); // ��Ʈw���X��Set����,�s�Jrequest
				return mapping.findForward("success3");
			}else return null;
	
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

	
	// �Ӧ�addEmp.jsp���ШD  
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
					new Integer(myForm.getDeptno()));
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

	
	// �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp���ШD
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String requestURL = request.getParameter("requestURL"); // �e�X�R�����ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j
		
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm myForm = (EmpnoForm) form;
			Integer empno = new Integer(myForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(empno);
			empSvc.deleteEmp(empno);
			// Send the Success view
			if(requestURL.equals("/emp/listAllEmp.jsp"))
			    return mapping.findForward("success1");
			else if(requestURL.equals("/dept/listEmps_ByDeptno.jsp")){
				DeptService deptSvc = new DeptService();
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(empVO.getDeptVO().getDeptno())); // ��Ʈw���X��list����,�s�Jrequest
				return mapping.findForward("success2");
			}else if(requestURL.equals("/dept/listAllDept.jsp")){
				DeptService deptSvc = new DeptService();
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(empVO.getDeptVO().getDeptno())); // ��Ʈw���X��list����,�s�Jrequest
				return mapping.findForward("success3");
			}else return null;
	
			// Handle any unusual exceptions
		} catch (RuntimeException e) {
			//�䥦���~(�Ϊ̥��~�޿�B�z)�����~
			// Log stack trace
			e.printStackTrace(System.err);
	
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.unexpectedError", e.getMessage()));
			saveMessages(request, messages);
			// and forward to the error handling page (the form itself)
			if(requestURL.equals("/emp/listAllEmp.jsp"))
			    return mapping.findForward("error1");
		    else if(requestURL.equals("/dept/listEmps_ByDeptno.jsp"))
				return mapping.findForward("error2");		
		    else if(requestURL.equals("/dept/listAllDept.jsp"))
		    	return mapping.findForward("error3");
		    else return null;
				
	
		} 
	}

}
