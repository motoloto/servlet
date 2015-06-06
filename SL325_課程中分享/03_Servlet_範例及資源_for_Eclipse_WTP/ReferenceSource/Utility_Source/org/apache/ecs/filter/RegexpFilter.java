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
package org.apache.ecs.filter;

import org.apache.ecs.Filter;

import org.apache.regexp.RE;
import org.apache.regexp.RESyntaxException;

import java.util.Hashtable;
import java.util.Enumeration;

/**
 * This filter uses regexp to create expressions and allows
 * you do a replace on them. 
 *
 * It works like the Perl function called subst. Given a regular 
 * expression of "a*b", and a String to substituteIn of 
 * "aaaabfooaaabgarplyaaabwackyb" and the substitution String "-", the 
 * resulting String returned by subst would be "-foo-garply-wacky-".
 *
 * <pre><code>
 *    Filter filter = new RegexpFilter();
 *    filter.addAttribute("a*b","-");
 *    String text = "aaaabfooaaabgarplyaaabwackyb";
 *    String result = filter.process(text);
 *    System.out.println(result);
 * </code></pre>
 *
 * Produces: -foo-garply-wacky-
 *
 * Note: "a*" means 0 or more occurences of 'a', therefore the last match
 * is absolutely correct.
 *
 * For more information about the regular expression package please do
 * visit <a href="http://jakarta.apache.org/regexp/">Jakarta Regexp"</a>
 *
 * @version $Id: RegexpFilter.java,v 1.1 2000/11/22 17:19:33 krzyszto Exp $
 * @author <a href="mailto:Krzysztof.Zelazowski@cern.ch">K. Zelazowski</a>
 */
public class RegexpFilter extends Hashtable implements Filter {
    
    public RegexpFilter() 
    {
        super(4);
    }

    /** Returns the name of the filter */
    public String getInfo() 
    {
        return "RegexpFilter";
    }

    
    /**
     * This method actually performs the filtering.
     */
    public String process(String to_process) 
    {
        if ( to_process == null || to_process.length() == 0 )
        {
            return "";
        }
        
        String substituteIn = to_process;
        Enumeration enum = keys();

        while (enum.hasMoreElements()) {
            RE r = (RE)enum.nextElement();
            String substitution = (String)get(r);
            substituteIn = r.subst(substituteIn, substitution);
        }
        
        return substituteIn;
    }

    
    /**
     *  Add regular expression - substitution pair.
     *
     *  @return itself or null if the was an error in the syntax of the 
     *          expression.
     */
    public Filter addAttribute(String expression,Object substitution) 
    {
        try {
            RE r = new RE(expression);
            put(r, substitution);
        }
        catch (RESyntaxException e) {
            return null;
        }

        return(this);
    }

    
    /**
     * Get rid of the specified expression filter.
     */
    public Filter removeAttribute(String expression) 
    {
        try
        {
             RE r = new RE(expression);
             remove(r);
        }
        catch(Exception e)
        { 
        }
        return(this);
    }

    
    /**
     * Returns true if this filter contains an expression specified
     * as an argument.
     */
    public boolean hasAttribute(String expression) 
    {
        try {
            RE r = new RE(expression);
            return containsKey(r);
        }
        catch (Exception e) {
        }
        return false;
    }
}
