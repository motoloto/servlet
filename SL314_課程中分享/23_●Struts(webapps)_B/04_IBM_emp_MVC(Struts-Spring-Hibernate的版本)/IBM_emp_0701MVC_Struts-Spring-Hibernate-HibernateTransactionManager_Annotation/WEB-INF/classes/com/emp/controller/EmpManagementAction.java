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

	// 來自select_page.jsp的請求
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
				throw new RuntimeException("查無資料");
			}
			// Store the empVO in the request-scope
			request.setAttribute("empVO", empVO);

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
	

	// 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp 的請求
	public ActionForward getOne_For_Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String requestURL = request.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		
		try {
			// Cast the form to the application-specific action-form class
			EmpnoForm empnoForm = (EmpnoForm) form;
			Integer empno = new Integer(empnoForm.getEmpno());
			// Perform business logic
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(new Integer(empnoForm.getEmpno()));
			if (empVO == null) {
				throw new RuntimeException("查無資料");
			}
			// 以下4行程式碼因為要讓/emp/update_emp_input.jsp能夠使用Struts的強大錯誤處理,所以顯得相當麻煩!!
			EmpForm empForm = new EmpForm();
			BeanUtils.copyProperties(empForm, empVO);
			empForm.setDeptno(String.valueOf(empVO.getDeptVO().getDeptno()));
			request.setAttribute("empForm", empForm);
	
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
			if(requestURL.equals("/emp/listAllEmp.jsp"))
			    return mapping.findForward("error1");
		    else if(requestURL.equals("/dept/listEmps_ByDeptno.jsp"))
				return mapping.findForward("error2");		
		    else if(requestURL.equals("/dept/listAllDept.jsp"))
		    	return mapping.findForward("error3");
		    else return null;
	
		}
	}

	
	// 來自update_emp_input.jsp的請求
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String requestURL = request.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		
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
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(new Integer(empForm.getDeptno()))); // 資料庫取出的Set物件,存入request
				return mapping.findForward("success2");
			}else if(requestURL.equals("/dept/listAllDept.jsp")){
				DeptService deptSvc = new DeptService();
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(new Integer(empForm.getDeptno()))); // 資料庫取出的Set物件,存入request
				return mapping.findForward("success3");
			}else return null;
	
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

	
	// 來自addEmp.jsp的請求  
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

	
	// 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp的請求
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String requestURL = request.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		
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
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(empVO.getDeptVO().getDeptno())); // 資料庫取出的list物件,存入request
				return mapping.findForward("success2");
			}else if(requestURL.equals("/dept/listAllDept.jsp")){
				DeptService deptSvc = new DeptService();
				request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(empVO.getDeptVO().getDeptno())); // 資料庫取出的list物件,存入request
				return mapping.findForward("success3");
			}else return null;
	
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
