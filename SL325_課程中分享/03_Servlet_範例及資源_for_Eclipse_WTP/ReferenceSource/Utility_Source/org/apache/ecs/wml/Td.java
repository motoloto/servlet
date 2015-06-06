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
  This class implements the &lt;td&gt; element.
  It is a container to hold a single table cell data within a table 
  row. Table cell data may be empty. Empty cells are significant, 
  and must not be ignored. The user agent should do a best effort 
  to deal with multiple line data cells that may result from using 
  images or line breaks.
 	
   @version $Id: Td.java,v 1.1 2000/07/04 22:51:38 krzyszto Exp $
   @author Written by <a href="mailto:Krzysztof.Zelazowski@cern.ch">Krzysztof Zelazowski</a>
 */
public class Td extends org.apache.ecs.MultiPartElement 
{
    /**
      Basic constructor.
     */
    public Td() 
	{
        setElementType("td");
    }

    /**
      Basic Constructor 
	  @param element an element to be added to this cell.
     */
    public Td(Element element)
    {
        this();
        addElement(element);
    }

    /**
      Basic Constructor.
	  @param element a String element to be added to this cell
     */
    public Td(String element)
    {
        this();
        addElement(element);
    }

    /**
      Adds an Element to the element.
	  @param  element an element to be added.
     */
    public Td addElement(Element element)
    {
        addElementToRegistry(element,getFilterState());
        return(this);
    }

    /**
      Adds an Element to the element.
	  @param element a String element to be added
     */
    public Td addElement(String element)
    {
        addElementToRegistry(element,getFilterState());
        return(this);
    }

}
