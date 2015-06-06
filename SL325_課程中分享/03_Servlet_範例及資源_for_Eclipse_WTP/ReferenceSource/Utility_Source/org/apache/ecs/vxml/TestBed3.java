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
package org.apache.ecs.vxml;

/**
    This class contains some simple tests of the vxml generation package

    @author Written by <a href="mailto:jcarol@us.ibm.com">Carol Jones</a>
*/
public class TestBed3
{
    	
	public void EmptyElements()
	{
	System.out.println("\nEmptyElements.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");	

	vxml.addElement(new Block());
	vxml.addElement(new Reprompt());
	vxml.addElement(new Disconnect());

	doc.addElement(vxml);

	System.out.println(doc.toString());
	}

	public void MiscElements()
	{
	System.out.println("\nMiscElements.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");	

	Initial init = new Initial("bypass_init");
	init.addElement(new Audio("hello.wav"));
	init.addElement(new Break("medium"));
	vxml.addElement(init);
	
	Dtmf dtmf = new Dtmf("application/x-jsgf");
	dtmf.addElement("1 {van} | 2 {choc} | 3 {straw}");
	vxml.addElement(dtmf);
	vxml.addElement(new Div("sentence"));
	vxml.addElement(new Emp("Hello!"));
	vxml.addElement(new Sayas("currency", "$123.50"));
	vxml.addElement(new Noinput("I didn't hear anything, please try again"));
	vxml.addElement(new Nomatch("Nothing matched, try again.", "1"));
	vxml.addElement(new Error("An Error has occurred"));
	vxml.addElement(new Throw("nomatch"));
	org.apache.ecs.vxml.Object obj = new org.apache.ecs.vxml.Object();
	obj.setName("debit");
	obj.setClassid("method://credit_card/gather_and_debit");
	obj.setData("http://www.recordings.example/prompts/credit/jesse.jar");
	obj.addElement (new Param("amount", "document.amt"));
	obj.addElement (new Param("vendor", "vendor_num"));
	vxml.addElement(obj);


	doc.addElement(vxml);
	System.out.println(doc.toString());
	}

	public void IfTest()
	{
	System.out.println("\nIfTest.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");	

	If iftag = new If("city == 'LA'");
	iftag.addElement(new Assign("city", "Los Angeles"));
	iftag.addElement(new Elseif("city == 'Philly'"));
	iftag.addElement(new Assign("city", "Philadelphia"));
	iftag.addElement(new Else());
	iftag.addElement(new Assign("city", "Unknown"));
	vxml.addElement(iftag);	

	doc.addElement(vxml);

	System.out.println(doc.toString());
	}

	public void ScriptTest()
	{
	System.out.println("\nScript.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");	
	
	Script script = new Script();
	script.addElement("<![CDATA[\n" + 
					  "function factorial(n) { return (n <= 1)? 1 : n * factorial(n-1); }" + 
					  "]]>");

	vxml.addElement(script);
	doc.addElement(vxml);

	doc.output(System.out);
	}


	public static void main(String[] args)
    {
	TestBed3 tb = new TestBed3();
	
	tb.EmptyElements();
	tb.MiscElements();
	tb.IfTest();
	tb.ScriptTest();
    }
}
