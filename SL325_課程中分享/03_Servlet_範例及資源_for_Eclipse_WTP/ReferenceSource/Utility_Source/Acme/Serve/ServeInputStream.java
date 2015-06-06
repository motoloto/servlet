// Serve - minimal Java HTTP server class
//
// Copyright (C)1996,1998 by Jef Poskanzer <jef@acme.com>. All rights reserved.
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

package Acme.Serve;

import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;
import Acme.Serve.servlet.*;
import Acme.Serve.servlet.http.*;

class ServeInputStream extends ServletInputStream
    {

    private InputStream in;

    public ServeInputStream( InputStream in )
	{
	this.in = in;
	}

    public int readLine( byte[] b, int off, int len ) throws IOException
	{
	int off2 = off;
	while ( off2 - off < len )
	    {
	    int r = read();
	    if ( r == -1 )
		{
		if (off2 == off )
		    return -1;
		break;
		}
	    if ( r == 13 )
		continue;
	    if ( r == 10 )
		break;
	    b[off2] = (byte) r;
	    ++off2;
	    }
	return off2 - off;
	}

    public int read() throws IOException
	{
	return in.read();
	}

    public int read( byte[] b, int off, int len ) throws IOException
	{
	return in.read( b, off, len );
	}

    public int available() throws IOException
	{
	return in.available();
	}

    public void close() throws IOException
	{
	in.close();
	}

    }


