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
    This class creates a &lt;Option&gt; tag.
    The Option tag defaults to not having a closing &lt;/Option&gt;
    because it is optional in the spec. This can be
    overridden by setNeedClosingTag(true)

    @version $Id: Option.java,v 1.3 1999/10/08 01:38:04 jonbolt Exp $
    @author <a href="mailto:snagy@servletapi.com">Stephan Nagy</a>
    @author <a href="mailto:jon@clearink.com">Jon S. Stevens</a>
*/
public class Option extends MultiPartElement implements Printable, FocusEvents, FormEvents, MouseEvents, KeyEvents

{

    /**
        Private initialization routine.
    */
    {
        setElementType("option");
        setNeedClosingTag(false);
    }
    
    /**
        Basic constructor. Use the set* methods to set the values
        of the attributes.
    */
    public Option()
    {
    }
    
    /**
        Basic constructor. Use the set* methods to set the values
        of the attributes.
        
        @param value sets the attribute VALUE=""
    */
    public Option(String value)
    {
        setValue(value);
    }

    /**
        Basic constructor. Use the set* methods to set the values
        of the attributes.
        
        @param label sets the attribute LABEL=""
        @param value sets the attribute VALUE=""
    */
    public Option(String label, String value)
    {
        setLabel(label);
        setValue(value);
    }

    /**
        Basic constructor. Use the set* methods to set the values
        of the attributes.
        
        @param label sets the attribute LABEL=""
        @param value sets the attribute VALUE=""
    */
    public Option(String label, int value)
    {
        setLabel(label);
        setValue(value);
    }

    /**
        Basic constructor. Use the set* methods to set the values
        of the attributes.
        
        @param label sets the attribute LABEL=""
        @param value sets the attribute VALUE=""
    */
    public Option(String label, double value)
    {
        setLabel(label);
        setValue(value);
    }

    /**
        Sets the LABEL="" attribute
        @param   label  the LABEL="" attribute
    */
    public Option setLabel(String label)
    {
        addAttribute("label",label);
        return this;
    }

    /**
        Sets the VALUE="" attribute
        @param   value  the VALUE="" attribute
    */
    public Option setValue(String value)
    {
        addAttribute("value",value);
        return this;
    }

    /**
        Sets the VALUE="" attribute
        @param   value  the VALUE="" attribute
    */
    public Option setValue(int value)
    {
        addAttribute("value",Integer.toString(value));
        return this;
    }

    /**
        Sets the VALUE="" attribute
        @param   value  the VALUE="" attribute
    */
    public Option setValue(double value)
    {
        addAttribute("value",Double.toString(value));
        return this;
    }

    /**
        Sets the selected value
        @param   selected  true or false
    */
    public Option setSelected(boolean selected)
    {
        if ( selected == true )
            addAttribute("selected", NO_ATTRIBUTE_VALUE);
        else
            removeAttribute("selected");
            
        return(this);
    }

    /**
        Sets the disabled value
        @param   disabled  true or false
    */
    public Option setDisabled(boolean disabled)
    {
        if ( disabled == true )
            addAttribute("disabled", NO_ATTRIBUTE_VALUE);
        else
            removeAttribute("disabled");
            
        return(this);
    }
    
    /**
        Adds an Element to the element.
        @param  hashcode name of element for hash table
        @param  element Adds an Element to the element.
     */
    public Option addElement(String hashcode,Element element)
    {
        addElementToRegistry(hashcode,element);
        return(this);
    }

    /**
        Adds an Element to the element.
        @param  hashcode name of element for hash table
        @param  element Adds an Element to the element.
     */
    public Option addElement(String hashcode,String element)
    {
        addElementToRegistry(hashcode,element);
        return(this);
    }

    /**
        Adds an Element to the element.
        @param  element Adds an Element to the element.
     */
    public Option addElement(Element element)
    {
        addElementToRegistry(element);
        return(this);
    }
    
    /**
        Adds an Element to the element.
        @param  element Adds an Element to the element.
     */
    public Option addElement(String element)
    {
        addElementToRegistry(element);
        return(this);
    }

