// LruHashtable - a Hashtable that expires least-recently-used objects
//
// Copyright (C) 1996 by Jef Poskanzer <jef@acme.com>.  All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// 1. Redistributions of source code must retain the above copyright
//    notice, this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
// OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
// LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
// OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE.
//
// Visit the ACME Labs Java page for up-to-date versions of this and other
// fine Java utilities: http://www.acme.com/java/

package Acme;

import java.util.*;

class LruHashtableEnumerator implements Enumeration
    {
    Enumeration oldEnum;
    Enumeration newEnum;
    boolean old;

    LruHashtableEnumerator( Hashtable oldTable, Hashtable newTable, boolean keys )
	{
	if ( keys )
	    {
	    oldEnum = oldTable.keys();
	    newEnum = newTable.keys();
	    }
	else
	    {
	    oldEnum = oldTable.elements();
	    newEnum = newTable.elements();
	    }
	old = true;
	}
	
    public boolean hasMoreElements()
	{
	boolean r;
	if ( old )
	    {
	    r = oldEnum.hasMoreElements();
	    if ( ! r )
		{
		old = false;
		r = newEnum.hasMoreElements();
		}
	    }
	else
	    r = newEnum.hasMoreElements();
	return r;
	}

    public Object nextElement()
	{
	if ( old )
	    return oldEnum.nextElement();
	return newEnum.nextElement();
	}
		    
    }
