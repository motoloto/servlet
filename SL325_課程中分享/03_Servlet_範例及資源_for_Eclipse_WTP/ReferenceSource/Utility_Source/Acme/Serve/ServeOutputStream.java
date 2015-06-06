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

class ServeOutputStream extends ServletOutputStream
    {

    private PrintStream out;
    private ServeConnection conn;

    public ServeOutputStream( OutputStream out, ServeConnection conn )
	{
	this.out = new PrintStream( out );
	this.conn = conn;
	}

    public void write( int b ) throws IOException
	{
	conn.writeHeaders();
	out.write( b );
	}

    public void write( byte[] b, int off, int len ) throws IOException
	{
	conn.writeHeaders();
	out.write( b, off, len );
	}

    public void flush() throws IOException
	{
	conn.writeHeaders();
	out.flush();
	}

    public void close() throws IOException
	{
	conn.writeHeaders();
	out.close();
	}

    public void print( String s ) throws IOException
	{
	conn.writeHeaders();
	out.print( s );
	}

    public void print( int i ) throws IOException
	{
	conn.writeHeaders();
	out.print( i );
	}

    public void print( long l ) throws IOException
	{
	conn.writeHeaders();
	out.print( l );
	}

    public void println( String s ) throws IOException
	{
	conn.writeHeaders();
	out.println( s );
	}

    public void println( int i ) throws IOException
	{
	conn.writeHeaders();
	out.println( i );
	}

    public void println( long l ) throws IOException
	{
	conn.writeHeaders();
	out.println( l );
	}

    public void println() throws IOException
	{
	conn.writeHeaders();
	out.println();
	}

    }
