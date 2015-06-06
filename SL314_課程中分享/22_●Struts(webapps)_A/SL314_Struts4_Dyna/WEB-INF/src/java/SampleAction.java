package com.my.strapp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import org.apache.struts.action.*;
import org.apache.commons.beanutils.PropertyUtils;

public final class SampleAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm userinfo=(DynaActionForm)form;
		if(Integer.parseInt((String)userinfo.get("age"))>19) {
			return (mapping.findForward("adult"));
		}else	{
			return (mapping.findForward("young"));
		}
	}
}
