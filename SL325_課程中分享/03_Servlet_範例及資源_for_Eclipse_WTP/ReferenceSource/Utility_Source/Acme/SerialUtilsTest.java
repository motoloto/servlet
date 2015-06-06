// SerialUtils - utilities for serializable objects
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

import java.io.*;

/// Sample/test class.

class SerialUtilsTest implements Acme.Serializable
    {

    SerialUtilsTest sub;
    String str;
    byte b;
    char c;
    short s;
    int i;
    long l;
    float f;
    double d;
    long[] al;

    /// Real constructor.
    public SerialUtilsTest( SerialUtilsTest sub, String str, byte b, char c, short s, int i, long l, float f, double d, long[] al )
	{
	this.sub = sub;
	this.str = str;
	this.b = b;
	this.c = c;
	this.s = s;
	this.i = i;
	this.l = l;
	this.f = f;
	this.d = d;
	this.al = al;
	}


    /// No-args constructor, makes a blank instance to be filled in by the
    // deserializer.
    public SerialUtilsTest()
	{
	}

    /// Version routine.
    public String getVersion()
	{
	return "1";
	}

    /// Serialize routine for the interface.
    public void serialize( DataOutputStream dout ) throws IOException
	{
	System.err.println( "Serializing..." );
	SerialUtils.serializeObject( sub, dout );
	SerialUtils.serializeString( str, dout );
	SerialUtils.serializeByte( b, dout );
	SerialUtils.serializeChar( c, dout );
	SerialUtils.serializeShort( s, dout );
	SerialUtils.serializeInt( i, dout );
	SerialUtils.serializeLong( l, dout );
	SerialUtils.serializeFloat( f, dout );
	SerialUtils.serializeDouble( d, dout );
	SerialUtils.serializeArrayLong( al, dout );
	System.err.println( "Done serializing." );
	}

    /// Deserialize routine for the interface.
    public void deserialize( DataInputStream din ) throws IOException
	{
	System.err.println( "Deserializing..." );
	sub = (SerialUtilsTest) SerialUtils.deserializeObject(
	    this.getClass(), din );
	str = SerialUtils.deserializeString( din );
	b = SerialUtils.deserializeByte( din );
	c = SerialUtils.deserializeChar( din );
	s = SerialUtils.deserializeShort( din );
	i = SerialUtils.deserializeInt( din );
	l = SerialUtils.deserializeLong( din );
	f = SerialUtils.deserializeFloat( din );
	d = SerialUtils.deserializeDouble( din );
	al = SerialUtils.deserializeArrayLong( din );
	System.err.println( "Done deserializing." );
	}

    /// String output routine.
    public String toString()
	{
	return
	    "[" +
	    this.getClass().getName() + " " +
	    sub + " " +
	    str.toString() + " " +
	    b + " " +
	    c + " " +
	    s + " " +
	    i + " " +
	    l + " " +
	    f + " " +
	    Acme.Fmt.fmt( d ) + " " +
	    arrayToString( al ) + "]";
	}
    
    private static String arrayToString( long[] al )
	{
	if ( al == null )
	    return "null";
	StringBuffer sb = new StringBuffer();
	sb.append( "{" );
	for ( int i = 0; i < al.length; ++i )
	    {
	    if ( i != 0 )
		sb.append( ", " );
	    sb.append( al[i] );
	    }
	sb.append( "}" );
	return sb.toString();
	}

    }
