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
    This class implements the transfer element

    @author Written by <a href="mailto:jcarol@us.ibm.com">Carol Jones</a>
*/
public class Transfer extends VXMLElement
{

    /**
	Basic constructor. You need to set the attributes using the
	set* methods.
    */
    public Transfer()
    {
	super("transfer");
    }

    /**
	This constructor creates a &lt;transfer&gt; tag.
	@param name the name="" attribute
	@param expr the expr="" attribute
	@param cond the cond="" attribute
	@param dest the dest="" attribute
	@param destexpr the destexpr="" attribute
	@param bridge the bridge="" attribute
	@param connecttime the connecttime="" attribute
	@param maxtime the maxtime="" attribute
    */
    public Transfer(String name, String expr, String cond, String dest,
	                String destexpr, String bridge, String connecttime, String maxtime)
    {
	this();
	setName(name);
	setExpr(expr);
	setCond(cond);
	setDest(dest);
	setDestexpr(destexpr);
	setBridge(bridge);
	setConnecttime(connecttime);
	setMaxtime(maxtime);
    }
    
    /**
	This constructor creates a &lt;transfer&gt; tag.
	@param name the name="" attribute
	@param dest the dest="" attribute
	@param bridge the bridge="" attribute
    */
    public Transfer(String name, String dest, String bridge)
    {
	this();
	setName(name);
	setDest(dest);
	setBridge(bridge);
    }
        
    /**
	Sets the name="" attribute
	@param name the name="" attribute
    */
    public Transfer setName(String name)
    {
	addAttribute("name", name);
	return this;
    }

    /**
	Sets the expr="" attribute
	@param expr the expr="" attribute
    */
    public Transfer setExpr(String expr)
    {
	addAttribute("expr", expr);
	return this;
    }

    /**
	Sets the cond="" attribute
	@param cond the cond="" attribute
    */
    public Transfer setCond(String cond)
    {
	addAttribute("cond", cond);
	return this;
    }

    /**
	Sets the dest="" attribute
	@param dest the dest="" attribute
    */
    public Transfer setDest(String dest)
    {
	addAttribute("dest", dest);
	return this;
    }
	
    /**
	Sets the destexpr="" attribute
	@param destexpr the destexpr="" attribute
    */
    public Transfer setDestexpr(String destexpr)
    {
	addAttribute("destexpr", destexpr);
	return this;
    }
	
    /**
	Sets the bridge="" attribute
	@param cond the bridge="" attribute
    */
    public Transfer setBridge(String bridge)
    {
	addAttribute("bridge", bridge);
	return this;
    }
	
    /**
	Sets the connecttime="" attribute
	@param cond the connecttime="" attribute
    */
    public Transfer setConnecttime(String connecttime)
    {
	addAttribute("connecttime", connecttime);
	return this;
    }
	
    /**
	Sets the maxtime="" attribute
	@param cond the maxtime="" attribute
    */
    public Transfer setMaxtime(String maxtime)
    {
	addAttribute("maxtime", maxtime);
	return this;
    }
    
} 
