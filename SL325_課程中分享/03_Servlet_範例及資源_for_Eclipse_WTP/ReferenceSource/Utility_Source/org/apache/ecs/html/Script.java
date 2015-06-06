/*
 * Copyright (c) 1999 The Java Apache Project.  All rights reserved.
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
package org.apache.ecs.html;

import org.apache.ecs.*;

/**
    This class creates a &lt;U&gt; tag.

    @version $Id: Script.java,v 1.3 2000/01/05 01:17:41 jonbolt Exp $
    @author <a href="mailto:snagy@servletapi.com">Stephan Nagy</a>
    @author <a href="mailto:jon@clearink.com">Jon S. Stevens</a>
*/
public class Script extends MultiPartElement implements Printable
{
    /**
        Private initialization routine.
    */
    {
        setElementType("script");
        setLanguage("JavaScript");
    }
    /**
        Basic constructor.
    */
    public Script()
    {
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
    */
    public Script(Element element)
    {
        addElement(element);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
        @param  src sets the SRC="" attribute
    */
    public Script(Element element, String src)
    {
        addElement(element);
        setSrc(src);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
        @param  src sets the SRC="" attribute
        @param  type sets the TYPE="" attribute
    */
    public Script(Element element, String src, String type)
    {
        addElement(element);
        setSrc(src);
        setType(type);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
        @param  src sets the SRC="" attribute
        @param  type sets the TYPE="" attribute
        @param  lang sets the LANGUAGE="" attribute
    */
    public Script(Element element, String src, String type, String lang)
    {
        addElement(element);
        setSrc(src);
        setType(type);
        setLanguage(lang);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
    */
    public Script(String element)
    {
        addElement(element);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
        @param  src sets the SRC="" attribute
    */
    public Script(String element, String src)
    {
        addElement(element);
        setSrc(src);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
        @param  src sets the SRC="" attribute
        @param  type sets the TYPE="" attribute
    */
    public Script(String element, String src, String type)
    {
        addElement(element);
        setSrc(src);
        setType(type);
    }

    /**
        Basic constructor.
        @param  element Adds an Element to the element.
        @param  src sets the SRC="" attribute
        @param  type sets the TYPE="" attribute
        @param  lang sets the LANGUAGE="" attribute
    */
    public Script(String element, String src, String type, String lang)
    {
        addElement(element);
        setSrc(src);
        setType(type);
        setLanguage(lang);
    }

    /**
        Sets the SRC="" attribute
        @param   src  the SRC="" attribute
    */
    public Script setSrc(String src)
    {
        addAttribute("src",src);
        return this;
    }

    /**
        Sets the TYPE="" attribute
        @param   type  the TYPE="" attribute
    */
    public Script setType(String type)
    {
        addAttribute("type", type);
        return this;
    }

    /**
        Sets the LANGUAGE="" attribute
        @param   language  the LANGUAGE="" attribute
    */
    public Script setLanguage(String language)
    {
        addAttribute("language", language);
        return this;
    }

    /**
        Adds an Element to the element.
        @param  hashcode name of element for hash table
        @param  element Adds an Element to the element.
     */
    public Script addElement(String hashcode,Element element)
    {
        addElementToRegistry(hashcode,element);
        return(this);
    }

    /**
        Adds an Element to the element.
        @param  hashcode name of element for hash table
        @param  element Adds an Element to the element.
     */
    public Script addElement(String hashcode,String element)
    {
        addElementToRegistry(hashcode,element);
        return(this);
    }

    /**
        Adds an Element to the element.
        @param  element Adds an Element to the element.
     */
    public Script addElement(Element element)
    {
        addElementToRegistry(element);
        return(this);
    }

    /**
        Adds an Element to the element.
        @param  element Adds an Element to the element.
     */
    public Script addElement(String element)
    {
        addElementToRegistry(element);
        return(this);
    }
    /**
        Removes an Element from the element.
        @param hashcode the name of the element to be removed.
    */
    public Script removeElement(String hashcode)
    {
        removeElementFromRegistry(hashcode);
        return(this);
    }
    
    /**
        We override this method here in order to create the Html
        comment code by default that protects scripts from older 
        browsers. We put in hard returns here because we want to make 
        sure that this code works even with PrettyPrint false.
    */
    protected String createStartTag()
    {
        StringBuffer out = new StringBuffer();
        out.append(super.createStartTag());
        out.append("\n");
        out.append("<!--");
        out.append("\n");
        return(out.toString());
    }
    /**
        We override this method here in order to create the Html
        comment code by default that protects scripts from older 
        browsers. We put in hard returns here because we want to make 
        sure that this code works even with PrettyPrint false.
    */    
    protected String createEndTag()
    {
        StringBuffer out = new StringBuffer();
        out.append("\n");
        out.append("// -->");
        out.append("\n");
        out.append(super.createEndTag());
        return(out.toString());
    }
}
