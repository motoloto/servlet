/*
 * Copyright (c) 2000 The Java Apache Project.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. All advertising materials mentioning features or use of this
 *    software must display the following acknowledgment:
 *    "This product includes software developed by the Java Apache 
 *    Project. <http://java.apache.org/>"
 *
 * 4. The names "Java Apache Element Construction Set", "Java Apache ECS" and 
 *    "Java Apache Project" must not be used to endorse or promote products 
 *    derived from this software without prior written permission.
 *
 * 5. Products derived from this software may not be called 
 *    "Java Apache Element Construction Set" nor "Java Apache ECS" appear 
 *    in their names without prior written permission of the 
 *    Java Apache Project.
 *
 * 6. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the Java Apache 
 *    Project. <http://java.apache.org/>"
 *    
 * THIS SOFTWARE IS PROVIDED BY THE JAVA APACHE PROJECT "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JAVA APACHE PROJECT OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Java Apache Project. For more information
 * on the Java Apache Project please see <http://java.apache.org/>.
 *
 */
package org.apache.ecs.jsp;
import org.apache.ecs.Document;
import org.apache.ecs.html.*;

/**
    This class contains some simple tests of the vxml generation package

    @author Written by <a href="mailto:jcarol@us.ibm.com">Carol Jones</a>
*/
public class TestBed
{
    	
	public void test1()
	{
	System.out.println("\ntest1");

	Document doc = new Document();
	jsp_useBean bean = new jsp_useBean("bean1", "page", "Person");
	jsp_setProperty set = new jsp_setProperty("bean1", "last", "Jones");
	jsp_getProperty get = new jsp_getProperty("bean1", "first");
	bean.addElement(set);
	doc.appendBody(bean);
	doc.appendBody(new P());
	doc.appendBody(get);
	doc.appendBody(new jsp_scriptlet("out.println(\"hello\");"));
	IMG img = new IMG();
	jsp_expression expr = new jsp_expression("bean1.getPhoto()");
	img.setSrc(expr.toString());
	doc.appendBody(img);

	System.out.println(doc.toString());
	}

	public void test2()
	{
	System.out.println("\ntest2");

	Document doc = new Document();
	jsp_page page= new jsp_page("java", "true", "16k", "true",
							    "true", "false", "text/html", "iso");
	doc.appendBody(page);
	
	jsp_include inc = new jsp_include("anotherpage.jsp");
	jsp_forward fwd = new jsp_forward("anotherpage.jsp");
	doc.appendBody(inc);
	doc.appendBody(fwd);
	System.out.println(doc.toString());
	}

	public void test3()
	{
	System.out.println("\ntest3");

	Document doc = new Document();
	tsx_dbconnect conn = new tsx_dbconnect("conn1", "jdbc:db2:sample", "com.ibm.db2.db2driver", "wsdemo", "wsdemo1");
    tsx_dbquery query = new tsx_dbquery("query1", "conn1", "10");
	query.addElement("select * from staff");
    tsx_dbmodify modify = new tsx_dbmodify("modify", "conn1");
	tsx_repeat rep = new tsx_repeat("i", "1", "10");
	tsx_getProperty getProp = new tsx_getProperty("query1", "lastname");
	rep.addElement(getProp);
	doc.appendBody(conn);
	doc.appendBody(query);
	doc.appendBody(rep);
	
	tsx_setProperty setProp = new tsx_setProperty("modify1", "lastname", "Jones");
	modify.addElement("delete from staff where lastname='Jones'");
	doc.appendBody(setProp);
	doc.appendBody(modify);

	
	System.out.println(doc.toString());
	}


	public static void main(String[] args)
    {
	TestBed tb = new TestBed();
	
	tb.test1();
	tb.test2();
	tb.test3();
    }
}
