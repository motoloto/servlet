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
		request.setAttribute("key1", "MyDispatchAction��method1�Q�I�s");
		return mapping.findForward("success1");
	}

	public ActionForward method2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("key2", "MyDispatchAction��method2�Q�I�s");
		return mapping.findForward("success2");
	}
	
	public ActionForward method3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("key3", "MyDispatchAction��method2�Q�I�s");
		return mapping.findForward("success3");
	}	
}
