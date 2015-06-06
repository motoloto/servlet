// Spider - a web-robot class
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
import java.net.*;
import java.io.*;

// SpiderConnection - utility class for Spider
//
// A SpiderConnection is the type returned by Spider.  It's a
// URLConnection, slightly modified internally to work with Spider.

class SpiderConnection extends URLConnection
    {
    private URLConnection uc;
    protected InputStream s;

    public SpiderConnection( URLConnection uc ) throws IOException
	{
	super( uc.getURL() );
	this.uc = uc;
	this.s = uc.getInputStream();
	}

    public SpiderConnection( URLConnection uc, InputStream s )
	{
	super( uc.getURL() );
	this.uc = uc;
	this.s = s;
	}

    public InputStream getInputStream() throws IOException
	{
	return s;
	}

    // The rest just forward to uc's methods.
    final public void connect() throws IOException
	{
	uc.connect();
	}
    final public URL getURL()
	{
	return uc.getURL();
	}
    final public int getContentLength()
	{
	return uc.getContentLength();
	}
    final public String getContentType()
	{
	return uc.getContentType();
	}
    final public String getContentEncoding()
	{
	return uc.getContentEncoding();
	}
    final public long getExpiration()
	{
	return uc.getExpiration();
	}
    final public long getDate()
	{
	return uc.getDate();
	}
    final public long getLastModified()
	{
	return uc.getLastModified();
	}
    final public String getHeaderField( String name )
	{
	return uc.getHeaderField( name );
	}
    final public int getHeaderFieldInt( String name, int Default )
	{
	return uc.getHeaderFieldInt( name, Default );
	}
    final public long getHeaderFieldDate( String name, long Default )
	{
	return uc.getHeaderFieldDate( name, Default );
	}
    final public String getHeaderFieldKey( int n )
	{
	return uc.getHeaderFieldKey( n );
	}
    final public String getHeaderField( int n )
	{
	return uc.getHeaderField( n );
	}
    final public Object getContent() throws IOException
	{
	return uc.getContent();
	}
    final public OutputStream getOutputStream() throws IOException
	{
	return uc.getOutputStream();
	}
    final public String toString()
	{
	return uc.toString();
	}
    final public void setDoInput( boolean doinput )
	{
	uc.setDoInput( doinput );
	}
    final public boolean getDoInput()
	{
	return uc.getDoInput();
	}
    final public void setDoOutput( boolean dooutput )
	{
	uc.setDoOutput( dooutput );
	}
    final public boolean getDoOutput()
	{
	return uc.getDoOutput();
	}
    final public void setAllowUserInteraction( boolean allowuserinteraction )
	{
	uc.setAllowUserInteraction( allowuserinteraction );
	}
    final public boolean getAllowUserInteraction()
	{
	return uc.getAllowUserInteraction();
	}
    final public static void setDefaultAllowUserInteraction(
	boolean defaultallowuserinteraction )
	{
	URLConnection.setDefaultAllowUserInteraction(
	    defaultallowuserinteraction );
	}
    final public static boolean getDefaultAllowUserInteraction()
	{
	return URLConnection.getDefaultAllowUserInteraction();
	}
    final public void setUseCaches( boolean usecaches )
	{
	uc.setUseCaches( usecaches );
	}
    final public boolean getUseCaches()
	{
	return uc.getUseCaches();
	}
    final public void setIfModifiedSince( long ifmodifiedsince )
	{
	uc.setIfModifiedSince( ifmodifiedsince );
	}
    final public long getIfModifiedSince()
	{
	return uc.getIfModifiedSince();
	}
    final public boolean getDefaultUseCaches()
	{
	return uc.getDefaultUseCaches();
	}
    final public void setDefaultUseCaches( boolean defaultusecaches )
	{
	uc.setDefaultUseCaches( defaultusecaches );
	}
    final public void setRequestProperty( String key, String value )
	{
	uc.setRequestProperty( key, value );
	}
    final public String getRequestProperty( String key )
	{
	return uc.getRequestProperty( key );
	}
    final public static void setDefaultRequestProperty(
	String key, String value )
	{
	URLConnection.setDefaultRequestProperty( key, value );
	}
    final public static String getDefaultRequestProperty( String key )
	{
	return URLConnection.getDefaultRequestProperty( key );
	}
    final public static void setContentHandlerFactory(
	ContentHandlerFactory fac )
	{
	URLConnection.setContentHandlerFactory( fac );
	}
    }
