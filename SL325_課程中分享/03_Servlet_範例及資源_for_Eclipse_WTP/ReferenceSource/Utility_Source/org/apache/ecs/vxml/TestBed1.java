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
public class TestBed1
{
    
    public void HelloWorldTest() 
    {
	System.out.println("\nHelloWorld.vxml");	

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	Form form = new Form();
	Block block = new Block();
	block.addElement("Hello World!");
	form.addElement(block);
	vxml.addElement(form);
	doc.addElement(vxml);

	System.out.println(doc.toString());
    }
    
	public void DrinkTest()
	{
	System.out.println("\nDrink.vxml");	

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	Form form = new Form();
	Field field = new Field("drink");
	Prompt prompt = new Prompt();
	prompt.addElement("Would you like coffee, tea, milk, or nothing?");
	Grammar grammar = new Grammar("drink.gram", "application/x-jsgf");
	Block block = new Block();
	block.addElement(new Submit("http://www.drink.example/drink2.asp"));
	field.addElement(prompt);
	field.addElement(grammar);
	form.addElement(field); 
	form.addElement(block);
	vxml.addElement(form);

	doc.addElement(vxml);

	System.out.println(doc.toString());
	
	}
	
	public void MetaTest()
	{
	System.out.println("\nMeta.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	vxml.addElement(new Meta().setAuthor("John Doe"));
	vxml.addElement(new Meta().setMaintainer("hello-support@hi.example"));
	vxml.addElement(new Var("hi", "'Hello World!'"));
	Form form = new Form();
	Block block = new Block();
	block.addElement(new Value("hi"));
	block.addElement(new Goto("#say_goodbye"));
	form.addElement(block);
	vxml.addElement(form);
	Form form2 = new Form("say_goodbye");
	Block block2 = new Block();
	block2.addElement("Goodbye!");
	form2.addElement(block2);
	vxml.addElement(form2);

	doc.addElement(vxml);

	System.out.println(doc.toString());
	}
	
	public void LinkTest()
	{
	System.out.println("\nLink.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	Var  var = new Var("bye", "'Ciao'");
	Link link = new Link();
	link.setNext("operator_xfer.vxml");
	Grammar grammar = new Grammar();
	grammar.addElement(" operator ");
	link.addElement(grammar);
	vxml.addElement(var);
	vxml.addElement(link);
	
	doc.addElement(vxml);

	System.out.println(doc.toString());
	}
	
	public void ExitTest()
	{
	System.out.println("\nExit.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	Form form = new Form("say_goodbye");
	Field field = new Field("answer", "boolean");
	Prompt prompt = new Prompt();
	prompt.addElement("Shall we say ");
	prompt.addElement(new Value("application.bye"));
	Filled filled = new Filled();
	If iftag = new If("answer");
	iftag.addElement(new Exit());
	filled.addElement(iftag);
	filled.addElement(new Clear("answer"));
	
	field.addElement(prompt);
	field.addElement(filled);
	form.addElement(field);
	vxml.addElement(form);

	doc.addElement(vxml);

	System.out.println(doc.toString());
	}
	
	public void FilledTest()
	{
	System.out.println("\nFilled.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	Form form = new Form("billing_adjustment");
	Var  var1 = new Var("account_number");
	Var  var2 = new Var("home_phone");
	Subdialog sub = new Subdialog();
	sub.setName("accountinfo");
	sub.setSrc("acct_info.vxml#basic");
	Filled filled = new Filled();
	filled.addElement (new Assign("account_number", "accountinfo.acctnum"));
	filled.addElement (new Assign("home_phone", "accountinfo.acctphone"));
	sub.addElement(filled);
	Field field = new Field();
	field.setName("adjustment_amount");
	field.setType("currency");
	Prompt prompt = new Prompt(" What is the value of your account adjustment?");
	Filled filled2 = new Filled();
	filled2.addElement(new Submit("/cgi-bin/updateaccount"));
	field.addElement(prompt);
	field.addElement(filled2);
	
	form.addElement(var1);
	form.addElement(var2);
	form.addElement(sub);
	form.addElement(field);
	vxml.addElement(form);
	
	doc.addElement(vxml);

	System.out.println(doc.toString());
	}
	
	public void ReturnTest()
	{
	System.out.println("\nReturn.vxml");

	VXMLDocument doc = new VXMLDocument();
	Vxml vxml = new Vxml("1.0");
	Form form = new Form("basic");
	form.addElement(
		new Field("acctnum", "digits").addElement(
				new Prompt(" What is your account number?")));
	Field field = new Field("acctphone", "phone");
	field.addElement(new Prompt(" What is your home telephone number?"));
	Filled filled = new Filled();
	filled.addElement(new Return("acctnum acctphone"));
	field.addElement(filled);
	form.addElement(field);
	vxml.addElement(form);
	
	doc.addElement(vxml);

	System.out.println(doc.toString());
	}
		
    public static void main(String[] args)
    {
	TestBed1 tb = new TestBed1();
	
	tb.HelloWorldTest();
	tb.DrinkTest();
	tb.MetaTest();
	tb.LinkTest();
	tb.ExitTest();
	tb.FilledTest();
	tb.ReturnTest();
    }
}
