// MultiplexNewsDb - proxy netnews database
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

package Acme.Nnrpd;

import java.io.*;
import java.util.*;
import java.net.*;
import Acme.Utils;

class MultiplexNewsDbMessageIds implements Enumeration
    {

    private Enumeration dbEnum;
    private String groupsPat;
    private long since;
    private String distsPat;

    private Enumeration messageIdEnum;
    private String messageId;

    public MultiplexNewsDbMessageIds( Enumeration dbEnum, String groupsPat, long since )
	{
	this( dbEnum, groupsPat, since, null );
	}

    public MultiplexNewsDbMessageIds( Enumeration dbEnum, String groupsPat, long since, String distsPat )
	{
	this.dbEnum = dbEnum;
	this.groupsPat = groupsPat;
	this.since = since;
	this.distsPat = distsPat;
	messageIdEnum = null;
	messageId = null;
	}

    public boolean hasMoreElements()
	{
	if ( messageId != null )
	    return true;
	while ( true )
	    {
	    if ( messageIdEnum == null )
		{
		if ( dbEnum == null )
		    return false;
		if ( ! dbEnum.hasMoreElements() )
		    {
		    dbEnum = null;
		    return false;
		    }
		try
		    {
		    NewsDb db = (NewsDb) dbEnum.nextElement();
		    if ( distsPat != null )
			messageIdEnum = db.getMessageIds( groupsPat, since, distsPat );
		    else
			messageIdEnum = db.getMessageIds( groupsPat, since );
		    }
		catch ( NewsDbException e )
		    {
		    continue;
		    }
		}
	    if ( ! messageIdEnum.hasMoreElements() )
		{
		messageIdEnum = null;
		continue;
		}
	    messageId = (String) messageIdEnum.nextElement();
	    return true;
	    }
	}
    
    public Object nextElement()
	{
	if ( ! hasMoreElements() )
	    return null;
	String mid = messageId;
	messageId = null;
	return mid;
	}

    }
