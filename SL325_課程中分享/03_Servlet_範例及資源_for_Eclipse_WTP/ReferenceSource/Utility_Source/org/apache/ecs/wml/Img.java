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
package org.apache.ecs.wml;

import org.apache.ecs.*;

/**
  *  This class creates an &lt;img&gt; element.
  *
  *  @version $Id: Img.java,v 1.1 2000/07/04 22:51:37 krzyszto Exp $
  *  @author Written by <a href="mailto:Krzysztof.Zelazowski@cern.ch">Krzysztof Zelazowski</a>
  */
public class Img extends SinglePartElement 
{

    /**
      Private initialization routine.
    */
    {
        setBeginEndModifier('/');
        setElementType("img");
    }


    /**
      Basic constructor. Use the set* methods to set the attibutes.
     */
    public Img() 
	{
    }

    /**
      Creates an Img tag
	  @param   src  the SRC="" attribute
    */
    public Img(String src) 
	{
        setSrc(src);
    }

    /**
      Creates an Img tag 
	  @param  src  the src="" attribute
      @param  alt  the alt="" attribute
    */
    public Img(String src, String alt) 
	{
        setSrc(src);
        setAlt(alt);
    }

    /**
      Sets the src="" attribute
	  @param   src  the src="" attribute
    */
    public Img setSrc(String src) 
	{
        addAttribute("src",src);
        return this;
    }

    /**
      Sets the alt="" attribute
	  @param   alt  the alt="" attribute
    */
    public Img setAlt(String alt) 
	{
        addAttribute("alt",alt);
        return this;
    }

    /** 
      Sets the localsrc="" attribute
	  @param localsrc the localsrc="" attribute
    */
    public Img setLocalsrc(String localsrc) 
	{
        addAttribute("localsrc",localsrc);
        return this;
    }
    
    /** 
      Sets the vspace="" attribute
	  @param vspace the vspace="" attribute
    */
    public Img setVspace(String vspace) 
	{
        addAttribute("vspace",vspace);
        return this;
    }
    
    /** 
      Sets the hspace="" attribute
	  @param hspace the hspace="" attribute
    */
    public Img setHspace(String hspace) 
	{
        addAttribute("hspace",hspace); 
        return this;
    }
    
    /** 
      Sets the align="" attribute 
	  @param align the align="" attribute
    */
    public Img setAlignment(Alignment align) 
	{
        addAttribute("align",align.toString());
        return this;
    }

    /**
      Sets the height="" attribute
	  @param height the height="" attribute
    */
    public Img setHeight(String height) 
	{
        addAttribute("height",height);
        return this;
    }

    /**
      Sets the width="" attribute
	  @param width the width="" attribute
    */
    public Img setWidth(String width) 
	{
        addAttribute("width",width);
        return this;
    } 
}
