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
package org.apache.ecs;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import org.apache.ecs.html.Html;
import org.apache.ecs.html.Body;
import org.apache.ecs.html.Title;
import org.apache.ecs.html.Head;
import org.apache.ecs.html.FrameSet;
import org.apache.ecs.html.NoFrames;

/**
    This class creates a FrameSetDocument container, for convience.

    @version $Id: FrameSetDocument.java,v 1.1 1999/07/05 18:38:44 stephan Exp $
    @author <a href="mailto:snagy@servletapi.com">Stephan Nagy</a>
    @author <a href="mailto:jon@clearink.com">Jon S. Stevens</a>
*/
public class FrameSetDocument implements Serializable,Cloneable
{
    /** @serial html html */
    private Html html; // this is the actual container for head and body
    /** @serial head head */
    private Head head;
    /** @serial body body */
    private Body body;
    /** @serial title title */
    private Title title;
    /** @serial frameset frameset */
    private FrameSet frameset;
    /** @serial noframes frameset */
    private NoFrames noframes;

    /** @serial codeset codeset */
    private String codeset = null;
    
    {
        html = new Html();
        head = new Head();
        title = new Title();
        frameset = new FrameSet();
        noframes = new NoFrames();
        body = new Body();
        
        head.addElement(title);
        html.addElement(head);
        html.addElement(frameset);
        html.addElement(noframes);
        noframes.addElement(body);        
    }
    
    /**
        Basic constructor.
    */
    public FrameSetDocument()
    {
    }

    /**
        Basic constructor. Sets the codeset for the page output.
    */
    public FrameSetDocument(String codeset)
    {
        setCodeset(codeset);
    }

    /**
        Get the html element for this document container.
    */
    public Html getHtml()
    {
        return(html);
    }
    
    /**
        Set the html element for this FrameSetDocument container.
    */
    public FrameSetDocument setHtml(Html set_html)
    {
        this.html = set_html;
        return(this);
    }
    
    /**
        Get the head element for this FrameSetDocument container.
    */
    public Head getHead()
    {
        return(head);
    }

    /**
        Set the head element for this FrameSetDocument container.
    */
    public FrameSetDocument setHead(Head set_head)
    {
        this.head = set_head;
        return(this);
    }

    /**
        Append to the head element for this FrameSetDocument container.
        @param value adds to the value between the head tags
    */
    public FrameSetDocument appendHead(Element value)
    {
        head.addElement(value);
        return(this);
    }

    /**
        Append to the head element for this FrameSetDocument container.
        @param value adds to the value between the head tags
    */
    public FrameSetDocument appendHead(String value)
    {
        head.addElement(value);
        return(this);
    }

    /**
        Get the FrameSet element for this FrameSetDocument container.
    */
    public FrameSet getFrameSet()
    {
        return(frameset);
    }

    /**
        Set the FrameSet element for this FrameSetDocument container.
    */
    public FrameSetDocument setHead(FrameSet set_frameset)
    {
        this.frameset = set_frameset;
        return(this);
    }

    /**
        Append to the head element for this FrameSetDocument container.
        @param value adds to the value between the head tags
    */
    public FrameSetDocument appendFrameSet(Element value)
    {
        frameset.addElement(value);
        return(this);
    }

    /**
        Append to the head element for this FrameSetDocument container.
        @param value adds to the value between the head tags
    */
    public FrameSetDocument appendFrameSet(String value)
    {
        frameset.addElement(value);
        return(this);
    }
    /**
        Get the body element for this FrameSetDocument container.
    */
    public Body getBody()
    {
        return(body);
    }

    /**
        Set the Body element for this FrameSetDocument container.
    */
    public FrameSetDocument setBody(Body set_body)
    {
        this.body = set_body;
        return(this);
    }
    
    /**
        Append to the body element for this FrameSetDocument container.
        @param value adds to the value between the body tags
    */
    public FrameSetDocument appendBody(Element value)
    {
        body.addElement(value);
        return(this);
    }

    /**
        Append to the body element for this FrameSetDocument container.
        @param value adds to the value between the body tags
    */
    public FrameSetDocument appendBody(String value)
    {
        body.addElement(value);
        return(this);
    }

    /**
        Get the title element for this FrameSetDocument container.
    */
    public Title getTitle()
    {
        return(title);
    }

    /**
        Set the Title element for this FrameSetDocument container.
    */
    public FrameSetDocument setTitle(Title set_title)
    {
        this.title = set_title;
        return(this);
    }
    
    /**
        Append to the title element for this FrameSetDocument container.
        @param value adds to the value between the title tags
    */
    public FrameSetDocument appendTitle(Element value)
    {
        title.addElement(value);
        return(this);
    }

    /**
        Append to the title element for this FrameSetDocument container.
        @param value adds to the value between the title tags
    */
    public FrameSetDocument appendTitle(String value)
    {
        title.addElement(value);
        return(this);
    }

    /**
     * Sets the codeset for this FrameSetDocument
     */
    public void setCodeset ( String codeset )
    {
        this.codeset = codeset;
    }

    /**
     * Gets the codeset for this FrameSetDocument
     *
     * @return    the codeset 
     */
    public String getCodeset()
    {
        return this.codeset;
    }
    
    /**
        Write the container to the OutputStream
    */
    public void output(OutputStream out)
    {
        // FrameSetDocument is just a convient wrapper for Html call Html.output
        html.output(out);
    }

    /**
        Write the container to the PrinteWriter
    */
    public void output(PrintWriter out)
    {
        // FrameSetDocument is just a convient wrapper for Html call Html.output
        html.output(out);
    }

    /**
        Override the toString() method so that it prints something meaningful.
    */
    public final String toString()
    {
        if ( getCodeset() != null )
            return (html.toString(getCodeset()));
        else
            return(html.toString());
    }

    /**
        Override the toString() method so that it prints something meaningful.
    */
    public final String toString(String codeset)
    {
        return(html.toString(codeset));
    }
    /**
        Allows the FrameSetDocument to be cloned.  Doesn't return an instanceof FrameSetDocument returns instance of Html.

    */

    public Object clone()
    {
        return(html.clone());
    }
}
