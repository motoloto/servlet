package com.my.strapp;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.DynaActionForm;

public class SampleForm extends DynaActionForm{

	public void reset(ActionMapping mapping,HttpServletRequest request) {
		try	{
		request.setCharacterEncoding("big5");
		}catch(java.io.UnsupportedEncodingException e){
			// �o�����g�J��ڻݭn���ҥ~�B�z
		}
		super.reset(mapping,request);
	}
}
