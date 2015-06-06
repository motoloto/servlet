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

package org.apache.ecs.factory;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class DOMFactory
{
    private PipedOutputStream outStream = new PipedOutputStream();
    private PipedInputStream pis = null;

    /* Default Initializer */
    {
        try
        {
            pis = new PipedInputStream(outStream);
        }
        catch(java.io.IOException _e)
        {
            throw new InternalError(_e.toString());
        }
    }

    /**
      Default Constructor.  Here is a simple example on how to use this class.
      <code>
      <pre>
        PI p = new PI();
        p.setVersion(1.0);
        XML x = new XML("root",true);
        XML x1 = new XML("page",true);
        XML x2 = new XML("paragraph");
        XML x3 = new XML("paragraph");
        x2.addElement("This is the first Paragraph");
        x3.addElement("This is the second Paragraph");
        x.addElement(x1.addElement(x2).addElement(x3));
        p.addElement(x);
        DOMFactory d = new DOMFactory();
        p.output(d.getOutputStream());

        Document doc = d.createDOM();
      </pre>
      </code>
    */
    public DOMFactory()
    {
    }

    /**
      Gets the output stream for the ecs element to write to.
    */
    public PipedOutputStream getOutputStream()
    {
        return outStream;
    }

    /**
      Creates a Document from the root element of the XML Stream.
    */
    public Document createDOM()
    {
        DOMParser parser = null;
        Document doc = null;

        try
        {
            outStream.close(); // before we parse the InputStream make sure the pipe is closed.
            parser = new DOMParser();
            parser.parse(new org.xml.sax.InputSource(pis));
            doc = parser.getDocument();
        }
        catch(java.io.IOException ioe)
        {
            System.err.println(ioe.toString());
            ioe.printStackTrace();
        }
        catch(org.xml.sax.SAXException sax)
        {
            System.err.println(sax.toString());
            sax.printStackTrace();
        }
        return doc;
    }
}