    /**
        Creates a group of options.
        @param  Creates a group of options.
     */
    public Option[] addElement(String[] element)
    {
        Option[] option = new Option[element.length];
        for(int x = 0; x < element.length; x++)
        {
            option[x]= new Option().addElement(element[x]);
        }
        return(option);
    }
    /**
        Removes an Element from the element.
        @param hashcode the name of the element to be removed.
    */
    public Option removeElement(String hashcode)
    {
        removeElementFromRegistry(hashcode);
        return(this);
    }

    /**
        The onfocus event occurs when an element receives focus either by the
        pointing device or by tabbing navigation. This attribute may be used
        with the following elements: LABEL, INPUT, SELECT, TEXTAREA, and
        BUTTON.
        
        @param The script
    */
    public void setOnFocus(String script)
    {
        addAttribute ( "onFocus", script );
    }

    /**
        The onblur event occurs when an element loses focus either by the
        pointing device or by tabbing navigation. It may be used with the same
        elements as onfocus.
        
        @param The script
    */
    public void setOnBlur(String script)
    {
        addAttribute ( "onBlur", script );
    }

    /**
        The onsubmit event occurs when a form is submitted. It only applies to
        the FORM element.
        
        @param The script
    */
    public void setOnSubmit(String script)
    {
        addAttribute ( "onSubmit", script );
    }

    /**
        The onreset event occurs when a form is reset. It only applies to the
        FORM element.
        
        @param The script
    */
    public void setOnReset(String script)
    {
        addAttribute ( "onReset", script );
    }

    /**
        The onselect event occurs when a user selects some text in a text
        field. This attribute may be used with the INPUT and TEXTAREA elements.
        
        @param The script
    */
    public void setOnSelect(String script)
    {
        addAttribute ( "onSelect", script );
    }

    /**
        The onchange event occurs when a control loses the input focus and its
        value has been modified since gaining focus. This attribute applies to
        the following elements: INPUT, SELECT, and TEXTAREA.
        
        @param The script
    */
    public void setOnChange(String script)
    {
        addAttribute ( "onChange", script );
    }

    /**
        The onclick event occurs when the pointing device button is clicked
        over an element. This attribute may be used with most elements.
        
        @param The script
    */
    public void setOnClick(String script)
    {
        addAttribute ( "onClick", script );
    }
    /**
        The ondblclick event occurs when the pointing device button is double
        clicked over an element. This attribute may be used with most elements.

        @param The script
    */
    public void setOnDblClick(String script)
    {
        addAttribute ( "onDblClick", script );
    }
    /**
        The onmousedown event occurs when the pointing device button is pressed
        over an element. This attribute may be used with most elements.

        @param The script
    */
    public void setOnMouseDown(String script)
    {
        addAttribute ( "onMouseDown", script );
    }
    /**
        The onmouseup event occurs when the pointing device button is released
        over an element. This attribute may be used with most elements.

        @param The script
    */
    public void setOnMouseUp(String script)
    {
        addAttribute ( "onMouseUp", script );
    }
    /**
        The onmouseover event occurs when the pointing device is moved onto an
        element. This attribute may be used with most elements.

        @param The script
    */
    public void setOnMouseOver(String script)
    {
        addAttribute ( "onMouseOver", script );
    }
    /**
        The onmousemove event occurs when the pointing device is moved while it
        is over an element. This attribute may be used with most elements.

        @param The script
    */
    public void setOnMouseMove(String script)
    {
        addAttribute ( "onMouseMove", script );
    }
    /**
        The onmouseout event occurs when the pointing device is moved away from
        an element. This attribute may be used with most elements.

        @param The script
    */
    public void setOnMouseOut(String script)
    {
        addAttribute ( "onMouseOut", script );
    }

    /**
        The onkeypress event occurs when a key is pressed and released over an
        element. This attribute may be used with most elements.
        
        @param The script
    */
    public void setOnKeyPress(String script)
    {
        addAttribute ( "onKeyPress", script );
    }

    /**
        The onkeydown event occurs when a key is pressed down over an element.
        This attribute may be used with most elements.
        
        @param The script
    */
    public void setOnKeyDown(String script)
    {
        addAttribute ( "onKeyDown", script );
    }

    /**
        The onkeyup event occurs when a key is released over an element. This
        attribute may be used with most elements.
        
        @param The script
    */
    public void setOnKeyUp(String script)
    {
        addAttribute ( "onKeyUp", script );
    }
}
