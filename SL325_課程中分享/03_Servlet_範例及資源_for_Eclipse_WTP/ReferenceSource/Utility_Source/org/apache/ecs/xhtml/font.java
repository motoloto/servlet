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

package org.apache.ecs.xhtml;



import org.apache.ecs.*;



/**

    This class creates a &lt;font&gt; object.

    @version $Id: font.java,v 1.1 2000/11/28 17:35:27 jstoor Exp $

    @author <a href="mailto:snagy@servletapi.com">Stephan Nagy</a>

    @author <a href="mailto:jon@clearink.com">Jon S. Stevens</a>

    @author <a href="mailto:bojan@binarix.com">Bojan Smojver</a>

*/

public class font extends MultiPartElement implements Printable

{



    /**

        Private initializer.

    */

    {

        setElementType("font");

        setCase(LOWERCASE);

        setAttributeQuote(true);

    }



    /**

        Basic Constructor. use set* methods.

    */

    public font()

    {

    }



    /**

        Basic constructor.

        @param face create new font object with this face.

    */

    public font(String face)

    {

        setFace(face);

    }



    /**

        Basic constructor

        @param  face

        @param  color

        Create a new font object with the face abd color already set. Convience colors are defined in HtmlColor interface.

    */

    public font(String face,String color)

    {

        setFace(face);

        setColor(color);

    }



    /**

        Basic constructor

        @param  face

        @param  color

        @param  size

        Create a new font object with the face,color and size already set. Convience colors are defined in HtmlColor interface.

    */

    public font(String face,String color,int size)

    {

        setFace(face);

        setColor(color);

        setSize(size);

    }



    /**

        Basic constructor

        @param  size

        Create a new font object with the size already set.

    */

    public font(int size)

    {

        setSize(size);

    }



    /**

        Basic constructor

        @param  size

        @param  face

        Create a new font object with the size and face already set.

    */

    public font(int size,String face)

    {

        setSize(size);

        setFace(face);

    }



    /**

        Basic constructor

        @param  color

        @param  size

        Create a new font object with the size and color already set.

    */

    public font(String color,int size)

    {

        setSize(size);

        setColor(color);

    }

    

    /**

        sets the face="" attribute.

        @param  face sets the face="" attribute.

    */

    public font setFace(String face)

    {

        addAttribute("face",face);

        return(this);

    }



    /**

        sets the color="" attribute.

        @param  color sets the color="" attribute. Convience colors are defined in the HtmlColors interface.

    */

    public font setColor(String color)

    {

        addAttribute("color",HtmlColor.convertColor(color));

        return(this);

    }

    

    /**

        sets the size="" attribute.

        @param    size sets the size="" attribute.

    */

    public font setSize(int size)

    {

        addAttribute("size",Integer.toString(size));

        return(this);

    }



    /**

        sets the size="" attribute.

        @param    size sets the size="" attribute.

    */

    public font setSize(String size)

    {

        addAttribute("size",size);

        return(this);

    }



    /**

        Sets the lang="" and xml:lang="" attributes

        @param   lang  the lang="" and xml:lang="" attributes

    */

    public Element setLang(String lang)

    {

        addAttribute("lang",lang);

        addAttribute("xml:lang",lang);

        return this;

    }



    /**

        Adds an Element to the element.

        @param  hashcode name of element for hash table

        @param  element Adds an Element to the element.

     */

    public font addElement(String hashcode,Element element)

    {

        addElementToRegistry(hashcode,element);

        return(this);

    }



    /**

        Adds an Element to the element.

        @param  hashcode name of element for hash table

        @param  element Adds an Element to the element.

     */

    public font addElement(String hashcode,String element)

    {

        addElementToRegistry(hashcode,element);

        return(this);

    }



    /**

        Adds an Element to the Element.

        @param     element adds and Element to the Element.

    */

    public font addElement(Element element)

    {

        addElementToRegistry(element);

        return(this);

    }



    /**

        Adds an Element to the Element.

        @param     element adds and Element to the Element.

    */

    public font addElement(String element)

    {

        addElementToRegistry(element);

        return(this);

    }

    /**

        Removes an Element from the element.

        @param hashcode the name of the element to be removed.

    */

    public font removeElement(String hashcode)

    {

        removeElementFromRegistry(hashcode);

        return(this);

    }

} 

