package myDispatchAction.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Struts classes
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.actions.DispatchAction;

public class MyDispatchAction extends DispatchAction {

	public ActionForward method1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("key1", "MyDispatchAction的method1被呼叫");
		return mapping.findForward("success1");
	}

	public ActionForward method2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("key2", "MyDispatchAction的method2被呼叫");
		return mapping.findForward("success2");
	}
	
	public ActionForward method3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("key3", "MyDispatchAction的method2被呼叫");
		return mapping.findForward("success3");
	}	
}
