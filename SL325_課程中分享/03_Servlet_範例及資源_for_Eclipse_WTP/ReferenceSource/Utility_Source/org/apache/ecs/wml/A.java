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
package org.apache.ecs.wml;

import org.apache.ecs.Element;
import org.apache.ecs.MultiPartElement;

/**
    This class implements the a element

    @author Written by <a href="mailto:Anders.Samuelson@aspiro.com">Anders.Samuelson</a>
    @author Modifications by <a href="mailto:Orjan.Petersson@ehpt.com">Örjan Petersson</a>
*/
public class A extends org.apache.ecs.MultiPartElement
{

    /**
	Basic constructor. You need to set the attributes using the
	set* methods.
    */
    public A()
    {
	setElementType("a");
    }

    
    /**
	This constructor creates a &lt;a&gt; tag.
	@param href the href="" attribute
	@param title the title="" attribute
    */
    public A(String href, String title)
    {
	this();
	setHref(href);
	setTitleAttr(title);
    }
    
    /**
	This constructor creates a &lt;a&gt; tag.
	@param href the href="" attribute
    */
    public A(String href)
    {
	this();
	setHref(href);
    }
    
    /**
	Sets the title="" attribute
	@param title the title="" attribute
    */
    public A setTitleAttr(String title)
    {
	addAttribute("title", title);
	return this;
    }

    /**
	Sets the href="" attribute
	@param href the href="" attribute
    */
    public A setHref(String href)
    {
	addAttribute("href", href);
	return this;
    }
    
    /**
	Adds an Element to the element.
	@param element Adds an Element to the element.
     */
    public A addElement(String element)
    {
	addElementToRegistry(element, getFilterState());
	return(this);
    }
    
    
} 
